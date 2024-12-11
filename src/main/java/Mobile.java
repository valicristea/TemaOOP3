import java.util.*;

public abstract class Mobile implements Phones {
    protected Integer batteryLife;
    public String color;
    public String material;
    private final String imei;
    private List<Contact> contactsList;
    private Map<Contact, ArrayList<String>> messageList;
    private ArrayList<Contact> callHistory;


    public Mobile(String imei) {
        this.imei = imei;
        contactsList = new ArrayList<>();
        messageList = new HashMap<>();
        callHistory = new ArrayList<>();
    }

    /**
     *
     * @param phoneNumber this is the phone number where the message is sent
     * @param firstName for the contact
     * @param secondName for the contact
     */
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

    /**
     * this adds a message in the list for a phone number
     * @param message this is the message which will drain 1hour from battery life
     * @param phoneNumber this is the phone number where the message is sent
     */
    @Override
    public void sendMessage(String message, String phoneNumber) {
        if (message.length() < 500) {
            messageList.get(getContactByPhoneNumber(phoneNumber)).add(message);
            batteryLife = batteryLife - 1;
        } else {
            System.out.println("The message is too long!");
        }


    }

    /**
     *
     * @param phoneNumber this is the phone number where the message is sent
     * @return the list of messages for the given number
     */
    @Override
    public List<String> seeMessage(String phoneNumber) {
        return messageList.get(getContactByPhoneNumber(phoneNumber));
    }

    /**
     *
     * @param phoneNumber this is the phone number where the message is sent
     */
    @Override
    public void makeCall(String phoneNumber) {
        callHistory.add(getContactByPhoneNumber(phoneNumber));
        batteryLife = batteryLife - 2;

    }

    /**
     *
     * @return the call history list
     */
    @Override
    public List<Contact> seeCallsHistory() {
        return callHistory;
    }

    /**
     *
     * @return the last contact
     */
    @Override
    public Contact getLastContact() {
        return seeContacts().get(seeContacts().size()-1);
    }

    /**
     *
     * @return the first contact
     */
    @Override
    public Contact getFirstContact() {
        return seeContacts().get(0);
    }

    /**
     *
     * @param phoneNumber this is the phone number where the message is sent
     * @return the first message for the contact
     */
    @Override
    public String getFirstMessage(String phoneNumber) {
        return seeMessage(phoneNumber).get(0);
    }

    /**
     *
     * @param phoneNumber this is the phone number where the message is sent
     * @return the second message of the contact
     */
    @Override
    public String getSecondMessage(String phoneNumber) {
        return seeMessage(phoneNumber).get(1);
    }

    /**
     *
     * @param phoneNumber this is the phone number where the message is sent
     * @return the contact with the given phone number
     */
    private Contact getContactByPhoneNumber(String phoneNumber){
        List<Contact> contacts = seeContacts();
        for (Contact contact : contacts) {
            if (Objects.equals(contact.phoneNumber, phoneNumber)) {
                return contact;
            }
        }

        return null;
    }
}
