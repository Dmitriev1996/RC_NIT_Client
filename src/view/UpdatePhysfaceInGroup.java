package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.entity.Physface;
import logic.entity.PhysfaceRow;

public class UpdatePhysfaceInGroup extends JFrame {
	private JTextField FIO=new JTextField(20);
	private JLabel FIOText=new JLabel("ФИО");
	private JTextField Post=new JTextField(20);
	private JLabel PostText=new JLabel("Должность");
	private JTextField DocumentScience=new JTextField(20);
	private JLabel DocumentScienceText=new JLabel("Документ об образовании");
	private JTextField SerialNumberDocument=new JTextField(20);
	private JLabel SerialNumberDocumentText=new JLabel("Серия и номер документа");
	private JTextField PhoneFax=new JTextField(20);
	private JLabel PhoneFaxText=new JLabel("Телефон/факс");
	private JTextField Website=new JTextField(20);
	private JLabel WebsiteText=new JLabel("Web-сайт");
	private JTextField INN=new JTextField(20);
	private JLabel INNText=new JLabel("ИНН");
	private JTextField KPP=new JTextField(20);
	private JLabel KPPText=new JLabel("КПП");
	private JTextField BIK=new JTextField(20);
	private JLabel BIKText=new JLabel("БИК");
	private JTextField RS=new JTextField(20);
	private JLabel RSText=new JLabel("Р/С");
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	
	public UpdatePhysfaceInGroup(Physface physface, int selectedRow) {
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
				physface.setFIO(FIO.getText());
				physface.setPost(Post.getText());
				physface.setDocumentScience(DocumentScience.getText());
				physface.setSerialNumberDocument(SerialNumberDocument.getText());
				physface.setPhoneFax(PhoneFax.getText());
				physface.setWebsite(Website.getText());
				physface.setINN(Long.parseLong(INN.getText()));
				physface.setKPP(Long.parseLong(KPP.getText()));
				physface.setBIK(Long.parseLong(BIK.getText()));
				physface.setRS(Long.parseLong(RS.getText()));
				HashMap<Integer, Physface> list=new HashMap<Integer, Physface>();
				list.put(selectedRow, physface);
				PhysfaceRow physfacerow=new PhysfaceRow();
				physfacerow.setNumRow(selectedRow);
				physfacerow.setStatus("update");
				physfacerow.setPhysface(physface);
				PhysfaceRow insertRow=new PhysfaceRow();
				insertRow.setNumRow(selectedRow);
				insertRow.setStatus("insert");
				insertRow.setPhysface(physface);
				int i=0;
				String status="";
				for(PhysfaceRow entry : UpdateYurfaceApp.updatePhysfaceList) {
					if(entry.getNumRow()==selectedRow) {
						i++;
						if(entry.getStatus()=="update") {
							UpdateYurfaceApp.updatePhysfaceList.set(UpdateYurfaceApp.updatePhysfaceList.indexOf(entry), physfacerow);
						} else if(entry.getStatus()=="insert") {
							UpdateYurfaceApp.updatePhysfaceList.set(UpdateYurfaceApp.updatePhysfaceList.indexOf(entry), insertRow);
						}
					}
				}
				if(i==0) {
					UpdateYurfaceApp.updatePhysfaceList.add(physfacerow);
				}
				UpdateYurfaceApp.physfacelist.set(selectedRow, physface);
				UpdateYurfaceApp.updatePhystable();
			}
			
		});
		setVisible(true);
	}
	
	public void createTextData(Physface physface) {
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

}
