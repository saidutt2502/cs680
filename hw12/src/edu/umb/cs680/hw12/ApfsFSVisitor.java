package edu.umb.cs680.hw12;

public interface ApfsFSVisitor<T> {
	public void visit(ApfsLink link) ;
	public void visit(ApfsDirectory dir);
	public void visit(ApfsFile file) ;
	
	public static void main(String[] args) {
		System.out.println("ApfsFSVisitor Works");
	}
}
