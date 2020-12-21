package edu.umb.cs680.hw12;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement>{

	@Override
	public int compare(ApfsElement f1, ApfsElement f2) {
		// TODO Auto-generated method stub
		return f1.getCreationTime().compareTo(f2.getCreationTime());
	}

	public static void main(String[] args) {
		System.out.println("TimeStampComaprator Works");
	}

}
