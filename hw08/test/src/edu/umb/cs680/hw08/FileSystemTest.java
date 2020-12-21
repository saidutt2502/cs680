package src.edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.FileSystem;

class FileSystemTest {

	private String[] stringarrayforthedirectory(Directory dir){
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
		assertArrayEquals(expected, stringarrayforthedirectory(actual));
	}
	
	
	@Test
	void checkInstanceCreation() {
		FileSystem instance1 = FileSystem.getFileSystem();
		FileSystem instance2 = FileSystem.getFileSystem();
		assertSame(instance1, instance2);
	}
	

}
