package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsLink extends ApfsElement {

	LinkedList<ApfsElement> children = new LinkedList<>();
	ApfsElement target;
	
	public ApfsLink(ApfsElement parent, String name, int size, LocalDateTime creationTime, ApfsElement target,  String owner, LocalDateTime lastModification) {
		super(parent, name, size, creationTime,owner,lastModification);
		this.target = target;
	}

	@Override
	public Boolean isDirectory() {
		return true;
	}

	public ApfsElement getTargetLink() {
		return target;
	}
	
	public void setTargetLink(ApfsElement target) {
		this.target = target;
	}
	
	@Override
	public void accept(ApfsFSVisitor v) {
		v.visit(this);
	}
	
	public static void main(String[] args) {
		System.out.println("ApfsLink Works");
	}
}