import java.util.*;

public abstract class Mobile implements Phones {
    protected Integer batteryLife;
    public String color;
    public String material;
    private final String imei;
    private List<Contact> contactsList;
    private Map<Contact, ArrayList<String>> messageList;
    private ArrayList<String> callHistory;


    public Mobile(String imei) {
        this.imei = imei;
        contactsList = new ArrayList<>();
        messageList = new HashMap<>();
        callHistory = new ArrayList<>();
    }

    @Override
    public void addContact(String phoneNumber, String firstName, String secondName) {
        Contact contact = new Contact(firstName,secondName,phoneNumber);
        contactsList.add(contact);
        messageList.put(contact, new ArrayList<>());

    }

    @Override
    public List<Contact> seeContacts() {
        return contactsList;
    }

    @Override
    public void sendMessage(String message, String contact) {
        if (message.length() < 500) {
            messageList.get(contact).add(message);
            batteryLife = batteryLife - 1;
        } else {
            System.out.println("The message is too long!");
        }


    }

    @Override
    public List<String> seeMessage(String contact) {
        return messageList.get(contact);
    }

    @Override
    public void makeCall(String contact) {
        callHistory.add(contact);
        batteryLife = batteryLife - 2;

    }

    @Override
    public List<String> seeCallsHistory() {
        return callHistory;
    }

    @Override
    public Contact getLastContact() {
        return seeContacts().getLast();
    }

    @Override
    public Contact getFirstContact() {
        return seeContacts().getFirst();
    }
}
