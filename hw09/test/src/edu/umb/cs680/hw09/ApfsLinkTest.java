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
import edu.umb.cs680.hw09.FSElement;

class ApfsLinkTest {
	
	static LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
	private String[] stringelementforfs(FSElement Elementforfs) {
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(Elementforfs.getParent());
		String[] informationoffs = { Boolean.toString(Elementforfs.isDirectory()), Elementforfs.getName(), 
				Integer.toString(Elementforfs.getSize()), Elementforfs.getCreationTime().toString(), 
				optionalDirectory.isPresent()?Elementforfs.getParent().getName():null};
		return informationoffs;
	}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setUpFilesAndDirectoryInstances() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "saidutt", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "saidutt", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "saidutt", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 760, localTime, "saidutt", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 540, localTime, "saidutt", localTime);
		ApfsFile c = new ApfsFile(home, "c", 900, localTime, "saidutt", localTime);
		ApfsFile d = new ApfsFile(home, "d", 450, localTime, "saidutt", localTime);
		ApfsFile e = new ApfsFile(code, "e", 280, localTime, "saidutt", localTime);
		ApfsFile f = new ApfsFile(code, "f", 120, localTime, "saidutt", localTime);
		ApfsLink x = new ApfsLink(home, "x", 100, localTime, "saidutt", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 900, localTime, "saidutt", localTime, b);
	}
	
	@Test
	public void verifyTargetEqualityfileb() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications" };
		//tried for a worked in hw9
		ApfsFile actual = (ApfsFile) root.findLinkByName("y").getTarget();
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	
	@Test
	public void testforDirectoryhome() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root" };
		ApfsDirectory actual = (ApfsDirectory) root.findLinkByName("x").getTarget();
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	
	
	@Test
	public void verifyTargetForBEquality() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications" };
		// this needs to return true for applications as b is a  part of applications but still returning false.
		ApfsFile actual = (ApfsFile) root.findLinkByName("y").getTarget();
		assertArrayEquals(expected,stringelementforfs(actual));
	}

}