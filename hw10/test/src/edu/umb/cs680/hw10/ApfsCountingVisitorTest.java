package src.edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.APFS;
import edu.umb.cs680.hw10.ApfsCountingVisitor;
import edu.umb.cs680.hw10.ApfsDirectory;
import edu.umb.cs680.hw10.ApfsFile;
import edu.umb.cs680.hw10.ApfsLink;

class AfpsCountingVisitorTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "saidutt", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "saidutt", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "saidutt", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 200, localTime, "saidutt", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 400, localTime, "saidutt", localTime);
		ApfsFile c = new ApfsFile(home, "c", 650, localTime, "saidutt", localTime);
		ApfsFile d = new ApfsFile(home, "d", 980, localTime, "saidutt", localTime);
		ApfsFile e = new ApfsFile(code, "e", 400, localTime, "saidutt", localTime);
		ApfsFile f = new ApfsFile(code, "f", 8000, localTime, "saidutt", localTime);
		ApfsLink x = new ApfsLink(home, "x", 123, localTime, "saidutt", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 142, localTime, "saidutt", localTime, b);
	}
	//count the visitors
	@Test
	void TestCountingVisitorvalue() {
		ApfsCountingVisitor count_visitor = new ApfsCountingVisitor();
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		root.accept(count_visitor);
		
		assertEquals(count_visitor.getDirNum(), 4);
		assertEquals(count_visitor.getFileNum(), 6);
		assertEquals(count_visitor.getLinkNum(), 2);
	}
	//testing code to check, need to remove later
	@Test
	void TestCountingVisitorvaluetry() {
		ApfsCountingVisitor count_visitor = new ApfsCountingVisitor();
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		root.accept(count_visitor);
		
		assertEquals(count_visitor.getDirNum(), 4);
		assertEquals(count_visitor.getFileNum(), 6);
		assertEquals(count_visitor.getLinkNum(), 2);
	}

}
