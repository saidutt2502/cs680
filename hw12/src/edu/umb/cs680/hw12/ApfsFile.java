package edu.umb.cs680.hw12;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

	public ApfsFile(ApfsElement parent, String name, int size, LocalDateTime creationTime, String owner, LocalDateTime lastModification) {
		super(parent, name, size, creationTime,owner,lastModification);
	}

	@Override
	public Boolean isDirectory() {
		return false;
	}
	
	@Override
	public void accept(ApfsFSVisitor v) {
		v.visit(this);
	}

	public static void main(String[] args) {
		System.out.println("ApfsFile Works");
	}
}
