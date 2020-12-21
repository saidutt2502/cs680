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

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
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
		assertSame("home", root.findByName_Directory("home").getName());
		assertSame("root", root.findByName_Directory("root").getName());
		assertSame("applications", root.findByName_Directory("applications").getName());
		assertSame("code", root.findByName_Directory("code").getName());
		assertSame("a", root.findByName_File("a").getName());	
		assertSame("c", root.findByName_File("c").getName());
		assertSame("d", root.findByName_File("d").getName());
		assertSame("e", root.findByName_File("e").getName());
		assertSame("f", root.findByName_File("f").getName());
		assertSame("b", root.findByName_File("b").getName());
	}
	@Test
	void testdir() {
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
	public void verifyDirectoryEqualityApplications() { 
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1050", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findByName_Directory("applications");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	void testforsizecode() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(1570, root.findByName_Directory("code").getTotalSize());
	}
	
	@Test
	public void verifyDirectoryEqualityCode() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "1570", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findByName_Directory("code");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityCodefile() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "1570", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findByName_Directory("code");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityHome() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "2450", "3", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findByName_Directory("home");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	

	@Test
	void testforinfoonfiles() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("d", root.findByName_Directory("home").getFiles().get(1).getName());
		assertSame("a", root.findByName_Directory("applications").getFiles().get(0).getName());
		assertSame("b", root.findByName_Directory("applications").getFiles().get(1).getName());
		assertSame("c", root.findByName_Directory("home").getFiles().get(0).getName());
	}

	@Test
	void testsubfilesindir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(2, root.findByName_Directory("root").countChildren());
		assertEquals(2, root.findByName_Directory("applications").countChildren());
		assertEquals(3, root.findByName_Directory("home").countChildren());
		assertEquals(2, root.findByName_Directory("code").countChildren());
	}
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3500", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findByName_Directory("root");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}

	
	
	
	

}
