package src.edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.Student;

import edu.umb.cs680.hw04.StudentStatus;

class StudentTest {

	Student inStateStudent = Student.createInStateStudent("George", "Downtown, Boston");
	Student outStateStudent = Student.createOutStateStudent("Mason", "Hollywood, LA", 3);
	Student internationalStudent = Student.createIntlStudent("Saidutt", 1828020, "Timon Ave, Boston", "Goa, India");

	@Test
	public void InstateStudent() throws Exception {
		assertEquals(StudentStatus.INSTATE, inStateStudent.getStatus());
	}
	
	@Test
	public void OutStateStudent() throws Exception{
		assertEquals(StudentStatus.OUTSTATE, outStateStudent.getStatus());
	}
	
	@Test
	public void InternationalStudent() throws Exception{
		assertEquals(StudentStatus.INTERNATIONAL, internationalStudent.getStatus());
	}
	
	@Test
	public void InstateStudentTuition() throws Exception{
		assertEquals(15000, inStateStudent.getTuition());
	}
	
	@Test
	public void InstateStudentTution_Not20000() throws Exception{
		assertNotEquals(20000, inStateStudent.getTuition());
	}
	
	@Test
	public void OutstateStudentTution() throws Exception{
		assertEquals(20000, outStateStudent.getTuition());
	}
	
	@Test
	public void OutstateStudentTuition_Not30000() throws Exception{
		assertNotEquals(30000, outStateStudent.getTuition());
	}
	
	@Test
	public void InternationalStudentTution() throws Exception{
		assertEquals(30000, internationalStudent.getTuition());
	}
	
	@Test
	public void InternationalStudentTution_Not15000() throws Exception{
		assertNotEquals(15000, internationalStudent.getTuition());
	}
	
	

}
