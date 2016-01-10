package Client.view;

import Client.ServerManager.view.ServerManagerGUI;
import Client.data.DataFile;
import Client.model.ClientModel;
import Client.network.Client;
import Server.network.Server;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        //addTestData();
    }
    
    public void addTestData() {
        modelLocal.addTestdaten();
        modelServer.addTestdaten();
    }
    
    private void sampleCommandTest(String cmd) throws Exception {
        //controlls if there is a connection
        if (client.isListening()) {
            String response = client.sendCommand(cmd);
            System.out.println("got response: " + response);

            //calls the method parseResponse() to get out the datafiles from the XML
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
        pnOutput = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        liOutput = new javax.swing.JList();
        pnPath = new javax.swing.JPanel();
        pnLocal = new javax.swing.JPanel();
        lbLocal = new javax.swing.JLabel();
        tfShowLocalPath = new javax.swing.JTextField();
        btChangeLocalPath = new javax.swing.JButton();
        pnServer = new javax.swing.JPanel();
        lbServer = new javax.swing.JLabel();
        tfShowServerPath = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miExit = new javax.swing.JMenuItem();

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

        pnOutput.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setViewportView(liOutput);

        pnOutput.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        pnPath.setLayout(new java.awt.GridLayout(1, 4));

        pnLocal.setLayout(new java.awt.GridLayout(1, 3));

        lbLocal.setText("Local");
        lbLocal.setMaximumSize(new java.awt.Dimension(10, 14));
        lbLocal.setMinimumSize(new java.awt.Dimension(10, 14));
        pnLocal.add(lbLocal);

        tfShowLocalPath.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                onEnterLocalPath(evt);
            }
        });
        pnLocal.add(tfShowLocalPath);

        btChangeLocalPath.setText("...");
        btChangeLocalPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onChangeLocalPath(evt);
            }
        });
        pnLocal.add(btChangeLocalPath);

        pnPath.add(pnLocal);

        pnServer.setLayout(new java.awt.GridLayout(1, 2));

        lbServer.setText("Server");
        pnServer.add(lbServer);
        pnServer.add(tfShowServerPath);

        pnPath.add(pnServer);

        pnOutput.add(pnPath, java.awt.BorderLayout.PAGE_END);

        pnData.add(pnOutput, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnData, java.awt.BorderLayout.CENTER);

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

    private void onClientToServer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClientToServer
        //Select file (local) that shall be copied to the Server
        try {
            if (data == null) {
                throw new Exception("Please chose a File from Local");
            }
            
            JOptionPane.showMessageDialog(this, data + "will be copied to the Server");
            
            if(client.isListening())
            {
                String localPath = tfShowLocalPath.getText();
                String newPath = localPath.endsWith("/") ? localPath : localPath + "/";
                newPath += data.getName();
                
                client.sendCommandWithData("upload#" + data.getName(), readFile(newPath));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onClientToServer

    private void onServerToClient(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onServerToClient
        //Select file (server) that shall be copied to the Client
        try {
            if (data == null) {
                throw new Exception("Please chose a File from Server");
            }
            if (tfShowLocalPath.getText().isEmpty()) {
                throw new Exception("You have to chose a Local File");
            }
            
            System.out.println("Path: " + tfShowLocalPath.getText());
            JOptionPane.showMessageDialog(this, data + "will be copied to the Client");
            
            if (client.isListening()) {
                String response = client.sendLongCommand("get#" + data.getName());
                //System.err.println("got response: " + response);

                //modelLocal.addFromServerToClient(data);
                String localPath = tfShowLocalPath.getText();
                String newPath = localPath.endsWith("/") ? localPath : localPath + "/";
                newPath += data.getName();
                
                System.out.println(newPath);
                
                BufferedWriter bw = new BufferedWriter(new FileWriter(newPath));
                bw.write(response);
                bw.flush();
                bw.close();

                //update local model
                modelLocal.getLocalDatas(new File(localPath));
                
            } else {
                System.out.println("not listening");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onServerToClient

    private void onStop(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onStop
        //Interrupt connection to the server
        try {

            //only if the server is running
            if (client.isListening()) {
                client.disconnect();
                btStart.setEnabled(true);
                btStop.setEnabled(false);
                btServerManager.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onStop

    private void onServerManager(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onServerManager
        //Opens ServerManager GUI
        try {

            //this.setVisible(false);
            ServerManagerGUI managerGUI = new ServerManagerGUI();
            managerGUI.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onServerManager

    private void onStart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onStart
        //connects the Client with the Server
        try {
            
            if ((tfIP.getText()).isEmpty() || (tfPort.getText()).isEmpty()) {
                throw new Exception("You have to fill in all fields");
            }

            //calls the Client and passes the information
            client = new Client(tfIP.getText(), Integer.parseInt(tfPort.getText()));
            client.connect();
            
            btStart.setEnabled(false);
            btStop.setEnabled(true);
            btServerManager.setEnabled(false);

            //Test onlys
            sampleCommandTest("tree");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onStart

    private void tbLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLocalMouseClicked
        //clickEvent of ClientTable: only to select one file
        try {
            btClientToServer.setEnabled(true);
            btServerToClient.setEnabled(false);
            int index = tbLocal.getSelectedRow();
            data = modelLocal.get(index);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbLocalMouseClicked

    private void tbServerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServerMouseClicked
        //clickEvent of ServerTable: only to select one file
        try {
            btServerToClient.setEnabled(true);
            btClientToServer.setEnabled(false);
            int index = tbServer.getSelectedRow();
            data = modelServer.get(index);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbServerMouseClicked

    private void onChangeLocalPath(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onChangeLocalPath
        //chose the local path with a FileChooser
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onChangeLocalPath
    private void onExit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onExit
        //closes the frame
        System.exit(0);
    }//GEN-LAST:event_onExit
    private void onEnterLocalPath(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onEnterLocalPath
        //if you type in a LocalPath and press enter the files will the loaded
        try {
            //KeyCode for Enter = 10
            if (evt.getKeyCode() == 10) {
                
                if (tfShowLocalPath.getText().isEmpty()) {
                    throw new Exception("You have to type in a Local File");
                }
                modelLocal.clearList();
                File f = new File(tfShowLocalPath.getText());
                modelLocal.getLocalDatas(f);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onEnterLocalPath

    private String readFile(String path) throws IOException {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded);
        }
    
    //initializes elements of the gui
    private void initGuiElements() {
        Color col = new Color(240, 240, 240);
        btClientToServer.setBackground(col);
        btServerToClient.setBackground(col);
        btStop.setBackground(col);
        btServerManager.setBackground(col);

        //oder vielleicht lieber doch nicht ? Notiz an mich selbst
        tfShowLocalPath.setEditable(true);
        tfShowServerPath.setEditable(false);
        
        btStart.setEnabled(true);
        btStop.setEnabled(false);
        btServerManager.setEnabled(true);
        btClientToServer.setEnabled(false); //only enabled when a datafile is selected (at the local table)
        btServerToClient.setEnabled(false);//only enabled when a datafile is selected (at the server table)
    }

    //gets the Path from the ServerGUI
    public void setPath(String server) {
        tfShowServerPath.setText(server);
    }
    
    public void setData(String ip, int port) {
        System.err.println("setData: " + ip + " " + port);
        
        tfIP.setText("");
        tfPort.setText("");
        tfIP.setText(ip);
        tfPort.setText("" + port);
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbClient;
    private javax.swing.JLabel lbIP;
    private javax.swing.JLabel lbLocal;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbServer;
    private javax.swing.JList liOutput;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnLocal;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JPanel pnOutput;
    private javax.swing.JPanel pnPath;
    private javax.swing.JPanel pnServer;
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
