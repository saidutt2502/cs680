package edu.umb.cs680.hw12;

import java.time.LocalDateTime;

public abstract class FSElement {
	private ApfsElement parent;
	private String name;
	private int size;
	private LocalDateTime creationTime;
	
	FSElement(ApfsElement parent,String name,int  size,LocalDateTime creationTime){
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
			 
	
	public ApfsElement getParent() {
		return parent;
	}



	public void setParent(ApfsElement parent) {
		this.parent = parent;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	public LocalDateTime getCreationTime() {
		return creationTime;
	}



	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}



	public abstract Boolean isDirectory();
	  
	public static void main(String[] args) {
		System.out.println("FSElement Works");
	}
}
