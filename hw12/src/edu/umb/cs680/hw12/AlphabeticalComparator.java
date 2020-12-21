package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement>{

	@Override
	public int compare(ApfsElement f1, ApfsElement f2) {
		// TODO Auto-generated method stub
		return f1.getName().toString().compareTo(f2.getName().toString());
	}

	public static void main(String[] args) {
		System.out.println("AlphabeticalComparator Works");
	}
	
}
