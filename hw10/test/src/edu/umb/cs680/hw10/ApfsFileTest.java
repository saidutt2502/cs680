package src.edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.APFS;
import edu.umb.cs680.hw10.ApfsCountingVisitor;
import edu.umb.cs680.hw10.ApfsDirectory;
import edu.umb.cs680.hw10.ApfsFile;
import edu.umb.cs680.hw10.ApfsLink;


class ApfsFileTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
private String[] arraystringforfile(ApfsFile Elementforfs) {
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(Elementforfs.getParent());
	String[] informationoffile = { Boolean.toString(Elementforfs.isDirectory()), Elementforfs.getName(), 
			Integer.toString(Elementforfs.getSize()), Elementforfs.getCreationTime().toString(), 
			optionalDirectory.isPresent()?Elementforfs.getParent().getName():null, Elementforfs.getOwnerName(),Elementforfs.getLastModified().toString()};
	return informationoffile;
}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void initialize() {
		
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
		ApfsLink x = new ApfsLink(home, "x", 450, localTime, "saidutt", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 780, localTime, "saidutt", localTime, b);
	}
	
	

	@Test
	void testfordirectory() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertTrue(root.findByName_Directory("root").isDirectory());
		assertTrue(root.findByName_Directory("home").isDirectory());
		assertTrue(root.findByName_Directory("applications").isDirectory());
		assertTrue(root.findByName_Directory("code").isDirectory());
		assertFalse(root.findByName_File("a").isDirectory());
		assertFalse(root.findByName_File("b").isDirectory());
		assertFalse(root.findByName_File("c").isDirectory());
		assertFalse(root.findByName_File("d").isDirectory());
		assertFalse(root.findByName_File("e").isDirectory());
		assertFalse(root.findByName_File("f").isDirectory());
	}
	
	@Test
	public void verifyFileA() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "a", "350", localTime.toString(), "applications", "saidutt", localTime.toString() };
		ApfsFile actual = root.findByName_File("a");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	
	@Test
	public void verifyFileB() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications", "saidutt", localTime.toString() };
		ApfsFile actual = root.findByName_File("b");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	
	@Test
	public void verifyFileC() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "c", "800", localTime.toString(), "home", "saidutt", localTime.toString() };
		ApfsFile actual = root.findByName_File("c");
		assertArrayEquals(expected,arraystringforfile(actual));
	}


}
