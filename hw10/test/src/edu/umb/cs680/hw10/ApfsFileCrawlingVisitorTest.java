package src.edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.APFS;
import edu.umb.cs680.hw10.ApfsCountingVisitor;
import edu.umb.cs680.hw10.ApfsDirectory;
import edu.umb.cs680.hw10.ApfsFile;
import edu.umb.cs680.hw10.ApfsFileCrawlingVisitor;
import edu.umb.cs680.hw10.ApfsLink;

class AfspFileCrawlingVisitorTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
private String[] arraystringfordirectory(ArrayList<ApfsFile> files) {
	String[] filesInDir = new String[files.size()];
	int i = 0;
	for(ApfsFile f : files) {
		filesInDir[i] = f.getName();
		i++;
	}
	return filesInDir;
}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "saidutt", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "saidutt", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "saidutt", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 120, localTime, "saidutt", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 450, localTime, "saidutt", localTime);
		ApfsFile c = new ApfsFile(home, "c", 300, localTime, "saidutt", localTime);
		ApfsFile d = new ApfsFile(home, "d", 850, localTime, "saidutt", localTime);
		ApfsLink x = new ApfsLink(home, "x", 90, localTime, "saidutt", localTime, applications);
		ApfsFile e = new ApfsFile(code, "e", 750, localTime, "saidutt", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "saidutt", localTime);
		ApfsLink y = new ApfsLink(code, "y", 900, localTime, "saidutt", localTime, b);
	}
	
	
	@Test
	void checkFilesUnderHome() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory home = root.findDirectoryByName("home");
		home.accept(visitor);
		String[] expected = {"e","f","c","d"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	
	
	@Test
	void test_Files_Root() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		root.accept(visitor);
		String[] expected = {"a","b","e","f","c","d"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	void test_Files_Applcations() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory system = root.findDirectoryByName("applications");
		system.accept(visitor);
		String[] expected = {"a","b"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	@Test
	void test_Files_Code() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory pictures = root.findDirectoryByName("code");
		pictures.accept(visitor);
		String[] expected = {"e","f"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	
}

