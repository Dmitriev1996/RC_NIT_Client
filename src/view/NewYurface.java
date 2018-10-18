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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.http.client.ClientProtocolException;

import logic.dao.YurfaceDAO;
import logic.entity.Yurface;
import service.CheckValue;

public class NewYurface extends JFrame {
	protected JTextField NameOrganization=new JTextField(50);
	protected JLabel NameOrganizationText=new JLabel("Наименование организации");
	protected JTextField Director=new JTextField(50);
	protected JLabel DirectorText=new JLabel("Директор");
	protected JTextField YurAdress=new JTextField(50);
	protected JLabel YurAdressText=new JLabel("Юр. адрес");
	protected JTextField FactAdress=new JTextField(50);
	protected JLabel FactAdressText=new JLabel("Факт. адрес");
	protected JTextField Email=new JTextField(50);
	protected JLabel EmailText=new JLabel("E-mail");
	protected JTextField PhoneFax=new JTextField(50);
	protected JLabel PhoneFaxText=new JLabel("Телефон/факс");
	protected JTextField RS=new JTextField(50);
	protected JLabel RSText=new JLabel("Р/С");
	protected JTextField KS=new JTextField(50);
	protected JLabel KSText=new JLabel("К/С");
	protected JTextField BIK=new JTextField(50);
	protected JLabel BIKText=new JLabel("БИК");
	protected JTextField INN=new JTextField(50);
	protected JLabel INNText=new JLabel("ИНН");
	protected JTextField KPP=new JTextField(50);
	protected JLabel KPPText=new JLabel("КПП");
	protected JButton ok=new JButton("OK");
	protected JButton cancel=new JButton("Отмена");
	protected YurfaceDAO yurfacedao;
	
	public NewYurface() {
		yurfacedao=new YurfaceDAO();
		createGUI();
		createActions();
	}
	
	private void createGUI() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());
		add(NameOrganizationText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(NameOrganization, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(DirectorText, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Director, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(YurAdressText, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(YurAdress, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(FactAdressText, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(FactAdress, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(EmailText, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Email, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(PhoneFaxText, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(PhoneFax, new GridBagConstraints(0, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(ok, new GridBagConstraints(0, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(RSText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(RS, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(KSText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(KS, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(BIKText, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(BIK, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(INNText, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(INN, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(KPPText, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(KPP, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(cancel, new GridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		setVisible(true);
		
	}
	
	private void createActions() {
		ok.addActionListener(new ActionListener() {

			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String message="";
				String errorList="";
				Yurface yurface=new Yurface();
				yurface.setNameOrganization(NameOrganization.getText());
				yurface.setDirector(Director.getText());
				yurface.setYurAdress(YurAdress.getText());
				yurface.setFactAdress(FactAdress.getText());
				yurface.setEmail(Email.getText());
				yurface.setPhoneFax(PhoneFax.getText());
				if(!CheckValue.isNumber(INN.getText())&&!INN.getText().equals("")) {
				errorList+="Поле ИНН должно являться числом!\n";
				} else if(!INN.getText().equals("")) {
					yurface.setINN(Long.parseLong(INN.getText()));
				}
				if(!CheckValue.isNumber(KPP.getText())&&!KPP.getText().equals("")) {
					errorList+="Поле КПП должно являться числом\n";
				} else if(!KPP.getText().equals("")) {
					yurface.setKPP(Long.parseLong(KPP.getText()));
				}
				if(!CheckValue.isNumber(BIK.getText())&&!BIK.getText().equals("")) {
					errorList+="Поле БИК должно являться числом!\n";
				} else if(!BIK.getText().equals("")) {
					yurface.setBIK(Long.parseLong(BIK.getText()));
				}
				if(!CheckValue.isNumber(RS.getText())&!RS.getText().equals("")) {
					errorList+="Поле РС должно являться числом!\n";
				} else if(!RS.getText().equals("")) {
					yurface.setRS(Long.parseLong(RS.getText()));
				}
				if(!errorList.equals("")) {
					JOptionPane.showMessageDialog(null, errorList);
				} else {
					try {
						message=yurfacedao.insertYurface(yurface);
						updateParentFrame();
					} catch (ClientProtocolException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, message);
				}
					
			}
			
		});
	}
	
	protected void updateParentFrame() throws ClientProtocolException, IOException {
		NewYurfaceApp.updateFrame();
	}

}
