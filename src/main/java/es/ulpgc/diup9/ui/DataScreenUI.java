/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diup9.ui;

import es.ulpgc.diup9.database.DatabaseHandler;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author nestorojeda
 */
public class DataScreenUI extends javax.swing.JFrame {

    private final DatabaseHandler dh;
    private final List<String> tables;
        
    public DataScreenUI(DatabaseHandler dh, LoginScreenUI ls) throws SQLException {
        System.out.println("Logging succesful");
        this.dh = dh;
        tables = dh.getTableList();
        
        initComponents();
        ls.setVisible(false);
        this.setVisible(true);
        
        this.setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el programa?", "Cerrar",JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }else{
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        
        populateTableList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        tableList = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldList = new javax.swing.JList<>();
        simpleToggleButton = new javax.swing.JToggleButton();
        intervalToggleButton = new javax.swing.JToggleButton();
        multipleIntervalsToggleButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        tableList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tableListValueChanged(evt);
            }
        });
        scrollPane.setViewportView(tableList);

        fieldList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "", "", "", "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(fieldList);

        simpleToggleButton.setText("Simple");
        simpleToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleToggleButtonActionPerformed(evt);
            }
        });

        intervalToggleButton.setText("Por intervalo");
        intervalToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intervalToggleButtonActionPerformed(evt);
            }
        });

        multipleIntervalsToggleButton.setText("Múltiples intervalos");
        multipleIntervalsToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multipleIntervalsToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(intervalToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(multipleIntervalsToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(simpleToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(simpleToggleButton)
                .addGap(55, 55, 55)
                .addComponent(intervalToggleButton)
                .addGap(61, 61, 61)
                .addComponent(multipleIntervalsToggleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpleToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleToggleButtonActionPerformed
        tableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        multipleIntervalsToggleButton.setSelected(false);
        intervalToggleButton.setSelected(false);


        
    }//GEN-LAST:event_simpleToggleButtonActionPerformed

    private void intervalToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intervalToggleButtonActionPerformed
        tableList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
        simpleToggleButton.setSelected(false);
        multipleIntervalsToggleButton.setSelected(false);


    }//GEN-LAST:event_intervalToggleButtonActionPerformed

    private void multipleIntervalsToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multipleIntervalsToggleButtonActionPerformed
        tableList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        simpleToggleButton.setSelected(false);
        intervalToggleButton.setSelected(false);

    }//GEN-LAST:event_multipleIntervalsToggleButtonActionPerformed

    private void tableListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tableListValueChanged
        if (evt.getValueIsAdjusting() == false) {
            try {
                if(tableList.getSelectedIndices().length == 1 ){
                    populateFieldList(new String[]{tables.get(tableList.getSelectedIndex())});
                }else{
                   int[] indices = tableList.getSelectedIndices();
                   System.out.println("Selected index" + Arrays.toString(indices));
                   String[] query = new String[tableList.getSelectedIndices().length];
                   
                   for (int i = 0 ; i < query.length; i++){
                       query[i] = tables.get(indices[i]);
                       System.out.println(query[i]);
                   }
                   
                   populateFieldList(query);
                   
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DataScreenUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tableListValueChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> fieldList;
    private javax.swing.JToggleButton intervalToggleButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton multipleIntervalsToggleButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JToggleButton simpleToggleButton;
    private javax.swing.JList<String> tableList;
    // End of variables declaration//GEN-END:variables

    
    
    private void populateTableList() throws SQLException {
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < tables.size(); i++){
            listModel.addElement(tables.get(i));
        }
        tableList.setModel(listModel);
    }
    
    
    
    private void populateFieldList(String[] tablename) throws SQLException{
        List<String> fields = new ArrayList<>();
        
        for (String tablename1 : tablename) {
            fields.addAll(dh.getFieldsList(tablename1));
        }
        
        System.out.println(fields.toString());
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < fields.size(); i++){
            listModel.addElement(fields.get(i));
        }
        fieldList.setModel(listModel);
        
    }
}
