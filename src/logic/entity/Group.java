/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entity;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Group {
    private int Group_ID;
    private int Cource_ID;
    private Cource Cource;
    private byte Certification;
    private int Teacher_ID;
    private Teacher Teacher;
    private ArrayList<Student> StudentList;
    private int StatusScience_ID;
    private String StatusScience;

    public int getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(int Group_ID) {
        this.Group_ID = Group_ID;
    }

    public int getTeacher_ID() {
        return Teacher_ID;
    }

    public void setTeacher_ID(int Teacher_ID) {
        this.Teacher_ID = Teacher_ID;
    }

	public int getCource_ID() {
		return Cource_ID;
	}

	public void setCource_ID(int cource_ID) {
		Cource_ID = cource_ID;
	}

	public Cource getCource() {
		return Cource;
	}

	public void setCource(Cource cource) {
		Cource = cource;
	}

	public byte getCertification() {
		return Certification;
	}

	public void setCertification(byte certification) {
		Certification = certification;
	}

	public Teacher getTeacher() {
		return Teacher;
	}

	public void setTeacher(Teacher teacher) {
		Teacher = teacher;
	}

	public ArrayList<Student> getStudentList() {
		return StudentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		StudentList = studentList;
	}

	public int getStatusScience_ID() {
		return StatusScience_ID;
	}

	public void setStatusScience_ID(int statusScience_ID) {
		StatusScience_ID = statusScience_ID;
	}

	public String getStatusScience() {
		return StatusScience;
	}

	public void setStatusScience(String statusScience) {
		StatusScience = statusScience;
	}
	
	
	
	
    
    
    
}
