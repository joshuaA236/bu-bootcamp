import java.util.*; 

 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Jon R", new Contact("Jon R", "262-490-1110"));
        contacts.put("Bob S", new Contact("Bob S", "262-565-1112"));
        contacts.put("Lewis E", new Contact("Lewis E", "262-111-1233"));
        contacts.put("Lennie R", new Contact("Lennie R", "262-221-4444"));
        contacts.put("Rob X", new Contact("Rob X", "262-564-2133"));
 
        // Step 5: look up a contact 

        Contact contact = contacts.get("Billy R");
        if (contact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(contact);

        }
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println(" === All Contacts === ");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    } 
}