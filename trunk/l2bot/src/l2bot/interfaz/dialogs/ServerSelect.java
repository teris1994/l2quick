/*
 * ServerSelect.java
 *
 * Created on 16 de agosto de 2008, 15:54
 */

package l2bot.interfaz.dialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import l2bot.Idioma;
import l2bot.network.login.GameServerInfo;
import l2bot.network.login.GameServersHandler;


/**
 *
 * @author  carl
 */
public class ServerSelect extends JDialog {


    /** Creates new form ServerSelect */

    DefaultTableModel tm;
    
    GameServersHandler gss;
    
    
    ColorRenderer colorRenderer;

    
    public ServerSelect(java.awt.Frame parent, GameServersHandler gsh, String gameservers) {
        super(parent, false);
        
        String[] gmss = gameservers.split(",");
        
        tm = new DefaultTableModel();
        tm.addColumn(Idioma.nombre);
        tm.addColumn(Idioma.estado);
        tm.addColumn(Idioma.players_max);
        initComponents();
        
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        for (int i = 0; i < gsh.gameServers.length; i++) {
            GameServerInfo gs = gsh.gameServers[i];
            addServer((gmss.length>i)?gmss[i]:"unknown",gs.players,gs.maxplayers,gs.online);
            
        }
        gss = gsh;

       // addServer("Liona",75,100,true);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable()		{
            @Override
			public Class getColumnClass(int column)
			{
				return getValueAt(0, column).getClass();
			}
 
			//  Apply background to existing renderer
 
                         @Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
			{
				Component c = super.prepareRenderer(renderer, row, column);
				colorRenderer.setBackground(c, row, column);
				return c;
			}
		};
        colorRenderer = new ColorRenderer( jTable1 );
        //colorRenderer.startBlinking(1000);


        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

       // jTable1.setAutoCreateColumnsFromModel(false);
       // jTable1.setAutoCreateRowSorter(true);
        
        jTable1.setModel(tm);
        jScrollPane1.setPreferredSize(new Dimension(120,120));
        
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText(Idioma.aceptar);
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAceptar((byte) jTable1.getSelectedRow());
                setVisible(false);
            }
        });
        

        jButton2.setText(Idioma.mostrar_info);
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogosComunes.mostrarTexto(gss.gameServers[(byte) jTable1.getSelectedRow()].toString());
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancelar();
                setVisible(false);
            }
        });
        jButton4.setText("Actualizar");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onActualizar();
                setVisible(false);
            }
        });  
        add(jScrollPane1);
        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        SpringLayout layout = new SpringLayout();
        layout.putConstraint(SpringLayout.NORTH, jScrollPane1, 5, SpringLayout.NORTH, this.getContentPane());
        layout.putConstraint(SpringLayout.WEST,jScrollPane1, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST,jScrollPane1, -5, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.EAST, this.getContentPane(), 5, SpringLayout.EAST, jButton3);
        layout.putConstraint(SpringLayout.NORTH, jButton1, 5, SpringLayout.SOUTH, jScrollPane1);
        layout.putConstraint(SpringLayout.NORTH, jButton2, 5, SpringLayout.SOUTH, jScrollPane1);
        layout.putConstraint(SpringLayout.NORTH, jButton3, 5, SpringLayout.SOUTH, jScrollPane1);
        layout.putConstraint(SpringLayout.NORTH, jButton4, 5, SpringLayout.SOUTH, jScrollPane1);
        layout.putConstraint(SpringLayout.WEST, jButton1, 5, SpringLayout.WEST, this.getContentPane());
        layout.putConstraint(SpringLayout.WEST, jButton2, 5, SpringLayout.EAST, jButton1);
        layout.putConstraint(SpringLayout.WEST, jButton4, 5, SpringLayout.EAST, jButton2);
        layout.putConstraint(SpringLayout.WEST, jButton3, 5, SpringLayout.EAST, jButton4);
        
        layout.putConstraint(SpringLayout.SOUTH, this.getContentPane(), 5, SpringLayout.SOUTH, jButton1);
        setLayout(layout);


        pack();
    }

    
    public void addServer(String nombre, int players, int maxPlayers, boolean online){
        String[] ser = {nombre, online?"online":"offline",players + "/" + maxPlayers};
        
        
        colorRenderer.setCellColor(tm.getRowCount(), 1, online?Color.GREEN:Color.RED); 
        colorRenderer.setCellColor(tm.getRowCount(), 2, maxPlayers!=0?(players/maxPlayers) < 0.5?Color.GREEN:(players/maxPlayers) < 0.75?Color.ORANGE:Color.RED:Color.BLACK); 
        
        
        tm.addRow(ser);
    
    }
    
    public void onAceptar(byte ser){}
    public void onCancelar(){}
    public void onActualizar(){}
    
    

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration

    
    	class ColorRenderer implements ActionListener
	{
		private JTable table;
		private AbstractTableModel model;
		private Map colors;
		private boolean isBlinking = true;
		private Timer timer;
		private Point location;
 
		public ColorRenderer(JTable table)
		{
			this.table = table;
			model = (AbstractTableModel)table.getModel();
			colors = new HashMap();
			location = new Point();
		}
 
		public void setBackground(Component c, int row, int column)
		{
			//  Don't override the background color of a selected cell
 
			if ( table.isCellSelected(row, column) ) return;
 
			//  The default render does not reset the background color
			//  that was set for the previous cell, so reset it here
 
			if (c instanceof DefaultTableCellRenderer)
			{
				//c.setBackground( table.getBackground() );
                                c.setForeground( table.getForeground());
			}
 
			//  Don't highlight this time
 
			if ( !isBlinking ) return;
 
			//  In case columns have been reordered, convert the column number
 
			column = table.convertColumnIndexToModel(column);
 
			//  Get cell color
 
			Object key = getKey(row, column);
			Object o = colors.get( key );
 
			if (o != null)
			{
				c.setForeground( (Color)o );
				return;
			}
 
			//  Get row color
 
			key = getKey(row, -1);
			o = colors.get( key );
 
			if (o != null)
			{
				c.setForeground( (Color)o );
				return;
			}
 
			//  Get column color
 
			key = getKey(-1, column);
			o = colors.get( key );
 
			if (o != null)
			{
				c.setForeground( (Color)o );
				return;
			}
 
		}
 
		public void setCellColor(int row, int column, Color color)
		{
			Point key = new Point(row, column);
			colors.put(key, color);
		}
 
		public void setColumnColor(int column, Color color)
		{
			setCellColor(-1, column, color);
		}
 
		public void setRowColor(int row, Color color)
		{
			setCellColor(row, -1, color);
		}
 
		private Object getKey(int row, int column)
		{
			location.x = row;
			location.y = column;
			return location;
		}
 
		public void startBlinking(int interval)
		{
			timer = new Timer(interval, this);
			timer.start();
		}
 
		public void stopBlinking()
		{
			timer.stop();
		}
 
		public void actionPerformed(ActionEvent e)
		{
			isBlinking = !isBlinking;
 
			Iterator it = colors.keySet().iterator();
 
			while ( it.hasNext() )
			{
				Point key = (Point)it.next();
				int row = key.x;
				int column = key.y;
 
				if (column == -1)
				{
					model.fireTableRowsUpdated(row, row);
				}
				else if (row == -1)
				{
					int rows = table.getRowCount();
 
					for (int i = 0; i < rows; i++)
					{
						model.fireTableCellUpdated(i, column);
					}
				}
				else
				{
					model.fireTableCellUpdated(row, column);
				}
			}
		}
	}
    
}
