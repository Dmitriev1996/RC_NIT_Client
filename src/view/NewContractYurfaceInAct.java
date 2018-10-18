package view;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class NewContractYurfaceInAct extends NewContractYurface {
	
	public NewContractYurfaceInAct() throws ClientProtocolException, IOException {
		super();
	}
	
	@Override
	protected void updateParentFrame() throws ClientProtocolException, IOException {
		NewActYurface.updateFrame();
	}

}
