package logic.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Examine {
	private int Examine_ID;
    private int Cource_ID;
    private String Cource;
    private int NumberHours;
    private Date DateExamine;
    private int Teacher_ID;
    private String Teacher;
    private ArrayList<Examinee> StudentList;
    
	public int getExamine_ID() {
		return Examine_ID;
	}
	public void setExamine_ID(int examine_ID) {
		Examine_ID = examine_ID;
	}
	public int getCource_ID() {
		return Cource_ID;
	}
	public void setCource_ID(int cource_ID) {
		Cource_ID = cource_ID;
	}
	public String getCource() {
		return Cource;
	}
	public void setCource(String cource) {
		Cource = cource;
	}
	public int getNumberHours() {
		return NumberHours;
	}
	public void setNumberHours(int numberHours) {
		NumberHours = numberHours;
	}
	public Date getDateExamine() {
		return DateExamine;
	}
	public void setDateExamine(Date dateExamine) {
		DateExamine = dateExamine;
	}
	public ArrayList<Examinee> getStudentList() {
		return StudentList;
	}
	public void setStudentList(ArrayList<Examinee> studentList) {
		StudentList = studentList;
	}
	public int getTeacher_ID() {
		return Teacher_ID;
	}
	public void setTeacher_ID(int teacher_ID) {
		Teacher_ID = teacher_ID;
	}
	public String getTeacher() {
		return Teacher;
	}
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	
	
    
    

}
