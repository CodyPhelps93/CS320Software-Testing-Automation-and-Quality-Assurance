import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContactCreation() {
		Contact contact = new Contact("123456", "Jack", "Smith", "0123456789", "222 Lonely Lane");
		assertEquals("123456", contact.getContactId());
		assertEquals("Jack", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("0123456789", contact.getPhone());
		assertEquals("222 Lonely Lane", contact.getAddress());
	}
	
	@Test
	void testInvalidId() {
		// null value
		 assertThrows(IllegalArgumentException.class, () -> {
	            new Contact(null, "Jack", "Smith", "1234567890", "123 Main St");
	        });
		 
		 // more than 10 chars
		 assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("01234567891", "Jack", "Smith", "1234567890", "123 Main St");
	        });
	}
	
	@Test
	void testInvalidFirstName() {
		//null value
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", null, "Smith", "0123456789", "222 Lonely Lane");;
        });
		
		// more than 10 chars
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "JackJackIII", "Smith", "0123456789", "222 Lonely Lane");
		});
	}
	
	@Test
	void testInvalidLastName() {
		//null value
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Jack", null, "0123456789", "222 Lonely Lane");;
        });
		
		// more than 10 chars
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Jack", "SmithSmithI", "0123456789", "222 Lonely Lane");
		});
	}
	
	@Test
	void testInvalidNumber() {
		//null value
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Jack", "Smith", null, "222 Lonely Lane");;
        });
		
		// more than 10 chars
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Jack", "Smith", "01234567890", "222 Lonely Lane");
		});
		
		// less than 10 chars
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Jack", "Smith", "01234", "222 Lonely Lane");
		});
	}
	
	@Test
	void testInvalidAddress() {
		//null value
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Jack", "Smith", "0123456789", null);;
        });
		
		// more than 30 chars
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Jack", "Smith", "0123456789", "222 Lonely Lane Tasdfasdfhis String IS To Long");
		});
	}
	
	@Test
	void testSetters() {
		Contact contact = new Contact("123456", "Jack", "Smith", "0123456789", "222 Lonely Lane");
		// null firstName & firstName greater 10 chars
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("ThisNameIsToLong");
		});
		// null lastName & lastName greater 10 chars
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("ThisNameIsToLong");
		});
		// null phone and phone
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("45679");
		});
		// null Address and length > 30
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("This Address is way to long so that this is to long");
		});
	}

}
