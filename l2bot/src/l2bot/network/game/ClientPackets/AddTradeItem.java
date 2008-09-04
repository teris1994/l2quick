/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package l2bot.network.game.ClientPackets;


/**
 * This class ...
 *
 * @version $Revision: 1.5.2.2.2.5 $ $Date: 2005/03/27 15:29:29 $
 */
public final class AddTradeItem extends L2GameClientPacket
{
    private static final String _C__16_ADDTRADEITEM = "[C] 16 AddTradeItem";

    public AddTradeItem()
    {
    }


	protected void readImpl(int tradeId, int objectId, int count)
	{
    	writeD(tradeId);
        writeD(objectId);
        writeD(count);
	}
/*
    //@Override
	protected void runImpl()
    {
        L2PcInstance player = getClient().getActiveChar();
        if (player == null) return;

        TradeList trade = player.getActiveTradeList();
        if (trade == null)
        	{
            _log.warning("Character: " + player.getName() + " requested item:" + _objectId + " add without active tradelist:" + _tradeId);
        	return;
        	}

        if (trade.getPartner() == null || L2World.getInstance().findObject(trade.getPartner().getObjectId()) == null)
        {
            // Trade partner not found, cancel trade
            if (trade.getPartner() != null)
            	_log.warning("Character:" + player.getName() + " requested invalid trade object: " + _objectId);
            SystemMessage msg = new SystemMessage(SystemMessageId.TARGET_IS_NOT_FOUND_IN_THE_GAME);
            player.sendPacket(msg);
            player.cancelActiveTrade();
            return;
        }

        if (!player.getAccessLevel().allowTransaction())
        {
            player.sendMessage("Transactions are disable for your Access Level");
            player.cancelActiveTrade();
            return;
        }

        if (!player.validateItemManipulation(_objectId, "trade"))
		{
			player.sendPacket(new SystemMessage(SystemMessageId.NOTHING_HAPPENED));
			return;
		}

        TradeList.TradeItem item = trade.addItem(_objectId, _count);
        if (item != null)
        {
        player.sendPacket(new TradeOwnAdd(item));
        trade.getPartner().sendPacket(new TradeOtherAdd(item));
        }
    }

    /* (non-Javadoc)
     * @see net.sf.l2j.gameserver.clientpackets.ClientBasePacket#getType()
     */
    ////@Override
	public String getType()
    {
        return _C__16_ADDTRADEITEM;
    }
}
