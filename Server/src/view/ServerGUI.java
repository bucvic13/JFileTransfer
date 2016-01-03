package view;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Viktoria Buchegger
 */
public class ServerGUI extends javax.swing.JFrame {

    private String pfad = System.getProperty("user.dir") + System.getProperty("file.separator")
            + "src" + System.getProperty("file.separator");

    public ServerGUI() {
        initComponents();

        initGuiElements();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnHeading = new javax.swing.JPanel();
        pnServer = new javax.swing.JLabel();
        pnStart = new javax.swing.JPanel();
        btStartServer = new javax.swing.JButton();
        pnInsertData = new javax.swing.JPanel();
        lbIP = new javax.swing.JLabel();
        tfIP = new javax.swing.JTextField();
        lbPort = new javax.swing.JLabel();
        tfPort = new javax.swing.JTextField();
        lbRootDirectory = new javax.swing.JLabel();
        tfRootDirectory = new javax.swing.JTextField();
        btGetRootDirectory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnHeading.setLayout(new java.awt.GridLayout(1, 0));

        pnServer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pnServer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnServer.setText("Server");
        pnServer.setToolTipText("");
        pnHeading.add(pnServer);

        getContentPane().add(pnHeading, java.awt.BorderLayout.PAGE_START);

        pnStart.setLayout(new java.awt.GridLayout(1, 0));

        btStartServer.setText("Start Server");
        pnStart.add(btStartServer);

        getContentPane().add(pnStart, java.awt.BorderLayout.PAGE_END);

        pnInsertData.setLayout(new java.awt.GridBagLayout());

        lbIP.setText("IP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnInsertData.add(lbIP, gridBagConstraints);

        tfIP.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnInsertData.add(tfIP, gridBagConstraints);

        lbPort.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnInsertData.add(lbPort, gridBagConstraints);

        tfPort.setColumns(10);
        tfPort.setText("8320");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnInsertData.add(tfPort, gridBagConstraints);

        lbRootDirectory.setText("Root directory:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnInsertData.add(lbRootDirectory, gridBagConstraints);

        tfRootDirectory.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnInsertData.add(tfRootDirectory, gridBagConstraints);

        btGetRootDirectory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/mode.png"))); // NOI18N
        btGetRootDirectory.setBorder(null);
        btGetRootDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOpenFileChooser(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnInsertData.add(btGetRootDirectory, gridBagConstraints);

        getContentPane().add(pnInsertData, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onOpenFileChooser(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOpenFileChooser
        try {
            JFileChooser chooser = new JFileChooser(pfad);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int ans = chooser.showOpenDialog(null);
            if (ans == JFileChooser.APPROVE_OPTION) {
                try {
                    File f = chooser.getSelectedFile();
                    tfRootDirectory.setText(f.toString());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error while saving..." + ex.toString());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_onOpenFileChooser
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGetRootDirectory;
    private javax.swing.JButton btStartServer;
    private javax.swing.JLabel lbIP;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbRootDirectory;
    private javax.swing.JPanel pnHeading;
    private javax.swing.JPanel pnInsertData;
    private javax.swing.JLabel pnServer;
    private javax.swing.JPanel pnStart;
    private javax.swing.JTextField tfIP;
    private javax.swing.JTextField tfPort;
    private javax.swing.JTextField tfRootDirectory;
    // End of variables declaration//GEN-END:variables

    private void initGuiElements() {

        tfIP.disable();
    }
}