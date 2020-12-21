package src.edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.APFS;
import edu.umb.cs680.hw15.ApfsDirectory;
import edu.umb.cs680.hw15.ApfsElement;
import edu.umb.cs680.hw15.ApfsFile;
import edu.umb.cs680.hw15.ApfsLink;

class TimeStampComparatorTest {
	
static LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
private String[] arraystringfordirectory(LinkedList<ApfsElement> fsElements) {
	String[] listnamefile = new String[fsElements.size()];
	int i = 0;
	for(ApfsElement afpselement : fsElements) {
		listnamefile[i] = afpselement.getName();
		i++;
	}
	return listnamefile;
}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "saidutt", LocalDateTime.of(2020, 12, 12, 0, 0));
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "saidutt", LocalDateTime.of(2020, 12, 15, 10, 0));
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "saidutt", LocalDateTime.of(2020, 12, 15, 5, 0));
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "saidutt", LocalDateTime.of(2020, 12, 16, 10, 0));
		ApfsFile b = new ApfsFile(applications, "b", 700, localTime, "saidutt", LocalDateTime.of(2020, 12, 17, 10, 0));
		ApfsFile c = new ApfsFile(home, "c", 800, localTime, "saidutt", LocalDateTime.of(2020, 12, 16, 15, 0));
		ApfsFile d = new ApfsFile(home, "d", 80, localTime, "saidutt", LocalDateTime.of(2020, 12, 17, 20, 0));
		ApfsFile apfselement = new ApfsFile(code, "apfselement", 700, localTime, "saidutt", LocalDateTime.of(2020, 12, 16, 23, 0));
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "saidutt", LocalDateTime.of(2020, 12, 17, 0, 20));
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "saidutt", LocalDateTime.of(2020, 12, 18, 0, 15), applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "saidutt", LocalDateTime.of(2020, 12, 18, 0, 20), b);
	}
	
	
	
	
	@Test
	void testforreversecomparatorchildren() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"applications", "home"};
		assertArrayEquals(expected,arraystringfordirectory(root.getChildren((ApfsElement object1, ApfsElement object2) -> object1.getLastModified().compareTo(object2.getLastModified()))));
	}
	
	
	@Test
	void testforreversecomparatorfilesforcode() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"apfselement", "f"};
		LinkedList<ApfsElement> actual = new LinkedList<ApfsElement>();
		for(ApfsElement apfselement : root.findByName_Directory("code").getFiles((ApfsElement object1, ApfsElement object2) -> object1.getLastModified().compareTo(object2.getLastModified()))){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void testforreversecomparatordirectory() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"applications", "home"};
		LinkedList<ApfsElement> actual = new LinkedList<ApfsElement>();
		for(ApfsElement apfselement : root.getSubDirectories((ApfsElement object1, ApfsElement object2) -> object1.getLastModified().compareTo(object2.getLastModified()))){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void testforreversecomparatorfilesforhome() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"c", "d"};
		LinkedList<ApfsElement> actual = new LinkedList<ApfsElement>();
		for(ApfsElement apfselement : root.findByName_Directory("home").getFiles((ApfsElement object1, ApfsElement object2) -> object1.getLastModified().compareTo(object2.getLastModified()))){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
}
