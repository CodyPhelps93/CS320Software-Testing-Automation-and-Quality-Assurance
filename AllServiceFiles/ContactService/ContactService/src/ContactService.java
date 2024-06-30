import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exist");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contacts.remove(contactId);
	}
	
	
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = contacts.get(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		 if (firstName == null) {
			 throw new IllegalArgumentException("firstName cannot be null");
	            
	        }
	        if (lastName == null) {
	        	throw new IllegalArgumentException("LastName cannot be null");
	        }
	        if (phone == null) {
	        	throw new IllegalArgumentException("Phone cannot be null");
	        }
	        if (address == null) {
	        	throw new IllegalArgumentException("Address cannot be null");
	        }
	        contact.setFirstName(firstName);
	        contact.setLastName(lastName);
	        contact.setPhone(phone);
	        contact.setAddress(address);
	}
	
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
}

