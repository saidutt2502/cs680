package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementComparator implements Comparator<ApfsElement>{

	@Override
	public int compare(ApfsElement f1, ApfsElement f2) {
		// TODO Auto-generated method stub
		if(f1 instanceof ApfsDirectory && f2 instanceof ApfsDirectory)
			return 3;
		else if(f1 instanceof ApfsDirectory && f2 instanceof ApfsFile)
			return 2;
		else if(f2 instanceof ApfsDirectory && f1 instanceof ApfsFile)
			return 1;
		else 
			return 0;
	}

	public static void main(String[] args) {
		System.out.println("ElementComparator Works");
	}
}
