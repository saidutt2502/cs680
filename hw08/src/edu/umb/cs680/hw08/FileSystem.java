package edu.umb.cs680.hw08;

import java.util.LinkedList;

public class FileSystem {
	private LinkedList<Directory> directoryRoot;
	private static FileSystem instance = null;
	
	private FileSystem() {};
	
	
	public static FileSystem getFileSystem() {
		if(instance==null)
			instance = new FileSystem ();
		return instance;
	}
	
	
	public void addRootDir(Directory rootDirectory) {
		directoryRoot = new LinkedList<Directory>();
		directoryRoot.add(rootDirectory);
	}
	
	
	public LinkedList<Directory> getRootDirs() {
		return this.directoryRoot;
	}
	
	
	public static void main(String[] args) {
		System.out.println("FileSystem Works!");
	}
}
