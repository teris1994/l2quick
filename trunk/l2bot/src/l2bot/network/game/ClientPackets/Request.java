/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.game.ClientPackets;

/**
 *
 * @author carl
 */
public class Request extends  L2GameClientPacket{
    
    //Comprobar optcodes!!
    public enum request{
         RequestDismissAlly ((byte)0x86),
         RequestFriendList ((byte)0x60),
         RequestGmList ((byte)0x81),
         RequestItemList ((byte)0x0F),
         RequestPledgeMemberList ((byte)0x3C),
         RequestPrivateStoreManageBuy ((byte)0x90),
         RequestPrivateStoreManageSell ((byte)0x73),
         RequestPrivateStoreQuitBuy ((byte)0x93),
         RequestPrivateStoreQuitSell ((byte)0x76),
         RequestQuestList ((byte)0x63),
         RequestRecipeShopManageList ((byte)0xb0),
         RequestRecipeShopPrev ((byte)0xb7),
         RequestRecipeShopManageQuit ((byte)0xb2),
         RequestRecordInfo ((byte)0xcf),
         RequestRestart ((byte)0x46),
         RequestShowMiniMap ((byte)0xcd),
         RequestSiegeInfo ((byte)0x47),
         RequestSkillList ((byte)0x3f),
         RequestWithDrawalParty ((byte)0x2b),
         RequestWithdrawalPledge ((byte)0x26);
         
        private final byte id;
        
        /*
         * 86 RequestDismissAlly 
         * 60 RequestFriendList
         * 81 RequestGmList
         * 0F RequestItemList
         * 3C RequestPledgeMemberList
         * 90 RequestPrivateStoreManageBuy
         * 73 RequestPrivateStoreManageSell
         * 93 RequestPrivateStoreQuitBuy
           76 RequestPrivateStoreQuitSell
           63 RequestQuestList
           b0 RequestRecipeShopManageList
           b7 RequestRecipeShopPrev
           b2 RequestRecipeShopManageQuit
           CF RequestRecordInfo
           46 RequestRestart
           cd RequestShowMiniMap
           47 RequestSiegeInfo
           3F RequestSkillList
           2B RequestWithDrawalParty
           26 RequestWithdrawalPledge
         */
        
        request(byte b){
            this.id = b;
        }

        public byte pid(){
            return id;
        }
    };
    
    public Request(request r){
        writeC(r.pid());
    }
    
    
}
