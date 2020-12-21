package edu.umb.cs680.hw09;

import java.time.LocalDateTime;
import edu.umb.cs680.hw09.FileSystem;

public class APFS extends FileSystem {
	
	public static APFS getAPFSFileSystem() {
		if(classinst==null)
			classinst = new APFS ();
		return classinst;
	}
	
	
	private static APFS classinst = null;
	
	
	@Override
	protected FSElement createDefaultRoot() {
		LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
		ApfsDirectory root = new ApfsDirectory(null, "root", 0, localTime, "saidutt", localTime);
		return root;
	}
	private APFS() {};
	
	
	public static void main(String[] args) {
		System.out.println("APFS Works!");
	}
}