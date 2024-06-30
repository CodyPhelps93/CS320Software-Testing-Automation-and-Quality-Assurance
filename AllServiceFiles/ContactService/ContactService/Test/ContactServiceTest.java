import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {
	

	 @Test
	    void testAddContact() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("123456", "Jack", "Smith", "0123456789", "222 Lonely Lane");
	        service.addContact(contact);

	        assertEquals(contact, service.getContact("123456"));
	    }
	 
	 @Test
	    void testDupeContact() {
	        ContactService service = new ContactService();
	        Contact contact = new Contact("123456", "Jack", "Smith", "0123456789", "222 Lonely Lane");
	        Contact contact1 = new Contact("123456", "Jordan", "Smith", "0123456789", "222 Lonely Lane");
	        service.addContact(contact);
	        
	        assertThrows(IllegalArgumentException.class, () -> {
	        	service.addContact(contact1);
	        });
	        
	    }
	 
	 @Test
	 	void testUpdateContact() {
		 ContactService service = new ContactService();
		 Contact contact = new Contact("123456", "Jack", "Smith", "0123456789", "222 Lonely Lane");
		 service.addContact(contact);
		 
		 service.updateContact("123456", "Janet", "Jacklyn", "0123456788", "222 Lovely Lane");
		 
		 Contact updatedContact = service.getContact("123456");
		 assertEquals("Janet", updatedContact.getFirstName());
		 assertEquals("Jacklyn", updatedContact.getLastName());
		 assertEquals("0123456788", updatedContact.getPhone());
		 assertEquals("222 Lovely Lane", updatedContact.getAddress());
		 
		 // null first name
		 assertThrows(IllegalArgumentException.class, () -> {
				service.updateContact("123456", null, "Jacklyn", "0123456788", "222 Lovely Lane");
			});
		 // null last name
		 assertThrows(IllegalArgumentException.class, () -> {
				service.updateContact("123456", "Janet", null, "0123456788", "222 Lovely Lane");
			});
		 // null phone
		 assertThrows(IllegalArgumentException.class, () -> {
				service.updateContact("123456", "Janet", "Jacklyn", null, "222 Lovely Lane");
			});
		 // null address
		 assertThrows(IllegalArgumentException.class, () -> {
				service.updateContact("123456", "Janet", "Jacklyn", "0123456788", null);
			});
	 }
	 
	 @Test
	 	void testNullContact() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("123456", "Janet", "Jacklyn", "0123456788", "222 Lovely Lane");
		});
	 }
	 
	 @Test
	 	void testDeleteContact() {
		 ContactService service = new ContactService();
		 Contact contact = new Contact("123456", "Jack", "Smith", "0123456789", "222 Lonely Lane");
		 service.addContact(contact);
		 service.deleteContact("123456");
		 
		 assertNull(service.getContact("123456"));
		 
		// NonExistent ID
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.deleteContact("1234567");
		 });
	 }
	 
	 
	 
}
