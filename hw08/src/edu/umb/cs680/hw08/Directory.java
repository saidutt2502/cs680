package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
	
	private LinkedList<FSElement> children;

	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		if(parent != null)
			parent.appendChild(this);
	}
	
	
	public LinkedList<FSElement> getChildren() {
		return children;
	}


	public void appendChild(FSElement child) {
		if(this.children == null) {
			this.children = new LinkedList<FSElement>();
		}
		this.children.add(child);
	}

	
	public LinkedList<Link> getLinks() {
		LinkedList<Link> linkList = new LinkedList<Link>();
		for(FSElement element : getChildren()) {
			if(element instanceof Link)
				linkList.add((Link) element);
		}
		return linkList;
	}

	public int countChildren() {
		return getChildren().size()- getLinks().size();
	}

	
	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> directories = new LinkedList<Directory>();
		for(FSElement s : getChildren()) {
			if(s instanceof Directory)
				directories.add((Directory) s);
		}
		return directories;	
	}
	
	
	public LinkedList<File> getFiles() {
		LinkedList<File> files = new LinkedList<File>();
		for(FSElement s : getChildren()) {
			if(s instanceof File)
				files.add((File) s);
		}
		return files;
	}
	
	public int getTotalSize() {
		int size = 0;
		for(FSElement s : getChildren()) {
			if(s instanceof Directory)
				size += ((Directory) s).getTotalSize();
			else
				size += s.getSize();
		}
		return size;
	}
	

	@Override
	public boolean isDirectory() {
		return true;
	}
	
	
	public Link findLinkByName(String linkName) {
		Link link = null;
		for(Link l : getLinks()) {
			if(linkName.equals(l.getName()))
				link = l;
		}
		if(link == null) {
			for(Directory dir : getSubDirectories()) {
				link = dir.findLinkByName(linkName);
				if(link != null)
					break;
			}
		}
		return link;
	}
	

	public Directory findDirectoryByName(String directoryName) {
		Directory directory = null;
		if(directoryName.equals(getName()))
			directory = this;
		else {
			for(Directory dir : getSubDirectories()) {
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
	
	public File findFileByName(String fileName) {
		File file = null;
		for(File f : getFiles()) {
			if(fileName.equals(f.getName()))
				file = f;
		}
		if(file == null) {
			for(Directory dir : getSubDirectories()) {
				file = dir.findFileByName(fileName);
				if(file != null)
					break;
			}
		}
		return file;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Directory Works!");
	}
}
