package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import logic.dao.CourceDAO;
import logic.dao.PayDAO;
import logic.dao.StatusAppDAO;
import logic.dao.TypeScienceDAO;
import logic.dao.YurfaceAppTeachDAO;
import logic.entity.AppTeach;
import logic.entity.Cource;
import logic.entity.Pay;
import logic.entity.Physface;
import logic.entity.StatusApp;
import logic.entity.TypeScience;
import logic.entity.Yurface;

public class NewPhysfaceList extends JFrame {
	private JComboBox Cource=new JComboBox();
	private JLabel CourceText=new JLabel("Курс");
	private JComboBox Certification=new JComboBox();
	private JLabel CertificationText=new JLabel("Выдача удостоверения");
	private JComboBox Pay=new JComboBox();
	private JLabel PayText=new JLabel("Оплата");
	private JComboBox TypeScience=new JComboBox();
	private JLabel TypeScienceText=new JLabel("Тип обучения");
	private JComboBox StatusApp=new JComboBox();
	private JLabel StatusAppText=new JLabel("Статус заявки");
	private JTextField Comment=new JTextField(20);
	private JLabel CommentText=new JLabel("Примечание");
	private JButton newPhysface;
	private JButton delete;
	private JButton ok;
	private JButton cancel;
	private JScrollPane jsp;
	private JPanel editPanel;
	private JPanel buttonPanel;
	public static JTable table;
	public static TableModel model;
	public static ArrayList<Physface> physfacelist;
	private CourceDAO courcedao;
	private PayDAO paydao;
	private TypeScienceDAO typedao;
	private StatusAppDAO statusappdao;
	private AppTeach appteach;
	private YurfaceAppTeachDAO yurfaceappteachdao;
	
	public NewPhysfaceList(Yurface yurface) throws ClientProtocolException, IOException {
		courcedao=new CourceDAO();
		paydao=new PayDAO();
		typedao=new TypeScienceDAO();
		statusappdao=new StatusAppDAO();
		yurfaceappteachdao=new YurfaceAppTeachDAO();
		physfacelist=new ArrayList<Physface>();
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		Box contentBox=new Box(BoxLayout.Y_AXIS);
		editPanel=new JPanel();
		editPanel.setLayout(new GridBagLayout());
		editPanel.add(CourceText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Cource, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(CertificationText, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Certification, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(PayText, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Pay, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(TypeScienceText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(TypeScience, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(StatusAppText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(StatusApp, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(CommentText, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Comment, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		createComboBoxes();
		contentBox.add(editPanel, BorderLayout.NORTH);
		table=new JTable();
		model=new PhysfaceListTableModel(physfacelist);
		table.setModel(model);
		jsp=new JScrollPane(table);
		contentBox.add(jsp);
		newPhysface=new JButton("Добавить физ. лицо");
		newPhysface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewPhysface();
			}
			
		});
		delete=new JButton("Удалить");
		ok=new JButton("OK");
		cancel=new JButton("Отмена");
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.add(newPhysface, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(delete, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(ok, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(cancel, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		contentBox.add(buttonPanel);
		add(contentBox);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String validateCource=Cource.getSelectedItem()+"";
				String validateCertification=Certification.getSelectedItem()+"";
				String validatePay=Pay.getSelectedItem()+"";
				String validateTypeScience=TypeScience.getSelectedItem()+"";
				String validateStatusApp=StatusApp.getSelectedItem()+"";
				String message="";
				appteach=new AppTeach();
				if(!validateCource.equals("null")) {
					appteach.setCource(Cource.getSelectedItem().toString());
				}
				if(!validateCertification.equals("null")) {
					appteach.setCertification(Certification.getSelectedItem().toString());
				}
				if(!validatePay.equals("null")) {
					appteach.setPay(Pay.getSelectedItem().toString());
				}
				if(!validateTypeScience.equals("null")) {
					appteach.setTypeScience(TypeScience.getSelectedItem().toString());
				}
				if(!validateStatusApp.equals("null")) {
					appteach.setStatusApp(StatusApp.getSelectedItem().toString());
				}
				appteach.setComment(Comment.getText());
				appteach.setYur_ID(yurface.getYur_ID());
				appteach.setPhysfaceList(physfacelist);
				try {
					message=yurfaceappteachdao.insertYurfaceAppTeach(appteach);
					SecretaryYurface.updateFrame();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, message);
			}
			
		});
		setVisible(true);
	}
	
	public void createComboBoxes() throws ClientProtocolException, IOException {
		ArrayList<Cource> courcelist=courcedao.getCourceList();
		ArrayList<Pay> paylist=paydao.getPayList();
		ArrayList<TypeScience> typelist=typedao.getTypeScienceList();
		ArrayList<StatusApp> statusapplist=statusappdao.getStatusAppList();
		Dimension size=new Dimension(20, 20);
		Cource.setPreferredSize(size);
		Certification.setPreferredSize(size);
		Pay.setPreferredSize(size);
		TypeScience.setPreferredSize(size);
		StatusApp.setPreferredSize(size);
		for(Cource cource : courcelist) {
			Cource.addItem(cource.getCource());
		}
		Certification.addItem("Да");
		Certification.addItem("Нет");
		for(Pay pay : paylist) {
			Pay.addItem(pay.getPay());
		}
		for(TypeScience type : typelist) {
			TypeScience.addItem(type.getTypeScience());
		}
		for(StatusApp statusapp : statusapplist) {
			StatusApp.addItem(statusapp.getStatusApp());
		}
	}
	
	public static void updateFrame() {
		NewPhysfaceList.model=new PhysfaceListTableModel(NewPhysfaceList.physfacelist);
		NewPhysfaceList.table.setModel(NewPhysfaceList.model);
		NewPhysfaceList.table.updateUI();
	}

}
