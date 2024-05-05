import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterGUI extends JFrame implements ActionListener {
    private JLabel nameLabel, ageLabel, genderLabel, emailLabel, passwordLabel;
    private JTextField nameField, ageField, genderField, emailField;
    private JPasswordField passwordField;
    private JButton saveButton, backButton; 

    private ArrayList<TMSClasses.Participant> participants;

    public RegisterGUI(ArrayList<TMSClasses.Participant> participants) {
        this.participants = participants;

        setTitle("Register");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 30, 150, 25);
        add(nameField);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(30, 60, 80, 25);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(120, 60, 150, 25);
        add(ageField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 90, 80, 25);
        add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(120, 90, 150, 25);
        add(genderField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 120, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(120, 120, 150, 25);
        add(emailField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 150, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 150, 150, 25);
        add(passwordField);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 190, 100, 25);
        saveButton.addActionListener(this);
        add(saveButton);

        backButton = new JButton("Back");
        backButton.setBounds(30, 190, 100, 25);
        backButton.addActionListener(this);
        add(backButton);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            registerParticipant();
        } else if (e.getSource() == backButton) {
            new LoginGUI(participants); 
            dispose(); 
        }
    }

    private void registerParticipant() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = genderField.getText();
        String email = emailField.getText();
        String password = String.valueOf(passwordField.getPassword());

        TMSClasses.Participant newParticipant = new TMSClasses.Participant(name, age, gender, email, password);

        boolean userExists = false;
        for (TMSClasses.Participant participant : participants) {
            if (participant.getEmail().equals(email)) {
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            participants.add(newParticipant);
            JOptionPane.showMessageDialog(this, "Registration successful");

            new LoginGUI(participants);

            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "A user with the same email already exists. Please choose a different email.");
        }
    }

    public static void main(String[] args) {
        ArrayList<TMSClasses.Participant> participants = new ArrayList<>();
        new RegisterGUI(participants);
    }
}
