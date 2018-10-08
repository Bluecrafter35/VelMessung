
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christoph Mautner
 */
public class VelGUI extends javax.swing.JFrame
{

    VelModel model = new VelModel();
    
    /**
     * Creates new form VelGUI
     */
    public VelGUI()
    {
        initComponents();
        this.jtTable.setModel(model);
        this.jtTable.setDefaultRenderer(Object.class, new VelTableCellRenderer());
        model.add(new VeloCity());
        //model.add(new VeloCity(LocalDate.now(), LocalTime.now(), "LB-Deichsel", 120, 10));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmiAdd = new javax.swing.JMenuItem();
        jmiDelete = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiDurchschnitt = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTable = new javax.swing.JTable();
        lbMessungen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmDatei = new javax.swing.JMenu();

        jmiAdd.setText("Hinzufügen");
        jmiAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiAddActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmiAdd);

        jmiDelete.setText("Löschen");
        jmiDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiDeleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmiDelete);
        jPopupMenu1.add(jSeparator1);

        jmiDurchschnitt.setText("jMenuItem1");
        jmiDurchschnitt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiDurchschnittActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmiDurchschnitt);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtTable.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jtTable);

        lbMessungen.setText("MESSUNGEN");

        jmDatei.setText("Datei");
        jMenuBar1.add(jmDatei);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMessungen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbMessungen, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiAddActionPerformed
    {//GEN-HEADEREND:event_jmiAddActionPerformed
        Veldialog dialog = new Veldialog(this, true);
        dialog.setVisible(true);
        if(dialog.isOk())
        {
            model.add(dialog.getVc());
        }
    }//GEN-LAST:event_jmiAddActionPerformed

    private void jmiDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiDeleteActionPerformed
    {//GEN-HEADEREND:event_jmiDeleteActionPerformed
        int[] indices = this.jtTable.getSelectedRows();
        for(int i = indices.length-1; i>=0;i--)
        {
            model.delete(indices[i]);
        }
    }//GEN-LAST:event_jmiDeleteActionPerformed

    private void jmiDurchschnittActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiDurchschnittActionPerformed
    {//GEN-HEADEREND:event_jmiDurchschnittActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiDurchschnittActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VelGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jmDatei;
    private javax.swing.JMenuItem jmiAdd;
    private javax.swing.JMenuItem jmiDelete;
    private javax.swing.JMenuItem jmiDurchschnitt;
    private javax.swing.JTable jtTable;
    private javax.swing.JLabel lbMessungen;
    // End of variables declaration//GEN-END:variables
}
