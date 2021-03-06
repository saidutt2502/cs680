package edu.umb.cs680.hw04;

public class Student {
	
	private float tution;
	private String name;
	private int i20num;
	private String usAddr;
	private int yrsInState;
	private String foreignAddr;
	private StudentStatus status;
	
	private Student(String name, int i20num, String usAddr, int yrsInState, String foreignAddr,StudentStatus status) {

		this.name = name;
		this.i20num = i20num;
		this.usAddr = usAddr;
		this.yrsInState = yrsInState;
		this.foreignAddr = foreignAddr;
		this.status = status;
	}
	
	public static Student createInStateStudent(String name, String usAddr) {
		return new Student(name, 0, usAddr, 0, null, StudentStatus.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, 0, usAddr, yrsInState, null, StudentStatus.OUTSTATE);
	}

	public static Student createIntlStudent(String name, int i20num, String usAddr, String foreignAddr) {
		return new Student(name, i20num, usAddr, 0, foreignAddr, StudentStatus.INTERNATIONAL);
	}
	
	public float getTuition() {
		if (status.equals(StudentStatus.INSTATE))
			return 15000;
		else if (status.equals(StudentStatus.OUTSTATE))
			return 20000;
		else
			return 30000;
	}
	
	public String getName() {
		return name;
	}
	
	public int getI20Num() {
		return i20num;
	}

	public String getUsAddr() {
		return usAddr;
	}
	
	public int getYrsInState() {
		return yrsInState;
	}

	public String getForeignAddr() {
		return foreignAddr;
	}
	
	public StudentStatus getStatus() {
		return status;
	}
	
	public static void main(String[] args) {
		Student internationalStudent = createIntlStudent("Saidutt", 1828020, "Timon Ave, Boston", "Goa, India");
		System.out.println("Student Name: "+internationalStudent.getName()+ "\n"
				             +"I20 number: "+internationalStudent.getI20Num()+ "\n"
				             +"US Address: "+internationalStudent.getUsAddr()+"\n"
		            		 +"Foreign Address: "+internationalStudent.getForeignAddr()+"\n"
            				 +"Status: " + internationalStudent.getStatus() +"\n"
				             +"Tution: "+internationalStudent.getTuition() + "\n");
		
		Student outStateStudent = createOutStateStudent("Mason","Hollywood, LA", 3);
		System.out.println("Student Name: "+outStateStudent.getName()+ "\n"
	             			 +"US Address: "+outStateStudent.getUsAddr()+"\n"
	             			 +"Years In State: "+outStateStudent.getYrsInState()+"\n"
	             			 +"Status: " + outStateStudent.getStatus() +"\n"
	             			 +"Tution: "+outStateStudent.getTuition() + "\n");
		
		Student inStateStudent = createInStateStudent("George","Downtown, Boston");
		System.out.println("Student Name: "+inStateStudent.getName()+ "\n"
	             			 +"US Address: "+inStateStudent.getUsAddr()+"\n"
	             			 +"Status: " + inStateStudent.getStatus() +"\n"
	             			 +"Tution: "+inStateStudent.getTuition() + "\n");
	}
		
}
