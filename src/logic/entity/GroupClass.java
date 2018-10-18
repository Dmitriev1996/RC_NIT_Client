/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class GroupClass {
    private int GroupClasses_ID;
    private int Group_ID;
    private Group Group;
    private String Cource;
    private String Teacher;
    private Date DateClass;
    private int NumberAudience;

    public int getGroupClasses_ID() {
        return GroupClasses_ID;
    }

    public void setGroupClasses_ID(int GroupClasses_ID) {
        this.GroupClasses_ID = GroupClasses_ID;
    }

    public int getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(int Group_ID) {
        this.Group_ID = Group_ID;
    }

    public Date getDateClass() {
        return DateClass;
    }

    public void setDateClass(Date DateClass) {
        this.DateClass = DateClass;
    }

    public int getNumberAudience() {
        return NumberAudience;
    }

    public void setNumberAudience(int NumberAudience) {
        this.NumberAudience = NumberAudience;
    }

	public Group getGroup() {
		return Group;
	}

	public void setGroup(Group group) {
		Group = group;
	}

	public String getCource() {
		return Cource;
	}

	public void setCource(String cource) {
		Cource = cource;
	}

	public String getTeacher() {
		return Teacher;
	}

	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
    
    
    
}
