/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz.dialogs;


import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javolution.util.FastList;

/**
 *
 * @author carl
 */
public class Propiedades extends JDialog {
    private JTable ps;
    private SpringLayout layout = new SpringLayout();
    DefaultTableModel model = new DefaultTableModel();
    ImageIcon help;
    ImageIcon nohelp;
    public FastList<String> tips = new FastList<String>();
    
    public Propiedades(Frame parent){
        super(parent, false);
        model.addColumn("");
        model.addColumn("Dato");
        model.addColumn("Valor");
        
        help = new ImageIcon("img/help.gif");
        nohelp = new ImageIcon("img/nohelp.gif");
        
        ps = new JTable(model){

                @Override
                public Component prepareRenderer(TableCellRenderer renderer,int rowIndex, int vColIndex) {
                    Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
                    if (c instanceof JComponent) {
                        JComponent jc = (JComponent)c;
                        if(vColIndex==0 && tips.get(rowIndex)!= null && !tips.get(rowIndex).equals("")){
                            jc.setToolTipText(tips.get(rowIndex));
                        }
                    }
                    return c;
                }
            };
            
        ps.getColumnModel().getColumn(0).setWidth(16);
        
        
        
        JScrollPane scrollPane = new JScrollPane(ps);
        ps.setFillsViewportHeight(true);
        ps.getColumnModel().getColumn(0).setPreferredWidth(16);
        ps.getColumnModel().getColumn(0).setWidth(16);
        ps.getColumnModel().getColumn(0).setMaxWidth(16);
        
        //ps.setSize(300, 350);
        //scrollPane.setSize(300,350);
        
        
        this.setSize(320, 370);
        //this.setResizable(false);
        add(scrollPane);
       
       
       
        
        setVisible(true);
        
        setLayout(layout);
        Container pane = this.getContentPane();
        layout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH,pane);
        
        addRow("Nombre]El nombre del pj >.<:YouWoTMA\nIsGod?:yeah");
        
    }
    
    public void addRow(String info){
        String[] rows;
        if(info.indexOf("\n") <=0){
            rows = new String[1] ;
            rows[0] = info;
        }else{
            rows = info.split("\n");
        }
        
        for(String s:rows){
            if(s.indexOf(":") < 0){continue;}
            
            String[] row = s.split(":");
            
            if(row[0].indexOf("]")<0){
                addRow("",row[0],row[1]);
            }else{
                String[] dat = row[0].split("]");
                addRow(dat[1],dat[0],row[1]);
            }
            
        }
    
    }
    
    public void addRow(String info, String key,String value){
        String[] data = {info!=null&&!info.equals("")?"asdasd":"asd",key,value};
        tips.add(info);
        model.addRow(data);
        
        int row = model.getRowCount();
        
        ps.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable tblDataTable, Object value, boolean isSelected, boolean hasFocus, int markedRow, int col){
                JLabel ret=(JLabel)super.getTableCellRendererComponent(tblDataTable,value,isSelected,hasFocus,markedRow,col);
                ret.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                if (value != null && value instanceof String) {
                        String dt = (String) value;
                        if(dt.equals("asdasd")){
                            ret.setIcon(help);//Use this method to set the proper icon for the file.
                        }else{
                            ret.setIcon(nohelp);
                        }
                        ret.setText("");//Blank out your Label's text.
                }
                

                return ret;
            }
        });
    }
    

    
    
}
