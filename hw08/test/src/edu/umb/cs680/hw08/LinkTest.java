package src.edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.FSElement;
import edu.umb.cs680.hw08.File;
import edu.umb.cs680.hw08.FileSystem;
import edu.umb.cs680.hw08.Link;

class LinkTest {
	
	static LocalDateTime localTime = LocalDateTime.now();
	private String[] fsElementToStringArray(FSElement f) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
		String[] fsElementInfo = { Boolean.toString(f.isDirectory()), f.getName(), 
				Integer.toString(f.getSize()), f.getCreationTime().toString(), 
				optionalDirectory.isPresent()?f.getParent().getName():null};
		return fsElementInfo;
	}
	@SuppressWarnings("unused")
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
		Link f5 = new Link(home, "f5", 0, localTime, applications);
		File f6 = new File(code, "f6", 70, localTime);
		File f7 = new File(code, "f7", 130, localTime);	
		Link f8 = new Link(code, "f8", 0, localTime, f2);
		
		FileSystem.getFileSystem().addRootDir(root);
	}
	
	@Test
	public void verifyTargetEqualityHome() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root" };
		Directory actual = (Directory) fileSystem.getRootDirs().get(0).findLinkByName("f5").getTarget();
		assertArrayEquals(expected,fsElementToStringArray(actual));
	}
	@Test
	public void verifyTargetEquality() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "f2", "350", localTime.toString(), "applications" };
		File actual = (File) fileSystem.getRootDirs().get(0).findLinkByName("f8").getTarget();
		assertArrayEquals(expected,fsElementToStringArray(actual));
	}

}
