package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {

	LinkedList<ApfsElement> children = new LinkedList<>();
	
	public ApfsDirectory(ApfsElement parent, String name, int size, LocalDateTime creationTime, String owner, LocalDateTime lastModification) {
		super(parent, name, size, creationTime,owner,lastModification);
	}

	@Override
	public Boolean isDirectory() {
		return true;
	}

	public LinkedList<ApfsElement> getChildren(){
		return children;
	}
	
	public void appendChild(ApfsElement child) {
		children.add(child);
	}

	public int countChildren() {
		LinkedList<FSElement> child = new LinkedList<>();
		int count = 0;
		child.addAll(children);
		for(FSElement e: child) {
			if(e.isDirectory())
				child.add(e);
			else
				count += 1;
			child.remove(e);
		}
		return count;
	}
	
	public int getTotalSize() {
		LinkedList<FSElement> child = new LinkedList<>();
		int count = 0;
		child.addAll(children);
		while(child.size() != 0) {
			FSElement e = child.get(0);
			if(e instanceof ApfsLink && ((ApfsLink) e).getTargetLink() instanceof ApfsDirectory) {
				child.add(((ApfsLink) e).getTargetLink());
			}
			else if(e instanceof ApfsDirectory && e.isDirectory())
				child.addAll(((ApfsDirectory) e).getChildren());
			else
				count += e.getSize();
			child.remove(0);
		}
		return count;
	}
	
	public LinkedList<ApfsElement> getSubDirectories(){
		LinkedList<ApfsElement> child = new LinkedList<>();
		for(ApfsElement e: children) {
				child.add(e);
		}
		return child;
	}
	
	public LinkedList<ApfsFile> getFiles(){
		LinkedList<ApfsFile> child = new LinkedList<>();
		for(FSElement e: children) {
			if(!e.isDirectory())
				child.add((ApfsFile) e);
		}
		return child;
	}
	
	@Override
	public void accept(ApfsFSVisitor v) {
		v.visit(this);
		for(ApfsElement e: children){
            e.accept(v); 
        }
	}
	
	public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> compare) {
		Collections.sort(children, compare);
		return children;
	}
	
	public LinkedList<ApfsElement> getSubDirectories(Comparator<ApfsElement> compare){
		return children;
	}
	
	public LinkedList<ApfsElement> getFiles(Comparator<ApfsElement> compare){
		return children;
	}
	public static void main(String[] args) {
		System.out.println("ApfsDirectory Works");
	}
	
}