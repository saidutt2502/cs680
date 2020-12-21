package src.edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.APFS;
import edu.umb.cs680.hw15.ApfsDirectory;
import edu.umb.cs680.hw15.ApfsFile;
import edu.umb.cs680.hw15.ApfsLink;

class ApfsDirectoryTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
private String[] arraystringfordirectory(ApfsDirectory directory) {
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(directory.getParent());
	String[] inforofdirectory = { Boolean.toString(directory.isDirectory()), directory.getName(), 
			Integer.toString(directory.getSize()), directory.getCreationTime().toString(), 
			optionalDirectory.isPresent()?directory.getParent().getName():null, 
					Integer.toString(directory.getTotalSize()),
					Integer.toString(directory.countChildren()), directory.getOwnerName(),directory.getLastModified().toString()};
	return inforofdirectory;
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
	void testforsizedir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(3500, root.findByName_Directory("root").getTotalSize());
		assertEquals(2450, root.findByName_Directory("home").getTotalSize());
		assertEquals(1050, root.findByName_Directory("applications").getTotalSize());
		assertEquals(1570, root.findByName_Directory("code").getTotalSize());
	}
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3500", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findByName_Directory("root");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}


	@Test
	void testforfileanddirectory() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("home", root.findByName_Directory("home").getName());
		assertSame("root", root.findByName_Directory("root").getName());
		assertSame("applications", root.findByName_Directory("applications").getName());
		assertSame("code", root.findByName_Directory("code").getName());
		assertSame("a", root.findFileByName("a").getName());	
		assertSame("c", root.findFileByName("c").getName());
		assertSame("d", root.findFileByName("d").getName());
		assertSame("e", root.findFileByName("e").getName());
		assertSame("f", root.findFileByName("f").getName());
		assertSame("b", root.findFileByName("b").getName());
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
	public void verifyDirectoryEqualityCode() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "1570", "2", "saidutt", localTime.toString() };
		ApfsDirectory actual = root.findByName_Directory("code");
		assertArrayEquals(expected,arraystringfordirectory(actual));
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
	void testforinfoonfiles() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("d", root.findByName_Directory("home").getFiles().get(1).getName());
		assertSame("a", root.findByName_Directory("applications").getFiles().get(0).getName());
		assertSame("b", root.findByName_Directory("applications").getFiles().get(1).getName());
		assertSame("c", root.findByName_Directory("home").getFiles().get(0).getName());
	}
	
	@Test
	void checkfetchedDirAndFile() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		assertSame("home", root.findByName_Directory("home").getName());
		assertSame("root", root.findByName_Directory("root").getName());
		assertSame("applications", root.findByName_Directory("applications").getName());
		assertSame("code", root.findByName_Directory("code").getName());
		assertSame("a", root.findFileByName("a").getName());
		assertSame("f", root.findFileByName("f").getName());
	}
	
	
	@Test
	void testsubdir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("applications", root.findByName_Directory("root").getSubDirectories().get(0).getName());
		assertSame("home", root.findByName_Directory("root").getSubDirectories().get(1).getName());
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

}
