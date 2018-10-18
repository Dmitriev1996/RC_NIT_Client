/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class IndividualStudent {
    private int IndividualStudent_ID;
    private int Phys_ID;
    private Physface Physface;
    private int Cource_ID;
    private Cource Cource;
    private Date DateCertification;
    private byte Certification;
    private int Teacher_ID;
    private String Teacher;

    public int getIndividualStudent_ID() {
        return IndividualStudent_ID;
    }

    public void setIndividualStudent_ID(int IndividualStudent_ID) {
        this.IndividualStudent_ID = IndividualStudent_ID;
    }

    public int getTeacher_ID() {
        return Teacher_ID;
    }

    public void setTeacher_ID(int Teacher_ID) {
        this.Teacher_ID = Teacher_ID;
    }

	public int getPhys_ID() {
		return Phys_ID;
	}

	public void setPhys_ID(int phys_ID) {
		Phys_ID = phys_ID;
	}

	public Date getDateCertification() {
		return DateCertification;
	}

	public void setDateCertification(Date dateCertification) {
		DateCertification = dateCertification;
	}

	public byte getCertification() {
		return Certification;
	}

	public void setCertification(byte certification) {
		Certification = certification;
	}

	public String getTeacher() {
		return Teacher;
	}

	public void setTeacher(String teacher) {
		Teacher = teacher;
	}

	public Physface getPhysface() {
		return Physface;
	}

	public void setPhysface(Physface physface) {
		Physface = physface;
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
	
	
	
	
    
    
    
}
