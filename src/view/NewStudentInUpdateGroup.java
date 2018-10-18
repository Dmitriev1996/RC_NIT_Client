package view;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import logic.entity.Student;

public class NewStudentInUpdateGroup extends NewStudent {
	public NewStudentInUpdateGroup() throws ClientProtocolException, IOException {
		super();
	}
	
	@Override
	protected void updateParentFrame(Student student) {
		UpdateGroup.addStudent(student);
		UpdateGroup.updateFrame();
	}

}
