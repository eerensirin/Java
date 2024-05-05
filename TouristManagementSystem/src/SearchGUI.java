import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchGUI extends JFrame {
    private JTextField searchField;
    private JButton searchButton, mainPageButton, joinButton;
    private JTextArea resultArea;
    private ArrayList<TMSClasses.Event> events;
    private MainPageGUI mainPageGUI;

    public SearchGUI(ArrayList<TMSClasses.Event> events, MainPageGUI mainPageGUI) {
        this.events = events;
        this.mainPageGUI = mainPageGUI;

        setTitle("Search Event");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().toLowerCase();
                if (events != null) {
                    ArrayList<TMSClasses.Event> foundEvents = searchEvents(searchTerm, events);
                    resultArea.setText("");
                    if (foundEvents.isEmpty()) {
                        resultArea.setText("No events found.");
                    } else {
                        displayEvents(foundEvents);
                    }
                } else {
                    resultArea.setText("Events list is null.");
                }
            }
        });

        mainPageButton = new JButton("Main Page");
        mainPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPageGUI.setVisible(true);
                dispose();
            }
        });

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(mainPageButton);

        add(searchPanel, BorderLayout.NORTH);

        JPanel joinPanel = new JPanel();
        joinButton = new JButton("Join Event");
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Join Event button action
                JOptionPane.showMessageDialog(SearchGUI.this, "You have successfully joined the event.");
            }
        });
        joinPanel.add(joinButton);

        add(joinPanel, BorderLayout.SOUTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        // Örnek etkinlikler oluştur
        events.add(new TMSClasses.Event("Football", "Stadium A", LocalDate.of(2024, 5, 10), 0));
        events.add(new TMSClasses.Event("Basketball", "Arena B", LocalDate.of(2024, 5, 11), 0));
        events.add(new TMSClasses.Event("Volleyball", "Hall C", LocalDate.of(2024, 5, 12), 0));

        setVisible(true);
    }

    private void displayEvents(ArrayList<TMSClasses.Event> foundEvents) {
        for (TMSClasses.Event event : foundEvents) {
            StringBuilder sb = new StringBuilder();
            sb.append("Event Name: ").append(event.getName()).append("\n");
            sb.append("Location: ").append(event.getLocation()).append("\n");
            sb.append("Date: ").append(event.getDate()).append("\n");
            sb.append("Participants: ").append(event.getParticipantCount()).append("\n");

            resultArea.append(sb.toString());
            resultArea.append("\n\n");
        }
    }

    private ArrayList<TMSClasses.Event> searchEvents(String searchTerm, ArrayList<TMSClasses.Event> events) {
        ArrayList<TMSClasses.Event> foundEvents = new ArrayList<>();
        for (TMSClasses.Event event : events) {
            if (event.getName().toLowerCase().contains(searchTerm) || event.getLocation().toLowerCase().contains(searchTerm)) {
                foundEvents.add(event);
            }
        }
        return foundEvents;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArrayList<TMSClasses.Event> events = new ArrayList<>();
            ArrayList<TMSClasses.Participant> participants = new ArrayList<>();
            MainPageGUI mainPageGUI = new MainPageGUI(participants);
            SearchGUI searchGUI = new SearchGUI(events, mainPageGUI);
        });
    }
}
