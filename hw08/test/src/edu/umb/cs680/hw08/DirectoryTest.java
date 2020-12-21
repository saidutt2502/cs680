package src.edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.File;
import edu.umb.cs680.hw08.FileSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DirectoryTest {
	
	static LocalDateTime localTime = LocalDateTime.now();
	
	@BeforeAll
	public static void fileStructureSetup() {
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
	
	private String[] directoryToString(Directory d) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] directorystring = { Boolean.toString(d.isDirectory()), d.getName(), 
				Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				optionalDirectory.isPresent()?d.getParent().getName():null, 
						Integer.toString(d.getTotalSize()),
						Integer.toString(d.countChildren())};
		return directorystring;
	}


	
	@Test
	void checkDirectoryFileValues() {
		FileSystem f = FileSystem.getFileSystem();
		assertSame("home", f.getRootDirs().get(0).findDirectoryByName("home").getName());
		assertSame("root", f.getRootDirs().get(0).findDirectoryByName("root").getName());
		assertSame("applications", f.getRootDirs().get(0).findDirectoryByName("applications").getName());
		assertSame("code", f.getRootDirs().get(0).findDirectoryByName("code").getName());
		assertSame("f1", f.getRootDirs().get(0).findFileByName("f1").getName());
		assertSame("f5", f.getRootDirs().get(0).findFileByName("f5").getName());
	} 
	
	
	@Test
	public void checkDirectoryEqualityCode() { 
		FileSystem f = FileSystem.getFileSystem();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "200", "2" };
		Directory actual = f.getRootDirs().get(0).findDirectoryByName("code");
		assertArrayEquals(expected,directoryToString(actual));
	}
	
	@Test
	public void checkDirectoryEqualityApplications() { 
		FileSystem f = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1650", "2" };
		Directory actual = f.getRootDirs().get(0).findDirectoryByName("applications");
		assertArrayEquals(expected,directoryToString(actual));
	}
	
	@Test
	public void checkDirectoryEqualityHome() { 
		FileSystem f = FileSystem.getFileSystem();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "1400", "3" };
		Directory actual = f.getRootDirs().get(0).findDirectoryByName("home");
		assertArrayEquals(expected,directoryToString(actual));

	}
	
}