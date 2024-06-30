import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	private AppointmentService service;
	private String id;
	private Date futureDate;
	private String appointmentDescription;
	
	private Date getFutureDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	@BeforeEach
	public void setUp() {
		service = new AppointmentService();
		id = "123456789";
		futureDate = getFutureDate();
		appointmentDescription = "This is the description";
		Appointment.clearUsedAppointmentIds();
	}

	@Test
	void testAddAppointment() {
		Appointment appointment = new Appointment(id, futureDate, appointmentDescription);
		service.addAppointment(appointment);
		assertEquals(appointment,service.getAppointment(id));
	}
	
	@Test
	void testDeleteAppointment() {
		Appointment appointment = new Appointment(id, futureDate, appointmentDescription);
		service.addAppointment(appointment);
		service.deleteAppointment(id);
		
	}
	
	@Test
	void testNonExistingAppointment() {
		assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment(id);
        });
		
	}
	
	

}
