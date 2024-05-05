import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.LocalDate;

public class PlanGUI extends JFrame implements ActionListener {
    private JLabel eventNameLabel, locationLabel, dayLabel, monthLabel, yearLabel, requirementsLabel, participantsLabel;
    private JTextField eventNameField, locationField, dayField, monthField, yearField;
    private JCheckBox foodCheckBox, drinksCheckBox, equipmentCheckBox;
    private JComboBox<String> participantsComboBox;
    private JButton createButton, mainPageButton;
    private ArrayList<TMSClasses.Event> events;
    private MainPageGUI mainPageGUI;

    public PlanGUI(ArrayList<TMSClasses.Event> events, MainPageGUI mainPageGUI) {
        this.events = events;
        this.mainPageGUI = mainPageGUI;

        setTitle("Plan Event");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(12, 2, 10, 5));

        eventNameLabel = new JLabel("Event Name:");
        eventNameField = new JTextField();
        locationLabel = new JLabel("Location:");
        locationField = new JTextField();
        dayLabel = new JLabel("Day:");
        monthLabel = new JLabel("Month:");
        yearLabel = new JLabel("Year:");
        dayField = new JTextField();
        monthField = new JTextField();
        yearField = new JTextField();
        requirementsLabel = new JLabel("Requirements:");
        foodCheckBox = new JCheckBox("Food");
        drinksCheckBox = new JCheckBox("Drinks");
        equipmentCheckBox = new JCheckBox("Equipment");
        participantsLabel = new JLabel("Number of Participants:");
        String[] participantOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        participantsComboBox = new JComboBox<>(participantOptions);

        add(eventNameLabel);
        add(eventNameField);
        add(locationLabel);
        add(locationField);
        add(dayLabel);
        add(dayField);
        add(monthLabel);
        add(monthField);
        add(yearLabel);
        add(yearField);
        add(requirementsLabel);
        add(new JPanel()); // Empty space
        add(foodCheckBox);
        add(new JPanel()); // Empty space
        add(drinksCheckBox);
        add(new JPanel()); // Empty space
        add(equipmentCheckBox);
        add(new JPanel()); // Empty space
        add(participantsLabel);
        add(participantsComboBox);

        createButton = new JButton("Create Event");
        createButton.addActionListener(this);
        add(createButton);

        mainPageButton = new JButton("Main Page");
        mainPageButton.addActionListener(this);
        add(mainPageButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            // Get event information
            String eventName = eventNameField.getText();
            String location = locationField.getText();
            int day = Integer.parseInt(dayField.getText());
            int month = Integer.parseInt(monthField.getText());
            int year = Integer.parseInt(yearField.getText());
            LocalDate date = LocalDate.of(year, month, day);
            int participantsCount = Integer.parseInt((String) participantsComboBox.getSelectedItem());

            // Get other event details
            boolean foodNeeded = foodCheckBox.isSelected();
            boolean drinksNeeded = drinksCheckBox.isSelected();
            boolean equipmentNeeded = equipmentCheckBox.isSelected();

            // Create a new event
            TMSClasses.Event newEvent = new TMSClasses.Event(eventName, location, date, participantsCount);
            for (int i = 0; i < participantsCount; i++) {
                newEvent.addParticipant(new TMSClasses.Participant("Participant " + (i + 1), 0, "Gender", "participant@example.com", "password"));
            }

            // Add the created event to the list
            events.add(newEvent);

            // Show event created message
            JOptionPane.showMessageDialog(this, "Event Created:\n" +
                    "Name: " + eventName + "\n" +
                    "Location: " + location + "\n" +
                    "Date: " + date.toString() + "\n" +
                    "Food Needed: " + (foodNeeded ? "Yes" : "No") + "\n" +
                    "Drinks Needed: " + (drinksNeeded ? "Yes" : "No") + "\n" +
                    "Equipment Needed: " + (equipmentNeeded ? "Yes" : "No") + "\n" +
                    "Number of Participants: " + participantsCount);

            // Close the PlanGUI window and show the MainPageGUI
            mainPageGUI.setVisible(true);
            dispose();

        } else if (e.getSource() == mainPageButton) {
            // Go back to the main page when Main Page button is clicked
            mainPageGUI.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArrayList<TMSClasses.Event> events = new ArrayList<>();
            MainPageGUI mainPageGUI = new MainPageGUI(new ArrayList<>());
            PlanGUI planGUI = new PlanGUI(events, mainPageGUI);
            mainPageGUI.setPlanGUI(planGUI);

            // Display the PlanGUI to test
            planGUI.setVisible(true);
        });
    }
}
