package edu.umb.cs680.hw15;

public abstract class FileSystem {

	private String fileSystemName;
	private int capacity;
	private int id;
	private FSElement rootDir;
	
	public FSElement initFileSystem(String name, int capacity) {
		this.fileSystemName = name;
		this.capacity = capacity;
		FSElement root = createDefaultRoot();
		if(root.isDirectory() && capacity > root.getSize()){
			setRootDir(root);
			this.id = root.hashCode();
			return root;
		}else
			return null;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getId() {
		return id;
	}	
	
	private void setRootDir(FSElement rootDir) {
		this.rootDir = rootDir;
	}

	
	public String getFileSystemName() {
		return fileSystemName;
	}
	public FSElement getRootDir() {
		return this.rootDir;
	}
	protected abstract FSElement createDefaultRoot();

	public static void main(String[] args) {
		System.out.println("FileSystem Works");
	}
}
