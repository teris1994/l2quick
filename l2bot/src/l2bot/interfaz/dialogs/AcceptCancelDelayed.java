package l2bot.interfaz.dialogs;

import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
//import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;
import l2bot.Idioma;
import l2bot.Main;


/**
 *
 * @author carl
 */
public class AcceptCancelDelayed extends JDialog implements Runnable{
    
    int milis;
    JProgressBar sdf;
    JButton Aceptar;
    JButton Cancelar;
    
    public AcceptCancelDelayed(int time,boolean cancel,boolean acept){
        super(Main.g,false);
        
        SpringLayout layout = new SpringLayout();
        
        setLayout(layout);
        
        
        Aceptar = new JButton(Idioma.aceptar);
        Cancelar = new JButton(Idioma.cancelar);
        
        
        
        sdf = new JProgressBar();
        
        layout.putConstraint(SpringLayout.EAST, sdf, 50, SpringLayout.EAST,this);
        layout.putConstraint(SpringLayout.NORTH, sdf, 50, SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST, sdf, 50, SpringLayout.WEST,this);
        
        layout.putConstraint(SpringLayout.NORTH, Aceptar, 20, SpringLayout.SOUTH,sdf);
        layout.putConstraint(SpringLayout.NORTH, Cancelar, 20, SpringLayout.SOUTH,sdf);
        
        layout.putConstraint(SpringLayout.EAST, Aceptar, 50, SpringLayout.EAST,this);
        layout.putConstraint(SpringLayout.EAST, Cancelar, 20, SpringLayout.WEST,Aceptar);
        
        
        
        milis = time;
        
        sdf.setMaximum(time);
        
        add(sdf);
        
        setVisible(true);
        
        Thread hilo = new Thread(this);
        hilo.start();
        
    }

    public void run() {
        long ult = Calendar.getInstance().getTimeInMillis() + milis;
        
        
        while(Calendar.getInstance().getTimeInMillis()<ult){
             sdf.setValue((int) (ult-Calendar.getInstance().getTimeInMillis()) );
             //System.out.println(ult -Calendar.getInstance().getTimeInMillis());
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                
            }
        } 
    }
}

