/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author carl
 */
public class Acciones extends JPanel{
    public Acciones(){
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        add(new JLabel("Basicas"+ ":"));
            JPanel acc = new JPanel();
            SpringLayout spl = new SpringLayout();
            acc.setLayout(spl);
            ImagePanel sitstand = new ImagePanel(0,"img/sit.gif","Sentarse o Levantarse (/sit, /stand)");
            ImagePanel runwalk = new ImagePanel(0,"img/run.gif","Correr o andar (/run, /walk)");
            ImagePanel atacar = new ImagePanel(0,"img/atacar.gif","atacar (/attack)");
            ImagePanel trade = new ImagePanel(0,"img/trade.gif","Tradear (/trade)");
            ImagePanel next = new ImagePanel(0,"img/next.gif","Siguiente objetivo (/nexttarget)");
            ImagePanel cojer = new ImagePanel(0,"img/pick.gif","cojer (/pick)");
            ImagePanel assist = new ImagePanel(0,"img/assist.gif","asistit (/assist)");
            ImagePanel sell = new ImagePanel(0,"img/sell.gif","vender");
            ImagePanel buy = new ImagePanel(0,"img/buy.gif","comprar");
            ImagePanel evaluar = new ImagePanel(0,"img/evaluate.gif","Recomendar");
            ImagePanel craft = new ImagePanel(0,"img/craft.gif","craft shop");
            ImagePanel find = new ImagePanel(0,"img/find.gif","buscar");
            ImagePanel duel = new ImagePanel(0,"img/duel.gif","Duelo");
            ImagePanel loseduel = new ImagePanel(0,"img/loseduel.gif","Abandonar el duelo (aka perder)");
            ImagePanel packsell = new ImagePanel(0,"img/all.gif","vender paquete");
            
            spl.putConstraint(SpringLayout.NORTH, sitstand, 3, SpringLayout.NORTH, acc);
            spl.putConstraint(SpringLayout.NORTH, runwalk, 3, SpringLayout.NORTH, acc);
            spl.putConstraint(SpringLayout.NORTH, atacar, 3, SpringLayout.NORTH, acc);
            spl.putConstraint(SpringLayout.NORTH, trade, 3, SpringLayout.NORTH, acc);
            spl.putConstraint(SpringLayout.NORTH, next, 3, SpringLayout.NORTH, acc);
            spl.putConstraint(SpringLayout.NORTH, cojer, 3, SpringLayout.NORTH, acc);
            spl.putConstraint(SpringLayout.NORTH, assist, 3, SpringLayout.NORTH, acc);
            spl.putConstraint(SpringLayout.NORTH, sell, 3, SpringLayout.NORTH, acc);
            spl.putConstraint(SpringLayout.NORTH, buy, 3, SpringLayout.NORTH, acc);
            spl.putConstraint(SpringLayout.NORTH, evaluar, 3, SpringLayout.NORTH, acc);
            
            spl.putConstraint(SpringLayout.WEST, sitstand, 3, SpringLayout.WEST, acc);
            spl.putConstraint(SpringLayout.WEST, runwalk, 3, SpringLayout.EAST, sitstand);
            spl.putConstraint(SpringLayout.WEST, atacar, 3, SpringLayout.EAST, runwalk);
            spl.putConstraint(SpringLayout.WEST, trade, 3, SpringLayout.EAST, atacar);
            spl.putConstraint(SpringLayout.WEST, next, 3, SpringLayout.EAST, trade);
            spl.putConstraint(SpringLayout.WEST, cojer, 3, SpringLayout.EAST, next);
            spl.putConstraint(SpringLayout.WEST, assist, 3, SpringLayout.EAST, cojer);
            spl.putConstraint(SpringLayout.WEST, sell, 3, SpringLayout.EAST, assist);
            spl.putConstraint(SpringLayout.WEST, buy, 3, SpringLayout.EAST, sell);
            spl.putConstraint(SpringLayout.WEST, evaluar, 3, SpringLayout.EAST, buy);
            
            spl.putConstraint(SpringLayout.NORTH, find, 3, SpringLayout.SOUTH, sitstand);
            spl.putConstraint(SpringLayout.NORTH, duel, 3, SpringLayout.SOUTH, sitstand);
            spl.putConstraint(SpringLayout.NORTH, loseduel, 3, SpringLayout.SOUTH, sitstand);
            spl.putConstraint(SpringLayout.NORTH, packsell, 3, SpringLayout.SOUTH, sitstand);
            spl.putConstraint(SpringLayout.NORTH, craft, 3, SpringLayout.SOUTH, sitstand);
            
            spl.putConstraint(SpringLayout.WEST, find, 3, SpringLayout.WEST, acc);
            spl.putConstraint(SpringLayout.WEST, duel, 3, SpringLayout.EAST, sitstand);
            spl.putConstraint(SpringLayout.WEST, loseduel, 3, SpringLayout.EAST, runwalk);
            spl.putConstraint(SpringLayout.WEST, packsell, 3, SpringLayout.EAST, atacar);
            spl.putConstraint(SpringLayout.WEST, craft, 3, SpringLayout.EAST, packsell);
            acc.add(sitstand);
            acc.add(runwalk);
            acc.add(atacar);
            acc.add(trade);
            acc.add(next);
            acc.add(cojer);
            acc.add(assist);
            acc.add(sell);
            acc.add(buy);
            acc.add(evaluar);
            acc.add(craft);
            acc.add(find);
            acc.add(duel);
            acc.add(loseduel);
            acc.add(packsell);  
        add(acc);
        add(new JLabel("Party" + ":"));
        
            JPanel acp = new JPanel();
            SpringLayout spll = new SpringLayout();
            acp.setLayout(spll);
            ImagePanel invite = new ImagePanel(0,"img/invite.gif","invitar a tu party (/invite)");
            ImagePanel leave = new ImagePanel(0,"img/leave.gif","irse de la party (/leave)");
            ImagePanel echar = new ImagePanel(0,"img/witdraw.gif","echar de la party");
            ImagePanel dismissleader = new ImagePanel(0,"img/cpl.gif","Dejar de ser el lider de la party");
            ImagePanel nombrar = new ImagePanel(0,"img/nombrar.gif","Nombrar lider de laparty");
            ImagePanel partychannel = new ImagePanel(0,"img/partychannel.gif","Canal de la party");
            ImagePanel partyduel = new ImagePanel(0,"img/partyd.gif","duelo de partys");
            
            spll.putConstraint(SpringLayout.NORTH, invite, 3, SpringLayout.NORTH, acp);
            spll.putConstraint(SpringLayout.NORTH, leave, 3, SpringLayout.NORTH, acp);
            spll.putConstraint(SpringLayout.NORTH, echar, 3, SpringLayout.NORTH, acp);
            spll.putConstraint(SpringLayout.NORTH, dismissleader, 3, SpringLayout.NORTH, acp);
            spll.putConstraint(SpringLayout.NORTH, nombrar, 3, SpringLayout.NORTH, acp);
            spll.putConstraint(SpringLayout.NORTH, partychannel, 3, SpringLayout.NORTH, acp);
            spll.putConstraint(SpringLayout.NORTH, partyduel, 3, SpringLayout.NORTH, acp);
            
            spll.putConstraint(SpringLayout.WEST, invite, 3, SpringLayout.WEST, acp);
            spll.putConstraint(SpringLayout.WEST, leave, 3, SpringLayout.EAST, invite);
            spll.putConstraint(SpringLayout.WEST, echar, 3, SpringLayout.EAST, leave);
            spll.putConstraint(SpringLayout.WEST, dismissleader, 3, SpringLayout.EAST, echar);
            spll.putConstraint(SpringLayout.WEST, nombrar, 3, SpringLayout.EAST, dismissleader);
            spll.putConstraint(SpringLayout.WEST, partychannel, 3, SpringLayout.EAST, nombrar);
            spll.putConstraint(SpringLayout.WEST, partyduel, 3, SpringLayout.EAST, partychannel);

            acp.add(invite);
            acp.add(leave);
            acp.add(echar);
            acp.add(dismissleader);
            acp.add(nombrar);
            acp.add(partychannel);
            acp.add(partyduel);
        add(acp);
        add(new JLabel("Acciones soaciales" + ":"));
            JPanel accs = new JPanel();
            SpringLayout spls = new SpringLayout();
            accs.setLayout(spls);
            ImagePanel hola = new ImagePanel(0,"img/hello.gif","Accion social: saludo");
            ImagePanel victoria = new ImagePanel(0,"img/victory.gif","Accion social: victoria");
            ImagePanel adelante = new ImagePanel(0,"img/avance.gif","Accion social: avanzar");
            ImagePanel si = new ImagePanel(0,"img/yes.gif","Accion social: si");
            ImagePanel no = new ImagePanel(0,"img/no.gif","Accion social: no");
            ImagePanel reverencia = new ImagePanel(0,"img/arrodillarse.gif","Accion social: reverencia");
            ImagePanel distraido = new ImagePanel(0,"img/distraido.gif","Accion social: distraido");
            ImagePanel estirarse = new ImagePanel(0,"img/estirarse.gif","Accion social: estirarse");
            ImagePanel idea = new ImagePanel(0,"img/idea.gif","Accion social: idea");
            ImagePanel aplaudir = new ImagePanel(0,"img/aplaudir.gif","Accion social: aplaudir");
            ImagePanel bailar = new ImagePanel(0,"img/vailar.gif","Accion social: bailar");
            ImagePanel llorar = new ImagePanel(0,"img/llorar.gif","Accion social: llorar");
            
            spls.putConstraint(SpringLayout.NORTH, hola, 3, SpringLayout.NORTH, accs);
            spls.putConstraint(SpringLayout.NORTH, victoria, 3, SpringLayout.NORTH, accs);
            spls.putConstraint(SpringLayout.NORTH, adelante, 3, SpringLayout.NORTH, accs);
            spls.putConstraint(SpringLayout.NORTH, si, 3, SpringLayout.NORTH, accs);
            spls.putConstraint(SpringLayout.NORTH, no, 3, SpringLayout.NORTH, accs);
            spls.putConstraint(SpringLayout.NORTH, reverencia, 3, SpringLayout.NORTH, accs);
            spls.putConstraint(SpringLayout.NORTH, distraido, 3, SpringLayout.NORTH, accs);
            spls.putConstraint(SpringLayout.NORTH, estirarse, 3, SpringLayout.NORTH, accs);
            spls.putConstraint(SpringLayout.NORTH, idea, 3, SpringLayout.NORTH, accs);
            spls.putConstraint(SpringLayout.NORTH, aplaudir, 3, SpringLayout.NORTH, accs);
            
            spls.putConstraint(SpringLayout.WEST, hola, 3, SpringLayout.WEST, accs);
            spls.putConstraint(SpringLayout.WEST, victoria, 3, SpringLayout.EAST, hola);
            spls.putConstraint(SpringLayout.WEST, adelante, 3, SpringLayout.EAST, victoria);
            spls.putConstraint(SpringLayout.WEST, si, 3, SpringLayout.EAST, adelante);
            spls.putConstraint(SpringLayout.WEST, no, 3, SpringLayout.EAST, si);
            spls.putConstraint(SpringLayout.WEST, reverencia, 3, SpringLayout.EAST, no);
            spls.putConstraint(SpringLayout.WEST, distraido, 3, SpringLayout.EAST, reverencia);
            spls.putConstraint(SpringLayout.WEST, estirarse, 3, SpringLayout.EAST, distraido);
            spls.putConstraint(SpringLayout.WEST, idea, 3, SpringLayout.EAST, estirarse);
            spls.putConstraint(SpringLayout.WEST, aplaudir, 3, SpringLayout.EAST, idea);
            
            
            spls.putConstraint(SpringLayout.NORTH, bailar, 3, SpringLayout.SOUTH, hola);
            spls.putConstraint(SpringLayout.NORTH, llorar, 3, SpringLayout.SOUTH, hola);
            
            spls.putConstraint(SpringLayout.WEST, bailar, 3, SpringLayout.WEST, accs);
            spls.putConstraint(SpringLayout.WEST, llorar, 3, SpringLayout.EAST, bailar);

            accs.add(hola);
            accs.add(victoria);
            accs.add(adelante);
            accs.add(si);
            accs.add(no);
            accs.add(reverencia);
            accs.add(distraido);
            accs.add(estirarse);
            accs.add(idea);
            accs.add(aplaudir);
            accs.add(bailar);
            accs.add(llorar);
       add(accs);
         
    }
}
