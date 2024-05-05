import java.time.LocalDate;
import java.util.ArrayList;

public class TMSClasses {

    public static class Event {
        private String name;
        private String location;
        private LocalDate date;
        private int participantCount;
        private ArrayList<Participant> participants;
        private static ArrayList<Event> events = new ArrayList<>();

        public Event(String name, String location, LocalDate date, int participantCount) {
            this.name = name;
            this.location = location;
            this.date = date;
            this.participantCount = participantCount;
            this.participants = new ArrayList<>();
            events.add(this);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public int getParticipantCount() {
            return participantCount;
        }

        public void setParticipantCount(int participantCount) {
            this.participantCount = participantCount;
        }

        public ArrayList<Participant> getParticipants() {
            return participants;
        }

        public void addParticipant(Participant participant) {
            participants.add(participant);
        }

        public void removeParticipant(Participant participant) {
            participants.remove(participant);
        }

        public boolean isParticipantRegistered(Participant participant) {
            return participants.contains(participant);
        }

        public boolean joinEvent(Participant participant) {
            if (!isParticipantRegistered(participant)) {
                addParticipant(participant);
                return true;
            } else {
                return false;
            }
        }

        public long calculateDurationInDays() {
            return LocalDate.now().until(date).getDays();
        }

        public boolean isUpcoming() {
            return LocalDate.now().isBefore(date);
        }

        public static ArrayList<Event> getEvents() {
            return events;
        }
    }

    public static class Participant {
        private String name;
        private int age;
        private String gender;
        private String email;
        private String password;

        public Participant(String name, int age, String gender, String email, String password) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.email = email;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        
    }
    // inheritance
    public static class MyEvent extends Event {
        private String additionalInfo;

        public MyEvent(String name, String location, LocalDate date, int participantCount, String additionalInfo) {
            super(name, location, date, participantCount);
            this.additionalInfo = additionalInfo;
        }

        public String getAdditionalInfo() {
            return additionalInfo;
        }

        public void setAdditionalInfo(String additionalInfo) {
            this.additionalInfo = additionalInfo;
        }
    }
    
    public static class EventManager {
        private ArrayList<Event> events;

        public EventManager() {
            this.events = new ArrayList<>();
        }

        public void addEvent(Event event) {
            if (event != null) {
                events.add(event);
            }
        }

        public ArrayList<Event> getEvents() {
            return events;
        }

        public void registerParticipant(Event event, Participant participant) {
            if (event != null && participant != null) {
                if (!event.isParticipantRegistered(participant)) {
                    event.addParticipant(participant);
                }
            }
        }

        public void cancelParticipation(Event event, Participant participant) {
            if (event != null && participant != null) {
                if (event.isParticipantRegistered(participant)) {
                    event.removeParticipant(participant);
                }
            }
        }

        public ArrayList<Event> getUpcomingEvents() {
            ArrayList<Event> upcomingEvents = new ArrayList<>();
            for (Event event : events) {
                if (event.isUpcoming()) {
                    upcomingEvents.add(event);
                }
            }
            return upcomingEvents;
        }

        public ArrayList<Event> getEventsByLocation(String location) {
            ArrayList<Event> eventsAtLocation = new ArrayList<>();
            for (Event event : events) {
                if (event.getLocation().equalsIgnoreCase(location)) {
                    eventsAtLocation.add(event);
                }
            }
            return eventsAtLocation;
        }

        public ArrayList<Event> getEventsByParticipant(Participant participant) {
            ArrayList<Event> participantEvents = new ArrayList<>();
            for (Event event : events) {
                if (event.isParticipantRegistered(participant)) {
                    participantEvents.add(event);
                }
            }
            return participantEvents;
        }

        public int getTotalParticipants() {
            int totalParticipants = 0;
            for (Event event : events) {
                totalParticipants += event.getParticipantCount();
            }
            return totalParticipants;
        }

        public ArrayList<Participant> getParticipants(Event event) {
            if (event != null) {
                return event.getParticipants();
            }
            return new ArrayList<>();
        }
    }

	}

