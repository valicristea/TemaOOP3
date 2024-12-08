import java.util.List;
import java.util.Set;

public interface Phones {
    public abstract void addContact(String phoneNumber, String firstName, String secondName);
    public abstract List<Contact> seeContacts ();
    public abstract void sendMessage (String message, String contact);
    public abstract List<String> seeMessage(String contact);
    public abstract void makeCall(String contact);
    public abstract List<String> seeCallsHistory ();
    public Contact getFirstContact();
    public Contact getLastContact();



}
