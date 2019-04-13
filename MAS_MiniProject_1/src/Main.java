import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String FILE_PATH = "C:\\dev\\PJWSTK\\MAS2019\\extent.bin"; 
	
	public static void main(String[] args) {
		try {
			testExtentObjectPlus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testExtentObjectPlus() throws Exception {

		Certificate cert1 = new Certificate("usa_4532", "Spring boot basics");
		Certificate cert2 = new Certificate("eu_3242", "Java 12 basics");
		
		Worker worker1 = new Worker("Michał", "Korzeniewicz", LocalDate.parse("1993-04-30"));
		Worker worker2 = new Worker("Adam", "Kowalski", LocalDate.parse("1995-02-12"));

		List<Certificate> certs = new ArrayList<>();
		certs.add(cert1);
		certs.add(cert2);
		
		worker1.setCertificates(certs);
		
		Worker.showExtent();

		System.out.println(worker1.getAge());
		System.out.println(worker2.getAge());
		
		
//		Worker.getYoungest();

	    try {
			// Write the extent to the stream
		    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			ObjectPlus.writeExtents(out);
			out.close();

		    // Read the extent from the stream
		    ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH));
			ObjectPlus.readExtents(in);
			in.close();			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		Worker.showExtent();
	}
}

