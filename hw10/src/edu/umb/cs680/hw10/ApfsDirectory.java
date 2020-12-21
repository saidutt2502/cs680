package edu.umb.cs680.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement{
	
	private LinkedList<ApfsElement> child;
	
	

	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModified) {
		super(parent, name, size, creationTime, ownerName, lastModified);
		if(parent != null)
			parent.appendChild(this);
	}
	public LinkedList<ApfsFile> getFiles() {
		LinkedList<ApfsFile> listfile = new LinkedList<ApfsFile>();
		for(FSElement s : getChildren()) {
			if(s instanceof ApfsFile)
				listfile.add((ApfsFile) s);
		}
		return listfile;
	}
	@Override
	public boolean isDirectory() {
		return true;
	}
	public LinkedList<ApfsElement> getChildren() {
		if(this.child == null) {
			this.child = new LinkedList<ApfsElement>();
		}
		return child;
	}
	public LinkedList<ApfsLink> getLinks() {
		LinkedList<ApfsLink> listoflink = new LinkedList<ApfsLink>();
		for(FSElement s : getChildren()) {
			if(s instanceof ApfsLink)
				listoflink.add((ApfsLink) s);
		}
		return listoflink;
	}
	
	public int getTotalSize() {
		int sizetotvalue = 0;
		for(ApfsElement s : getChildren()) {
			if(s instanceof ApfsDirectory)
				sizetotvalue += ((ApfsDirectory) s).getTotalSize();
			else
				sizetotvalue += s.getSize();
		}
		return sizetotvalue;
	}
	public void appendChild(ApfsElement child) {
		if(this.child == null) {
			this.child = new LinkedList<ApfsElement>();
		}
		this.child.add(child);
	}
	
	public int countChildren() {
		return getChildren().size() - getLinks().size();
	}
	
	public LinkedList<ApfsDirectory> getSubDirectories() {
		LinkedList<ApfsDirectory> listdir = new LinkedList<ApfsDirectory>();
		for(FSElement s : getChildren()) {
			if(s instanceof ApfsDirectory)
				listdir.add((ApfsDirectory) s);
		}
		return listdir;	
	}
	@Override
	public void accept(ApfsFSVisitor visitor) {
		visitor.visit(this);
		for(ApfsElement e : getChildren()) {
			e.accept(visitor);
		}
	}
	
	
	
	public ApfsLink findByName_Link(String nameoflink) {
		ApfsLink link = null;
		for(ApfsLink l : getLinks()) {
			if(nameoflink.equals(l.getName()))
				link = l;
		}
		if(link == null) {
			for(ApfsDirectory dir : getSubDirectories()) {
				link = dir.findByName_Link(nameoflink);
				if(link != null)
					break;
			}
		}
		return link;
	}
	public ApfsDirectory findByName_Directory(String nameofdir) {
		ApfsDirectory nameddirectory = null;
		if(nameofdir.equals(getName()))
			nameddirectory = this;
		else {
			for(ApfsDirectory dir : getSubDirectories()) {
				if(nameddirectory == null) {
					nameddirectory = dir.findByName_Directory(nameofdir);
					if(nameofdir.equals(dir.getName())) {
						nameddirectory = dir;
						break;
					}
				}
			}
		}
		return nameddirectory;
	}
	
	public ApfsFile findByName_File(String namedfile) {
		ApfsFile fileinstance = null;
		for(ApfsFile f : getFiles()) {
			if(namedfile.equals(f.getName()))
				fileinstance = f;
		}
		if(fileinstance == null) {
			for(ApfsDirectory dir : getSubDirectories()) {
				fileinstance = dir.findByName_File(namedfile);
				if(fileinstance != null)
					break;
			}
		}
		return fileinstance;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("ApfsDirectory Works!");
	}
}