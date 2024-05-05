import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<TMSClasses.Participant> participants = new ArrayList<>();

        // Start the LoginGUI window
        LoginGUI loginGUI = new LoginGUI(participants);
        loginGUI.setVisible(true); 
    }
}
