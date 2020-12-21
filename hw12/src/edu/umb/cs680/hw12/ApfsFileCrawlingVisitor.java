package edu.umb.cs680.hw12;

import java.util.ArrayList;

public class ApfsFileCrawlingVisitor<T> implements ApfsFSVisitor<T> {

	ArrayList<ApfsFile> files = new ArrayList<>();
	
	@Override
	public void visit(ApfsLink link) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void visit(ApfsDirectory dir) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void visit(ApfsFile file) {
		// TODO Auto-generated method stub
		files.add(file);
	}
	
	public ArrayList getFiles() {
		return files;
	}

	public static void main(String[] args) {
		System.out.println("ApfsFileCrawlingVisitor Works");
	}
}
