import java.io.Serializable;

public class Certificate implements Serializable {

	private static final long serialVersionUID = 8074443502760885410L;

	private String internationalId;
	private String name;
	
	public Certificate(String internationalId, String name) {
		this.internationalId = internationalId;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Certificate [internationalId=" + internationalId + ", name=" + name + "]";
	}

	public String getInternationalId() {
		return internationalId;
	}

	public void setInternationalId(String internationalId) {
		this.internationalId = internationalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
