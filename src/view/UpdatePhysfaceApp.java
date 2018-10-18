package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.http.client.ClientProtocolException;

import logic.dao.CourceDAO;
import logic.dao.PayDAO;
import logic.dao.PhysfaceAppTeachDAO;
import logic.dao.StatusAppDAO;
import logic.dao.TypeScienceDAO;
import logic.entity.AppTeach;
import logic.entity.Cource;
import logic.entity.Pay;
import logic.entity.Physface;
import logic.entity.StatusApp;
import logic.entity.TypeScience;
import service.CheckValue;

public class UpdatePhysfaceApp extends JFrame {
	private JLabel AppTeach_IDText=new JLabel("№");
	private JLabel FIOText=new JLabel("ФИО");
	private JLabel PostText=new JLabel("Должность");
	private JLabel DocumentScienceText=new JLabel("Документ об образовании");
	private JLabel SerialNumberDocumentText=new JLabel("Серия и номер документа");
	private JLabel PhoneFaxText=new JLabel("Телефон/факс");
	private JLabel WebsiteText=new JLabel("Web-сайт");
	private JLabel INNText=new JLabel("ИНН");
	private JLabel KPPText=new JLabel("КПП");
	private JLabel BIKText=new JLabel("БИК");
	private JLabel RSText=new JLabel("Р/С");
	private JLabel CourceText=new JLabel("Курс");
	private JLabel CertificationText=new JLabel("Выдача удостоверения");
	private JLabel PayText=new JLabel("Оплата");
	private JLabel TypeScienceText=new JLabel("Тип обучения");
	private JLabel StatusAppText=new JLabel("Статус заявки");
	private JLabel CommentText=new JLabel("Примечание");
	private JTextField AppTeach_ID=new JTextField(50);
	private JTextField FIO=new JTextField(50);
	private JTextField Post=new JTextField(50);
	private JTextField DocumentScience=new JTextField(50);
	private JTextField SerialNumberDocument=new JTextField(50);
	private JTextField PhoneFax=new JTextField(50);
	private JTextField Website=new JTextField(50);
	private JTextField INN=new JTextField(50);
	private JTextField KPP=new JTextField(50);
	private JTextField BIK=new JTextField(50);
	private JTextField RS=new JTextField(50);
	private JComboBox Cource=new JComboBox();
	private JComboBox Certification=new JComboBox();
	private JComboBox Pay=new JComboBox();
	private JComboBox TypeScience=new JComboBox();
	private JComboBox StatusApp=new JComboBox();
	private JTextField Comment=new JTextField(50);
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private AppTeach appteach;
	private PhysfaceAppTeachDAO physfacedao;
	private Physface physface;
	private CourceDAO courcedao=new CourceDAO();
	private PayDAO paydao=new PayDAO();
	private TypeScienceDAO typesciencedao=new TypeScienceDAO();
	private StatusAppDAO statusappdao=new StatusAppDAO();
	
	public UpdatePhysfaceApp(AppTeach obj) throws ClientProtocolException, IOException {
		this.appteach=obj;
		this.physface=appteach.getPhysface();
		createComboBoxes();
		createTextData();
		createGUI();
		createActions();
		
	}
	
	private void createComboBoxes() throws ClientProtocolException, IOException {
		Dimension size=new Dimension(50, 20);
		Cource.setPreferredSize(size);
		Certification.setPreferredSize(size);
		Pay.setPreferredSize(size);
		TypeScience.setPreferredSize(size);
		StatusApp.setPreferredSize(size);
		for(Cource cource : courcedao.getCourceList()) {
			Cource.addItem(cource.getCource());
		}
		Certification.addItem("Да");
		Certification.addItem("Нет");
		for(Pay pay : paydao.getPayList()) {
			Pay.addItem(pay.getPay());
		}
		for(TypeScience type : typesciencedao.getTypeScienceList()) {
			TypeScience.addItem(type.getTypeScience());
		}
		for(StatusApp status : statusappdao.getStatusAppList()) {
			StatusApp.addItem(status.getStatusApp());
		}
		
	}
	
	private void createTextData() {
		AppTeach_ID.setText(appteach.getAppTeach_ID()+"");
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
		Cource.setSelectedItem(appteach.getCource());
	    Certification.setSelectedItem(appteach.getCertification());
	    Pay.setSelectedItem(appteach.getPay());
		TypeScience.setSelectedItem(appteach.getTypeScience());
		StatusApp.setSelectedItem(appteach.getStatusApp());
		Comment.setText(appteach.getComment());
	}
	
	private void createActions() {
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String errorList="";
				String validateCource=Cource.getSelectedItem()+"";
				String validateCertification=Certification.getSelectedItem()+"";
				String validatePay=Pay.getSelectedItem()+"";
				String validateTypeScience=TypeScience.getSelectedItem()+"";
				String validateStatusApp=StatusApp.getSelectedItem()+"";
				AppTeach updateRow=new AppTeach();
				Physface physface=new Physface();
				physfacedao=new PhysfaceAppTeachDAO();
					ArrayList<AppTeach> list;
					physface.setPhys_ID(appteach.getPhys_ID());
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
					updateRow.setPhysface(physface);
					updateRow.setAppTeach_ID(appteach.getAppTeach_ID());
					updateRow.setPhys_ID(appteach.getPhys_ID());
					updateRow.setFIO(FIO.getText());
					if(!validateCource.equals("null")) {
						updateRow.setCource(Cource.getSelectedItem().toString());
					}
					if(!validateCertification.equals("null")) {
						updateRow.setCertification(Certification.getSelectedItem().toString());
					}
					if(!validatePay.equals("null")) {
						updateRow.setPay(Pay.getSelectedItem().toString());
					}
					if(!validateTypeScience.equals("null")) {
						updateRow.setTypeScience(TypeScience.getSelectedItem().toString());
					}
					if(!validateStatusApp.equals("null")) {
						updateRow.setStatusApp(StatusApp.getSelectedItem().toString());
					}
					updateRow.setComment(Comment.getText());
					if(!errorList.equals("")) {
						JOptionPane.showMessageDialog(null, errorList);
					} else {
						try {
							String message=physfacedao.updatePhysfaceAppTeach(updateRow);
							JOptionPane.showMessageDialog(null, message);
							SecretaryPhysface.updateFrame();
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
			}
			
		});
	}
	
	private void createGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());
		add(AppTeach_IDText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(AppTeach_ID, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(FIOText, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(FIO, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(PostText, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Post, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(DocumentScienceText, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(DocumentScience, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(SerialNumberDocumentText, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(SerialNumberDocument, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(PhoneFaxText, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(PhoneFax, new GridBagConstraints(0, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(WebsiteText, new GridBagConstraints(0, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Website, new GridBagConstraints(0, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(INNText, new GridBagConstraints(0, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(INN, new GridBagConstraints(0, 15, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(KPPText, new GridBagConstraints(0, 16, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(KPP, new GridBagConstraints(0, 17, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(BIKText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(BIK, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(RSText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(RS, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(CourceText, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Cource, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(CertificationText, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Certification, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(PayText, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Pay, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(TypeScienceText, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    add(TypeScience, new GridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(StatusAppText, new GridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(StatusApp, new GridBagConstraints(1, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(CommentText, new GridBagConstraints(1, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Comment, new GridBagConstraints(1, 15, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(ok, new GridBagConstraints(0, 18, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(cancel, new GridBagConstraints(1, 18, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		setSize(500, 500);
		setVisible(true);
	}
	
	

}
