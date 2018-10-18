package view;

import java.awt.BorderLayout;
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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import com.toedter.calendar.JDateChooser;

import logic.dao.ContractOrderYurfaceDAO;
import logic.dao.CourceDAO;
import logic.dao.OrderAdmissionYurfaceDAO;
import logic.dao.StatusOrderDAO;
import logic.dao.TeacherDAO;
import logic.entity.ContractOrderYurface;
import logic.entity.Cource;
import logic.entity.StatusOrder;
import logic.entity.Teacher;

public class MetodOrderAdmissionYurface extends JPanel {
	private JLabel HeaderText=new JLabel("Выборка по:");
	private JLabel BeginText=new JLabel("с");
	private JLabel EndText=new JLabel("по");
	private JLabel ContractText=new JLabel("№ договора");
	private JComboBox Contract=new JComboBox();
	private JCheckBox ContractCheck=new JCheckBox();
	private JLabel CourceText=new JLabel("Курс");
	private JComboBox Cource=new JComboBox();
	private JCheckBox CourceCheck=new JCheckBox();
	private JLabel DateBeginText=new JLabel("Дата начала обучения");
	private JDateChooser DateBeginFirst=new JDateChooser();
	private JDateChooser DateBeginSecond=new JDateChooser();
	private JCheckBox DateBeginCheck=new JCheckBox();
	private JLabel DateEndText=new JLabel("Дата окончания обучения");
	private JDateChooser DateEndFirst=new JDateChooser();
	private JDateChooser DateEndSecond=new JDateChooser();
	private JCheckBox DateEndCheck=new JCheckBox();
	private JLabel TeacherText=new JLabel("Преподаватель");
	private JComboBox Teacher=new JComboBox();
	private JCheckBox TeacherCheck=new JCheckBox();
	private JLabel StatusOrderText=new JLabel("Статус приказа");
	private JComboBox StatusOrder=new JComboBox();
	private JCheckBox StatusCheck=new JCheckBox();
	private JPanel paramPanel;
	private JPanel buttonParamPanel;
	private JPanel samples;
	private JPanel view;
	private JPanel buttonPanel;
	private JPanel dateBeginPanel;
	private JPanel dateEndPanel;
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private JButton newAdmission=new JButton("Добавить приказ");
	private JButton updateAdmission=new JButton("Редактиоровать");
	private JButton deleteAdmission=new JButton("Удалить");
	private TableModel orderModel;
	private JTable orderTable;
	private JScrollPane orderJsp;
	private ContractOrderYurfaceDAO contractdao=new ContractOrderYurfaceDAO();
	private CourceDAO courcedao=new CourceDAO();
	private TeacherDAO teacherdao=new TeacherDAO();
	private StatusOrderDAO statusdao=new StatusOrderDAO();
	private OrderAdmissionYurfaceDAO orderdao=new OrderAdmissionYurfaceDAO();
	private Map<String, String> parameters=new LinkedHashMap<String, String>();
	
	public MetodOrderAdmissionYurface() throws ClientProtocolException, IOException {
		setSize(300, 300);
		setLayout(new BorderLayout());
		updateAdmission.setEnabled(false);
		deleteAdmission.setEnabled(false);
		samples=new JPanel();
		samples.setLayout(new BorderLayout());
		paramPanel=new JPanel();
		paramPanel.setLayout(new GridBagLayout());
		buttonParamPanel=new JPanel();
		buttonParamPanel.setLayout(new GridBagLayout());
		view=new JPanel();
		view.setLayout(new BorderLayout());
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		orderModel=new OrderAdmissionYurfaceTableModel(orderdao.getOrderList());
		orderTable=new JTable(orderModel);
		orderJsp=new JScrollPane(orderTable);
		buttonParamPanel.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonParamPanel.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateBeginPanel=new JPanel();
	    dateBeginPanel.setLayout(new GridBagLayout());
	    dateBeginPanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateBeginPanel.add(DateBeginFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateBeginPanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateBeginPanel.add(DateBeginSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateEndPanel=new JPanel();
	    dateEndPanel.setLayout(new GridBagLayout());
	    dateEndPanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateEndPanel.add(DateEndFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateEndPanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    dateEndPanel.add(DateEndSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(HeaderText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(ContractText, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(ContractCheck, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Contract, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(CourceText, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(CourceCheck, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Cource, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(DateBeginText, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(DateBeginCheck, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(dateBeginPanel, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(DateEndText, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(DateEndCheck, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(dateEndPanel, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(TeacherText, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(TeacherCheck, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Teacher, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(StatusOrderText, new GridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(StatusCheck, new GridBagConstraints(0, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(StatusOrder, new GridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonPanel.add(newAdmission, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonPanel.add(updateAdmission, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonPanel.add(deleteAdmission, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    samples.add(paramPanel, BorderLayout.NORTH);
	    samples.add(buttonParamPanel, BorderLayout.SOUTH);
	    Dimension size=new Dimension(50, 20);
	    Contract.setPreferredSize(size);
	    Cource.setPreferredSize(size);
	    Teacher.setPreferredSize(size);
	    createSamples();
	    ContractCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Contract.setEnabled(true);
				} else {
					Contract.setEnabled(false);
				}
				
			}
	    	
	    });
	    CourceCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Cource.setEnabled(true);
				} else {
					Cource.setEnabled(false);
				}
				
			}
	    	
	    });
	    DateBeginCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					DateBeginFirst.setEnabled(true);
					DateBeginSecond.setEnabled(true);
				} else {
					DateBeginFirst.setEnabled(false);
					DateBeginSecond.setEnabled(false);
				}
				
			}
	    	
	    });
	    DateEndCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					DateEndFirst.setEnabled(true);
					DateEndSecond.setEnabled(true);
				} else {
					DateEndFirst.setEnabled(false);
					DateEndSecond.setEnabled(false);
				}
				
			}
	    	
	    });
	    TeacherCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Teacher.setEnabled(true);
				} else {
					Teacher.setEnabled(false);
				}
				
			}
	    	
	    });
	    StatusCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					StatusOrder.setEnabled(true);
				} else {
					StatusOrder.setEnabled(false);
				}
				
			}
	    	
	    });
	    ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameters.clear();
				String str="";
				if(ContractCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="ContractsOrdersYurfaces_ID="+Contract.getSelectedItem();
					} else {
						str=" AND ContractsOrdersYurfaces_ID="+Contract.getSelectedItem();
					}
					parameters.put("ContractYurface", str);
				}
				if(CourceCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Cource='"+Cource.getSelectedItem().toString()+"'";
					} else {
						str=" AND Cource='"+Cource.getSelectedItem().toString()+"'";
					}
				}
				if(DateBeginCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(DateBeginFirst.getDate().toString()!="") {
							Date ubegindate=DateBeginFirst.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateBeginScience>='"+sbegindate+"'";
						}
						if(DateBeginSecond.getDate().toString()!="") {
							Date uenddate=DateBeginSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							if(str!="") {
							   str+=" AND DateBeginScience<='"+senddate+"'";
							} else {
								str="DateBeginScience<='"+senddate+"'";
							}
						}
					} else {
						if(DateBeginFirst.getDate().toString()!="") {
							Date ubegindate=DateBeginFirst.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateBeginScience>='"+sbegindate+"'";
						}
						if(DateBeginSecond.getDate().toString()!="") {
							Date uenddate=DateBeginSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							str+=" AND DateBeginScience<='"+senddate+"'";
						}
					}
					parameters.put("DateBeginScience", str);
					str="";
				}
				if(DateEndCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(DateEndFirst.getDate().toString()!="") {
							Date ubegindate=DateEndFirst.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateEndScience>='"+sbegindate+"'";
						}
						if(DateEndSecond.getDate().toString()!="") {
							Date uenddate=DateEndSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							if(str!="") {
							   str+=" AND DateEndScience<='"+senddate+"'";
							} else {
								str="DateEndScience<='"+senddate+"'";
							}
						}
					} else {
						if(DateEndFirst.getDate().toString()!="") {
							Date ubegindate=DateEndFirst.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateEndScience>='"+sbegindate+"'";
						}
						if(DateEndSecond.getDate().toString()!="") {
							Date uenddate=DateEndSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							str+=" AND DateEndScience<='"+senddate+"'";
						}
					}
					parameters.put("DateEndScience", str);
					str="";
				}
				
				
			}
	    	
	    });
	    view.add(orderJsp);
	    view.add(buttonPanel, BorderLayout.SOUTH);
	    add(samples, BorderLayout.WEST);
	    add(view, BorderLayout.CENTER);
	}
	
	private void createSamples() throws ClientProtocolException, IOException {
		for(ContractOrderYurface contract : contractdao.getContractYurfaceList()) {
			Contract.addItem(contract.getContractsOrdersYurfaces_ID());
		}
		
		for(Cource cource : courcedao.getCourceList()) {
			Cource.addItem(cource.getCource());
		}
		
		for(Teacher teacher : teacherdao.getTeacherList()) {
			Teacher.addItem(teacher.getTeacher());
		}
		
		for(StatusOrder status : statusdao.getStatusList()) {
			StatusOrder.addItem(status.getStatusOrder());
		}
		
		Contract.setEnabled(false);
		Cource.setEnabled(false);
		DateBeginFirst.setEnabled(false);
		DateBeginSecond.setEnabled(false);
		DateEndFirst.setEnabled(false);
		DateEndSecond.setEnabled(false);
		Teacher.setEnabled(false);
		StatusOrder.setEnabled(false);
	}

}
