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

class ElementBasedComparatorTest {
	
	static LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
	
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
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "saidutt", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "saidutt", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "saidutt", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "saidutt", localTime, b);
	}
	
	private String[] elementToStringArray(LinkedList<ApfsElement> fsElements) {
		String[] nameoflistfile = new String[fsElements.size()];
		int i = 0;
		for(ApfsElement apfselement : fsElements) {
			nameoflistfile[i] = apfselement.getName();
			i++;
		}
		return nameoflistfile;
	}

	@Test
	void checkElementComparatorSystem() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = {"code", "c", "d","x"};
		assertArrayEquals(expected,elementToStringArray(root.findByName_Directory("home").getChildren((ApfsElement object1, ApfsElement object2) -> object1.getOwnerName().compareTo(object2.getOwnerName()))));
	}
	
	@Test
	void checkElementComparatorPictures() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = {"e", "f", "y"};
		assertArrayEquals(expected,elementToStringArray(root.findByName_Directory("code").getChildren((ApfsElement object1, ApfsElement object2) -> object1.getOwnerName().compareTo(object2.getOwnerName()))));
	}
}
