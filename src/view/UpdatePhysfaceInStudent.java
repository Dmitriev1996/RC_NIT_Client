package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;

import logic.dao.PhysfaceDAO;
import logic.entity.Physface;

public class UpdatePhysfaceInStudent extends UpdatePhysfaceInContract {
	private PhysfaceDAO physfacedao=new PhysfaceDAO();
	public UpdatePhysfaceInStudent(Physface physface) {
		super(physface);
	}
	
	
	@Override
	protected void updatePhysface(Physface physface) throws ClientProtocolException, IOException {
		String message="";
		if(errorList.isEmpty()) {
			message=physfacedao.updatePhysface(physface);
		} else {
			message=errorList;
		}
		JOptionPane.showMessageDialog(null, message);
	}
	
	protected void updateParentFrame(Physface physface) throws ClientProtocolException, IOException {
		NewStudent.updateFrame();
	}

}
