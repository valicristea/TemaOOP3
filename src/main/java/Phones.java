import java.util.List;
import java.util.Set;

public interface Phones {
    public abstract void addContact(String phoneNumber, String firstName, String secondName);
    public abstract List<Contact> seeContacts ();
    public abstract void sendMessage (String message, String phoneNumber);
    public abstract List<String> seeMessage(String phoneNumber);
    public abstract void makeCall(String phoneNumber);
    public abstract List<Contact> seeCallsHistory ();
    public Contact getFirstContact();
    public Contact getLastContact();
    public String getFirstMessage(String phoneNumber);
    public String getSecondMessage(String phoneNumber);





}
