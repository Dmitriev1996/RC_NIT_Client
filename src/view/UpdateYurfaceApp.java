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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import logic.dao.CourceDAO;
import logic.dao.GroupAppDAO;
import logic.dao.PayDAO;
import logic.dao.PhysfaceDAO;
import logic.dao.StatusAppDAO;
import logic.dao.TypeScienceDAO;
import logic.dao.YurfaceAppTeachDAO;
import logic.entity.AppTeach;
import logic.entity.Cource;
import logic.entity.GroupApp;
import logic.entity.Pay;
import logic.entity.Physface;
import logic.entity.PhysfaceRow;
import logic.entity.StatusApp;
import logic.entity.TypeScience;
import logic.entity.Yurface;

public class UpdateYurfaceApp extends JFrame{
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
	public static JTable phystable;
	public static JTable yurtable;
	public static TableModel physmodel;
	public static TableModel yurmodel;
	private JScrollPane physjsp;
	private JScrollPane yurjsp;
	private JButton updateYurface=new JButton("Редактировать");
	private JButton updatePhysface=new JButton("Редактировать");
	private JButton deletePhysface=new JButton("Удалить");
	private JButton newPhysface=new JButton("Добавить");
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private JPanel editPanel;
	private JPanel physButtonPanel;
	private JPanel yurButtonPanel;
	private JPanel mainButtonPanel;
	private Yurface yurface;
	public static ArrayList<Physface> physfacelist;
	private static ArrayList<Yurface> yurfacelist;
	private CourceDAO courcedao;
	private PayDAO paydao;
	private TypeScienceDAO typedao;
	private StatusAppDAO statusappdao;
	private PhysfaceDAO physfacedao;
	private GroupAppDAO groupappdao;
	private YurfaceAppTeachDAO appteachdao=new YurfaceAppTeachDAO();
	
	public static ArrayList<PhysfaceRow> updatePhysfaceList;
	
	public UpdateYurfaceApp(AppTeach appteach) throws ClientProtocolException, IOException {
		yurface=appteach.getYurface();
		System.out.println(yurface.getNameOrganization());
		physfacedao=new PhysfaceDAO();
		groupappdao=new GroupAppDAO();
		updatePhysfaceList=new ArrayList<PhysfaceRow>();
		courcedao=new CourceDAO();
		paydao=new PayDAO();
		typedao=new TypeScienceDAO();
		statusappdao=new StatusAppDAO();
		yurface=appteach.getYurface();
		physfacelist=appteach.getPhysfaceList();
		yurfacelist=new ArrayList<Yurface>();
		yurfacelist.add(yurface);
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
		Cource.setSelectedItem(appteach.getCource());
		Certification.setSelectedItem(appteach.getCertification());
		Pay.setSelectedItem(appteach.getPay());
		TypeScience.setSelectedItem(appteach.getTypeScience());
		StatusApp.setSelectedItem(appteach.getStatusApp());
		Comment.setText(appteach.getComment());
		contentBox.add(editPanel);
		yurmodel=new OrganizationTableModel(yurfacelist);
		yurtable=new JTable(yurmodel);
		yurjsp=new JScrollPane(yurtable);
		contentBox.add(yurjsp);
		yurButtonPanel=new JPanel();
		yurButtonPanel.setLayout(new GridBagLayout());
		yurButtonPanel.add(updateYurface, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		updateYurface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateYurface(yurface);
			}
			
		});
		contentBox.add(yurButtonPanel);
		updateYurface.setEnabled(false);
		yurtable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateYurface.setEnabled(true);
				
			}
			
		});
		physmodel=new PhysfaceListTableModel(physfacelist);
		phystable=new JTable(physmodel);
		physjsp=new JScrollPane(phystable);
		contentBox.add(physjsp);
		physButtonPanel=new JPanel();
		physButtonPanel.setLayout(new GridBagLayout());
		physButtonPanel.add(newPhysface, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		physButtonPanel.add(updatePhysface, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		physButtonPanel.add(deletePhysface, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		newPhysface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewPhysfaceInGroup();
				
			}
			
		});
		updatePhysface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=phystable.getSelectedRow();
				Physface physface=physfacelist.get(selectedRow);
				new UpdatePhysfaceInGroup(physface, selectedRow);
			}
			
		});
		deletePhysface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=phystable.getSelectedRow();
				Physface physface=physfacelist.get(selectedRow);
				PhysfaceRow physfacerow=new PhysfaceRow();
				physfacerow.setNumRow(selectedRow);
				physfacerow.setStatus("delete");
				physfacerow.setPhysface(physface);
				int i=0;
				String status="";
				
				for(PhysfaceRow entry : updatePhysfaceList) {
					if((entry.getNumRow()==selectedRow)&&(entry.getStatus()!="delete")) {
						i++;
						if(entry.getStatus()=="insert") {
							status="insert";
						}
					}
				}
				if(i==0) {
					updatePhysfaceList.add(physfacerow);
				} else {
					if(status=="insert") {
						updatePhysfaceList.remove(selectedRow);
					} else {
						updatePhysfaceList.remove(selectedRow);
						updatePhysfaceList.add(physfacerow);
					}
				}
				physfacelist.remove(selectedRow);
				updatePhystable();
			}
			
		});
		contentBox.add(physButtonPanel);
		updatePhysface.setEnabled(false);
		deletePhysface.setEnabled(false);
		phystable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updatePhysface.setEnabled(true);
				deletePhysface.setEnabled(true);
				
			}
			
		});
		mainButtonPanel=new JPanel();
		mainButtonPanel.setLayout(new GridBagLayout());
		mainButtonPanel.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		mainButtonPanel.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String validateCource=Cource.getSelectedItem()+"";
				String validateCertification=Certification.getSelectedItem()+"";
			    String validatePay=Pay.getSelectedItem()+"";
			    String validateTypeScience=TypeScience.getSelectedItem()+"";
			    String validateStatusApp=StatusApp.getSelectedItem()+"";
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
				try {
					String message=appteachdao.updateYurfaceAppTeach(appteach);
					System.out.println(message);
				} catch (ClientProtocolException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				GroupApp groupapp=new GroupApp();
				groupapp.setAppTeach_ID(appteach.getAppTeach_ID());
				groupapp.setYur_ID(yurface.getYur_ID());
				String message="";
				String buffer="";
				int i=0;
				ArrayList<Physface> insertList=new ArrayList<Physface>();
				ArrayList<Physface> updateList=new ArrayList<Physface>();
				ArrayList<Physface> deleteList=new ArrayList<Physface>();
				for(PhysfaceRow entry : updatePhysfaceList) {
					switch(entry.getStatus()) {
					  case "insert":
						  insertList.add(entry.getPhysface());
					  break;
					  case "update":
						  updateList.add(entry.getPhysface());
					  break;
					  case "delete":
						  deleteList.add(entry.getPhysface());
					  break;
					}
				}
				
				if(!insertList.isEmpty()) {
					try {
						groupapp.setPhysfaceList(insertList);
						groupappdao.insertPhysfaceInGroupApp(groupapp);
					} catch (ClientProtocolException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				if(!updateList.isEmpty()) {
					try {
						physfacedao.updatePhysfaceList(updateList);
					} catch (ClientProtocolException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				if(!deleteList.isEmpty()) {
					try {
						physfacedao.deletePhysfaceList(deleteList);
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
		contentBox.add(mainButtonPanel);
		add(contentBox, BorderLayout.CENTER);
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
	
	public static void setYurfaceList(ArrayList<Yurface> list) {
		yurfacelist=list;
	}
	
	public static void UpdateFrame() {
		yurmodel=new OrganizationTableModel(yurfacelist);
		yurtable.setModel(yurmodel);
		yurtable.updateUI();
	}
	
	public static void updatePhystable() {
		physmodel=new PhysfaceListTableModel(physfacelist);
		phystable.setModel(physmodel);
		phystable.updateUI();
	}

}
