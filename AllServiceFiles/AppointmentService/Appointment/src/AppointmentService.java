import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	private Map<String, Appointment> appointments;
	
	public AppointmentService() {
		this.appointments = new HashMap<>();
	}
	
	public void addAppointment(Appointment appointment) {
		appointments.put(appointment.getAppointmentID(), appointment);
	}
	
	public void deleteAppointment(String appointmentID) {
		if(!appointments.containsKey(appointmentID)) {
			throw new IllegalArgumentException("Appointment not found");
		}
		appointments.remove(appointmentID);
	}
	
	public Appointment getAppointment(String appointmentID) {
		return appointments.get(appointmentID);
	}

}
