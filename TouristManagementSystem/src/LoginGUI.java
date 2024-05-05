import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginGUI extends JFrame implements ActionListener {
    private JLabel emailLabel, passwordLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton; 


    private ArrayList<TMSClasses.Participant> participants;

    public LoginGUI(ArrayList<TMSClasses.Participant> participants) {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        this.participants = participants;

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 30, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(120, 30, 150, 25);
        add(emailField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 150, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(30, 120, 100, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        registerButton = new JButton("Register"); 
        registerButton.setBounds(150, 120, 100, 25); 
        registerButton.addActionListener(this); 
        add(registerButton); 

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());

            boolean loggedIn = false;
            for (TMSClasses.Participant participant : participants) {
                if (participant.getEmail().equals(email) && participant.getPassword().equals(password)) {
                    loggedIn = true;
                    break;
                }
            }
            if (loggedIn) {
                JOptionPane.showMessageDialog(this, "Login successful");
                MainPageGUI mainPageGUI = new MainPageGUI(participants);
                mainPageGUI.setVisible(true);
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password");
            }
        } else if (e.getSource() == registerButton) {
            RegisterGUI registerGUI = new RegisterGUI(participants);
            registerGUI.setVisible(true);
            dispose(); 
        }
    }

    public static void main(String[] args) {
        ArrayList<TMSClasses.Participant> participants = new ArrayList<>();
        new LoginGUI(participants);
    }
}
