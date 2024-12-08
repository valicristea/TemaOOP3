public class Main {
    public static void main(String[] args){

        Phones phone = new Galaxy("ABCD12635");

        phone.addContact( "phone number", "first name", "last name");

        phone.addContact( "second phone number", "second first name", "second last name");

        phone.getFirstContact();

        phone.getLastContact();

// send a message to the first contact from the previously listed

// max number of characters - 100

        phone.sendMessage("phone number", "message content");

        phone.getFirstMessage("phone number");

        phone.getSecondMessage("phone number");

// make a call to the second contact from the previously listed

        phone.call("second phone number");

        phone.seeCallsHistory();

    }
}
