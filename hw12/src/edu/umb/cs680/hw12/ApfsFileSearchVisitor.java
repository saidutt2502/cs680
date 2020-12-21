package edu.umb.cs680.hw12;

public class ApfsFileSearchVisitor<T> implements ApfsFSVisitor<T> {

	ApfsFile file;
	@Override
	public void visit(ApfsLink link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ApfsDirectory dir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ApfsFile file) {
		// TODO Auto-generated method stub
		this.file = file;
	}
	
	public boolean search(String fileName) {
		if(fileName.equals(file.getName()))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println("ApfsFileSearchVisitor Works");
	}
}
