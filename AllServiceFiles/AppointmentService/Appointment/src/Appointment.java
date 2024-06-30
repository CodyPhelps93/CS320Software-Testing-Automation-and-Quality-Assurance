import java.util.HashSet;
import java.util.Set;
import java.util.Date;


public class Appointment {
	private static final Set<String> usedID = new HashSet<>();
	private String uniqueId;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment(String uniqueID, Date appointmentDate, String appointmentDescription) {
		if (uniqueID == null || uniqueID.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		if (usedID.contains(uniqueID)){
			throw new IllegalArgumentException("Appointment ID already in use");
		}
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment Date: Date must not be before");
		}
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Description: Must have a description under 50 characters");
		}
		
		this.uniqueId = uniqueID;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
		usedID.add(uniqueID);
	}
	
	public static void clearUsedAppointmentIds() {
		usedID.clear();
	}
	
	// getters
	public String getAppointmentID() {
		return uniqueId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	//setters
	
	public void setAppointmentDate(Date appointmentDate) {
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment Date: Date must not be before");
		}
		this.appointmentDate = appointmentDate;
	}
	
	public void setAppointmentDescription(String appointmentDescription) {
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Description: Must have a description under 50 characters");
		}
		this.appointmentDescription = appointmentDescription;
	}

}
