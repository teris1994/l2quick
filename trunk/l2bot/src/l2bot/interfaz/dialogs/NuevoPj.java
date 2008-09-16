/*
 * NuevoPj.java
 *
 * Created on 14 de agosto de 2008, 10:15
 */

package l2bot.interfaz.dialogs;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import l2bot.Idioma;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import l2bot.Main;

/**
 *
 * @author  carl
 */
public class NuevoPj extends javax.swing.JDialog {

    /** Creates new form NuevoPj */
    java.awt.Frame pa;
    public NuevoPj(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pa = parent;
        parsear();
    }
    Document doc;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        list1.setMultipleMode(true);

        jButton1.setText(Idioma.nuevo);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(Idioma.editar);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(Idioma.aceptar_puedes_seleccionar_varias_cuentas);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText(Idioma.borrar);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    if(list1.getSelectedIndex() < 0){
    JOptionPane.showMessageDialog( this,"Tiene que seleccionar una cuenta");
    return;
    }
    
    if(JOptionPane.showConfirmDialog( this,"¿Estas seguro?","confirmacion",JOptionPane.YES_NO_OPTION ) == JOptionPane.NO_OPTION){
        return;
    }
    NodeList f = doc.getElementsByTagName("server");
    for(int i=0;i<f.getLength();i++){
        Element h = (Element) f.item(i);
        if(list1.getSelectedItem().equals(h.getAttribute("name"))){
            doc.removeChild((Node)h);
            saveChanges();
        }
    }
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    Element y = doc.createElement("account");


    PJedit edit = new PJedit(pa,true,y,true);
    edit.setVisible(true);
    doc.getElementsByTagName("accounts").item(0).appendChild(y);
    saveChanges();
    parsear();
        
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if(list1.getSelectedIndex() < 0){
    JOptionPane.showMessageDialog( this,"Tiene que seleccionar una cuenta");
    return;
    }
    
    NodeList s = doc.getElementsByTagName("account");
    
    for(int i=0;i<s.getLength();i++){
        if(((Element)s.item(i)).getAttribute("user").equals(list1.getSelectedItem())){
            PJedit edit = new PJedit(pa,true,(Element)s.item(i),false);
            edit.setVisible(true);
            saveChanges();
            parsear();
            return;
        }
    }
    //error    
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    String[] nuevosPj = list1.getSelectedItems();
    for (int i = 0; i < nuevosPj.length; i++) {
        Main.NuevoPj(nuevosPj[i]);
    }
    setVisible(false);
}//GEN-LAST:event_jButton3ActionPerformed

void saveChanges(){
            try {
            // Prepare the DOM document for writing
            Source source = new DOMSource(doc);
    
            // Prepare the output file
            File file = new File("xml/accounts.xml");
            Result result = new StreamResult(file);
    
            // Write the DOM document to the file
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
        } catch (TransformerException e) {
        }
}

void parsear(){
    DOMParser parser = new DOMParser();
    try {
        parser.parse("xml/accounts.xml");
    } catch (SAXException ex) {

    } catch (IOException ex) {

    }
    doc = parser.getDocument();
    NodeList f = doc.getElementsByTagName("account");
    list1.removeAll();
    for(int i=0;i<f.getLength();i++){
        Element h = (Element) f.item(i);
        list1.add(h.getAttribute("user"));
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables

}