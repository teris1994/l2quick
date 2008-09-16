






package l2bot.network.game;

import l2bot.interfaz.logger;
import l2bot.network.game.ClientPackets.ProtocolVersion;
import l2bot.network.game.ServerPackets.*;
import l2bot.pj.Pj;

/**
 *
 * @author carl
 */
public class PacketsHandler {
    
    public static final byte ESTADO_CONECTANDO = 0;
    public static final byte ESTADO_AUTENTIFICADO = 1;
    public static final byte ESTADO_IN_GAME = 2;
    
    public Pj pj;
    
    public logger log;
    
    public byte estado = 0;
    public void onConect(){
        byte[] g = new ProtocolVersion(851).getBytes();
        sendPacketToGame(g);
    }
    
    
    public void paquete(byte[] raw){
        //System.out.println(LoginCrypt.byteArrayToHexString(raw));
        byte cde = raw[2];
        L2GameServerPacket pa;
        pa = null;
        switch(estado){
            case ESTADO_CONECTANDO:
            {
                switch(cde){
                    case 0x2e:
                        pa = new KeyPacket();
                        estado = ESTADO_AUTENTIFICADO;
                        break;
                }
                break;
            }
            case ESTADO_AUTENTIFICADO:
            {
                switch(cde){
                    case 0x09:
                        pa = new CharSelectionInfo();
                        break;
                }
            }
            case ESTADO_IN_GAME:
            {
                switch(cde & 0xFF){
                    case 0x00:
                        pa = new Die();
                        break;
                    case 0x07:
                        pa = new BuyList();
                        break;
                    case 0x08:
                        pa = new DeleteObject();
                        break;
                    case 0x10:
                        pa = new CharCreateFail();
                        break;
                    case 0x0b:
                        pa = new CharSelected();
                        break;
                    case 0x0c:
                        pa = new NpcInfo();
                        break;
                    case 0x0f:
                        pa = new CharCreateOk();
                        break;
                    case 0x1f:
                        pa = new ActionFailed();
                        break;
                    case 0x16:
                        pa = new DropItem();
                        break;
                    case 0x1e:
                        pa = new CharDeleteFail();
                        break;
                    case 0x1d:
                        pa = new CharDeleteSuccess();
                        break;
                    case 0x21:
                        pa = new InventoryUpdate();
                        break;
                    case 0x25:
                        pa = new AutoAttackStart();
                        break;
                    case 0x26:
                        pa = new AutoAttackStop();
                        break;
                    case 0x28:
                        pa = new ChangeMoveType();
                        break;
                    case 0x29:
                        pa = new ChangeWaitType();
                        break;
                    case 0x2c:
                        pa = new AskJoinPledge();
                        break;
                    case 0x31:
                        pa = new CharInfo();
                        break;
                    case 0x33:
                        pa = new Attack();
                        break;
                    case 0x39:
                        pa = new AskJoinParty();
                        break;
                    case 0x4b:
                        pa = new EquipUpdate();
                        break;
                    case 0x4c:
                        pa = new DoorInfo();
                        break;
                    case 0x4d:
                        pa = new DoorStatusUpdate();
                        break;
                    case 0x4a:
                        pa = new CreatureSay();
                        break;
                    case 0x4e:
                        pa = new PartySmallWindowAll();
                        break;
                    case 0x4f:
                        pa = new PartySmallWindowAdd();
                        break;
                    case 0x50:
                        pa = new PartySmallWindowDeleteAll();
                        break;
                    case 0x51:
                        pa = new PartySmallWindowDelete();
                        break;
                    case 0x52:
                        pa = new PartySmallWindowUpdate();
                        break;
                    case 0x62:
                        pa = new SystemMessage();
                        break;
                    case 0x73:
                        pa = new SSQInfo();
                        break;
                    case 0x7c:
                        pa = new ChooseInventoryItem();
                        break;
                    case 0x85:
                        pa = new AbnormalStatusUpdate();
                        break;
                    case 0x87:
                        pa = new EnchantResult();
                        break;
                    case 0x90:
                        pa = new AcquireSkillList();
                        break;
                    case 0x91:
                        pa = new AcquireSkillInfo();
                        break;
                    case 0x9d:
                        pa = new PartyMatchDetail();
                        break;
                    case 0xaf:
                        pa = new AllyCrest();
                        break;
                    case 0xb5:
                        pa = new AllyInfo();
                        break;
                    case 0xba:
                        pa = new PartyMemberPosition();
                        break;
                    case 0xbb:
                        pa = new AskJoinAlly();
                        break;
                    case 0xda:
                        pa = new Dice();
                        break;
                    case 0xe9:
                        pa = new BuyListSeed();
                        break;
                    case 0xed:
                        pa = new ChairSit();
                        break;
                    case 0xd3:
                        pa = new Earthquake();
                        break;
                    case 0xf2: 
                        pa = new ClientSetTime();
                        break;
                    case 0xf3:
                        pa = new ConfirmDlg();
                        break;
                    case 0xf4:
                        pa = new PartySpelled();
                        break;
                    case 0xf7:
                        pa = new CameraMode();
                        break;
                    case 0xf9:
                        pa = new EtcStatusUpdate();
                        break;
                    case 0xfe:
                        switch(raw[3]){
                            case 0x0e:
                                pa = new ExAutoSoulShot();
                                break;
                            case 0x18:
                                pa = new ExPartyPetWindowAdd();
                                break;
                            case 0x19:
                                pa = new ExPartyPetWindowUpdate();
                                break;
                            case 0x1a:
                                pa = new ExAskJoinMPCC();
                                break;
                            case 0x22:
                                pa = new ExSendManorList();
                                break;
                            case 0x35:
                                pa = new ExAskJoinPartyRoom();
                                break;
                            case 0x44:
                                pa = new ExCaptureOrc();
                                break;
                            case 0x5f:
                                pa = new ExBasicActionList();
                                break;
                            case 0x6a:
                                pa = new ExPartyPetWindowDelete();
                                break;
                            
                        }
                        break;
                    case 0xfd:
                        pa = new AgitDecoInfo();
                        break;
                        
                   
                }
            }
        }
        if(pa == null){log.logError("Unknown optcode:" + raw[2]);return;} 
        pa.setBytes(raw);
        pa.setPj(pj);
        pa.readP();
        
    }
    
    
    public void sendPacketToGame(byte[] raw){}
    

}
