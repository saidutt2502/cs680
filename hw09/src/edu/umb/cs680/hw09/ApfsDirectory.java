package edu.umb.cs680.hw09;

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

	
	
	
	public ApfsLink findLinkByName(String linkName) {
		ApfsLink link = null;
		for(ApfsLink l : getLinks()) {
			if(linkName.equals(l.getName()))
				link = l;
		}
		if(link == null) {
			for(ApfsDirectory dir : getSubDirectories()) {
				link = dir.findLinkByName(linkName);
				if(link != null)
					break;
			}
		}
		return link;
	}
	public ApfsDirectory findDirectoryByName(String directoryName) {
		ApfsDirectory directory = null;
		if(directoryName.equals(getName()))
			directory = this;
		else {
			for(ApfsDirectory dir : getSubDirectories()) {
				if(directory == null) {
					directory = dir.findDirectoryByName(directoryName);
					if(directoryName.equals(dir.getName())) {
						directory = dir;
						break;
					}
				}
			}
		}
		return directory;
	}
	
	public ApfsFile findFileByName(String fileName) {
		ApfsFile file = null;
		for(ApfsFile f : getFiles()) {
			if(fileName.equals(f.getName()))
				file = f;
		}
		if(file == null) {
			for(ApfsDirectory dir : getSubDirectories()) {
				file = dir.findFileByName(fileName);
				if(file != null)
					break;
			}
		}
		return file;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("ApfsDirectory Works!");
	}
}