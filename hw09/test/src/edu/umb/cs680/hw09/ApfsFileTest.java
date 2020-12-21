package src.edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.APFS;
import edu.umb.cs680.hw09.ApfsDirectory;
import edu.umb.cs680.hw09.ApfsFile;
import edu.umb.cs680.hw09.ApfsLink;

class ApfsFileTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
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
		ApfsLink x = new ApfsLink(home, "x", 90, localTime, "saidutt", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 140, localTime, "saidutt", localTime, b);
	}
	
	
	@Test
	public void verifyFileEqualityfile() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "e", "700", localTime.toString(), "code", "saidutt", localTime.toString() };
		ApfsFile actual = root.findFileByName("e");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	@Test
	void testfordir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertTrue(root.findDirectoryByName("root").isDirectory());
		assertTrue(root.findDirectoryByName("home").isDirectory());
		assertTrue(root.findDirectoryByName("applications").isDirectory());
		assertTrue(root.findDirectoryByName("code").isDirectory());
		assertFalse(root.findFileByName("a").isDirectory());
		assertFalse(root.findFileByName("b").isDirectory());
		assertFalse(root.findFileByName("c").isDirectory());
		assertFalse(root.findFileByName("d").isDirectory());
		assertFalse(root.findFileByName("e").isDirectory());
		assertFalse(root.findFileByName("f").isDirectory());
	}
	
	@Test
	public void verifyFileEqualityforA() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "a", "350", localTime.toString(), "applications", "saidutt", localTime.toString() };
		ApfsFile actual = root.findFileByName("a");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	
	@Test
	public void verifyFileEqualityforB() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications", "saidutt", localTime.toString() };
		ApfsFile actual = root.findFileByName("b");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	
	@Test
	public void verifyFileEqualityforC() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "c", "800", localTime.toString(), "home", "saidutt", localTime.toString() };
		ApfsFile actual = root.findFileByName("c");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	@Test
	public void verifyFileEqualityforD() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "d", "80", localTime.toString(), "home", "saidutt", localTime.toString() };
		ApfsFile actual = root.findFileByName("d");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	
	
	@Test
	public void verifyFileEqualityforE() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "e", "700", localTime.toString(), "code", "saidutt", localTime.toString() };
		ApfsFile actual = root.findFileByName("e");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	@Test
	public void verifyFileEqualityforF() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "f", "870", localTime.toString(), "code", "saidutt", localTime.toString() };
		ApfsFile actual = root.findFileByName("f");
		assertArrayEquals(expected,arraystringforfile(actual));
	}

}