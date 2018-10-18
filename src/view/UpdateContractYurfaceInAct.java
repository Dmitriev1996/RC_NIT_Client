package view;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import logic.entity.ContractOrderYurface;

public class UpdateContractYurfaceInAct extends UpdateContractYurface {
	
	public UpdateContractYurfaceInAct(ContractOrderYurface contract) throws ClientProtocolException, IOException {
		super(contract);
	}
	
	@Override
	protected void updateParentFrame() throws ClientProtocolException, IOException {
		NewActYurface.updateFrame();
	}

}
