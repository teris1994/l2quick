/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.network.game.ClientPackets;

/**
 * para los del tipo D0 xx
 * @author carl
 */
public class RequestAll extends  L2GameClientPacket{
    public enum request{
        RequesrCursedWeapomList((byte)0x2a),
        RequestCursedWeaponLocation((byte)0x2b),
         AllCastleInfo ((byte)0x3f),
         AllFortressInfo ((byte) 0x40),
         AllAgitInfo ((byte)0x41),
         RequestDuelSurrender ((byte)0x48),
         RequestExFishRanking ((byte)0x18),
         RequestExitPartyMatchingWaitingRoom ((byte)0x25),
         RequestFortressSiegeInfo ((byte)0x42),
         RequestGotoLobby((byte)0x00),
         RequestKeyMapping((byte)0x21),
         RequestListPartyMatchingWaitingRoom((byte)0x32),
         RequestManorList((byte)0x01),
         RequestOlympiadMatchList((byte)0x2f),
         RequestOlympiadObserverEnd((byte)0x29),
         RequestPVPMatchRecord((byte)0x00),
         RequestPledgePowerGradeList((byte)0x13),
        ;
         
         /*
          * _C__D0_22_REQUESTCURSEDWEAPONLIST     //2a
          * D0_23_REQUESTCURSEDWEAPONLOCATION     //2b
          * D0:30 RequestDuelSurrender             //48
          * D0:1F RequestExFishRanking             //18
          * D0:17 RequestExitPartyMatchingWaitingRoom //25
          * D0:42 RequestFortressSiegeInfo            //42
          * D0:38 RequestGotoLobby                     //  Este es para cuando todavia no estas ig
          * D0:21 RequestKeyMapping                      //21
          * D0:16 RequestListPartyMatchingWaitingRoom          //32
          * D0:01 RequestManorList                                //01
          * D0:13 RequestOlympiadMatchList                          //2f        
          * D0:12 RequestOlympiadObserverEnd                 //29
          * D0:4C RequestPVPMatchRecord                    //??????????
          * D0:1A RequestPledgePowerGradeList               //13
          */
        private final byte id;
        
        request(byte b){
            this.id = b;
        }

        public byte pid(){
            return id;
        }
    };
    
    public RequestAll(request r){
        writeC(0xD0);
        writeH(r.id);
    }
    
    
    
    /*
                                     case 0x01:
664 	                                msg = new RequestManorList();
665 	                                break;
666 	                            case 0x02:
667 	                                msg = new RequestProcureCropList();
668 	                                break;
669 	                            case 0x03:
670 	                                msg = new RequestSetSeed();
671 	                                break;
672 	                            case 0x04:
673 	                                msg = new RequestSetCrop();
674 	                                break;
675 	                            case 0x05:
676 	                                msg = new RequestWriteHeroWords();
677 	                                break;
678 	                            case 0x06:
679 	                                msg = new RequestExAskJoinMPCC();
680 	                                break;
681 	                            case 0x07:
682 	                                msg = new RequestExAcceptJoinMPCC();
683 	                                break;
684 	                            case 0x08:
685 	                                msg = new RequestExOustFromMPCC();
686 	                                break;
687 	                                        case 0x09:
688 	                                                msg = new RequestOustFromPartyRoom();
689 	                                                break;
690 	                                        case 0x0a:
691 	                                                msg = new RequestDismissPartyRoom();
692 	                                                break;
693 	                                        case 0x0b:
694 	                                                msg = new RequestWithdrawPartyRoom();
695 	                                                break;
696 	                                    case 0x0c:
697 	                                        msg = new RequestChangePartyLeader();
698 	                                        break;
699 	                                    case 0x0d:
700 	                                        msg = new RequestAutoSoulShot();
701 	                                        break;
702 	                                    case 0x0e:
703 	                                        msg = new RequestExEnchantSkillInfo();
704 	                                        break;
705 	                                    case 0x0f:
706 	                                        msg = new RequestExEnchantSkill();
707 	                                        break;
708 	                                    case 0x10:
709 	                                        msg = new RequestExPledgeCrestLarge();
710 	                                        break;
711 	                                    case 0x11:
712 	                                        msg = new RequestExSetPledgeCrestLarge();
713 	                                        break;
714 	                            case 0x12:
715 	                                msg = new RequestPledgeSetAcademyMaster();
716 	                                break;
717 	                            case 0x13:
718 	                                msg = new RequestPledgePowerGradeList();
719 	                                break;
720 	                            case 0x14:
721 	                                msg = new RequestPledgeMemberPowerInfo();
722 	                                break;
723 	                            case 0x15:
724 	                                msg = new RequestPledgeSetMemberPowerGrade();
725 	                                break;
726 	                            case 0x16:
727 	                                msg = new RequestPledgeMemberInfo();
728 	                                break;
729 	                            case 0x17:
730 	                                msg = new RequestPledgeWarList();
731 	                                break;
732 	                            case 0x18:
733 	                                msg = new RequestExFishRanking();
734 	                                break;
735 	                            case 0x19:
736 	                                msg = new RequestPCCafeCouponUse();
737 	                                break;
738 	                            case 0x1b:
739 	                                msg = new RequestDuelStart();
740 	                                break;
741 	                            case 0x1c:
742 	                                msg = new RequestDuelAnswerStart();
743 	                                break;
744 	                            case 0x1e:
745 	                                msg = new RequestExRqItemLink();
746 	                                break;
747 	                            case 0x21:
748 	                                msg = new RequestKeyMapping();
749 	                                break;
750 	                            case 0x22:
751 	                                // TODO implement me (just disabling warnings for this packet)
752 	                                break;
753 	                            case 0x24:
754 	                                msg = new RequestSaveInventoryOrder();
755 	                                break;
756 	                            case 0x25:
757 	                                msg = new RequestExitPartyMatchingWaitingRoom();
758 	                                break;
759 	                            case 0x26:
760 	                                msg = new RequestConfirmTargetItem();
761 	                                break;
762 	                            case 0x27:
763 	                                msg = new RequestConfirmRefinerItem();
764 	                                break;
765 	                            case 0x28:
766 	                                msg = new RequestConfirmGemStone();
767 	                                break;
768 	                                    case 0x29:
769 	                                        msg = new RequestOlympiadObserverEnd();
770 	                                        break;
771 	                            case 0x2a:
772 	                                msg = new RequestCursedWeaponList();
773 	                                break;
774 	                            case 0x2b:
775 	                                msg = new RequestCursedWeaponLocation();
776 	                                break;
777 	                            case 0x2c:
778 	                                msg = new RequestPledgeReorganizeMember();
779 	                                break;
780 	                            case 0x2e:
781 	                                msg = new RequestExMPCCShowPartyMembersInfo();
782 	                                break;
783 	                                    case 0x2f:
784 	                                        msg = new RequestOlympiadMatchList();
785 	                                        break;
786 	                                    case 0x30:
787 	                                        msg = new RequestAskJoinPartyRoom();
788 	                                        break;
789 	                                    case 0x31:
790 	                                        msg = new AnswerJoinPartyRoom();
791 	                                        break;
792 	                                    case 0x32:
793 	                                        msg = new RequestListPartyMatchingWaitingRoom();
794 	                                        break;
795 	                            case 0x33:
796 	                                msg = new RequestExEnchantSkillSafe();
797 	                                break;
798 	                            case 0x34:
799 	                                msg = new RequestExEnchantSkillUntrain();
800 	                                break;
801 	                            case 0x35:
802 	                                msg = new RequestExEnchantSkillRouteChange();
803 	                                break;
804 	                            case 0x36:
805 	                                msg = new ExGetOnAirShip();
806 	                                break;
807 	                            case 0x3f:
808 	                                msg = new RequestAllCastleInfo();
809 	                                break;
810 	                            case 0x40:
811 	                                msg = new RequestAllFortressInfo();
812 	                                break;
813 	                            case 0x41:
814 	                                msg = new RequestAllAgitInfo();
815 	                                break;
816 	                            case 0x42:
817 	                                msg = new RequestFortressSiegeInfo();
818 	                                break;
819 	                                    case 0x43:
820 	                                        msg = new RequestGetBossRecord();
821 	                                        break;
822 	                                    case 0x44:
823 	                                        msg = new RequestRefine();
824 	                                        break;
825 	                                    case 0x45:
826 	                                        msg = new RequestConfirmCancelItem();
827 	                                        break;
828 	                                    case 0x46:
829 	                                        msg = new RequestRefineCancel();
830 	                                        break;
831 	                                    case 0x47:
832 	                                        msg = new RequestExMagicSkillUseGround();
833 	                                        break;
834 	                                    case 0x48:
835 	                                        msg = new RequestDuelSurrender();
836 	                                        break;
837 	                                    case 0x49:
838 	                                        msg = new RequestExEnchantSkillInfoDetail();
839 	                                        break;
840 	                                    case 0x4b:
841 	                                        msg = new RequestFortressMapInfo();
842 	                                        break;
843 	                                    case 0x4d:
844 	                                        msg = new SetPrivateStoreWholeMsg();
845 	                                        break;
846 	                                    case 0x4e:
847 	                                        msg = new RequestDispel();
848 	                                        break;
849 	                                    case 0x4f:
850 	                                        msg = new RequestExTryToPutEnchantTargetItem();
851 	                                        break;
852 	                                    case 0x50:
853 	                                        msg = new RequestExTryToPutEnchantSupportItem();
854 	                                        break;
855 	                                    case 0x51:
856 	                                        msg = new RequestExCancelEnchantItem();
857 	                                        break;
858 	                                    case 0x52:
859 	                                        msg = new RequestChangeNicknameColor();
860 	                                        break;
861 	                                    case 0x53:
862 	                                        msg = new RequestResetNickname();
863 	                                        break;
864 	                                    default:
865 	                                        this.printDebugDoubleOpcode(opcode, id2, buf, state, client);
866 	                                        break;
867 	                                }
     
     
     */
    
    
    
}
