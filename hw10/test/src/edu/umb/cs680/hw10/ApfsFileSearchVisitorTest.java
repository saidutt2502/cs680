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
import edu.umb.cs680.hw10.ApfsFileSearchVisitor;
import edu.umb.cs680.hw10.ApfsLink;

class AfpsFileSearchVisitorTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 12, 20, 0, 0);
private String[] arraystringfordirectory(ApfsFile f) {
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(f.getParent());
	String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), 
			Integer.toString(f.getSize()), f.getCreationTime().toString(), 
			optionalDirectory.isPresent()?f.getParent().getName():null, f.getOwnerName(),f.getLastModified().toString()};
	return fileInfo;
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
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "saidutt", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "saidutt", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "saidutt", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "saidutt", localTime, b);
	}
	
	
	
	@Test
	public void verifyFileA() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "a", "350", localTime.toString(), "applications", "saidutt", localTime.toString() };
		apfsvisior.setFileName("a");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	public void verifyFileB() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications", "saidutt", localTime.toString() };
		apfsvisior.setFileName("b");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	public void verifyFileC() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "c", "800", localTime.toString(), "home", "saidutt", localTime.toString() };
		apfsvisior.setFileName("c");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	
	

}
