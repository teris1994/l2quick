/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javolution.util.FastList;
import javolution.util.FastMap;
import javolution.util.FastSet;
import l2bot.network.login.LoginCrypt;

/**
 *
 * @author carl
 */
public class Sniffer extends JFrame{
    
    boolean enable;
    
    boolean ignoreChanges = false;
    
    FastMap<Integer,Packet> serverPackets = new FastMap<Integer,Packet>();
    FastMap<Integer,Packet> clientPackets = new FastMap<Integer,Packet>();
    FastMap<Integer,Packet> loginServerPackets = new FastMap<Integer,Packet>();
    FastMap<Integer,Packet> loginClientPackets = new FastMap<Integer,Packet>();
    Packet unknown;
    
    FastList<SniffedPacket> pks = new FastList<SniffedPacket>();
    
    public static final int GAME_SERVER = 0;
    public static final int CLIENTE_GAME = 1;
    public static final int LOGIN_SERVER = 3;
    public static final int CLIENTE_LOGIN = 4;
    
    //icons
    ImageIcon iconFromLoginServer = new ImageIcon("img/lsc.gif");
    ImageIcon iconFromGameServer = new ImageIcon("img/gsc.gif");
    ImageIcon iconToLoginServer = new ImageIcon("img/cls.gif");
    ImageIcon iconToGameServer = new ImageIcon("img/cgs.gif");
    ImageIcon atencion = new ImageIcon("img/atencion.gif");
    ImageIcon blank = new ImageIcon("img/nohelp.gif");
    
    //components
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    SpringLayout layout = new SpringLayout();
    JEditorPane editor = new JEditorPane();
    JComboBox combo = new JComboBox();

    //getinstance.....
    private static Sniffer snif;
    public static Sniffer getInstance(){
        if(snif == null){
            snif = new Sniffer();
        }
        return snif;
    }
    public static void mostrar(){
        getInstance().setVisible(true);
    }
    
    
    public Sniffer(){
        loadPackets();
        loadPackets2();
        loadPackets3();

        System.out.println(loginServerPackets.get(0x00).name);
        
        editor.setEditable(false);
        
        model.addColumn("");
        model.addColumn("");
        model.addColumn("Nombre");
        
        table = new JTable(model);
        
        table.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                int b = 0;
                
                for(SniffedPacket pk: pks){
                    if(combo.getSelectedItem() != null && ((String)combo.getSelectedItem()).equals(pk.pj)){
                        if(b == i){
                            editor.setText(pk.tipo.parsear(pk.raw));
                            return;
                        }
                        b++;
                    }
                }
                //error
            }
            public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
        });
        
        Renderer rend = new Renderer();
        
        table.getColumnModel().getColumn(0).setCellRenderer(rend);
        table.getColumnModel().getColumn(1).setCellRenderer(rend);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(16);
        table.getColumnModel().getColumn(0).setWidth(16);
        table.getColumnModel().getColumn(0).setMaxWidth(16);
        
        table.getColumnModel().getColumn(1).setPreferredWidth(16);
        table.getColumnModel().getColumn(1).setWidth(16);
        table.getColumnModel().getColumn(1).setMaxWidth(16);
        
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        table.setDefaultEditor(Object.class, null);
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.setSize(800,600);
        
        editor.setMaximumSize(new Dimension(600,600));
        editor.setMinimumSize(new Dimension(400,100));
        editor.setSize(new Dimension(550,600));
        
       
       
        Container pane = this.getContentPane();
        
        layout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.WEST, combo, 10, SpringLayout.WEST, pane);
        
        layout.putConstraint(SpringLayout.NORTH, combo, 10, SpringLayout.NORTH, pane);
        
        layout.putConstraint(SpringLayout.NORTH, editor, 10, SpringLayout.SOUTH, combo);
        layout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, combo);
        
        layout.putConstraint(SpringLayout.EAST, editor, -10, SpringLayout.EAST, pane);
        
        layout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.WEST, editor);
        //layout.putConstraint(SpringLayout.WIDTH, scrollPane, 0, SpringLayout.WIDTH, editor);
        
        layout.putConstraint(SpringLayout.SOUTH, editor, -10, SpringLayout.SOUTH, pane);
        layout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, pane);
        
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(ignoreChanges){return;}
                actTabla();
            }
        });
        
        
        add(scrollPane);
        add(editor);
        add(combo);
        
        setLayout(layout);

        /*byte[] testdata = {12,0x00,0x00,0x01};
        byte[] testdata2 = {12,0,(byte)0xFE,0x25};
        byte[] testdata3 = {12,0x00,0x00,0x03};
        byte[] testdata4 = {12,0x00,0x00,0x04};
        addPacket(testdata,LOGIN_SERVER,"pj1");
        addPacket(testdata2,GAME_SERVER,"pj1");
        addPacket(testdata3,LOGIN_SERVER,"pj1");
        addPacket(testdata4,LOGIN_SERVER,"pj2");*/
        
        //System.out.println(serverPackets.get(0xFF+0x25).name);
        
        
    }
    
    
    public void addPacket(byte[] datos, int procedencia, String pj){
        
        switch(procedencia){
            case GAME_SERVER:
                Integer cde = (datos[2])==(byte)0xFE?new Integer(0xFF+datos[2]):new Integer(datos[2]);
                pks.add(new SniffedPacket(datos,procedencia,pj,serverPackets.get(cde)));
                break;
            case CLIENTE_GAME:
                pks.add(new SniffedPacket(datos,procedencia,pj,clientPackets.get((datos[2]&0xFF)==0xd0?new Integer(0xFF+datos[2]):new Integer(datos[2]))));
                break;
            case LOGIN_SERVER:
                 pks.add(new SniffedPacket(datos,procedencia,pj,loginServerPackets.get(new Integer(datos[2]))));
                 break;
            case CLIENTE_LOGIN:
                 pks.add(new SniffedPacket(datos,procedencia,pj,loginClientPackets.get(new Integer(datos[2]))));
                 break;                
                
        }      
        
        

        actTabla();
        
    }

    private void actTabla() {
        
        ignoreChanges = true;
        FastSet<String> set = new FastSet<String>();
        
        while (model.getRowCount()>0){
        model.removeRow(0);
        }
        
        for(SniffedPacket pk: pks){
            set.add(pk.pj);
            if(combo.getSelectedItem() != null && ((String)combo.getSelectedItem()).equals(pk.pj)){
                String icon = "";
                switch(pk.procedencia){
                    case GAME_SERVER:
                        icon = "GS->C";
                        break;
                    case LOGIN_SERVER:
                        icon = "LS->C";
                        break;
                    case CLIENTE_GAME:
                        icon = "C->GS";
                        break;
                    case CLIENTE_LOGIN:
                        icon = "C->LS";
                        break;
                        
                }
                if(pk.tipo == null){
                    pk.tipo = unknown;
                }
                
                model.addRow(new String[]{icon,"",pk.tipo.name});
            }
            
           
        }
        String se = (String)combo.getSelectedItem();
        
        combo.removeAllItems();
        
        for(String s:set){
            combo.addItem(s);
            if(se != null && se.equals(s)){
                combo.setSelectedIndex(combo.getItemCount()-1);
            }
            
        }
        
        ignoreChanges = false;
        
        
    }
    
    
    class SniffedPacket{
        public byte[] raw;
        public int procedencia;
        public String pj;
        public Packet tipo;
        
        public boolean isWorng;
        
        public SniffedPacket(byte[] raw, int pro, String pj, Packet tipo){
            this.tipo = tipo;
            this.raw = raw;
            this.procedencia = pro;
            this.pj = pj;
        }
    }
    
    class Packet{
        public String name;
        public String desc;
        
        public Packet(String name,String desc){
            this.name = name;
            this.desc = desc;
        }
        
        public String parsear(byte[] raw){
            return LoginCrypt.byteArrayToHexString(raw);
        }
    }
    
    class Renderer extends DefaultTableCellRenderer{
            @Override
            public Component getTableCellRendererComponent(JTable tblDataTable, Object value, boolean isSelected, boolean hasFocus, int markedRow, int col){
                JLabel ret=(JLabel)super.getTableCellRendererComponent(tblDataTable,value,isSelected,hasFocus,markedRow,col);
                ret.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                if (value != null && value instanceof String) {
                        String dt = (String) value;
                        if(dt.equals("C->GS")){
                            ret.setIcon(iconToGameServer);//Use this method to set the proper icon for the file.
                        }
                        else if(dt.equals("C->LS")){
                            ret.setIcon(iconToLoginServer);
                        }
                        else if(dt.equals("LS->C")){
                            ret.setIcon(iconFromLoginServer);
                        }                        
                        else if(dt.equals("GS->C")){
                            ret.setIcon(iconFromGameServer);
                        }
                        else if(dt.equals("A")){
                            ret.setIcon(atencion);
                        }else{
                            ret.setIcon(blank);
                        }
                        ret.setText("");//Blank out your Label's text.
                }
                return ret;
            }
        
    }
    
    public void loadPackets(){
clientPackets.put(0x0e
,new Packet("ProtocolVersion",""));

clientPackets.put(0x2b
,new Packet("AuthLogin",""));

clientPackets.put(0x00
,new Packet("Logout",""));

clientPackets.put(0x0c
,new Packet("CharacterCreate",""));

clientPackets.put(0x0d
,new Packet("CharacterDelete",""));

clientPackets.put(0x12
,new Packet("CharacterSelect",""));

clientPackets.put(0x13
,new Packet("NewCharacter",""));

clientPackets.put(0x67
,new Packet("RequestPledgeCrest",""));

clientPackets.put(0x7b
,new Packet("CharacterRestore",""));

clientPackets.put(0x39 + 0xFF
,new Packet("RequestGotoLobby",""));

clientPackets.put(0x00
,new Packet("Logout",""));

clientPackets.put(0x01
,new Packet("AttackRequest",""));

clientPackets.put(0x03
,new Packet("RequestStartPledgeWar",""));

clientPackets.put(0x04
,new Packet("RequestReplyStartPledgeWar",""));

clientPackets.put(0x05
,new Packet("RequestStopPledgeWar",""));

clientPackets.put(0x06
,new Packet("RequestReplyStopPledgeWar",""));

clientPackets.put(0x07
,new Packet("RequestSurrenderPledgeWar",""));

clientPackets.put(0x08
,new Packet("RequestReplySurrenderPledgeWar",""));

clientPackets.put(0x09
,new Packet("RequestSetPledgeCrest",""));

clientPackets.put(0x0b
,new Packet("RequestGiveNickName",""));

clientPackets.put(0x0f
,new Packet("MoveBackwardToLocation",""));

clientPackets.put(0x11
,new Packet("EnterWorld",""));

clientPackets.put(0x14
,new Packet("RequestItemList",""));

clientPackets.put(0x16
,new Packet("RequestUnEquipItem","")); 

clientPackets.put(0x17
,new Packet("RequestDropItem",""));

clientPackets.put(0x19
,new Packet("UseItem",""));

clientPackets.put(0x1a
,new Packet("TradeRequest",""));

clientPackets.put(0x1b
,new Packet("clientPackets.putTradeItem",""));

clientPackets.put(0x1c
,new Packet("TradeDone",""));

clientPackets.put(0x1f
,new Packet("Action",""));

clientPackets.put(0x22
,new Packet("RequestLinkHtml",""));

clientPackets.put(0x23
,new Packet("RequestBypassToServer",""));

clientPackets.put(0x24
,new Packet("RequestBBSwrite",""));

clientPackets.put(0x26
,new Packet("RequestJoinPledge",""));

clientPackets.put(0x27
,new Packet("RequestAnswerJoinPledge",""));

clientPackets.put(0x28
,new Packet("RequestWithdrawalPledge",""));

clientPackets.put(0x29
,new Packet("RequestOustPledgeMember",""));

clientPackets.put(0x2c
,new Packet("RequestGetItemFromPet",""));

clientPackets.put(0x2e
,new Packet("RequestAllyInfo",""));

clientPackets.put(0x2f
,new Packet("RequestCrystallizeItem",""));

clientPackets.put(0x30 
,new Packet("RequestPrivateStoreManageSell",""));

clientPackets.put(0x31 
,new Packet("SetPrivateStoreListSell",""));

clientPackets.put(0x34
,new Packet("RequestSocialAction",""));

clientPackets.put(0x35
,new Packet("ChangeMoveType2",""));

clientPackets.put(0x36
,new Packet("ChangeWaitType2",""));

clientPackets.put(0x37
,new Packet("RequestSellItem",""));

clientPackets.put(0x39
,new Packet("RequestMagicSkillUse",""));

clientPackets.put(0x3a
,new Packet("Appearing",""));  

clientPackets.put(0x3b
,new Packet("SendWareHouseDepositList",""));

clientPackets.put(0x3c
,new Packet("SendWareHouseWithDrawList",""));

clientPackets.put(0x3d
,new Packet("RequestShortCutReg",""));

clientPackets.put(0x3f
,new Packet("RequestShortCutDel",""));

clientPackets.put(0x40 
,new Packet("RequestBuyItem",""));

clientPackets.put(0x42
,new Packet("RequestJoinParty",""));

clientPackets.put(0x43
,new Packet("RequestAnswerJoinParty",""));

clientPackets.put(0x44
,new Packet("RequestWithDrawalParty",""));

clientPackets.put(0x45
,new Packet("RequestOustPartyMember",""));

clientPackets.put(0x47
,new Packet("CannotMoveAnymore",""));

clientPackets.put(0x48
,new Packet("RequestTargetCanceld",""));

clientPackets.put(0x49
,new Packet("Say2",""));

clientPackets.put(0x4d
,new Packet("RequestPledgeMemberList",""));

clientPackets.put(0x4f
,new Packet("DummyPacket",""));

clientPackets.put(0x50
,new Packet("RequestSkillList",""));

clientPackets.put(0x52
,new Packet("MoveWithDelta","")); 

clientPackets.put(0x53
,new Packet("RequestGetOnVehicle",""));  

clientPackets.put(0x54
,new Packet("RequestGetOffVehicle",""));

clientPackets.put(0x55
,new Packet("AnswerTradeRequest",""));

clientPackets.put(0x56
,new Packet("RequestActionUse",""));

clientPackets.put(0x57
,new Packet("RequestRestart",""));

clientPackets.put(0x58
,new Packet("RequestSiegeInfo",""));   

clientPackets.put(0x59 
,new Packet("ValidatePosition",""));

clientPackets.put(0x5e
,new Packet("RequestShowBoard",""));

clientPackets.put(0x5f
,new Packet("RequestEnchantItem",""));

clientPackets.put(0x60
,new Packet("RequestDestroyItem",""));

clientPackets.put(0x62
,new Packet("RequestQuestList",""));

clientPackets.put(0x63  
,new Packet("RequestQuestAbort",""));  
              
clientPackets.put(0x65
,new Packet("RequestPledgeInfo",""));

clientPackets.put(0x66
,new Packet("RequestPledgeExtendedInfo",""));   

clientPackets.put(0x67
,new Packet("RequestPledgeCrest",""));

clientPackets.put(0x6f
,new Packet("RequestHennaEquip",""));

clientPackets.put(0x73 
,new Packet("RequestAquireSkillInfo",""));

clientPackets.put(0x74
,new Packet("SendBypassBuildCmd",""));

clientPackets.put(0x75
,new Packet("RequestMoveToLocationInVehicle",""));

clientPackets.put(0x76
,new Packet("CannotMoveAnymoreInVehicle",""));

clientPackets.put(0x77
,new Packet("RequestFriendInvite",""));

clientPackets.put(0x78
,new Packet("RequestAnswerFriendInvite",""));

clientPackets.put(0x79
,new Packet("RequestFriendList",""));

clientPackets.put(0x7a
,new Packet("RequestFriendDel",""));

clientPackets.put(0x7c 
,new Packet("RequestAquireSkill",""));

clientPackets.put(0x7d
,new Packet("RequestRestartPoint",""));

clientPackets.put(0x7e
,new Packet("RequestGMCommand",""));

clientPackets.put(0x7f
,new Packet("RequestPartyMatchConfig",""));

clientPackets.put(0x80
,new Packet("RequestPartyMatchList",""));

clientPackets.put(0x81
,new Packet("RequestPartyMatchDetail",""));

clientPackets.put(0x83
,new Packet("RequestPrivateStoreBuy",""));

clientPackets.put(0x85
,new Packet("RequestTutorialLinkHtml",""));

clientPackets.put(0x86
,new Packet("RequestTutorialPassCmdToServer",""));

clientPackets.put(0x87
,new Packet("RequestTutorialQuestionMark",""));

clientPackets.put(0x88
,new Packet("RequestTutorialClientEvent",""));

clientPackets.put(0x89
,new Packet("RequestPetition",""));

clientPackets.put(0x8a
,new Packet("RequestPetitionCancel",""));

clientPackets.put(0x8b
,new Packet("RequestGmList",""));

clientPackets.put(0x8c
,new Packet("RequestJoinAlly",""));

clientPackets.put(0x8d
,new Packet("RequestAnswerJoinAlly",""));

clientPackets.put(0x8e
,new Packet("AllyLeave",""));

clientPackets.put(0x8f
,new Packet("AllyDismiss",""));

clientPackets.put(0x90
,new Packet("RequestDismissAlly",""));

clientPackets.put(0x91
,new Packet("RequestSetAllyCrest",""));

clientPackets.put(0x92
,new Packet("RequestAllyCrest",""));

clientPackets.put(0x93
,new Packet("RequestChangePetName",""));

clientPackets.put(0x94
,new Packet("RequestPetUseItem",""));

clientPackets.put(0x95
,new Packet("RequestGiveItemToPet",""));

clientPackets.put(0x96
,new Packet("RequestPrivateStoreQuitSell",""));

clientPackets.put(0x97
,new Packet("SetPrivateStoreMsgSell",""));

clientPackets.put(0x98
,new Packet("RequestPetGetItem",""));

clientPackets.put(0x99
,new Packet("RequestPrivateStoreManageBuy",""));

clientPackets.put(0x9a
,new Packet("SetPrivateStoreListBuy",""));

clientPackets.put(0x9c
,new Packet("RequestPrivateStoreQuitBuy",""));

clientPackets.put(0x9d
,new Packet("SetPrivateStoreMsgBuy",""));

clientPackets.put(0x9f
,new Packet("RequestPrivateStoreSell",""));

clientPackets.put(0xa7
,new Packet("RequestPackageSendableItemList",""));

clientPackets.put(0xa8
,new Packet("RequestPackageSend",""));

clientPackets.put(0xa9
,new Packet("RequestBlock",""));

clientPackets.put(0xab
,new Packet("RequestSiegeAttackerList",""));

clientPackets.put(0xac
,new Packet("RequestSiegeDefenderList",""));

clientPackets.put(0xad
,new Packet("RequestJoinSiege",""));

clientPackets.put(0xae
,new Packet("RequestConfirmSiegeWaitingList",""));

clientPackets.put(0xb0
,new Packet("MultiSellChoose",""));

clientPackets.put(0xb3
,new Packet("RequestUserCommand",""));

clientPackets.put(0xb4
,new Packet("SnoopQuit",""));

clientPackets.put(0xb5  
,new Packet("RequestRecipeBookOpen",""));

clientPackets.put(0xb6
,new Packet("RequestRecipeBookDestroy",""));

clientPackets.put(0xb7
,new Packet("RequestRecipeItemMakeInfo",""));

clientPackets.put(0xb8
,new Packet("RequestRecipeItemMakeSelf",""));

clientPackets.put(0xba
,new Packet("RequestRecipeShopMessageSet",""));

clientPackets.put(0xbb
,new Packet("RequestRecipeShopListSet",""));

clientPackets.put(0xbc
,new Packet("RequestRecipeShopManageQuit",""));

clientPackets.put(0xbe
,new Packet("RequestRecipeShopMakeInfo",""));

clientPackets.put(0xbf
,new Packet("RequestRecipeShopMakeItem",""));

clientPackets.put(0xc0
,new Packet("RequestRecipeShopManagePrev",""));

clientPackets.put(0xc1
,new Packet("ObserverReturn",""));

clientPackets.put(0xc2
,new Packet("RequestEvaluate",""));

clientPackets.put(0xc3
,new Packet("RequestHennaList",""));

clientPackets.put(0xc4
,new Packet("RequestHennaItemInfo",""));

clientPackets.put(0xcc
,new Packet("RequestPledgePower",""));

clientPackets.put(0xcd
,new Packet("RequestMakeMacro",""));

clientPackets.put(0xce
,new Packet("RequestDeleteMacro",""));

clientPackets.put(0xcf
,new Packet("RequestBuyProcure",""));

clientPackets.put(0xc5
,new Packet("RequestBuySeed",""));

clientPackets.put(0xc6
,new Packet("DlgAnswer",""));

clientPackets.put(0xc7
,new Packet("RequestWearItem",""));

clientPackets.put(0xc8
,new Packet("RequestSSQStatus",""));

clientPackets.put(0xcb
,new Packet("GameGuardReply",""));

clientPackets.put(0x6b
,new Packet("RequestSendFriendMsg",""));

clientPackets.put(0x6c
,new Packet("RequestShowMiniMap",""));

clientPackets.put(0x6e 
,new Packet("RequestRecordInfo",""));

clientPackets.put(0xFF + 0x01
,new Packet("RequestManorList",""));

clientPackets.put(0xFF + 0x02
,new Packet("RequestProcureCropList",""));

clientPackets.put(0xFF + 0x03
,new Packet("RequestSetSeed",""));

clientPackets.put(0xFF + 0x04
,new Packet("RequestSetCrop",""));

clientPackets.put(0xFF + 0x05
,new Packet("RequestWriteHeroWords",""));

clientPackets.put(0xFF + 0x06
,new Packet("RequestExAskJoinMPCC",""));

clientPackets.put(0xFF + 0x07
,new Packet("RequestExAcceptJoinMPCC",""));

clientPackets.put(0xFF + 0x08
,new Packet("RequestExOustFromMPCC",""));

clientPackets.put(0xFF + 0x09
,new Packet("RequestOustFromPartyRoom",""));

clientPackets.put(0xFF + 0x0a
,new Packet("RequestDismissPartyRoom",""));

clientPackets.put(0xFF + 0x0b
,new Packet("RequestWithdrawPartyRoom",""));

clientPackets.put(0xFF + 0x0c
,new Packet("RequestChangePartyLeader",""));

clientPackets.put(0xFF + 0x0d
,new Packet("RequestAutoSoulShot",""));

clientPackets.put(0xFF + 0x0e
,new Packet("RequestExEnchantSkillInfo",""));

clientPackets.put(0xFF + 0x0f
,new Packet("RequestExEnchantSkill",""));

clientPackets.put(0xFF + 0x10
,new Packet("RequestExPledgeCrestLarge",""));

clientPackets.put(0xFF + 0x11
,new Packet("RequestExSetPledgeCrestLarge",""));

clientPackets.put(0xFF + 0x12
,new Packet("RequestPledgeSetAcademyMaster",""));

clientPackets.put(0xFF + 0x13
,new Packet("RequestPledgePowerGradeList",""));

clientPackets.put(0xFF + 0x14
,new Packet("RequestPledgeMemberPowerInfo",""));

clientPackets.put(0xFF + 0x15
,new Packet("RequestPledgeSetMemberPowerGrade",""));

clientPackets.put(0xFF + 0x16
,new Packet("RequestPledgeMemberInfo",""));

clientPackets.put(0xFF + 0x17
,new Packet("RequestPledgeWarList",""));

clientPackets.put(0xFF + 0x18
,new Packet("RequestExFishRanking",""));

clientPackets.put(0xFF + 0x19
,new Packet("RequestPCCafeCouponUse",""));

clientPackets.put(0xFF + 0x1b
,new Packet("RequestDuelStart",""));

clientPackets.put(0xFF + 0x1c
,new Packet("RequestDuelAnswerStart",""));

clientPackets.put(0xFF + 0x1e
,new Packet("RequestExRqItemLink",""));

clientPackets.put(0xFF + 0x21
,new Packet("RequestKeyMapping","")); 

clientPackets.put(0xFF + 0x24
,new Packet("RequestSaveInventoryOrder",""));

clientPackets.put(0xFF + 0x25
,new Packet("RequestExitPartyMatchingWaitingRoom",""));

clientPackets.put(0xFF + 0x26
,new Packet("RequestConfirmTargetItem",""));

clientPackets.put(0xFF + 0x27
,new Packet("RequestConfirmRefinerItem",""));

clientPackets.put(0xFF + 0x28
,new Packet("RequestConfirmGemStone",""));

clientPackets.put(0xFF + 0x29
,new Packet("RequestOlympiadObserverEnd",""));

clientPackets.put(0xFF + 0x2a
,new Packet("RequestCursedWeaponList",""));

clientPackets.put(0xFF + 0x2b
,new Packet("RequestCursedWeaponLocation",""));

clientPackets.put(0xFF + 0x2c
,new Packet("RequestPledgeReorganizeMember",""));

clientPackets.put(0xFF + 0x2e
,new Packet("RequestExMPCCShowPartyMembersInfo",""));

clientPackets.put(0xFF + 0x2f
,new Packet("RequestOlympiadMatchList",""));

clientPackets.put(0xFF + 0x30
,new Packet("RequestAskJoinPartyRoom",""));

clientPackets.put(0xFF + 0x31
,new Packet("AnswerJoinPartyRoom",""));

clientPackets.put(0xFF + 0x32
,new Packet("RequestListPartyMatchingWaitingRoom",""));

clientPackets.put(0xFF + 0x33
,new Packet("RequestExEnchantSkillSafe",""));

clientPackets.put(0xFF + 0x34
,new Packet("RequestExEnchantSkillUntrain",""));

clientPackets.put(0xFF + 0x35
,new Packet("RequestExEnchantSkillRouteChange",""));

clientPackets.put(0xFF + 0x36
,new Packet("ExGetOnAirShip",""));

clientPackets.put(0xFF + 0x3f
,new Packet("RequestAllCastleInfo",""));

clientPackets.put(0xFF + 0x40
,new Packet("RequestAllFortressInfo",""));

clientPackets.put(0xFF + 0x41
,new Packet("RequestAllAgitInfo",""));

clientPackets.put(0xFF + 0x42
,new Packet("RequestFortressSiegeInfo",""));

clientPackets.put(0xFF + 0x43
,new Packet("RequestGetBossRecord",""));

clientPackets.put(0xFF + 0x44
,new Packet("RequestRefine",""));

clientPackets.put(0xFF + 0x45
,new Packet("RequestConfirmCancelItem",""));

clientPackets.put(0xFF + 0x46
,new Packet("RequestRefineCancel",""));

clientPackets.put(0xFF + 0x47
,new Packet("RequestExMagicSkillUseGround",""));

clientPackets.put(0xFF + 0x48
,new Packet("RequestDuelSurrender",""));

clientPackets.put(0xFF + 0x49
,new Packet("RequestExEnchantSkillInfoDetail",""));

clientPackets.put(0xFF + 0x4b
,new Packet("RequestFortressMapInfo",""));

clientPackets.put(0xFF + 0x4d
,new Packet("SetPrivateStoreWholeMsg",""));

clientPackets.put(0xFF + 0x4e
,new Packet("RequestDispel",""));

clientPackets.put(0xFF + 0x4f
,new Packet("RequestExTryToPutEnchantTargetItem",""));

clientPackets.put(0xFF + 0x50
,new Packet("RequestExTryToPutEnchantSupportItem",""));

clientPackets.put(0xFF + 0x51
,new Packet("RequestExCancelEnchantItem",""));

clientPackets.put(0xFF + 0x52
,new Packet("RequestChangeNicknameColor",""));

clientPackets.put(0xFF + 0x53
,new Packet("RequestResetNickname",""));
        
    }
    
    public void loadPackets2(){
        serverPackets.put(0x2e
,new Packet("KeyPacket",""));

serverPackets.put(0x09
,new Packet("CharSelectionInfo",""));

serverPackets.put(0x00
,new Packet("Die",""));

serverPackets.put(0x01
,new Packet("Revive",""));

serverPackets.put(0x05
,new Packet("SpawnItem",""));

serverPackets.put(0x06
,new Packet("SellList",""));

serverPackets.put(0x07
,new Packet("BuyList",""));

serverPackets.put(0x08
,new Packet("DeleteObject",""));

serverPackets.put(0x0b
,new Packet("CharSelected",""));

serverPackets.put(0x0c
,new Packet("NpcInfo",""));

serverPackets.put(0x0d
,new Packet("NewCharacterSuccess",""));

serverPackets.put(0x0f
,new Packet("CharCreateOk",""));

serverPackets.put(0x10
,new Packet("CharCreateFail",""));

serverPackets.put(0x11
,new Packet("ItemList",""));

serverPackets.put(0x12
,new Packet("SunRise",""));

serverPackets.put(0x13
,new Packet("SunSet",""));

serverPackets.put(0x14
,new Packet("TradeStart",""));

serverPackets.put(0x16
,new Packet("DropItem",""));

serverPackets.put(0x17
,new Packet("GetItem",""));

serverPackets.put(0x18
,new Packet("StatusUpdate",""));

serverPackets.put(0x19
,new Packet("NpcHtmlMessage",""));

serverPackets.put(0x1a
,new Packet("TradeOwnAdd",""));

serverPackets.put(0x1b
,new Packet("TradeOtherAdd",""));

serverPackets.put(0x1c
,new Packet("TradeDone",""));

serverPackets.put(0x1d
,new Packet("CharDeleteSuccess",""));

serverPackets.put(0x1e
,new Packet("CharDeleteFail",""));

serverPackets.put(0x1f
,new Packet("ActionFailed",""));

serverPackets.put(0x20
,new Packet("ServerClose",""));

serverPackets.put(0x21
,new Packet("InventoryUpdate",""));

serverPackets.put(0x22
,new Packet("TeleportToLocation",""));

serverPackets.put(0x23
,new Packet("TargetSelected",""));
 
serverPackets.put(0x24
,new Packet("TargetUnselected",""));

serverPackets.put(0x25
,new Packet("AutoAttackStart",""));

serverPackets.put(0x26
,new Packet("AutoAttackStop",""));

serverPackets.put(0x27
,new Packet("SocialAction",""));

serverPackets.put(0x28
,new Packet("ChangeMoveType",""));

serverPackets.put(0x29
,new Packet("ChangeWaitType",""));

serverPackets.put(0x2a
,new Packet("ManagePledgePower",""));

serverPackets.put(0x2c
,new Packet("AskJoinPledge",""));

serverPackets.put(0x2f
,new Packet("MoveToLocation",""));

serverPackets.put(0x30
,new Packet("NpcSay",""));

serverPackets.put(0x31
,new Packet("CharInfo",""));

serverPackets.put(0x32
,new Packet("UserInfo",""));

serverPackets.put(0x33
,new Packet("Attack",""));

serverPackets.put(0x39
,new Packet("AskJoinParty",""));

serverPackets.put(0x3a
,new Packet("JoinParty",""));

serverPackets.put(0x41
,new Packet("WareHouseDepositList",""));

serverPackets.put(0x42
,new Packet("SortedWareHouseWithdrawalList",""));

serverPackets.put(0x44
,new Packet("ShortCutRegister",""));

serverPackets.put(0x45
,new Packet("ShortCutInit",""));

serverPackets.put(0x47
,new Packet("StopMove",""));

serverPackets.put(0x48
,new Packet("MagicSkillUse",""));

serverPackets.put(0x49
,new Packet("MagicSkillCanceld",""));

serverPackets.put(0x4b
,new Packet("EquipUpdate",""));

serverPackets.put(0x4c
,new Packet("DoorInfo",""));

serverPackets.put(0x4d
,new Packet("DoorStatusUpdate",""));

serverPackets.put(0x4a
,new Packet("CreatureSay",""));

serverPackets.put(0x4e
,new Packet("PartySmallWindowAll",""));

serverPackets.put(0x4f
,new Packet("PartySmallWindowAdd",""));

serverPackets.put(0x50
,new Packet("PartySmallWindowDeleteAll",""));

serverPackets.put(0x51
,new Packet("PartySmallWindowDelete",""));

serverPackets.put(0x52
,new Packet("PartySmallWindowUpdate",""));

serverPackets.put(0x54
,new Packet("MagicSkillLaunched",""));

serverPackets.put(0x5a
,new Packet("PledgeShowMemberListAll",""));

serverPackets.put(0x5b
,new Packet("PledgeShowMemberListUpdate",""));

serverPackets.put(0x5c
,new Packet("PledgeShowMemberListAdd",""));

serverPackets.put(0x5d
,new Packet("PledgeShowMemberListDelete",""));

serverPackets.put(0x5f
,new Packet("SkillList",""));

serverPackets.put(0x60
,new Packet("VehicleInfo",""));

serverPackets.put(0x61
,new Packet("StopRotation",""));

serverPackets.put(0x62
,new Packet("SystemMessage",""));

serverPackets.put(0x63
,new Packet("StartPledgeWar",""));

serverPackets.put(0x65
,new Packet("StopPledgeWar",""));

serverPackets.put(0x67
,new Packet("SurrenderPledgeWar",""));

serverPackets.put(0x6a
,new Packet("PledgeCrest",""));

serverPackets.put(0x6b
,new Packet("SetupGauge",""));

serverPackets.put(0x6c
,new Packet("VehicleDeparture",""));

serverPackets.put(0x6d
,new Packet("VehicleCheckLocation",""));

serverPackets.put(0x6e
,new Packet("GetOnVehicle",""));

serverPackets.put(0x6f
,new Packet("GetOffVehicle",""));

serverPackets.put(0x70
,new Packet("SendTradeRequest",""));

serverPackets.put(0x71
,new Packet("RestartResponse",""));

serverPackets.put(0x72
,new Packet("MoveToPawn",""));

serverPackets.put(0x73
,new Packet("SSQInfo",""));

serverPackets.put(0x74
,new Packet("GameGuardQuery",""));

serverPackets.put(0x75
,new Packet("FriendList",""));

serverPackets.put(0x78
,new Packet("JoinPledge",""));

serverPackets.put(0x79
,new Packet("ValidateLocation",""));

serverPackets.put(0x80
,new Packet("ValidateLocationInVehicle",""));

serverPackets.put(0x7a
,new Packet("StartRotation",""));

serverPackets.put(0x7b
,new Packet("ShowBoard",""));

serverPackets.put(0x7c
,new Packet("ChooseInventoryItem",""));

serverPackets.put(0x7e
,new Packet("MoveToLocationInVehicle",""));

serverPackets.put(0x7f
,new Packet("StopMoveInVehicle",""));

serverPackets.put(0x83
,new Packet("FriendAddRequest",""));

serverPackets.put(0x84
,new Packet("LeaveWorld",""));

serverPackets.put(0x85
,new Packet("AbnormalStatusUpdate",""));

serverPackets.put(0x86
,new Packet("QuestList",""));

serverPackets.put(0x87
,new Packet("EnchantResult",""));

serverPackets.put(0x88
,new Packet("PledgeShowMemberListDeleteAll",""));

serverPackets.put(0x8c
,new Packet("Ride",""));

serverPackets.put(0x8e
,new Packet("PledgeShowInfoUpdate",""));

serverPackets.put(0x90
,new Packet("AcquireSkillList",""));

serverPackets.put(0x91
,new Packet("AcquireSkillInfo",""));

serverPackets.put(0x95
,new Packet("GMViewCharacterInfo",""));

serverPackets.put(0x96
,new Packet("GMViewPledgeInfo",""));

serverPackets.put(0x97
,new Packet("GMViewSkillInfo",""));

serverPackets.put(0x99
,new Packet("GmViewQuestInfo",""));

serverPackets.put(0x9a
,new Packet("GMViewItemList",""));

serverPackets.put(0x9b
,new Packet("GMViewWarehouseWithdrawList",""));

serverPackets.put(0x9c
,new Packet("ListPartyWating",""));

serverPackets.put(0x9d
,new Packet("PartyMatchDetail",""));

serverPackets.put(0x9e
,new Packet("PlaySound",""));

serverPackets.put(0x9f
,new Packet("StaticObject",""));

serverPackets.put(0xa0
,new Packet("PrivateStoreManageListSell",""));

serverPackets.put(0xa1
,new Packet("PrivateStoreListSell",""));

serverPackets.put(0xa2
,new Packet("PrivateStoreMsgSell",""));

serverPackets.put(0xa3
,new Packet("ShowMiniMap",""));

serverPackets.put(0xa6
,new Packet("TutorialShowHtml",""));

serverPackets.put(0xa7
,new Packet("TutorialShowQuestionMark",""));

serverPackets.put(0xa8
,new Packet("TutorialEnableClientEvent",""));

serverPackets.put(0xa9
,new Packet("TutorialCloseHtml",""));

serverPackets.put(0xaf
,new Packet("AllyCrest",""));

serverPackets.put(0xb1
,new Packet("PetStatusShow",""));

serverPackets.put(0xb2
,new Packet("PetInfo",""));

serverPackets.put(0xb3
,new Packet("PetItemList",""));

serverPackets.put(0xb4
,new Packet("PetInventoryUpdate",""));

serverPackets.put(0xb5
,new Packet("AllyInfo",""));

serverPackets.put(0xb6
,new Packet("PetStatusUpdate",""));

serverPackets.put(0xb7
,new Packet("PetDelete",""));

serverPackets.put(0xb9
,new Packet("MyTargetSelected",""));

serverPackets.put(0xba
,new Packet("PartyMemberPosition",""));

serverPackets.put(0xbb
,new Packet("AskJoinAlly",""));

serverPackets.put(0xbd
,new Packet("PrivateStoreManageListBuy",""));

serverPackets.put(0xbe
,new Packet("PrivateStoreListBuy",""));

serverPackets.put(0xbf
,new Packet("PrivateStoreMsgBuy",""));

serverPackets.put(0xc0
,new Packet("VehicleStarted",""));

serverPackets.put(0xc7
,new Packet("SkillCoolTime",""));

serverPackets.put(0xc8
,new Packet("PackageToList",""));

serverPackets.put(0xc9
,new Packet("FortressSiegeInfo",""));

serverPackets.put(0xca
,new Packet("FortSiegeAttackerList",""));

serverPackets.put(0xcb
,new Packet("FortSiegeDefenderList",""));

serverPackets.put(0xcc
,new Packet("NicknameChanged",""));

serverPackets.put(0xcd
,new Packet("PledgeStatusChanged",""));

serverPackets.put(0xce
,new Packet("RelationChanged",""));

serverPackets.put(0xd0
,new Packet("MultiSellList",""));

serverPackets.put(0xd1
,new Packet("SetSummonRemainTime",""));

serverPackets.put(0xd2
,new Packet("PackageSendableList",""));

serverPackets.put(0xd6
,new Packet("SpecialCamera",""));

serverPackets.put(0xda
,new Packet("Dice",""));

serverPackets.put(0xd3
,new Packet("Earthquake",""));

serverPackets.put(0xd4
,new Packet("FlyToLocation",""));

serverPackets.put(0xd7
,new Packet("NormalCamera",""));

serverPackets.put(0xdb
,new Packet("Snoop",""));

serverPackets.put(0xdc
,new Packet("RecipeBookItemList",""));

serverPackets.put(0xdd
,new Packet("RecipeItemMakeInfo",""));

serverPackets.put(0xde
,new Packet("RecipeShopManageList",""));

serverPackets.put(0xdf
,new Packet("RecipeShopSellList",""));

serverPackets.put(0xe0
,new Packet("RecipeShopItemInfo",""));

serverPackets.put(0xe1
,new Packet("RecipeShopMsg",""));

serverPackets.put(0xe2
,new Packet("ShowCalculator",""));

serverPackets.put(0xe3
,new Packet("MonRaceInfo",""));

serverPackets.put(0xe4
,new Packet("HennaItemInfo",""));

serverPackets.put(0xe5
,new Packet("HennaInfo",""));

serverPackets.put(0xe8
,new Packet("SendMacroList",""));

serverPackets.put(0xe9
,new Packet("BuyListSeed",""));

serverPackets.put(0xea
,new Packet("ShowTownMap",""));

serverPackets.put(0xeb
,new Packet("ObservationMode",""));

serverPackets.put(0xec
,new Packet("ObservationReturn",""));

serverPackets.put(0xed
,new Packet("ChairSit",""));

serverPackets.put(0xee
,new Packet("HennaEquipList",""));

serverPackets.put(0xef
,new Packet("SellListProcure",""));

serverPackets.put(0xf0
,new Packet("GMHennaInfo",""));

serverPackets.put(0xf1
,new Packet("RadarControl",""));

serverPackets.put(0xf2 
,new Packet("ClientSetTime",""));

serverPackets.put(0xf3
,new Packet("ConfirmDlg",""));

serverPackets.put(0xf4
,new Packet("PartySpelled",""));

serverPackets.put(0xf5
,new Packet("ShopPreviewList",""));

serverPackets.put(0xf7
,new Packet("CameraMode",""));

serverPackets.put(0xf8
,new Packet("ShowXMasSeal",""));

serverPackets.put(0xf9
,new Packet("EtcStatusUpdate",""));

serverPackets.put(0xfa
,new Packet("ShortBuffStatusUpdate",""));

serverPackets.put(0xfb
,new Packet("SSQStatus",""));

serverPackets.put(0xfd
,new Packet("AgitDecoInfo",""));

serverPackets.put(0xFF + 0x01
,new Packet("ExRegMax",""));

serverPackets.put(0xFF + 0x0e
,new Packet("ExAutoSoulShot",""));

serverPackets.put(0xFF + 0x12
,new Packet("ExOpenMPCC",""));

serverPackets.put(0xFF + 0x13
,new Packet("ExCloseMPCC",""));

serverPackets.put(0xFF + 0x14
,new Packet("ExShowCastleInfo",""));

serverPackets.put(0xFF + 0x15
,new Packet("ExShowFortressInfo",""));

serverPackets.put(0xFF + 0x16
,new Packet("ExShowAgitInfo",""));

serverPackets.put(0xFF + 0x17
,new Packet("ExShowFortressSiegeInfo",""));

serverPackets.put(0xFF + 0x18
,new Packet("ExPartyPetWindowAdd",""));

serverPackets.put(0xFF + 0x19
,new Packet("ExPartyPetWindowUpdate",""));

serverPackets.put(0xFF + 0x1a
,new Packet("ExAskJoinMPCC",""));

serverPackets.put(0xFF + 0x1b
,new Packet("ExPledgeCrestLarge",""));

serverPackets.put(0xFF + 0x1e
,new Packet("ExFishingStart",""));

serverPackets.put(0xFF + 0x1f
,new Packet("ExFishingEnd",""));

serverPackets.put(0xFF + 0x20
,new Packet("ExShowQuestInfo",""));

serverPackets.put(0xFF + 0x21
,new Packet("ExShowQuestMark",""));

serverPackets.put(0xFF + 0x22
,new Packet("ExSendManorList",""));

serverPackets.put(0xFF + 0x23
,new Packet("ExShowSeedInfo",""));

serverPackets.put(0xFF + 0x24
,new Packet("ExShowCropInfo",""));

serverPackets.put(0xFF + 0x25
,new Packet("ExShowManorDefaultInfo",""));

serverPackets.put(0xFF + 0x26
,new Packet("ExShowSeedSetting",""));

serverPackets.put(0xFF + 0x27
,new Packet("ExFishingStartCombat",""));

serverPackets.put(0xFF + 0x28
,new Packet("ExFishingHpRegen",""));

serverPackets.put(0xFF + 0x29
,new Packet("ExEnchantSkillList",""));

serverPackets.put(0xFF + 0x2a
,new Packet("ExEnchantSkillInfo",""));

serverPackets.put(0xFF + 0x2b
,new Packet("ExShowCropSetting",""));

serverPackets.put(0xFF + 0x2c
,new Packet("ExShowSellCropList",""));

serverPackets.put(0xFF + 0x2e
,new Packet("ExMailArrived",""));

serverPackets.put(0xFF + 0x2f
,new Packet("ExStorageMaxCount",""));

serverPackets.put(0xFF + 0x31
,new Packet("ExMultiPartyCommandChannelInfo",""));

serverPackets.put(0xFF + 0x32
,new Packet("ExPCCafePointInfo",""));

serverPackets.put(0xFF + 0x33
,new Packet("ExSetCompassZoneCode",""));

serverPackets.put(0xFF + 0x34
,new Packet("ExGetBossRecord",""));

serverPackets.put(0xFF + 0x38
,new Packet("ExShowAdventurerGuideBook",""));

serverPackets.put(0xFF + 0x39
,new Packet("ExShowScreenMessage",""));

serverPackets.put(0xFF + 0x3a
,new Packet("PledgeSkillList",""));

serverPackets.put(0xFF + 0x3b
,new Packet("PledgeSkillListAdd",""));

serverPackets.put(0xFF + 0x3c
,new Packet("PledgePowerGradeList",""));

serverPackets.put(0xFF + 0x3d
,new Packet("PledgeReceivePowerInfo",""));

serverPackets.put(0xFF + 0x3e
,new Packet("PledgeReceiveMemberInfo",""));

serverPackets.put(0xFF + 0x3f
,new Packet("PledgeReceiveWarList",""));

serverPackets.put(0xFF + 0x40
,new Packet("PledgeReceiveSubPledgeCreated",""));

serverPackets.put(0xFF + 0x41
,new Packet("ExRedSky",""));

serverPackets.put(0xFF + 0x44
,new Packet("ShowPCCafeCouponShowUI",""));

serverPackets.put(0xFF + 0x35
,new Packet("ExAskJoinPartyRoom",""));

serverPackets.put(0xFF + 0x45
,new Packet("ExSearchOrc",""));

serverPackets.put(0xFF + 0x46
,new Packet("ExCursedWeaponList",""));

serverPackets.put(0xFF + 0x47
,new Packet("ExCursedWeaponLocation",""));

serverPackets.put(0xFF + 0x48
,new Packet("ExRestartClient",""));

serverPackets.put(0xFF + 0x49
,new Packet("ExRequestHackShield",""));

serverPackets.put(0xFF + 0x4a
,new Packet("ExUseSharedGroupItem",""));

serverPackets.put(0xFF + 0x4b
,new Packet("ExMPCCShowPartyMemberInfo",""));

serverPackets.put(0xFF + 0x4c
,new Packet("ExDuelAskStart",""));

serverPackets.put(0xFF + 0x4d
,new Packet("ExDuelReady",""));

serverPackets.put(0xFF + 0x4e
,new Packet("ExDuelStart",""));

serverPackets.put(0xFF + 0x4f
,new Packet("ExDuelEnd",""));

serverPackets.put(0xFF + 0x50
,new Packet("ExDuelUpdateUserInfo",""));

serverPackets.put(0xFF + 0x51
,new Packet("ExShowVariationMakeWindow",""));

serverPackets.put(0xFF + 0x52
,new Packet("ExShowVariationCancelWindow",""));

serverPackets.put(0xFF + 0x53
,new Packet("ExPutItemResultForVariationMake",""));

serverPackets.put(0xFF + 0x54
,new Packet("ExPutIntensiveResultForVariationMake",""));

serverPackets.put(0xFF + 0x55
,new Packet("ExPutCommissionResultForVariationMake",""));

serverPackets.put(0xFF + 0x56
,new Packet("ExVariationResult",""));

serverPackets.put(0xFF + 0x57
,new Packet("ExPutItemResultForVariationCancel",""));

serverPackets.put(0xFF + 0x58
,new Packet("ExVariationCancelResult",""));

serverPackets.put(0xFF + 0x5c
,new Packet("ExPlayScene",""));

serverPackets.put(0xFF + 0x5d
,new Packet("ExSpawnEmitter",""));

serverPackets.put(0xFF + 0x5b
,new Packet("ExMPCCPartyInfoUpdate",""));

serverPackets.put(0xFF + 0x5e
,new Packet("ExEnchantSkillInfoDetail",""));

serverPackets.put(0xFF + 0x5f
,new Packet("ExBasicActionList",""));

serverPackets.put(0xFF + 0x62
,new Packet("ExChooseInventoryAttributeItem",""));

serverPackets.put(0xFF + 0x67
,new Packet("ExShowTrace",""));

serverPackets.put(0xFF + 0x6a
,new Packet("ExPartyPetWindowDelete",""));

serverPackets.put(0xFF + 0x6c
,new Packet("ExRpItemLink",""));

serverPackets.put(0xFF + 0x78
,new Packet("ExShowProcureCropDetail",""));

serverPackets.put(0xFF + 0x79
,new Packet("ExHeroList",""));

serverPackets.put(0xFF + 0x7a
,new Packet("ExOlympiadUserInfoSpectator",""));

serverPackets.put(0xFF + 0x7b
,new Packet("ExOlympiadSpelledInfo",""));

serverPackets.put(0xFF + 0x7c
,new Packet("ExOlympiadMode",""));

serverPackets.put(0xFF + 0x7d
,new Packet("ExShowFortressMapInfo",""));

serverPackets.put(0xFF + 0x80
,new Packet("ExPrivateStoreSetWholeMsg",""));
    }

    public void loadPackets3(){
        loginClientPackets.put(0x07, new Packet("AuthGameGuard",""));
        loginClientPackets.put(0x00, new Packet("RequestAuthLogin",""));
        loginClientPackets.put(0x05, new Packet("RequestServerList",""));
        loginClientPackets.put(0x02, new Packet("RequestServerLogin",""));
        
        loginServerPackets.put(0x00, new Packet("Init",""));
        loginServerPackets.put(0x01, new Packet("LoginFail",""));
        loginServerPackets.put(0x03, new Packet("LoginOk",""));
        loginServerPackets.put(0x06, new Packet("PlayFail",""));
        loginServerPackets.put(0x07, new Packet("PlayOk",""));
        loginServerPackets.put(0x04, new Packet("ServerList",""));
        loginServerPackets.put(0x02, new Packet("AccountKicked",""));
        loginServerPackets.put(0x0b, new Packet("GGAuth",""));
        
        unknown = new Packet("Unknown","");
        
    }
    


}


