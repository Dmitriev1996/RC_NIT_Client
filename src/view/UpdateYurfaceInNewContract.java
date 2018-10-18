package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;

import logic.entity.Yurface;

public class UpdateYurfaceInNewContract extends UpdateYurface {
	
	public UpdateYurfaceInNewContract(Yurface yurface) {
		super(yurface);
	}
	
	@Override
	protected void updateParentFrame() throws ClientProtocolException, IOException {
		NewContractYurface.updateFrame();
	}
	

}
