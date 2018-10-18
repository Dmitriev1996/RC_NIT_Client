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
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import com.toedter.calendar.JDateChooser;

import logic.dao.ActOrderYurfaceDAO;
import logic.entity.ActOrderYurface;

public class EconomYurfaceAct extends JPanel {
	private JLabel HeaderText=new JLabel("Выборка по:");
	private JLabel BeginText=new JLabel("с");
	private JLabel EndText=new JLabel("по");
	private JLabel NumberContractText=new JLabel("№ договора");
	private JCheckBox NumberContractCheck=new JCheckBox();
	private JTextField NumberContractBegin=new JTextField(10);
	private JTextField NumberContractEnd=new JTextField(10);
	private JLabel DateActText=new JLabel("Дата акта");
	private JCheckBox DateActCheck=new JCheckBox();
	private JDateChooser DateActBegin=new JDateChooser();
	private JDateChooser DateActEnd=new JDateChooser();
	private JLabel NameOrganizationText=new JLabel("Наименование организации");
	private JCheckBox NameOrganizationCheck=new JCheckBox();
	private JComboBox NameOrganization=new JComboBox();
	private JLabel WorkText=new JLabel("Наименование услуги");
	private JCheckBox WorkCheck=new JCheckBox();
	private JComboBox Work=new JComboBox();
	private JLabel PriceText=new JLabel("Сумма");
	private JCheckBox PriceCheck=new JCheckBox();
	private JTextField PriceBegin=new JTextField(10);
	private JTextField PriceEnd=new JTextField(10);
	private JLabel DatePayText=new JLabel("Дата оплаты");
	private JCheckBox DatePayCheck=new JCheckBox();
	private JDateChooser DatePayBegin=new JDateChooser();
	private JDateChooser DatePayEnd=new JDateChooser();
	private JLabel ReturnActText=new JLabel("Возврат акта");
	private JCheckBox ReturnActCheck=new JCheckBox();
	private JLabel ReturnYesText=new JLabel("да");
	private JCheckBox ReturnYes=new JCheckBox();
	private JLabel ReturnNoText=new JLabel("нет");
	private JCheckBox ReturnNo=new JCheckBox();
	private JLabel CommentText=new JLabel("Примечание");
	private JCheckBox CommentCheck=new JCheckBox();
	private JComboBox Comment=new JComboBox();
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private static ActOrderYurfaceDAO actyurfacedao;
	private static JTable table;
	private static TableModel model;
	private JScrollPane jsp;
	private Map<String, String> parameters=new LinkedHashMap<String, String>();
	
	public EconomYurfaceAct() throws ClientProtocolException, IOException {
		setSize(800, 600);
		setLayout(new BorderLayout());
		JPanel samples=new JPanel();
		JPanel view=new JPanel();
		JPanel buttonpanel=new JPanel();
		actyurfacedao=new ActOrderYurfaceDAO();
		model=new ActYurfaceTableModel(actyurfacedao.getActYurfaceList());
		table=new JTable();
		table.setModel(model);
		jsp=new JScrollPane(table);
		JPanel params=new JPanel();
		JPanel buttonsparam=new JPanel();
		buttonsparam.setLayout(new GridBagLayout());
		buttonsparam.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
			    GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonsparam.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		JPanel numbercontractpanel=new JPanel();
		numbercontractpanel.setLayout(new GridBagLayout());
		numbercontractpanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		numbercontractpanel.add(NumberContractBegin, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		numbercontractpanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		numbercontractpanel.add(NumberContractEnd, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		JPanel dateactpanel=new JPanel();
		dateactpanel.setLayout(new GridBagLayout());
		dateactpanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateactpanel.add(DateActBegin, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateactpanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateactpanel.add(DateActEnd, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    JPanel pricepanel=new JPanel();
		pricepanel.setLayout(new GridBagLayout());
		pricepanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		pricepanel.add(PriceBegin, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		pricepanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		pricepanel.add(PriceEnd, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		JPanel datepaypanel=new JPanel();
		datepaypanel.setLayout(new GridBagLayout());
		datepaypanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		datepaypanel.add(DatePayBegin, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		datepaypanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		datepaypanel.add(DatePayEnd, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		JPanel returnactpanel=new JPanel();
		returnactpanel.setLayout(new GridBagLayout());
		returnactpanel.add(ReturnYesText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		returnactpanel.add(ReturnYes, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		returnactpanel.add(ReturnNoText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		returnactpanel.add(ReturnNo, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.setLayout(new GridBagLayout());
		samples.setLayout(new BorderLayout());
		params.add(HeaderText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(NumberContractText, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(NumberContractCheck, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(numbercontractpanel, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(DateActText, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(DateActCheck, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(dateactpanel, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(NameOrganizationText, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
			    GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(NameOrganizationCheck, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(NameOrganization, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(WorkText, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(WorkCheck, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(Work, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(PriceText, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(PriceCheck, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(pricepanel, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(DatePayText, new GridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(DatePayCheck, new GridBagConstraints(0, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(datepaypanel, new GridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(ReturnActText, new GridBagConstraints(1, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(ReturnActCheck, new GridBagConstraints(0, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(returnactpanel, new GridBagConstraints(1, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(CommentText, new GridBagConstraints(1, 15, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(CommentCheck, new GridBagConstraints(0, 16, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		params.add(Comment, new GridBagConstraints(1, 16, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		Dimension size=new Dimension(50, 20);
		NameOrganization.setPreferredSize(size);
		Work.setPreferredSize(size);
		//createSamples();
		NumberContractCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					NumberContractBegin.setEnabled(true);
					NumberContractEnd.setEnabled(true);
				} else {
					NumberContractBegin.setEnabled(false);
					NumberContractEnd.setEnabled(false);
				}
				
			}
			
		});
		
		DateActCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
			     if(e.getStateChange()==1) {
			    	 DateActBegin.setEnabled(true);
			    	 DateActEnd.setEnabled(true);
			     } else {
			    	 DateActBegin.setEnabled(false);
			    	 DateActEnd.setEnabled(false);
			     }
				
			}
			
		});
		
		NameOrganizationCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					NameOrganization.setEnabled(true);
				} else {
					NameOrganization.setEnabled(false);
				}
				
			}
			
		});
		
		PriceCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					PriceBegin.setEnabled(true);
					PriceEnd.setEnabled(true);
				} else {
					PriceBegin.setEnabled(false);
					PriceEnd.setEnabled(false);
				}
				
			}
			
		});
		
		DatePayCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					DatePayBegin.setEnabled(true);
					DatePayEnd.setEnabled(true);
				} else {
					DatePayBegin.setEnabled(false);
					DatePayEnd.setEnabled(false);
				}
				
			}
			
		});
		
		ReturnActCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					ReturnYes.setEnabled(true);
					ReturnNo.setEnabled(true);
				} else {
					ReturnYes.setEnabled(false);
					ReturnNo.setEnabled(false);
				}
				
			}
			
		});
		
		CommentCheck.addItemListener(new ItemListener() {

			@Override
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
			public void actionPerformed(ActionEvent e) {
				parameters.clear();
				String str="";
				if(NumberContractCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(NumberContractBegin.getText()!="") {
							str="ContractsOrdersYurfaces_ID>="+NumberContractBegin.getText();
						}
						if(NumberContractEnd.getText()!="") {
							if(str!="") {
								str+=" AND ContractOrdersYurfaces_ID<="+NumberContractEnd.getText();
							} else {
								str="ContractsOrdersYurfaces_ID<="+NumberContractEnd.getText();
							}
						}
					} else {
						if(NumberContractBegin.getText()!="") {
							str="ContractsOrdersYurfaces_ID>="+NumberContractBegin.getText();
						}
						if(NumberContractEnd.getText()!="") {
							str+="AND ContractsOrdersYurfaces_ID<="+NumberContractEnd.getText();
						}
					}
					parameters.put("NumberContract", str);
					str="";
				}
				
				if(DateActCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(DateActBegin.getDate().toString()!="") {
							Date uactbegindate=DateActBegin.getDate();
							java.sql.Date sactbegindate=new java.sql.Date(uactbegindate.getTime());
							str="DateAct>='"+sactbegindate+"'";
						}
						if(DateActEnd.getDate().toString()!="") {
							Date uactenddate=DateActEnd.getDate();
							java.sql.Date sactenddate=new java.sql.Date(uactenddate.getTime());
							if(str!="") {
								str+=" AND DateAct<='"+sactenddate+"'";
							} else {
								str="DateAct<='"+sactenddate+"'";
							}
						}
					} else {
						if(DateActBegin.getDate().toString()!="") {
							Date uactbegindate=DateActBegin.getDate();
							java.sql.Date sactbegindate=new java.sql.Date(uactbegindate.getTime());
							str="DateAct>='"+sactbegindate+"'";
						}
						if(DateActEnd.getDate().toString()!="") {
							Date uactenddate=DateActEnd.getDate();
							java.sql.Date sactenddate=new java.sql.Date(uactenddate.getTime());
						    str+=" AND DateAct<='"+sactenddate+"'";
						}
					}
					parameters.put("DateAct", str);
					str="";
				}
				
				if(NameOrganizationCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="NameOrganization='"+NameOrganization.getSelectedItem().toString()+"'";
					} else {
						str=" AND NameOrganization='"+NameOrganization.getSelectedItem().toString()+"'";
					}
					parameters.put("NameOrganization", str);
					str="";
				}
				
				if(WorkCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Cource='"+Work.getSelectedItem()+"'";
					} else {
						str=" AND Cource='"+Work.getSelectedItem()+"'";
					}
					parameters.put("Work", str);
					str="";
				}
				
				if(PriceCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(PriceBegin.getText()!="") {
							str="Price>="+Double.parseDouble(PriceBegin.getText());
						}
						if(PriceEnd.getText()!="") {
							if(str!="") {
								str+=" AND Price>="+Double.parseDouble(PriceBegin.getText());
							} else {
								str="Price>="+Double.parseDouble(PriceBegin.getText());
							}
						}
					} else {
						if(PriceBegin.getText()!="") {
							str="Price>="+Double.parseDouble(PriceBegin.getText());
						}
						if(PriceEnd.getText()!="") {
							str+=" AND Price>="+Double.parseDouble(PriceBegin.getText());
						}
					}
					parameters.put("Price", str);
					str="";
				}
				
				if(DatePayCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(DatePayBegin.getDate().toString()!="") {
							Date udatepaybegin=DatePayBegin.getDate();
							java.sql.Date sudatepaybegin=new java.sql.Date(udatepaybegin.getTime());
							str="DatePay>='"+sudatepaybegin+"'";
						}
						if(DatePayEnd.getDate().toString()!="") {
							Date udatepayend=DatePayEnd.getDate();
							java.sql.Date sudatepayend=new java.sql.Date(udatepayend.getTime());
							if(str!="") {
								str+=" AND DatePay<='"+sudatepayend+"'";
							} else {
								str="DatePay<='"+sudatepayend+"'";
							}
						}
					} else {
						if(DatePayBegin.getDate().toString()!="") {
							Date udatepaybegin=DatePayBegin.getDate();
							java.sql.Date sudatepaybegin=new java.sql.Date(udatepaybegin.getTime());
							str="DatePay>='"+sudatepaybegin+"'";
						}
						if(DatePayEnd.getDate().toString()!="") {
							Date udatepayend=DatePayEnd.getDate();
							java.sql.Date sudatepayend=new java.sql.Date(udatepayend.getTime());
							str+=" AND DatePay<='"+sudatepayend+"'";
						}
					}
					parameters.put("DatePay", str);
					str="";
				}
				
				if(CommentCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Comment='"+Comment.getSelectedItem().toString()+"'";
					} else {
						str=" AND Comment='"+Comment.getSelectedItem().toString()+"'";
					}
				}
				
				if(ReturnActCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(ReturnYes.isSelected()) {
							str="CloseContract="+1;
						} else if(ReturnNo.isSelected()) {
							str="CloseContract="+0;
						}
					} else {
						if(ReturnYes.isSelected()) {
							str=" AND CloseContract="+1;
						} else if(ReturnNo.isSelected()) {
							str=" AND CloseContract="+0;
						}
					}
					parameters.put("ReturnAct", str);
					str="";
				}
				try {
					updateAtParams(createStringParameters());
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		view.setLayout(new BorderLayout());
		buttonpanel.setLayout(new GridBagLayout());
		samples.add(params, BorderLayout.NORTH);
		samples.add(buttonsparam, BorderLayout.SOUTH);
		view.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		view.add(jsp);
		add(samples, BorderLayout.WEST);
		JButton newAct=new JButton("Новый акт");
		JButton updateAct=new JButton("Редактировать");
		JButton deleteAct=new JButton("Удалить");
		JButton newTicket=new JButton("Новая квитанция");
		updateAct.setEnabled(false);
		deleteAct.setEnabled(false);
		newTicket.setEnabled(false);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateAct.setEnabled(true);
				deleteAct.setEnabled(true);
				newTicket.setEnabled(true);
				
			}
			   
		   });
		newAct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new NewActYurface();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		updateAct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				System.out.println(id);
				try {
					ActOrderYurface act=actyurfacedao.getActOrderYurfaceById(id);
					System.out.println(act.getActsOrdersYurface_ID());
					new UpdateActYurface(actyurfacedao.getActOrderYurfaceById(id));
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		deleteAct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new DeleteActYurface();
				
			}
			
		});
		buttonpanel.setLayout(new GridBagLayout());
		buttonpanel.add(newAct, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonpanel.add(updateAct, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonpanel.add(deleteAct, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonpanel.add(newTicket, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		view.add(buttonpanel, BorderLayout.SOUTH);
		add(view, BorderLayout.CENTER);
		
		
		
	}
	
	public String createStringParameters() {
		String str="";
		for(Map.Entry entry : parameters.entrySet()) {
			str+=entry.getValue();
		}
		return str;
	}
	
	public static void updateAtParams(String params) throws ClientProtocolException, IOException {
		model=new ActYurfaceTableModel(actyurfacedao.getActYurfaceListAtParams(params));
		table.setModel(model);
		table.updateUI();
	}
	
	public static void updateFrame() throws ClientProtocolException, IOException {
		model=new ActYurfaceTableModel(actyurfacedao.getActYurfaceList());
		table.setModel(model);
		table.updateUI();
	}

   
		

}
