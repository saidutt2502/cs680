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

class ApfsDirectoryTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
private String[] arraystringfordirectory(ApfsDirectory Elementforfs) {
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(Elementforfs.getParent());
	String[] informationoffile = { Boolean.toString(Elementforfs.isDirectory()), Elementforfs.getName(), 
			Integer.toString(Elementforfs.getSize()), Elementforfs.getCreationTime().toString(), 
			optionalDirectory.isPresent()?Elementforfs.getParent().getName():null, 
					Integer.toString(Elementforfs.getTotalSize()),
					Integer.toString(Elementforfs.countChildren()), Elementforfs.getOwnerName(),Elementforfs.getLastModified().toString()};
	return informationoffile;
}

	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "saidutt", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "saidutt", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "saidutt", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 850, localTime, "saidutt", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 200, localTime, "saidutt", localTime);
		ApfsFile c = new ApfsFile(home, "c", 300, localTime, "saidutt", localTime);
		ApfsFile d = new ApfsFile(home, "d", 50, localTime, "saidutt", localTime);
		ApfsFile e = new ApfsFile(code, "e", 90, localTime, "saidutt", localTime);
		ApfsFile f = new ApfsFile(code, "f", 430, localTime, "saidutt", localTime);
		ApfsLink x = new ApfsLink(home, "x", 200, localTime, "saidutt", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 300, localTime, "saidutt", localTime, b);
	}
	
	@Test
	void testforinfoonfiles() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("d", root.findDirectoryByName("home").getFiles().get(1).getName());
		assertSame("a", root.findDirectoryByName("applications").getFiles().get(0).getName());
		assertSame("b", root.findDirectoryByName("applications").getFiles().get(1).getName());
		assertSame("c", root.findDirectoryByName("home").getFiles().get(0).getName());
	}
	
	@Test
	void testforsizecode() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(1570, root.findDirectoryByName("code").getTotalSize());
	}
	
	
	
	@Test
	void testforsizedir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(3500, root.findDirectoryByName("root").getTotalSize());
		assertEquals(2450, root.findDirectoryByName("home").getTotalSize());
		assertEquals(1050, root.findDirectoryByName("applications").getTotalSize());
		assertEquals(1570, root.findDirectoryByName("code").getTotalSize());
	}
	
	@Test
	public void verifyDirectoryEqualityApplications() { 
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1050", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findDirectoryByName("applications");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	void testsubdir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("applications", root.findDirectoryByName("root").getSubDirectories().get(0).getName());
		assertSame("home", root.findDirectoryByName("root").getSubDirectories().get(1).getName());
	}
	
	
	@Test
	public void verifyDirectoryEqualityHome() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "2450", "3", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findDirectoryByName("home");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3500", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findDirectoryByName("root");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityCodefile() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "1570", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findDirectoryByName("code");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
}