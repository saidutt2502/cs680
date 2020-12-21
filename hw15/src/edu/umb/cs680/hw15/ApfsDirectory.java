package edu.umb.cs680.hw15;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class ApfsDirectory extends ApfsElement{
	
	private LinkedList<ApfsElement> child;
	public void appendChild(ApfsElement child) {
		if(this.child == null) {
			this.child = new LinkedList<ApfsElement>();
		}
		this.child.add(child);
	}
	public LinkedList<ApfsElement> getChildren() {
		if(this.child == null) {
			this.child = new LinkedList<ApfsElement>();
		}
		Collections.sort(child, (ApfsElement object1, ApfsElement object2) -> object1.getName().compareTo(object1.getName()));
		return child;
	}

	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModified) {
		super(parent, name, size, creationTime, ownerName, lastModified);
		if(parent != null)
			parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		return true;
	}
	
	
	public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator) {
		LinkedList<ApfsFile> fileList = getFiles();
		Collections.sort(fileList, comparator);
		return fileList;
	}
	public int countChildren() {
		return getChildren().size() - getLinks().size();
	}
	
	public LinkedList<ApfsDirectory> getSubDirectories() {
		LinkedList<ApfsDirectory> listofdir = new LinkedList<ApfsDirectory>();
		for(FSElement a : getChildren()) {
			if(a instanceof ApfsDirectory)
				listofdir.add((ApfsDirectory) a);
		}
		Collections.sort(listofdir, (ApfsElement object1, ApfsElement object2) -> object1.getName().compareTo(object2.getName()));
		return listofdir;	
	}

	
	
	public LinkedList<ApfsLink> getLinks() {
		LinkedList<ApfsLink> linkList = new LinkedList<ApfsLink>();
		for(FSElement a : getChildren()) {
			if(a instanceof ApfsLink)
				linkList.add((ApfsLink) a);
		}
		return linkList;
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for(ApfsElement a : getChildren()) {
			if(a instanceof ApfsDirectory)
				totalSize += ((ApfsDirectory) a).getTotalSize();
			else
				totalSize += a.getSize();
		}
		return totalSize;
	}
	public LinkedList<ApfsFile> getFiles() {
		LinkedList<ApfsFile> fileList = new LinkedList<ApfsFile>();
		for(FSElement a : getChildren()) {
			if(a instanceof ApfsFile)
				fileList.add((ApfsFile) a);
		}
		Collections.sort(fileList, (ApfsElement object1, ApfsElement object2) -> object1.getName().compareTo(object2.getName()));
		return fileList;
	}
	public ApfsDirectory findByName_Directory(String dirName) {
		ApfsDirectory directory = null;
		if(dirName.equals(getName()))
			directory = this;
		else {
			for(ApfsDirectory dir : getSubDirectories()) {
				if(directory == null) {
					directory = dir.findByName_Directory(dirName);
					if(dirName.equals(dir.getName())) {
						directory = dir;
						break;
					}
				}
			}
		}
		return directory;
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
	
	public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
		Collections.sort(getChildren(), comparator);
		return child;
	}
	
	public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator) {
		LinkedList<ApfsDirectory> listofdir = getSubDirectories();
		Collections.sort(listofdir, comparator);
		return listofdir;
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
		System.out.println("ApfsDirectory Works");
	}
}
