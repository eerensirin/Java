import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProfileGUI extends JFrame {
    private JLabel nameLabel, ageLabel, genderLabel, emailLabel, typeLabel;
    private JTextField nameField, ageField, genderField, emailField, typeField;

    public ProfileGUI(TMSClasses.Participant user) {
        setTitle("Profile");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        nameLabel = new JLabel("Name:");
        add(nameLabel);

        nameField = new JTextField(user.getName());
        nameField.setEditable(false);
        add(nameField);

        ageLabel = new JLabel("Age:");
        add(ageLabel);

        ageField = new JTextField(String.valueOf(user.getAge()));
        ageField.setEditable(false);
        add(ageField);

        genderLabel = new JLabel("Gender:");
        add(genderLabel);

        genderField = new JTextField(user.getGender());
        genderField.setEditable(false);
        add(genderField);

        emailLabel = new JLabel("Email:");
        add(emailLabel);

        emailField = new JTextField(user.getEmail());
        emailField.setEditable(false);
        add(emailField);

      

        setVisible(true);
    }

  
    }

