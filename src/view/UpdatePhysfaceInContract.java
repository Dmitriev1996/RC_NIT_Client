package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.http.client.ClientProtocolException;

import logic.entity.Physface;
import service.CheckValue;

public class UpdatePhysfaceInContract extends JFrame {
	protected JTextField FIO=new JTextField(20);
	protected JLabel FIOText=new JLabel("ФИО");
	protected JTextField Post=new JTextField(20);
	protected JLabel PostText=new JLabel("Должность");
	protected JTextField DocumentScience=new JTextField(20);
	protected JLabel DocumentScienceText=new JLabel("Документ об образовании");
	protected JTextField SerialNumberDocument=new JTextField(20);
	protected JLabel SerialNumberDocumentText=new JLabel("Серия и номер документа");
	protected JTextField PhoneFax=new JTextField(20);
	protected JLabel PhoneFaxText=new JLabel("Телефон/факс");
	protected JTextField Website=new JTextField(20);
	protected JLabel WebsiteText=new JLabel("Web-сайт");
	protected JTextField INN=new JTextField(20);
	protected JLabel INNText=new JLabel("ИНН");
	protected JTextField KPP=new JTextField(20);
	protected JLabel KPPText=new JLabel("КПП");
	protected JTextField BIK=new JTextField(20);
	protected JLabel BIKText=new JLabel("БИК");
	protected JTextField RS=new JTextField(20);
	protected JLabel RSText=new JLabel("Р/С");
	protected JButton ok=new JButton("OK");
	protected JButton cancel=new JButton("Отмена");
	protected String errorList;
	
	public UpdatePhysfaceInContract(Physface physface) {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());
		add(FIOText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(FIO, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(PostText, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Post, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(DocumentScienceText, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(DocumentScience, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(SerialNumberDocumentText, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(SerialNumberDocument, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(PhoneFaxText, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(PhoneFax, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(ok, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(WebsiteText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Website, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(INNText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(INN, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(KPPText, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(KPP, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(BIKText, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(BIK, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(RSText, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(RS, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(cancel, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		createTextData(physface);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				errorList="";
				physface.setFIO(FIO.getText());
				physface.setPost(Post.getText());
				physface.setDocumentScience(DocumentScience.getText());
				physface.setSerialNumberDocument(SerialNumberDocument.getText());
				physface.setPhoneFax(PhoneFax.getText());
				physface.setWebsite(Website.getText());
				if(!CheckValue.isNumber(INN.getText())&&!INN.getText().equals("")) {
			    	errorList+="Поле ИНН должно являться числом!\n";
			     } else if(!INN.getText().equals("")) {
				    physface.setINN(Long.parseLong(INN.getText()));
			     }
			    if(!CheckValue.isNumber(KPP.getText())&&!KPP.getText().equals("")) {
				  errorList+="Поле КПП должно являться числом\n";
			    } else if(!KPP.getText().equals("")) {
				    physface.setKPP(Long.parseLong(KPP.getText()));
			    }
			    if(!CheckValue.isNumber(BIK.getText())&&!BIK.getText().equals("")) {
				  errorList+="Поле БИК должно являться числом!\n";
			    } else if(!BIK.getText().equals("")) {
				    physface.setBIK(Long.parseLong(BIK.getText()));
			    }
			    if(!CheckValue.isNumber(RS.getText())&&!RS.getText().equals("")) {
				  errorList+="Поле РС должно являться числом!\n";
			    } else if(!RS.getText().equals("")) {
				    physface.setRS(Long.parseLong(RS.getText()));
			    }
				try {
					updatePhysface(physface);
					updateParentFrame(physface);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		setVisible(true);
	}
	
	protected void createTextData(Physface physface) {
		FIO.setText(physface.getFIO());
		Post.setText(physface.getPost());
		DocumentScience.setText(physface.getDocumentScience());
		SerialNumberDocument.setText(physface.getSerialNumberDocument());
		PhoneFax.setText(physface.getPhoneFax());
		Website.setText(physface.getWebsite());
		INN.setText(physface.getINN()+"");
		KPP.setText(physface.getKPP()+"");
		BIK.setText(physface.getBIK()+"");
		RS.setText(physface.getRS()+"");
	}
	
	protected void updatePhysface(Physface physface) throws ClientProtocolException, IOException {
		
	}
	
	protected void updateParentFrame(Physface physface) throws ClientProtocolException, IOException {
		UpdateContractPhysface.setPhysface(physface);
		UpdateContractPhysface.updateFrame();
	}

}
