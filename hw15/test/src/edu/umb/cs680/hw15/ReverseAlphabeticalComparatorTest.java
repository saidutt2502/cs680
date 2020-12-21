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

class ReverseAlphabeticalComparatorTest {

	static LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
	private String[] arraystringfordirectory(LinkedList<ApfsElement> fsElements) {
		String[] Listfilename = new String[fsElements.size()];
		int i = 0;
		for(ApfsElement Apfselement : fsElements) {
			Listfilename[i] = Apfselement.getName();
			i++;
		}
		return Listfilename;
	}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "saidutt", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "saidutt", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "saidutt", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "saidutt", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 700, localTime, "saidutt", localTime);
		ApfsFile c = new ApfsFile(home, "c", 800, localTime, "saidutt", localTime);
		ApfsFile d = new ApfsFile(home, "d", 80, localTime, "saidutt", localTime);
		ApfsFile Apfselement = new ApfsFile(code, "Apfselement", 700, localTime, "saidutt", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "saidutt", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "saidutt", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "saidutt", localTime, b);
	}
	
	
	@Test
	void testcomparatorreverseforfiles() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"b", "a"};
		LinkedList<ApfsElement> actual = new LinkedList<ApfsElement>();
		for(ApfsElement Apfselement : root.findByName_Directory("applications").getFiles((ApfsElement object1, ApfsElement object2) -> object2.getName().compareTo(object1.getName()))){
			actual.add(Apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	void testcomparatorreverseforchild() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"home", "applications"};
		assertArrayEquals(expected,arraystringfordirectory(root.getChildren((ApfsElement object1, ApfsElement object2) -> object2.getName().compareTo(object1.getName()))));
	}

	@Test
	void testcomparatorreversefordirectory() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"home", "applications"};
		LinkedList<ApfsElement> actual = new LinkedList<ApfsElement>();
		for(ApfsElement Apfselement : root.getSubDirectories((ApfsElement object1, ApfsElement object2) -> object2.getName().compareTo(object1.getName()))){
			actual.add(Apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
}
