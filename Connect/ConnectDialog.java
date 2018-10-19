package Connect;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* This class displays a dialog for entering e-mail
   server connection settings. */
public class ConnectDialog extends JDialog {
    
 


/**
 *
 * @author Priyal
 */
//public class ConnectDialog extends javax.swing.JFrame {

    /**
     * Creates new form ConnectDialog
     */
    public ConnectDialog() 
    {
       initComponents();
         // These are the e-mail server types.
    private static final String[] TYPES = {"pop3", "imap"};
    
    // Combo box for e-mail server types.
    private JComboBox typeComboBox;
    
    // Server, username and SMTP server text fields.
    private JTextField serverTextField, usernameTextField;
    private JTextField smtpServerTextField;
    
    // Password text field.
    private JPasswordField passwordField;
    
    // Constructor for dialog.
    public ConnectDialog(Frame parent) 
    {
        // Call super constructor, specifying that dialog is modal.
        super(parent, true);
        
        // Set dialog title.
        setTitle("Connect");
        
        // Handle closing events.
    addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                actionCancel();
            }
        });
        
        // Setup settings panel.
        JPanel settingsPanel = new JPanel();
        settingsPanel.setBorder(BorderFactory.createTitledBorder("Connection Settings"));
        GridBagConstraints constraints;
        GridBagLayout layout = new GridBagLayout();
        settingsPanel.setLayout(layout);
        JLabel typeLabel = new JLabel("Type:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(typeLabel, constraints);
        settingsPanel.add(typeLabel);
        typeComboBox = new JComboBox(TYPES);
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(typeComboBox, constraints);
        settingsPanel.add(typeComboBox);
        JLabel serverLabel = new JLabel("Server:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(serverLabel, constraints);
        settingsPanel.add(serverLabel);
        serverTextField = new JTextField(25);
        constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(serverTextField, constraints);
        settingsPanel.add(serverTextField);
        JLabel usernameLabel = new JLabel("Username:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(usernameLabel, constraints);
        settingsPanel.add(usernameLabel);
        usernameTextField = new JTextField();
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(usernameTextField, constraints);
        settingsPanel.add(usernameTextField);
        JLabel passwordLabel = new JLabel("Password:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 5, 0);
        layout.setConstraints(passwordLabel, constraints);
        settingsPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(passwordField, constraints);
        settingsPanel.add(passwordField);
        JLabel smtpServerLabel = new JLabel("SMTP Server:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 5, 0);
        layout.setConstraints(smtpServerLabel, constraints);
        settingsPanel.add(smtpServerLabel);
        smtpServerTextField = new JTextField(25);
        constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(smtpServerTextField, constraints);
        settingsPanel.add(smtpServerTextField);
        
        // Setup buttons panel.
        JPanel buttonsPanel = new JPanel();
        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionConnect();
            }
        });
        buttonsPanel.add(connectButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionCancel();
            }
        });
        buttonsPanel.add(cancelButton);
        
        // Add panels to display.
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(settingsPanel, BorderLayout.CENTER);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        
        // Size dialog to components.
        pack();
        
        // Center dialog over application.
        setLocationRelativeTo(parent);
    }
    
    // Validate connection settings and close dialog.
    private void actionConnect() {
        if (serverTextField.getText().trim().length() < 1
                || usernameTextField.getText().trim().length() < 1
                || passwordField.getPassword().length < 1
                || smtpServerTextField.getText().trim().length() < 1) {
            JOptionPane.showMessageDialog(this,
                    "One or more settings is missing.",
                    "Missing Setting(s)", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Close dialog.
        dispose();
    }
    
    // Cancel connecting and exit program.
    private void actionCancel() {
        System.exit(0);
    }
    
    // Get e-mail server type.
    public String getType() 
    {
        return (String) typeComboBox.getSelectedItem();
    }
    
    // Get e-mail server.
    public String getServer() {
        return serverTextField.getText();
    }
    
    // Get e-mail username.
    public String getUsername() {
        return usernameTextField.getText();
    }
    
    // Get e-mail password.
    public String getPassword() {
        return new String(passwordField.getPassword());
    }
    
    // Get e-mail SMTP server.
    public String getSmtpServer() {
        return smtpServerTextField.getText();
    }

    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ConnectDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}