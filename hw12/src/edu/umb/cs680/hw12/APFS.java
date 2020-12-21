package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem {
	
	private static APFS fs = null;
	
	private APFS() {
	}

	public static APFS getFileSystem() {
		if (fs == null) {
			fs = new APFS();
			fs.initFileSystem("Root", 1800);
		}
		return fs;
	}

	public LinkedList<ApfsElement> getRootDirs(ApfsElement d) {
		LinkedList<ApfsElement> child = new LinkedList<>();
		while (d.getParent() != null) {
			child.add(d.getParent());
			d = d.getParent();
		}
		return child;
	}

	@Override
	protected FSElement createDefaultRoot() {
		return new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2020, 12, 12, 1, 0), "saidutt", null);
	}
	
	public void setRootDir(ApfsDirectory root) {
		super.setRoot(root);
	}
	
	public ApfsDirectory getRootDir() {
		return (ApfsDirectory)this.getRoot();
	}
	
	public static void main(String[] args) {
		System.out.println("APFS Works");
	}
}