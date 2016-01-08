package Client.view;

import Client.ServerManager.view.ServerManagerGUI;
import Client.data.DataFile;
import Client.model.ClientModel;
import Client.network.Client;
import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * ClientGUI
 *
 * @author Viktoria Buchegger
 * @version 1.0.0
 */
public class ClientGUI extends javax.swing.JFrame {

    private Client client;
    private ClientModel modelServer, modelLocal;
    private DataFile data;

    public ClientGUI() {
        initComponents();
        initGuiElements();

        modelLocal = new ClientModel();
        modelServer = new ClientModel();

        tbLocal.setModel(modelLocal);
        tbServer.setModel(modelServer);

        //only for testing
        // addTestData();
    }

    public void addTestData() {
        modelLocal.addTestdaten();
        modelServer.addTestdaten();
    }

    private void sampleCommandTest() throws Exception {
        if (client.isListening()) {
            String response = client.sendCommand("tree");
            System.out.println("got response: " + response);
            //TODO parse response and load model with data
            modelServer.parseResponse(response);
        } else {
            System.out.println("not listening");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnOptions = new javax.swing.JPanel();
        lbClient = new javax.swing.JLabel();
        lbIP = new javax.swing.JLabel();
        lbPort = new javax.swing.JLabel();
        tfIP = new javax.swing.JTextField();
        tfPort = new javax.swing.JTextField();
        btStop = new javax.swing.JButton();
        btClientToServer = new javax.swing.JButton();
        btServerToClient = new javax.swing.JButton();
        btServerManager = new javax.swing.JButton();
        btStart = new javax.swing.JButton();
        pnData = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        spServer = new javax.swing.JScrollPane();
        tbServer = new javax.swing.JTable();
        spLocal = new javax.swing.JScrollPane();
        tbLocal = new javax.swing.JTable();
        pnView = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        pnLocal = new javax.swing.JPanel();
        lbLocal = new javax.swing.JLabel();
        tfShowLocalPath = new javax.swing.JTextField();
        btChangeLocalPath = new javax.swing.JButton();
        pnServer = new javax.swing.JPanel();
        lbServer = new javax.swing.JLabel();
        tfShowServerPath = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        pnOptions.setLayout(new java.awt.GridBagLayout());

        lbClient.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbClient.setText("Client");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 0, 9);
        pnOptions.add(lbClient, gridBagConstraints);

        lbIP.setText("IP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 0, 9);
        pnOptions.add(lbIP, gridBagConstraints);

        lbPort.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 0, 9);
        pnOptions.add(lbPort, gridBagConstraints);

        tfIP.setColumns(10);
        tfIP.setText("127.0.0.1");
        tfIP.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 0, 9);
        pnOptions.add(tfIP, gridBagConstraints);

        tfPort.setColumns(10);
        tfPort.setText("8320");
        tfPort.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 0, 9);
        pnOptions.add(tfPort, gridBagConstraints);

        btStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/src/close.png"))); // NOI18N
        btStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onStop(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        pnOptions.add(btStop, gridBagConstraints);

        btClientToServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/src/back.png"))); // NOI18N
        btClientToServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClientToServer(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        pnOptions.add(btClientToServer, gridBagConstraints);

        btServerToClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/src/right.png"))); // NOI18N
        btServerToClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onServerToClient(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        pnOptions.add(btServerToClient, gridBagConstraints);

        btServerManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/src/menu.png"))); // NOI18N
        btServerManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onServerManager(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        pnOptions.add(btServerManager, gridBagConstraints);

        btStart.setText("Start");
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onStart(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        pnOptions.add(btStart, gridBagConstraints);

        getContentPane().add(pnOptions, java.awt.BorderLayout.PAGE_START);

        pnData.setLayout(new java.awt.BorderLayout());

        tbServer.setModel(new javax.swing.table.DefaultTableModel(
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
        tbServer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbServerMouseClicked(evt);
            }
        });
        spServer.setViewportView(tbServer);

        jSplitPane1.setRightComponent(spServer);

        tbLocal.setModel(new javax.swing.table.DefaultTableModel(
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
        tbLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLocalMouseClicked(evt);
            }
        });
        spLocal.setViewportView(tbLocal);

        jSplitPane1.setLeftComponent(spLocal);

        pnData.add(jSplitPane1, java.awt.BorderLayout.SOUTH);

        pnView.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());
        pnView.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jScrollPane3.setViewportView(jList1);

        pnView.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 4));

        pnLocal.setLayout(new java.awt.GridLayout(1, 3));

        lbLocal.setText("Local");
        pnLocal.add(lbLocal);
        pnLocal.add(tfShowLocalPath);

        btChangeLocalPath.setText("...");
        btChangeLocalPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onChangeLocalPath(evt);
            }
        });
        pnLocal.add(btChangeLocalPath);

        jPanel4.add(pnLocal);

        pnServer.setLayout(new java.awt.GridLayout(1, 2));

        lbServer.setText("Server");
        pnServer.add(lbServer);
        pnServer.add(tfShowServerPath);

        jPanel4.add(pnServer);

        pnView.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        pnData.add(pnView, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnData, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onClientToServer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClientToServer
        //Datei auswählen (Lokal) die man zum server kopieren will
        try {
            if (data == null) {
                throw new Exception("Please chose a File from Local");
            }

            JOptionPane.showMessageDialog(this, data + "will be moved to the Server");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_onClientToServer

    private void onServerToClient(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onServerToClient
        //Datei auswählen (Server) die man zum client kopieren will
        try {
            if (data == null) {
                throw new Exception("Please chose a File from Server");
            }

            JOptionPane.showMessageDialog(this, data + "will be moved to the Client");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_onServerToClient

    private void onStop(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onStop
        //Verbindung zum Server unterbrechen
        try {
            if (client.isListening()) {
                client.disconnect();
                btStart.setEnabled(true);
                btStop.setEnabled(false);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onStop

    private void onServerManager(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onServerManager
        //Startet ServerManager GUI
        try {

            //this.setVisible(false);
            ServerManagerGUI managerGUI = new ServerManagerGUI();
            managerGUI.setVisible(true);

            if (managerGUI.isOk()) {
                tfIP.setText(managerGUI.getIp());
                tfPort.setText("" + managerGUI.getIp());
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_onServerManager

    private void onStart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onStart

        try {

            if ((tfIP.getText()).isEmpty() || (tfPort.getText()).isEmpty()) {
                throw new Exception("You have to fill in all fields");
            }

            client = new Client(tfIP.getText(), Integer.parseInt(tfPort.getText()));
            client.connect();
            btStart.setEnabled(false);
            btStop.setEnabled(true);

            //Test only
            sampleCommandTest();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onStart

    private void tbLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLocalMouseClicked
        try {

            btClientToServer.setEnabled(true);
            btServerToClient.setEnabled(false);
            int index = tbLocal.getSelectedRow();
            data = modelLocal.getElement(index);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbLocalMouseClicked

    private void tbServerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServerMouseClicked
        try {

            btServerToClient.setEnabled(true);
            btClientToServer.setEnabled(false);
            int index = tbServer.getSelectedRow();
            data = modelServer.getElement(index);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbServerMouseClicked

    private void onChangeLocalPath(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onChangeLocalPath

        try {
            JFileChooser chooser = new JFileChooser("");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int ans = chooser.showOpenDialog(null);
            if (ans == JFileChooser.APPROVE_OPTION) {
                try {
                    File f = chooser.getSelectedFile();
                    tfShowLocalPath.setText("" + f.getAbsoluteFile());
                    modelLocal.getLocalDatas(f);

                } catch (Exception ex) {
                    throw new Exception("Error while opening..." + ex.toString());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_onChangeLocalPath

    private void initGuiElements() {
        Color col = new Color(240, 240, 240);
        btClientToServer.setBackground(col);
        btServerToClient.setBackground(col);
        btStop.setBackground(col);
        btServerManager.setBackground(col);

        //oder vielleicht lieber doch nicht ? Notiz an mich selbst xD
        tfShowLocalPath.setEditable(true);
        tfShowServerPath.setEditable(false);
        
        btStart.setEnabled(true);
        btStop.setEnabled(false);
        btServerManager.setEnabled(true);
        btClientToServer.setEnabled(false); //nur enabled wenn datei ausgewählt (auf der lokalen tabelle)
        btServerToClient.setEnabled(false);//nur enabled when datei ausgewählt ist (auf der server tabelle)
    }

    public void setPath(String server) {
        tfShowServerPath.setText(server);
    }

    public static void main(String args[]) {
        //Use Windows Look&Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChangeLocalPath;
    private javax.swing.JButton btClientToServer;
    private javax.swing.JButton btServerManager;
    private javax.swing.JButton btServerToClient;
    private javax.swing.JButton btStart;
    private javax.swing.JButton btStop;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbClient;
    private javax.swing.JLabel lbIP;
    private javax.swing.JLabel lbLocal;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbServer;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnLocal;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JPanel pnServer;
    private javax.swing.JPanel pnView;
    private javax.swing.JScrollPane spLocal;
    private javax.swing.JScrollPane spServer;
    private javax.swing.JTable tbLocal;
    private javax.swing.JTable tbServer;
    private javax.swing.JTextField tfIP;
    private javax.swing.JTextField tfPort;
    private javax.swing.JTextField tfShowLocalPath;
    private javax.swing.JTextField tfShowServerPath;
    // End of variables declaration//GEN-END:variables

}
