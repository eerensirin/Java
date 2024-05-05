import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;

public class NotificationGUI extends JFrame {
    private JPanel eventPanel;
    private TMSClasses.EventManager eventManager;

    public NotificationGUI(TMSClasses.EventManager eventManager) {
        this.eventManager = eventManager;

        setTitle("Notifications");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        eventPanel = new JPanel();
        eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(eventPanel);
        add(scrollPane, BorderLayout.CENTER);

        displayNotifications();

        JButton backButton = new JButton("Back to Main Page");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                new MainPageGUI(new ArrayList<TMSClasses.Participant>());
            }
        });
        add(backButton, BorderLayout.SOUTH);
        eventManager.addEvent(new TMSClasses.Event("Football", "Stadium A", LocalDate.of(2024, 5, 10), 0));
        eventManager.addEvent(new TMSClasses.Event("Basketball", "Arena B", LocalDate.of(2024, 5, 11), 0));
        eventManager.addEvent(new TMSClasses.Event("Volleyball", "Hall C", LocalDate.of(2024, 5, 12), 0));

        setVisible(true);
    }

    void displayNotifications() {
        ArrayList<TMSClasses.Event> upcomingEvents = eventManager.getUpcomingEvents();
        upcomingEvents.sort((e1, e2) -> e1.getDate().compareTo(e2.getDate())); // Sort events by date

        JLabel titleLabel = new JLabel("Upcoming Events");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        eventPanel.add(titleLabel);
        eventPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        for (TMSClasses.Event event : upcomingEvents) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel nameLabel = new JLabel("Name: " + event.getName());
            panel.add(nameLabel, BorderLayout.NORTH);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            JLabel dateLabel = new JLabel("Date: " + event.getDate().format(formatter));
            panel.add(dateLabel, BorderLayout.CENTER);

            JButton detailsButton = new JButton("Details");
            detailsButton.addActionListener(new DetailsButtonListener(event));
            panel.add(detailsButton, BorderLayout.SOUTH);

            eventPanel.add(panel);
            eventPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
    }

    private class DetailsButtonListener implements ActionListener {
        private TMSClasses.Event event;

        public DetailsButtonListener(TMSClasses.Event event) {
            this.event = event;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(NotificationGUI.this, "Event Details:\n" +
                    "Name: " + event.getName() + "\n" +
                    "Location: " + event.getLocation() + "\n" +
                    "Date: " + event.getDate() + "\n" +
                    "Participant Count: " + event.getParticipantCount());
        }
    }

    public static void main(String[] args) {
        ArrayList<TMSClasses.Participant> participants = new ArrayList<>();
        TMSClasses.EventManager eventManager = new TMSClasses.EventManager();
        eventManager.addEvent(new TMSClasses.Event("Football", "Stadium A", LocalDate.of(2024, 5, 10), 0));
        eventManager.addEvent(new TMSClasses.Event("Basketball", "Arena B", LocalDate.of(2024, 5, 11), 0));
        eventManager.addEvent(new TMSClasses.Event("Volleyball", "Hall C", LocalDate.of(2024, 5, 12), 0));
        new NotificationGUI(eventManager);
    }
}
