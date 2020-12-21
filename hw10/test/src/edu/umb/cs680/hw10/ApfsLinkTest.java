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
import edu.umb.cs680.hw10.FSElement;

class ApfsLinkTest {
	
	static LocalDateTime localTime = LocalDateTime.of(2020, 12, 20, 0, 0);
	private String[] stringelementforfs(FSElement Elementforfs) {
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(Elementforfs.getParent());
		String[] informationoffs = { Boolean.toString(Elementforfs.isDirectory()), Elementforfs.getName(), 
				Integer.toString(Elementforfs.getSize()), Elementforfs.getCreationTime().toString(), 
				optionalDirectory.isPresent()?Elementforfs.getParent().getName():null};
		return informationoffs;
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
		ApfsLink x = new ApfsLink(home, "x", 456, localTime, "saidutt", localTime, applications);
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "saidutt", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "saidutt", localTime);
		ApfsLink y = new ApfsLink(code, "y", 234, localTime, "saidutt", localTime, b);
	}
	
	@Test
	public void testHome() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "home", "0", localTime.toString(), "root" };
		ApfsDirectory actual = root.findByName_Directory("home");
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	
	@Test
	public void verifyTargetA() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "a", "350", localTime.toString(), "applications" };
		// this needs to return true for applications as b is a  part of applications but still returning false.
		ApfsFile actual = root.findByName_File("a");
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	@Test
	public void verifyTargetB() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications" };
		// this needs to return true for applications as b is a  part of applications but still returning false.
		ApfsFile actual = root.findByName_File("b");
		assertArrayEquals(expected,stringelementforfs(actual));
	}

}

