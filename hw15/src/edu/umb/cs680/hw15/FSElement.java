package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

public abstract class FSElement {
	private String name;
	private int size;
	private LocalDateTime creationTime;
	private ApfsDirectory parent; 
	public int getSize() {
		return size;
	}
	public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
	public ApfsDirectory getParent() {
		return parent;
	}
	public String getName() {
		return name;
	}
	
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	
	
	public abstract boolean isDirectory();
	
	public static void main(String[] args) {
		System.out.println("FSElement Works");
	}
}
