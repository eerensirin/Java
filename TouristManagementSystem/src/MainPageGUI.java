import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPageGUI extends JFrame implements ActionListener {
	private JButton profileButton, notificationButton, planButton, searchButton;
	private ArrayList<TMSClasses.Participant> participants;
	private ArrayList<TMSClasses.Event> events;
	private TMSClasses.Participant currentUser;
	private PlanGUI planGUI;
	private SearchGUI searchGUI;
	private NotificationGUI notificationGUI;
	private TMSClasses.EventManager eventManager;
	
	public MainPageGUI(ArrayList<TMSClasses.Participant> participants) {
		this.participants = participants;
		this.events = new ArrayList<>();

		setTitle("Main Page");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		profileButton = new JButton("Profile");
		profileButton.setBounds(50, 30, 200, 30);
		profileButton.addActionListener(this);
		add(profileButton);

		notificationButton = new JButton("Notifications");
		notificationButton.setBounds(50, 70, 200, 30);
		notificationButton.addActionListener(this);
		add(notificationButton);

		planButton = new JButton("Plan");
		planButton.setBounds(50, 110, 200, 30);
		planButton.addActionListener(this);
		add(planButton);

		searchButton = new JButton("Search");
		searchButton.setBounds(50, 150, 200, 30);
		searchButton.addActionListener(this);
		add(searchButton);

		

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == profileButton) {

			if (!participants.isEmpty()) {

				TMSClasses.Participant user = participants.get(0);
				new ProfileGUI(user);
			} else {
				JOptionPane.showMessageDialog(this, "No users registered yet.");
			}
		} else if (e.getSource() == notificationButton) {
		    if (notificationGUI == null) {
		        eventManager = new TMSClasses.EventManager(); // Event manager instance
		        notificationGUI = new NotificationGUI(eventManager);
		    } else {
		        notificationGUI.displayNotifications();
		        dispose();
		    }
		
			
		} else if (e.getSource() == planButton) {
			PlanGUI planGUI = new PlanGUI(events, this);
			planGUI.setVisible(true);
			dispose();
		} else if (e.getSource() == searchButton) {
			searchGUI = new SearchGUI(events,this);
			searchGUI.setVisible(true);
			dispose(); 
		}
	}

	public void addEvent(TMSClasses.Event event) {
		events.add(event);
	}

	public void setPlanGUI(PlanGUI planGUI) {
		this.planGUI = planGUI;
	}

	public static void main(String[] args) {
		ArrayList<TMSClasses.Participant> participants = new ArrayList<>();
		SwingUtilities.invokeLater(() -> {
			new MainPageGUI(participants);
		});
	}
}
