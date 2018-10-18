package logic.entity;

public class Examinee {
	private int Examinee_ID;
    private int Examine_ID;
    private int Student_ID;
    private String FIO;
    private int Mark_ID;
    private String Mark;
	public int getExaminee_ID() {
		return Examinee_ID;
	}
	public void setExaminee_ID(int examinee_ID) {
		Examinee_ID = examinee_ID;
	}
	public int getExamine_ID() {
		return Examine_ID;
	}
	public void setExamine_ID(int examine_ID) {
		Examine_ID = examine_ID;
	}
	public int getStudent_ID() {
		return Student_ID;
	}
	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}
	public String getFIO() {
		return FIO;
	}
	public void setFIO(String fIO) {
		FIO = fIO;
	}
	public int getMark_ID() {
		return Mark_ID;
	}
	public void setMark_ID(int mark_ID) {
		Mark_ID = mark_ID;
	}
	public String getMark() {
		return Mark;
	}
	public void setMark(String mark) {
		Mark = mark;
	}
    
    

}
