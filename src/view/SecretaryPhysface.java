package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import logic.dao.CourceDAO;
import logic.dao.PayDAO;
import logic.dao.PhysfaceAppTeachDAO;
import logic.dao.StatusAppDAO;
import logic.dao.TypeScienceDAO;
import logic.entity.AppTeach;
import logic.entity.Cource;
import logic.entity.Pay;
import logic.entity.StatusApp;
import logic.entity.TypeScience;

public class SecretaryPhysface extends JPanel {
	public static JTable table;
	private JScrollPane jsp;
	private static PhysfaceAppTeachDAO physfacedao=new PhysfaceAppTeachDAO();
	private CourceDAO courcedao=new CourceDAO();
	private PayDAO paydao=new PayDAO();
	private TypeScienceDAO typedao=new TypeScienceDAO();
	private StatusAppDAO statusappdao=new StatusAppDAO();
	public static TableModel model;
	private JLabel HeaderText=new JLabel("Выборка по:");
	private JLabel FIOText=new JLabel("ФИО");
	private JComboBox FIO=new JComboBox();
	private JCheckBox FIOCheck=new JCheckBox();
	private JLabel CourceText=new JLabel("Курс");
	private JComboBox Cource=new JComboBox();
	private JCheckBox CourceCheck=new JCheckBox();
	private JLabel CertificationText=new JLabel("Выдача удостоверения");
	private JCheckBox CertificationCheck=new JCheckBox();
	private JComboBox Certification=new JComboBox();
	private JLabel PayText=new JLabel("Оплата");
	private JComboBox Pay=new JComboBox();
	private JCheckBox PayCheck=new JCheckBox();
	private JLabel TypeScienceText=new JLabel("Тип обучения");
	private JComboBox TypeScience=new JComboBox();
	private JCheckBox TypeScienceCheck=new JCheckBox();
	private JLabel StatusAppText=new JLabel("Статус заявки");
	private JComboBox StatusApp=new JComboBox();
	private JCheckBox StatusAppCheck=new JCheckBox();
	private JLabel CommentText=new JLabel("Примечание");
	private JCheckBox CommentCheck=new JCheckBox();
	private JComboBox Comment=new JComboBox();
	private JPanel buttonpanel=new JPanel();
	private JPanel samples=new JPanel();
	private JPanel view=new JPanel();
	private JPanel params=new JPanel();
	private JPanel buttonsparam=new JPanel();
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private JButton newApp=new JButton("Новая заявка");
	private JButton update=new JButton("Редатировать");
	private JButton delete=new JButton("Удалить");
	
	private Map<String, String> parameters=new LinkedHashMap<String, String>();
	private String str="";
	
	public SecretaryPhysface() throws ClientProtocolException, IOException {
	   createGUI();
	   createActions();
	}
	
	private void createGUI() throws ClientProtocolException, IOException {
		   setSize(800, 600);
		   setLayout(new BorderLayout());
		   model=new PhysfaceAppTableModel(physfacedao.getPhysfaceAppTeachList());
		   table=new JTable();
		   table.setModel(model);
		   jsp=new JScrollPane(table);
		   update.setEnabled(false);
		   delete.setEnabled(false);
		   buttonsparam.setLayout(new GridBagLayout());
		   buttonsparam.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   buttonsparam.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.setLayout(new GridBagLayout());
		   samples.setLayout(new BorderLayout());
		   params.add(HeaderText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(FIOText, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(FIOCheck, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(FIO, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CourceText, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CourceCheck, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Cource, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CertificationText, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CertificationCheck, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Certification, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(PayText, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(PayCheck, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Pay, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(TypeScienceText, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(TypeScienceCheck, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(TypeScience, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(StatusAppText, new GridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(StatusAppCheck, new GridBagConstraints(0, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(StatusApp, new GridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CommentText, new GridBagConstraints(1, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CommentCheck, new GridBagConstraints(0, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Comment, new GridBagConstraints(1, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   Dimension size=new Dimension(50, 20);
		   FIO.setPreferredSize(size);
		   Cource.setPreferredSize(size);
		   Certification.setPreferredSize(size);
		   Pay.setPreferredSize(size);
		   TypeScience.setPreferredSize(size);
		   StatusApp.setPreferredSize(size);
		   Comment.setPreferredSize(size);
		   view.setLayout(new BorderLayout());
		   buttonpanel.setLayout(new GridBagLayout());
		   samples.add(params, BorderLayout.NORTH);
		   samples.add(buttonsparam, BorderLayout.SOUTH);
		   createSamples();
		   view.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		   view.add(jsp);
		   buttonpanel.add(newApp, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   buttonpanel.add(update, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   buttonpanel.add(delete, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   add(samples, BorderLayout.WEST);
		   view.add(buttonpanel, BorderLayout.SOUTH);
		   add(view, BorderLayout.CENTER);
		   
	}
	
	private void createActions() {
		FIOCheck.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent e) {
				   if(e.getStateChange()==1) {
					   FIO.setEnabled(true);
				   } else {
					   FIO.setEnabled(false);
				   }
			   }
		   });
		   CourceCheck.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent e) {
				   if(e.getStateChange()==1) {
					   Cource.setEnabled(true);
				   } else {
					   Cource.setEnabled(false);
				   }
			   }
		   });
		   CertificationCheck.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent e) {
				   if(e.getStateChange()==1) {
					   Certification.setEnabled(true);
				   } else {
					   Certification.setEnabled(false);
				   }
			   }
		   });
		   PayCheck.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent e) {
				  if(e.getStateChange()==1) {
					  Pay.setEnabled(true);
				  } else {
					  Pay.setEnabled(false);
				  }
			   }
		   });
		   TypeScienceCheck.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent e) {
				  if(e.getStateChange()==1) {
					  TypeScience.setEnabled(true);
				  } else {
					  TypeScience.setEnabled(false);
				  }
			   }
		   });
		   StatusAppCheck.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent e) {
				   if(e.getStateChange()==1) {
					   StatusApp.setEnabled(true);
				   } else {
					   StatusApp.setEnabled(false);
				   }
			   }
		   });
		   CommentCheck.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent e) {
				   if(e.getStateChange()==1) {
					   Comment.setEnabled(true);
				   } else {
					   Comment.setEnabled(false);
				   }
			   }
		   });
		   ok.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent ae) {
				parameters.clear();
				String str="";
				if(FIOCheck.isSelected()) {
					   if(parameters.isEmpty()) {
						   str="FIO='"+FIO.getSelectedItem().toString()+"'";
					   } else {
						   str=" AND FIO='"+FIO.getSelectedItem().toString()+"'";
					   }
					   parameters.put("FIO", str);
				}
				if(CourceCheck.isSelected()) {
					if(parameters.isEmpty()) {
						   str="Cource='"+Cource.getSelectedItem().toString()+"'";
					   } else {
						   str=" AND Cource='"+Cource.getSelectedItem().toString()+"'";
					   }
					   parameters.put("Cource", str);
				}
				if(CertificationCheck.isSelected()) {
					String val=Certification.getSelectedItem().toString();
					int id=0;
					if(val=="Да") {
						   id=1;
					   } else if(val=="Нет") {
						   id=0;
					   }
					   if(parameters.isEmpty()) {
						   str="Certification="+id;
					   } else {
						   str=" AND Certification="+id;
					   }
					   parameters.put("Certification", str);
				}
				if(PayCheck.isSelected()) {
					if(parameters.isEmpty()) {
						   str="Pay='"+Pay.getSelectedItem().toString()+"'";
					   } else {
						   str=" AND Pay='"+Pay.getSelectedItem().toString()+"'";
					   }
					   parameters.put("Pay", str);
				}
				if(TypeScienceCheck.isSelected()) {
					if(parameters.isEmpty()) {
						   str="TypeScience='"+TypeScience.getSelectedItem().toString()+"'";
					   } else {
						   str=" AND TypeScience='"+TypeScience.getSelectedItem().toString()+"'";
					   }
					   parameters.put("TypeScience", str);
				}
				if(StatusAppCheck.isSelected()) {
					if(parameters.isEmpty()) {
						   str="StatusApp='"+StatusApp.getSelectedItem().toString()+"'";
					   } else {
						   str=" AND StatusApp='"+StatusApp.getSelectedItem().toString()+"'";
					   }
					   parameters.put("StatusApp", str);
				}
				if(CommentCheck.isSelected()) {
					if(parameters.isEmpty()) {
						   str="Comment='"+Comment.getSelectedItem().toString()+"'";
					   } else {
						   str=" AND Comment='"+Comment.getSelectedItem().toString()+"'";
					   }
					   parameters.put("Comment", str);
				}
				try {
					updateAtParams(createStringParameters());
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
		   });
		   cancel.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent ae) {
				   FIOCheck.setSelected(false);
				   CourceCheck.setSelected(false);
				   CertificationCheck.setSelected(false);
				   PayCheck.setSelected(false);
				   TypeScienceCheck.setSelected(false);
				   StatusAppCheck.setSelected(false);
				   CommentCheck.setSelected(false);
				   try {
					updateFrame();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
		   });
		   update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
					AppTeach appteach;
					try {
						appteach = physfacedao.getPhysfaceAppTeachById(id);
						new UpdatePhysfaceApp(appteach);
					} catch (ClientProtocolException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
			   
		   });
		   newApp.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   try {
					new NewPhysfaceApp();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   }
		   });
		   delete.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   int selectedRow=table.getSelectedRow();
				   int id=(int)model.getValueAt(selectedRow, 0);
				   try {
					String message=physfacedao.deletePhysfaceAppTeach(id);
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
		   });
		   table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				update.setEnabled(true);
				delete.setEnabled(true);
				
			}
			   
		   });
	}
	
	public static void updateFrame() throws ClientProtocolException, IOException {
		SecretaryPhysface.model=new PhysfaceAppTableModel(SecretaryPhysface.physfacedao.getPhysfaceAppTeachList());
		SecretaryPhysface.table.setModel(SecretaryPhysface.model);
		SecretaryPhysface.table.updateUI();
	}
	
	public static void updateAtParams(String params) throws ClientProtocolException, IOException {
		SecretaryPhysface.model=new PhysfaceAppTableModel(SecretaryPhysface.physfacedao.getPhysfaceAppTeachListAtParams(params));
		SecretaryPhysface.table.setModel(SecretaryPhysface.model);
		SecretaryPhysface.table.updateUI();
	}
	
	public void createSamples() throws ClientProtocolException, IOException {
		ArrayList<AppTeach> physfaceappteachlist=physfacedao.getPhysfaceAppTeachList();
		ArrayList<Cource> courcelist=courcedao.getCourceList();
		ArrayList<Pay> paylist=paydao.getPayList();
		ArrayList<TypeScience> typesciencelist=typedao.getTypeScienceList();
		ArrayList<StatusApp> statusapplist=statusappdao.getStatusAppList();
		for(AppTeach appteach : physfaceappteachlist) {
			FIO.addItem(appteach.getFIO());
			Comment.addItem(appteach.getComment());
		}
		
		for(Cource cource : courcelist) {
			Cource.addItem(cource.getCource());
		}
		
		Certification.addItem("Да");
		Certification.addItem("Нет");
		
		for(Pay pay : paylist) {
			Pay.addItem(pay.getPay());
		}
		
		for(TypeScience typescience : typesciencelist) {
			TypeScience.addItem(typescience.getTypeScience());
		}
		
		for(StatusApp statusapp : statusapplist) {
			StatusApp.addItem(statusapp.getStatusApp());
		}
		FIO.setEnabled(false);
		Cource.setEnabled(false);
		Certification.setEnabled(false);
		Pay.setEnabled(false);
		TypeScience.setEnabled(false);
		StatusApp.setEnabled(false);
		Comment.setEnabled(false);
		
	}
	
	public String createStringParameters() {
		String str="";
		for(Map.Entry entry : parameters.entrySet()) {
			str+=entry.getValue();
		}
		return str;
	}

}
