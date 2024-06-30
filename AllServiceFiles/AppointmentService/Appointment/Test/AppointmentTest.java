import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

class AppointmentTest {
	Date futureDate;
	Date pastDate;
	String ID;
	String longID;
	String regDescription;
	String longDescription;
	
	// using Calendar to add a date for testing
	private Date getFutureDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	// using Calendar to Subtract a date for testing
	private Date getPastDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	
	@BeforeEach
	public void setUp() {
		// set variables for ease of use
		futureDate = getFutureDate();
		pastDate = getPastDate();
		ID = "1234";
		longID = "12345678901";
		regDescription = "This is a small description";
		longDescription = "This is a description with way to many characters than what should be provided";
		Appointment.clearUsedAppointmentIds();
	}

	@Test
	void testAppointmentCreation() {
		Date futureDate = getFutureDate();
		
		Appointment appointment = new Appointment(ID, futureDate, regDescription);
		
		assertEquals(ID, appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals(regDescription, appointment.getAppointmentDescription());
	}
	
	@Test
	void testNullAppointment() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, regDescription);
        });
	}
	
	@Test
	void testLongAppointmentID() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(longID, futureDate, regDescription);
		});
	}
	
	@Test
	void testPastAppointmentDate() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, pastDate, regDescription);
		});
	}
	
	@Test
	void testNullAppointmentDate() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, null, regDescription);
		});
	}
	
	@Test
	void testNullAppointmentDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, futureDate, null);
		});
	}
	
	@Test
	void testLongAppointmentDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, futureDate, longDescription);
		});
	}
	
	@SuppressWarnings("unused")
	@Test
    void testDuplicateAppointmentID() {
        // Create first appointment with ID
        Appointment appointment1 = new Appointment(ID, futureDate, regDescription);

        // Attempt to create another appointment with the same ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(ID, futureDate, regDescription);
        });
    }
	
	@Test
	void testGetUniqueID() {
		Appointment appointment = new Appointment(ID, futureDate, regDescription);
		assertEquals(ID, appointment.getAppointmentID());
	}
	
	 @Test
	    void testSetValidAppointmentDate() {
	        Appointment appointment = new Appointment(ID, futureDate, regDescription);
	        Date newFutureDate = getFutureDate();
	        appointment.setAppointmentDate(newFutureDate);
	        assertEquals(newFutureDate, appointment.getAppointmentDate());
	    }

	    @Test
	    void testSetInvalidAppointmentDate() {
	        Appointment appointment = new Appointment(ID, futureDate, regDescription);
	        assertThrows(IllegalArgumentException.class, () -> {
	            appointment.setAppointmentDate(pastDate);
	        });
	        assertThrows(IllegalArgumentException.class, () -> {
	            appointment.setAppointmentDate(null);
	        });
	    }

	    @Test
	    void testSetValidAppointmentDescription() {
	        Appointment appointment = new Appointment(ID, futureDate, regDescription);
	        String newDescription = "New valid description";
	        appointment.setAppointmentDescription(newDescription);
	        assertEquals(newDescription, appointment.getAppointmentDescription());
	    }

	    @Test
	    void testSetInvalidAppointmentDescription() {
	        Appointment appointment = new Appointment(ID, futureDate, regDescription);
	        assertThrows(IllegalArgumentException.class, () -> {
	            appointment.setAppointmentDescription(longDescription);
	        });
	        assertThrows(IllegalArgumentException.class, () -> {
	            appointment.setAppointmentDescription(null);
	        });
	    }

}
