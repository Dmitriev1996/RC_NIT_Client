package view;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import logic.entity.Yurface;

public class UpdateYurfaceInContract extends UpdateYurface {
	
	public UpdateYurfaceInContract(Yurface yurface) {
		super(yurface);
	}
	
	@Override
	protected void updateParentFrame() throws ClientProtocolException, IOException {
		UpdateContractYurface.updateFrame();
	}

}
