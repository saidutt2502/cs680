package edu.umb.cs680.hw12;

import java.util.LinkedList;

public abstract class FileSystem {

	private FSElement root;
	private String name;
	private int capacity; 
	private int id;

	
	public FSElement initFileSystem(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		FSElement root = createDefaultRoot();
		if(root.isDirectory() && capacity > root.getSize()) {
			setRoot(root);
			this.id = root.hashCode();
			return root;
		}else {
			return null;
		}
	}
	
	protected abstract  FSElement createDefaultRoot();
	
	public int getCapacity() {
		return capacity;
	}
	public int getUsed() {
		return root.getSize();
	}

	public void setRoot(FSElement root) {
		this.root = root;
	}
			
	public FSElement getRoot() {
		return root;
	}
	public static void main(String[] args) {
		System.out.println("FileSystem Works");
	}
}
