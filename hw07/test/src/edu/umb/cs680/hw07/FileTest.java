package src.edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.FileSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileTest {
	private String[] stringArray(File f) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), 
				Integer.toString(f.getSize()), f.getCreationTime().toString(), 
				optionalDirectory.isPresent()?f.getParent().getName():null};
		return fileInfo;
	}
	static LocalDateTime localTime = LocalDateTime.now();
	
	@BeforeAll
	public static void createDirectoryAndFile() {
		Directory root = new Directory(null, "root", 0, localTime);
		Directory applications = new Directory(root, "applications", 0, localTime);
		Directory home = new Directory(root, "home", 0, localTime);
		Directory code = new Directory(home, "code", 0, localTime);
		File f1 = new File(applications, "f1", 1300, localTime);
		File f2 = new File(applications, "f2", 350, localTime);
		File f3 = new File(home, "f3", 500, localTime);
		File f4 = new File(home, "f4", 700, localTime);
		File f5 = new File(code, "f5", 70, localTime);
		File f6 = new File(code, "f6", 130, localTime);
		FileSystem.getFileSystem().addRootDir(root);
	}
	
	@Test
	void checkDirectoryRoot() {
		FileSystem f = FileSystem.getFileSystem();
		assertTrue(f.getRootDirs().get(0).findDirectoryByName("root").isDirectory());
	}

	
	@Test
	public void checkFileEqualityA() {
		FileSystem f = FileSystem.getFileSystem();
		String[] expected = { "false", "f1", "1300", localTime.toString(), "applications" };
		File actual = f.getRootDirs().get(0).findFileByName("f1");
		assertArrayEquals(expected,stringArray(actual));
	}
	
	@Test
	public void checkFileEqualityB() {
		FileSystem f = FileSystem.getFileSystem();
		String[] expected = { "false", "f2", "350", localTime.toString(), "applications" };
		File actual = f.getRootDirs().get(0).findFileByName("f2");
		assertArrayEquals(expected,stringArray(actual));
	}
	
	@Test
	public void checkFileEqualityC() {
		FileSystem f = FileSystem.getFileSystem();
		String[] expected = { "false", "f3", "500", localTime.toString(), "home" };
		File actual = f.getRootDirs().get(0).findFileByName("f3");
		assertArrayEquals(expected,stringArray(actual));
	}
}