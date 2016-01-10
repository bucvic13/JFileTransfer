package Server.view;

import Client.view.ClientGUI;
import Server.network.Server;
import java.awt.Color;
import java.io.File;
import java.net.UnknownHostException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * ServerGUI
 *
 * @author Viktoria Buchegger
 * @version 1.0.0
 */
public class ServerGUI extends javax.swing.JFrame {

    private String pfad = System.getProperty("user.dir") + System.getProperty("file.separator")
            + "src" + System.getProperty("file.separator");

    private Server server;

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
        btRootDirectory = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sever");

        pnHeading.setLayout(new java.awt.GridLayout(1, 0));

        pnServer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pnServer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnServer.setText("Server");
        pnServer.setToolTipText("");
        pnHeading.add(pnServer);

        getContentPane().add(pnHeading, java.awt.BorderLayout.PAGE_START);

        pnStart.setLayout(new java.awt.GridLayout(1, 0));

        btStartServer.setText("Start Server");
        btStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onStartServer(evt);
            }
        });
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
        tfRootDirectory.setText("D:\\Benutzer\\User\\Dokumente\\TestOrdner\\server");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnInsertData.add(tfRootDirectory, gridBagConstraints);

        btRootDirectory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Server/src/mode.png"))); // NOI18N
        btRootDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onChooseRootFile(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnInsertData.add(btRootDirectory, gridBagConstraints);

        getContentPane().add(pnInsertData, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

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

    private void onStartServer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onStartServer
        try {
            //reads the rootDirectory from the textField
            String root = tfRootDirectory.getText();

            if (root.isEmpty()) {
                throw new Exception("You have to choose a Root Directory");
            }

            //stops the server, if it is already running
            if (server != null && server.isRunning()) {
                server.stop();
                btStartServer.setText("Start Server");

            } else {

                //creates a new server
                server = new Server(Integer.parseInt(tfPort.getText()),
                        new File(root));
                server.start();
                btStartServer.setText("Stop Server");

                //For opening the Client GUI and to deliver the Sever path
                ClientGUI clientGUI = new ClientGUI();
                clientGUI.setPath(root);
                clientGUI.setVisible(true);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_onStartServer

    private void onChooseRootFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onChooseRootFile
        //select the rootFile
        try {
            JFileChooser chooser = new JFileChooser("");
            //only directories will be displayed 
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int ans = chooser.showOpenDialog(null);
            if (ans == JFileChooser.APPROVE_OPTION) {
                try {
                    File f = chooser.getSelectedFile();
                    tfRootDirectory.setText(f.toString());

                } catch (Exception ex) {
                    throw new Exception("Error while opening..." + ex.toString());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_onChooseRootFile

    private void onExit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onExit
        //closes the window
        System.exit(0);
    }//GEN-LAST:event_onExit
    public static void main(String args[]) {
        //Use Windows Look&Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRootDirectory;
    private javax.swing.JButton btStartServer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbIP;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbRootDirectory;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JPanel pnHeading;
    private javax.swing.JPanel pnInsertData;
    private javax.swing.JLabel pnServer;
    private javax.swing.JPanel pnStart;
    private javax.swing.JTextField tfIP;
    private javax.swing.JTextField tfPort;
    private javax.swing.JTextField tfRootDirectory;
    // End of variables declaration//GEN-END:variables

    private void initGuiElements() {
        tfIP.setEnabled(false);
        try {
            tfIP.setText(Server.getIp());
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        Color col = new Color(240, 240, 240);
        btRootDirectory.setBackground(col);

    }

}
