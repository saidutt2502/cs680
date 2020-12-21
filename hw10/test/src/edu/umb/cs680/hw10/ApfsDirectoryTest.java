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
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "saidutt", localTime, applications);
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "saidutt", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "saidutt", localTime);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "saidutt", localTime, b);
	}
	
	
	@Test
	void testforfileanddirectory() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("home", root.findDirectoryByName("home").getName());
		assertSame("root", root.findDirectoryByName("root").getName());
		assertSame("applications", root.findDirectoryByName("applications").getName());
		assertSame("code", root.findDirectoryByName("code").getName());
		assertSame("a", root.findFileByName("a").getName());	
		assertSame("c", root.findFileByName("c").getName());
		assertSame("d", root.findFileByName("d").getName());
		assertSame("e", root.findFileByName("e").getName());
		assertSame("f", root.findFileByName("f").getName());
		assertSame("b", root.findFileByName("b").getName());
	}
	@Test
	void testdir() {
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
	public void verifyDirectoryEqualityApplications() { 
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1050", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findDirectoryByName("applications");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	void testforsizecode() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(1570, root.findDirectoryByName("code").getTotalSize());
	}
	
	@Test
	public void verifyDirectoryEqualityCode() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "1570", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findDirectoryByName("code");
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
	
	@Test
	public void verifyDirectoryEqualityHome() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "2450", "3", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findDirectoryByName("home");
		assertArrayEquals(expected,arraystringfordirectory(actual));
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
	void testsubfilesindir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(2, root.findDirectoryByName("root").countChildren());
		assertEquals(2, root.findDirectoryByName("applications").countChildren());
		assertEquals(3, root.findDirectoryByName("home").countChildren());
		assertEquals(2, root.findDirectoryByName("code").countChildren());
	}
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3500", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findDirectoryByName("root");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}

	
	
	
	

}
