package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;

import logic.dao.PhysfaceDAO;
import logic.entity.Physface;

public class NewPhysfaceInStudent extends NewPhysface {
	private PhysfaceDAO physfacedao=new PhysfaceDAO();
	
	public NewPhysfaceInStudent() {
		super();
	}
	
	@Override
	protected void insertPhysface(Physface physface) throws ClientProtocolException, IOException {
		String message="";
		if(errorList.isEmpty()) {
			message=physfacedao.insertPhysface(physface);
		} else {
			message=errorList;
		}
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	@Override
	protected void updateParentFrame(Physface physface) throws ClientProtocolException, IOException {
		NewStudent.updateFrame();
	}
	
	

}
