import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Worker extends ObjectPlus implements Serializable {

	private static final long serialVersionUID = 537418369606124629L;
	
	/**
	 * Atrybut klasowy
	 */
	private static final float VAT = 0.23f; 
	
	private UUID id;
	private String firstName;
	private String lastName;
	private String NIP;
	/**
	 * Atrybut złożony
	 */
	private LocalDate birthDate;
	/**
	 * Atrybut opcjonalny
	 */
	private LocalDate lastInWork;
	/**
	 * Atrybut powtarzalny
	 */
	private List<Certificate> certificates = new ArrayList<>();

	public Worker(String firstName, String lastName, LocalDate birthDate) {
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	/**
	 * Przeciążenie konstruktora
	 * 
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param NIP
	 */
	public Worker(String firstName, String lastName, LocalDate birthDate, String NIP) { 
		this(firstName, lastName, birthDate);
		this.NIP = NIP;
	}
	
	/**
	 * Metoda klasowa
	 * 
	 * @return
	 */
	public static Worker getYoungest() throws Exception { 
		List<ObjectPlus> workers = ObjectPlus.getExtent(Worker.class);
		if (workers.isEmpty()) {
			throw new Exception("No workers");
		}
		return workers.stream()
				.map(e -> (Worker)e)
				.min(Comparator.comparing(Worker::getAge))
				.get();
	}
	
	/**
	 * Atrybut pochodny
	 * 
	 * @return
	 */
	public int getAge() {
		return (int) birthDate.until(LocalDate.now(), ChronoUnit.YEARS);
	}
	
	/**
	 * Przesłonięcie
	 */
	@Override
	public String toString() {
		return id + ": " + firstName + " " + lastName + ", no.certificates:" + certificates.size(); 
	}
	
	/**
	 * Przesłonięcie
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Worker) {
			return id.equals(((Worker) obj).getId());
		}
		return false;
	}

	public static void showExtent() {
		try {
			ObjectPlus.showExtent(Worker.class);
		} catch (Exception e) {
			System.out.println("Nie ma obiektów tej klasy");
		}
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNIP() {
		return NIP;
	}

	public void setNIP(String nIP) {
		NIP = nIP;
	}

	public LocalDate getLastInWork() {
		return lastInWork;
	}

	public void setLastInWork(LocalDate lastInWork) {
		this.lastInWork = lastInWork;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}
}
