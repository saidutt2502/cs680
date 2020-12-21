package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

public class APFS extends FileSystem{

	private static APFS instance = null;
	
	private APFS() {};
	@Override
	protected FSElement createDefaultRoot() {
		LocalDateTime localTime = LocalDateTime.of(2020, 12, 12, 0, 0);
		ApfsDirectory root = new ApfsDirectory(null, "root", 0, localTime, "saidutt", localTime);
		return root;
	}
	public static APFS getAPFSFileSystem() {
		if(instance==null)
			instance = new APFS ();
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println("APFS Works");
	}
}
