package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement{

	
	
	public ApfsElement getTarget() {
		return target;
	}
	@Override
	public boolean isDirectory() {
		return false;
	}
	public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModified, ApfsElement target) {
		super(parent, name, size, creationTime, ownerName, lastModified);
		this.target = target;
		parent.appendChild(this);
	}
	private ApfsElement target;
	

	public static void main(String[] args) {
		System.out.println("Apfslink Works");
	}
}
