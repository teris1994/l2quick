/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.pj.handlers;

import l2bot.pj.Pj;

/**
 *
 * @author carl
 */
public abstract class AbstractHandler {
    private Pj pj;

    public Pj getPj() {
        return pj;
    }

    public void setPj(Pj pj) {
        this.pj = pj;
    }


}
