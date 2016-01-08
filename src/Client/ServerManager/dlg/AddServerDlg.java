package Client.ServerManager.dlg;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Viktoria Buchegger
 */
public class AddServerDlg extends javax.swing.JDialog {

    private String ip;
    private int port;

    private boolean ok;

    public AddServerDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfIp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfPort = new javax.swing.JTextField();
        btAccept = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Server");
        getContentPane().setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setText("IP:");
        getContentPane().add(jLabel1);
        getContentPane().add(tfIp);

        jLabel2.setText("Port:");
        getContentPane().add(jLabel2);
        getContentPane().add(tfPort);

        btAccept.setText("Accept");
        btAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAccept(evt);
            }
        });
        getContentPane().add(btAccept);

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCanel(evt);
            }
        });
        getContentPane().add(btCancel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onAccept(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAccept
        try {

            if (tfIp.getText().isEmpty() || tfPort.getText().isEmpty()) {
                throw new Exception("fill in all fields");
            }

            ip = tfIp.getText();
            port = Integer.parseInt(tfPort.getText());

            this.ok = true;
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_onAccept

    private void onCanel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCanel
        this.ok = false;
        this.dispose();
    }//GEN-LAST:event_onCanel

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public boolean isOk() {
        return ok;
    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddServerDlg dialog = new AddServerDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAccept;
    private javax.swing.JButton btCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfIp;
    private javax.swing.JTextField tfPort;
    // End of variables declaration//GEN-END:variables
}
