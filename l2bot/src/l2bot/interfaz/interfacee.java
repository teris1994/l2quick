package l2bot.interfaz;

/**
 *
 * @author carl
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import l2bot.Main;
import l2bot.interfaz.dialogs.NuevoPj;
import l2bot.interfaz.dialogs.ServerConfigDialog;

public class interfacee extends JFrame implements ActionListener{
	int alto  = 700;
	int ancho = 1024;
	CloseableTabbedPane tabs;

	public interfacee(){
		
		setTitle("L2Bot");

		//JLabel emptyLabel = new JLabel("");
        /*emptyLabel.setPreferredSize(new Dimension(ancho, alto));
        getContentPane().add(emptyLabel, BorderLayout.CENTER);*/
		
                this.setMinimumSize(new Dimension(ancho,alto));
		Tab();
		Menu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                
                    
                
                pack();
		
                setVisible(true);
                
                
                /*if(DialogosComunes.PreguntarNumero("hola... dime un numero!") > 0){
                System.out.println("grax");
                }*/
	}
	
	private void Menu(){
                JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Archivo");
		menu.setMnemonic(KeyEvent.VK_A);
		
                JMenuItem menuItem = new JMenuItem("Servidores",KeyEvent.VK_S);
		JMenuItem menuItem2 = new JMenuItem("Nuevo pj",KeyEvent.VK_N);
		
                menuItem.addActionListener(this);
                menuItem2.addActionListener(this);



                
		menu.add(menuItem);
		menu.add(menuItem2);
                
		menuBar.add(menu);
		setJMenuBar(menuBar);

	}
	
	private void Tab(){

		
		tabs = new CloseableTabbedPane();
		
		tabs.addCloseableTabbedPaneListener(new CloseableTabbedPaneListener() {
                    public boolean closeTab(int tabIndexToClose) {
                        Main.pjs.get(tabIndexToClose);
                        return false;
                    }
                });
                
		//makePJ("Panel #1");
		
		//makePJ("pj 1");
		getContentPane().add(tabs);
	}
	
	public void makePJ(PjInter pj) {
	
	//PjInter pj = new PjInter();
        
        
        
	//panel.setLayout(new GridLayout(1, 1));
        /*
        ItemList inventario = new ItemList(5,5);
        inventario.setVisible(true);
        panel.add(inventario);
	panel.add(filler);
	*/
        
        //panel.add(new ImageList(6,8));
        
        
	tabs.addTab(pj.toString(), pj);
        
	}
        
        
        
        public void actionPerformed(ActionEvent e) {
            String a = e.getActionCommand();

            if (a.equals("Servidores")){
                servidoresClick();
            }else if(a.equals("Nuevo pj")){
                nuevoPjClick();
            }
        }
        
        public void servidoresClick(){
            ServerConfigDialog scd = new ServerConfigDialog(this,true);
            scd.setVisible(true);
        }
        
        public void nuevoPjClick(){
            //System.out.println("asd");
            NuevoPj h = new NuevoPj(this, true);
            h.setVisible(true);
        }

}