package Client.view;

import Client.ServerManager.ServerManagerGUI;
import Client.data.DataFile;
import Client.model.ClientModel;
import Client.network.Client;
import java.awt.Color;
import java.io.File;
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

        //addTestData();
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
        imageButton1 = new at.petritzdesigns.ImageButton();
        pnData = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        spServer = new javax.swing.JScrollPane();
        tbServer = new javax.swing.JTable();
        spLocal = new javax.swing.JScrollPane();
        tbLocal = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        lbServer = new javax.swing.JLabel();
        lbLocalPath = new javax.swing.JLabel();
        lbLocal = new javax.swing.JLabel();
        lbServerPath = new javax.swing.JLabel();

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
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        pnOptions.add(lbClient, gridBagConstraints);

        lbIP.setText("IP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        pnOptions.add(lbIP, gridBagConstraints);

        lbPort.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        pnOptions.add(lbPort, gridBagConstraints);

        tfIP.setColumns(10);
        tfIP.setText("127.0.0.1");
        tfIP.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        pnOptions.add(tfIP, gridBagConstraints);

        tfPort.setColumns(10);
        tfPort.setText("8320");
        tfPort.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        pnOptions.add(tfPort, gridBagConstraints);

        btStop.setText("X");
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
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnOptions.add(btStop, gridBagConstraints);

        btClientToServer.setText("<-");
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
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnOptions.add(btClientToServer, gridBagConstraints);

        btServerToClient.setText("->");
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
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnOptions.add(btServerToClient, gridBagConstraints);

        btServerManager.setText("*");
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
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
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
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnOptions.add(btStart, gridBagConstraints);

        imageButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/src/menu.png"))); // NOI18N
        imageButton1.setText("TODO");
        pnOptions.add(imageButton1, new java.awt.GridBagConstraints());

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

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jScrollPane3.setViewportView(jList1);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 4));

        lbServer.setText("Local");
        jPanel4.add(lbServer);
        jPanel4.add(lbLocalPath);

        lbLocal.setText("Server");
        jPanel4.add(lbLocal);
        jPanel4.add(lbServerPath);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        pnData.add(jPanel2, java.awt.BorderLayout.NORTH);

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

            this.setVisible(false);
            ServerManagerGUI dlg = new ServerManagerGUI();
            dlg.setVisible(true);

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

    private void initGuiElements() {
        Color col = new Color(240, 240, 240);
        btClientToServer.setBackground(col);
        btServerToClient.setBackground(col);
        btStop.setBackground(col);
        btServerManager.setBackground(col);

        btStart.setEnabled(true);
        btStop.setEnabled(false);
        btServerManager.setEnabled(true);
        btClientToServer.setEnabled(false); //nur enabled wenn datei ausgewählt (auf der lokalen tabelle)
        btServerToClient.setEnabled(false);//nur enabled when datei ausgewählt ist (auf der server tabelle)
    }

    public void setPath(File local, File server) {
        lbLocalPath.setText("" + local);
        lbServerPath.setText("" + server);
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
    private javax.swing.JButton btClientToServer;
    private javax.swing.JButton btServerManager;
    private javax.swing.JButton btServerToClient;
    private javax.swing.JButton btStart;
    private javax.swing.JButton btStop;
    private at.petritzdesigns.ImageButton imageButton1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbClient;
    private javax.swing.JLabel lbIP;
    private javax.swing.JLabel lbLocal;
    private javax.swing.JLabel lbLocalPath;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbServer;
    private javax.swing.JLabel lbServerPath;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JScrollPane spLocal;
    private javax.swing.JScrollPane spServer;
    private javax.swing.JTable tbLocal;
    private javax.swing.JTable tbServer;
    private javax.swing.JTextField tfIP;
    private javax.swing.JTextField tfPort;
    // End of variables declaration//GEN-END:variables

}