package Client.ServerManager.view;

import Client.ServerManager.data.ServerInformation;
import Client.ServerManager.model.ServerManagerModel;
import Client.ServerManager.dlg.AddServerDlg;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Viktoria Buchegger
 */
public class ServerManagerGUI extends javax.swing.JFrame {

    private ServerManagerModel model;
    private boolean ok = false;
    private String ip;
    private int port;

    public ServerManagerGUI() {
        try {
            initComponents();
            model = new ServerManagerModel();
            tbSafedServer.setModel(model);
        } catch (Exception ex) {
            Logger.getLogger(ServerManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnOptions = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        btSelect = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        pnTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSafedServer = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miLoad = new javax.swing.JMenuItem();
        miSafe = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Manager");

        pnOptions.setLayout(new java.awt.GridBagLayout());

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAdd(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        pnOptions.add(btAdd, gridBagConstraints);

        btRemove.setText("Remove");
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemove(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        pnOptions.add(btRemove, gridBagConstraints);

        btSelect.setText("Select");
        btSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelect(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        pnOptions.add(btSelect, gridBagConstraints);

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancel(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        pnOptions.add(btCancel, gridBagConstraints);

        getContentPane().add(pnOptions, java.awt.BorderLayout.PAGE_START);

        pnTable.setLayout(new java.awt.GridLayout(1, 0));

        tbSafedServer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbSafedServer);

        pnTable.add(jScrollPane1);

        getContentPane().add(pnTable, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLoad(evt);
            }
        });

        miLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/src/circularMini.png"))); // NOI18N
        miLoad.setText("Load");
        miLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLoadFile(evt);
            }
        });
        jMenu1.add(miLoad);

        miSafe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/src/downMini.png"))); // NOI18N
        miSafe.setText("Safe");
        miSafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSafeData(evt);
            }
        });
        jMenu1.add(miSafe);

        miExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/src/closeMini.png"))); // NOI18N
        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onExit(evt);
            }
        });
        jMenu1.add(miExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onAdd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAdd
        try {

            AddServerDlg dialog = new AddServerDlg(this, true);
            dialog.setVisible(true);

            if (dialog.isOk()) {

                ServerInformation data = new ServerInformation(dialog.getIp(), dialog.getPort());
                model.add(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onAdd

    private void onRemove(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRemove
        try {

            int index = tbSafedServer.getSelectedRow();

            int ans = JOptionPane.showConfirmDialog(this, "Do you want to remove this element");
            if (ans == JOptionPane.YES_OPTION) {
                model.remove(index);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onRemove

    private void onSelect(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSelect
        try {

            int index = tbSafedServer.getSelectedRow();

            if (index < 0) {
                throw new Exception("you have to choose an Element");
            }

            ServerInformation data = model.get(index);
            ip = data.getIp();
            port = data.getPort();
            System.out.println("onSelect: " + data.toString());

            this.ok = true;
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onSelect

    private void onLoad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLoad
        //woher kommt das schon wieder ???
    }//GEN-LAST:event_onLoad

    private void onSafeData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSafeData
        JFileChooser chooser = new JFileChooser("");
        int ret = chooser.showSaveDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            try {
                File f = chooser.getSelectedFile();
                model.save(f);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error while saving..." + ex.toString());
            }
        }
    }//GEN-LAST:event_onSafeData

    private void onExit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onExit
        System.exit(0);
    }//GEN-LAST:event_onExit

    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel

        this.ok = false;
        this.dispose();

    }//GEN-LAST:event_onCancel
    private void onLoadFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLoadFile
        JFileChooser chooser = new JFileChooser("");
        int ret = chooser.showOpenDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            try {
                File f = chooser.getSelectedFile();
                model.load(f);
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_onLoadFile

    public boolean isOk() {
        return ok;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btRemove;
    private javax.swing.JButton btSelect;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miLoad;
    private javax.swing.JMenuItem miSafe;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JPanel pnTable;
    private javax.swing.JTable tbSafedServer;
    // End of variables declaration//GEN-END:variables
}
