package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;

import logic.entity.Yurface;

public class NewYurfaceInNewContract extends NewYurface {
	
	public NewYurfaceInNewContract() {
		super();
	}
	
	@Override
	protected void updateParentFrame() throws ClientProtocolException, IOException {
		NewContractYurface.updateFrame();
	}
	
	}

