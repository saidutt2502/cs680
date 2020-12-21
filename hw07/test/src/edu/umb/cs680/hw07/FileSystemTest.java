package src.edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.FileSystem;

class FileSystemTest {
	private String[] directoryStringArray(Directory dir){
		String[] stringelement = {null, dir.getName(), Integer.toString(dir.getSize()), dir.getCreationTime().toString()};
		return stringelement; 
	}
	
	@Test
	void checkRootDirectory() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Directory root = new Directory(null, "root", 0, localDateTime);
		String[] expected = {null, "root", "0", localDateTime.toString()}; 
		FileSystem.getFileSystem().addRootDir(root);
		Directory actual = FileSystem.getFileSystem().getRootDirs().get(0);
		assertArrayEquals(expected, directoryStringArray(actual));
	}

	@Test
	void checkFileSystemEquality() {
		FileSystem f1 = FileSystem.getFileSystem();
		FileSystem f2 = FileSystem.getFileSystem();
		assertSame(f1, f2);
	}

}