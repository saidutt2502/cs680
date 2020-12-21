package edu.umb.cs680.hw10;

public class ApfsFileSearchVisitor implements ApfsFSVisitor{

	private String f_Name;
	private ApfsFile file;
	
	
	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}
	public void setFileName(String f_Name) {
		this.f_Name = f_Name;
	}

	@Override
	public void visit(ApfsLink link) {
		return;
	}
	public ApfsFile getFile() {
		return file;
	}
	

	@Override
	public void visit(ApfsFile file) {
		if(f_Name.equals(file.getName()))
			this.file = file;
	}

	public static void main(String[] args) {
		System.out.println("ApfsFileSearchVisitor Works");
	}
}
