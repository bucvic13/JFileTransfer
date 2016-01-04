package view;

import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author Viktoria Buchegger
 */
public class ClientGUI extends javax.swing.JFrame {

    public ClientGUI() {
        initComponents();
        initGuiElements();

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
        btClientToServer = new at.petritzdesigns.ImageButton();
        btServerToClient = new at.petritzdesigns.ImageButton();
        btCancel = new at.petritzdesigns.ImageButton();
        btServerManager = new at.petritzdesigns.ImageButton();
        pnData = new javax.swing.JPanel();
        tbLocal = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tbServer = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnOptions.setLayout(new java.awt.GridBagLayout());

        lbClient.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbClient.setText("Client");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pnOptions.add(lbClient, gridBagConstraints);

        lbIP.setText("IP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pnOptions.add(lbIP, gridBagConstraints);

        lbPort.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pnOptions.add(lbPort, gridBagConstraints);

        tfIP.setColumns(10);
        tfIP.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pnOptions.add(tfIP, gridBagConstraints);

        tfPort.setColumns(10);
        tfPort.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        pnOptions.add(tfPort, gridBagConstraints);

        btClientToServer.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\OneDrive\\3CHIF\\POS\\Java\\2. Test\\Projekt\\Vorlage\\Icons 24Px\\back28 (1).png")); // NOI18N
        btClientToServer.setText("imageButton1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnOptions.add(btClientToServer, gridBagConstraints);

        btServerToClient.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\OneDrive\\3CHIF\\POS\\Java\\2. Test\\Projekt\\Vorlage\\Icons 24Px\\right127 (1).png")); // NOI18N
        btServerToClient.setText("imageButton2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnOptions.add(btServerToClient, gridBagConstraints);

        btCancel.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\OneDrive\\3CHIF\\POS\\Java\\2. Test\\Projekt\\Vorlage\\Icons 24Px\\close33 (1).png")); // NOI18N
        btCancel.setText("imageButton3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnOptions.add(btCancel, gridBagConstraints);

        btServerManager.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\OneDrive\\3CHIF\\POS\\Java\\2. Test\\Projekt\\Vorlage\\Icons 24Px\\menu33 (1).png")); // NOI18N
        btServerManager.setText("imageButton4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnOptions.add(btServerManager, gridBagConstraints);

        getContentPane().add(pnOptions, java.awt.BorderLayout.PAGE_START);

        pnData.setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbLocal.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        pnData.add(tbLocal, gridBagConstraints);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        tbServer.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        pnData.add(tbServer, gridBagConstraints);

        jScrollPane3.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        pnData.add(jScrollPane3, gridBagConstraints);

        getContentPane().add(pnData, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private at.petritzdesigns.ImageButton btCancel;
    private at.petritzdesigns.ImageButton btClientToServer;
    private at.petritzdesigns.ImageButton btServerManager;
    private at.petritzdesigns.ImageButton btServerToClient;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbClient;
    private javax.swing.JLabel lbIP;
    private javax.swing.JLabel lbPort;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JScrollPane tbLocal;
    private javax.swing.JScrollPane tbServer;
    private javax.swing.JTextField tfIP;
    private javax.swing.JTextField tfPort;
    // End of variables declaration//GEN-END:variables

    private void initGuiElements() {
        Color col = new Color(240, 240, 240);
        btClientToServer.setBackground(col);
        btServerToClient.setBackground(col);
        btCancel.setBackground(col);
        btServerManager.setBackground(col);
    }
}
