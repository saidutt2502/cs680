package edu.umb.cs680.hw12;

public class ApfsCountingVisitor<T> implements ApfsFSVisitor<T> {

	private int d_Num=0;
	private int f_Num=0;
	private int l_Num=0;
	
	@Override
	public void visit(ApfsLink link) {
		l_Num++;
	}
	
	@Override
	public void visit(ApfsDirectory dir) {
		d_Num++;
		
	}
	
	@Override
	public void visit(ApfsFile file) {
		f_Num++;
	}
	
	public int getDirNum() {
		return d_Num;
	}
	
	public int getLinkNum() {
		return l_Num;
	}
	
	public int getFileNum() {
		return f_Num;
	}
	
	public static void main(String[] args) {
		System.out.println("ApfsCountingVisitor Works");
	}

}
