package edu.umb.cs680.hw10;

import java.util.ArrayList;

public class ApfsFileCrawlingVisitor implements ApfsFSVisitor{

	private ArrayList<ApfsFile> files;
	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}
	public ArrayList<ApfsFile> getFiles() {
		if(null == files) {
			files = new ArrayList<ApfsFile>();
		}
		return files;
	}

	

	@Override
	public void visit(ApfsFile file) {
		if(null == files) {
			files = new ArrayList<ApfsFile>();
		}
		files.add(file);
	}
	@Override
	public void visit(ApfsLink link) {
		return;
	}
	
	public static void main(String[] args) {
		System.out.println("ApfsFileCrawlingVisitor Works");
	}
}