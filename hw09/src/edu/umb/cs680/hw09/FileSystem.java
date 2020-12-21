package edu.umb.cs680.hw09;

public abstract class FileSystem {
	private int capacity;
	private String fileSystemName;
	private FSElement rootDir;
	private int id;
	
	
	

	public int getCapacity() {
		return capacity;
	}
	
	
	private void setRootDir(FSElement rootDir) {
		this.rootDir = rootDir;
	}
	public int getId() {
		return id;
	}
	
	
	public String getFileSystemName() {
		return fileSystemName;
	}
	public FSElement initFileSystem(String Fselementname, int size) {
		this.fileSystemName = Fselementname;
		this.capacity = size;
		FSElement root = createDefaultRoot();
		if(root.isDirectory() && size > root.getSize()){
			setRootDir(root);
			this.id = root.hashCode();
			return root;
		}else
			return null;
	}
	public FSElement getRootDir() {
		return this.rootDir;
	}
	
	

	
	
	protected abstract FSElement createDefaultRoot();

	public static void main(String[] args) {
		System.out.println("FileSystem Works!");
	}
}