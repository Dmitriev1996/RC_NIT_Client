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

import logic.dao.ContractOrderPhysfaceDAO;
import logic.dao.ReportGenerator;
import logic.entity.ContractOrderPhysface;
import logic.entity.Physface;

public class EconomPhysfaceContract extends JPanel {
	public static JTable table;
	private JScrollPane jsp;
	public static TableModel model;
	private static ContractOrderPhysfaceDAO contractphysfacedao;
	private JLabel HeaderText=new JLabel("Выборка по:");
	private JLabel BeginText=new JLabel("с");
	private JLabel EndText=new JLabel("по");
	private JLabel DateContractText=new JLabel("Дата договора");
	private JDateChooser DateContractBegin=new JDateChooser();
	private JDateChooser DateContractEnd=new JDateChooser();
	private JCheckBox DateContractCheck=new JCheckBox();
	private JLabel FIOText=new JLabel("ФИО");
	private JComboBox FIO=new JComboBox();
	private JCheckBox FIOCheck=new JCheckBox();
	private JLabel CourceText=new JLabel("Курс");
	private JComboBox Cource=new JComboBox();
	private JCheckBox CourceCheck=new JCheckBox();
	private JLabel NumberText=new JLabel("Колчество");
	private JComboBox Number=new JComboBox();
	private JCheckBox NumberCheck=new JCheckBox();
	private JLabel PriceText=new JLabel("Стоимость");
	private JTextField PriceBegin=new JTextField(5);
	private JTextField PriceEnd=new JTextField(5);
	private JCheckBox PriceCheck=new JCheckBox();
	private JLabel DatePayText=new JLabel("Дата оплаты");
	private JDateChooser DatePayBegin=new JDateChooser();
	private JDateChooser DatePayEnd=new JDateChooser();
	private JCheckBox DatePayCheck=new JCheckBox();
	private JLabel NumberTicketText=new JLabel("№ квитанции");
	private JTextField NumberTicketBegin=new JTextField(5);
	private JTextField NumberTicketEnd=new JTextField(5);
	private JCheckBox NumberTicketCheck=new JCheckBox();
	private JLabel DetailText=new JLabel("Реквизиты");
	private JComboBox Detail=new JComboBox();
	private JCheckBox DetailCheck=new JCheckBox();
	private JLabel CommentText=new JLabel("Примечание");
	private JComboBox Comment=new JComboBox();
	private JCheckBox CommentCheck=new JCheckBox();
	private JLabel CloseContractText=new JLabel("Договор закрыт");
	private JLabel YesText=new JLabel("да");
	private JLabel NoText=new JLabel("нет");
	private JCheckBox CloseYes=new JCheckBox();
	private JCheckBox CloseNo=new JCheckBox();
	private JCheckBox CloseContractCheck=new JCheckBox();
	private Map<String, String> parameters=new LinkedHashMap<String, String>();
	private JButton ok=new JButton("ОК");
	private JButton cancel=new JButton("Отмена");
	private JButton newReport=new JButton("Создать отчёт");
	
	public EconomPhysfaceContract() throws ClientProtocolException, IOException {
		   setSize(800, 600);
		   setLayout(new BorderLayout());
		   JPanel samples=new JPanel();
		   JPanel view=new JPanel();
		   JPanel buttonpanel=new JPanel();
		   contractphysfacedao=new ContractOrderPhysfaceDAO();
		   model=new ContractPhysfaceTableModel(contractphysfacedao.getContractPhysfaceList());
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
		   JPanel datecontractpanel=new JPanel();
		   datecontractpanel.setLayout(new GridBagLayout());
		   datecontractpanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   datecontractpanel.add(DateContractBegin, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   datecontractpanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   datecontractpanel.add(DateContractEnd, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
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
		   JPanel ticketpanel=new JPanel();
		   ticketpanel.setLayout(new GridBagLayout());
		   ticketpanel.add(NumberTicketBegin, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   ticketpanel.add(NumberTicketEnd, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   JPanel closepanel=new JPanel();
		   closepanel.setLayout(new GridBagLayout());
		   closepanel.add(YesText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   closepanel.add(CloseYes, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   closepanel.add(NoText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   closepanel.add(CloseNo, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.setLayout(new GridBagLayout());
		   samples.setLayout(new BorderLayout());
		   params.add(HeaderText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DateContractText, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DateContractCheck, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(datecontractpanel, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(FIOText, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(FIOCheck, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(FIO, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CourceText, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CourceCheck, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Cource, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(NumberText, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(NumberCheck, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Number, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
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
		   params.add(NumberTicketText, new GridBagConstraints(1, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(NumberTicketCheck, new GridBagConstraints(0, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(ticketpanel, new GridBagConstraints(1, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DetailText, new GridBagConstraints(1, 15, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DetailCheck, new GridBagConstraints(0, 16, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Detail, new GridBagConstraints(1, 16, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CommentText, new GridBagConstraints(1, 17, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CommentCheck, new GridBagConstraints(0, 18, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Comment, new GridBagConstraints(1, 18, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CloseContractText, new GridBagConstraints(1, 19, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CloseContractCheck, new GridBagConstraints(0, 20, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(closepanel, new GridBagConstraints(1, 20, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   Dimension size=new Dimension(50, 20);
		   FIO.setPreferredSize(size);
		   Cource.setPreferredSize(size);
		   Comment.setPreferredSize(size);
		   createSamples();
		   DateContractCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					DateContractBegin.setEnabled(true);
					DateContractEnd.setEnabled(true);
				} else {
					DateContractBegin.setEnabled(false);
					DateContractEnd.setEnabled(false);
				}
				
			}
			   
		   });
		   
		   FIOCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					FIO.setEnabled(true);
				} else {
					FIO.setEnabled(false);
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
		   
		   NumberCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Number.setEnabled(true);
				} else {
					Number.setEnabled(false);
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
		   
		   NumberTicketCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					NumberTicketBegin.setEnabled(true);
					NumberTicketEnd.setEnabled(true);
				} else {
					NumberTicketBegin.setEnabled(false);
					NumberTicketEnd.setEnabled(false);
				}
				
			}
			   
		   });
		   
		   DetailCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Detail.setEnabled(true);
				} else {
					Detail.setEnabled(false);
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
		   
		   CloseContractCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					CloseYes.setEnabled(true);
					CloseNo.setEnabled(true);
				} else {
					CloseYes.setEnabled(false);
					CloseNo.setEnabled(false);
				}
				
			}
			   
		   });
		   ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameters.clear();
				String str="";
				if(DateContractCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(DateContractBegin.getDate().toString()!="") {
							Date ubegindate=DateContractBegin.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateContract>='"+sbegindate+"'";
						}
						if(DateContractEnd.getDate().toString()!="") {
							Date uenddate=DateContractEnd.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							if(str!="") {
							   str+=" AND DateContract<='"+senddate+"'";
							} else {
								str="DateContract<='"+senddate+"'";
							}
						}
					} else {
						if(DateContractBegin.getDate().toString()!="") {
							Date ubegindate=DateContractBegin.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateContract>='"+sbegindate+"'";
						}
						if(DateContractEnd.getDate().toString()!="") {
							Date uenddate=DateContractEnd.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							str+=" AND DateContract<='"+senddate+"'";
						}
					}
					parameters.put("DateContract", str);
					str="";
				}
				
				if(FIOCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="FIO='"+FIO.getSelectedItem().toString()+"'";
					} else {
						str=" AND FIO='"+FIO.getSelectedItem().toString()+"'";
					}
					parameters.put("FIO", str);
					str="";
				}
				
				if(CourceCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Cource='"+Cource.getSelectedItem().toString()+"'";
					} else {
						str=" AND Cource='"+Cource.getSelectedItem().toString()+"'";
					}
					parameters.put("Cource", str);
					str="";
				}
				
				if(NumberCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Number="+Number.getSelectedItem().toString()+"'";
					} else {
						str=" AND Number="+Number.getSelectedItem().toString()+"'";
					}
					parameters.put("Number", str);
					str="";
				}
				
				if(PriceCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(PriceBegin.getText()!="") {
						  str="Price>="+PriceBegin.getText();
						}
						if(PriceEnd.getText()!="") {
							if(str!="") {
								str+=" AND Price<="+PriceEnd.getText();
							} else {
								str+="Price<="+PriceEnd.getText();
							}
						}
					} else {
						if(PriceBegin.getText()!="") {
							str="AND Price>="+PriceBegin.getText();
						}
						if(PriceEnd.getText()!="") {
							str+="AND Price<="+PriceEnd.getText();
						}
					}
					parameters.put("Price", str);
					str="";
				}
				
				if(DatePayCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(DatePayBegin.getDate().toString()!="") {
							Date ubegindate=DatePayBegin.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DatePay>='"+sbegindate+"'";
						}
						if(DatePayEnd.getDate().toString()!="") {
							Date uenddate=DatePayEnd.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							if(str!="") {
								str+=" AND DatePay<='"+senddate+"'";
							} else {
								str+="DatePay<='"+senddate+"'";
							}
						}
					} else {
						if(DatePayBegin.getDate().toString()!="") {
							Date ubegindate=DatePayBegin.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str=" AND DatePay>='"+sbegindate+"'";
						}
						if(DatePayEnd.getDate().toString()!="") {
							Date uenddate=DatePayEnd.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
						    str+=" AND DatePay<='"+senddate+"'";
						}
					}
					parameters.put("DatePay", str);
					str="";
				}
				
				if(NumberTicketCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(NumberTicketBegin.getText()!="") {
							str="NumberTicket>="+NumberTicketBegin.getText();
						}
						if(NumberTicketEnd.getText()!="") {
							if(str!="") {
								str+=" AND NumberTicket<="+NumberTicketEnd.getText();
							} else {
								str+="NumberTicket<="+NumberTicketEnd.getText();
							}
						}
					}
					parameters.put("NumberTicket", str);
					str="";
				}
				
				if(DetailCheck.isSelected()) {
					if(parameters.isEmpty()){
						str="DetailsContract='"+Detail.getSelectedItem().toString()+"'";
					} else {
						str=" AND DetailsContract='"+Detail.getSelectedItem().toString()+"'";
					}
					parameters.put("DetailsContract", str);
					str="";
				}
				
				if(CommentCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Comment='"+Comment.getSelectedItem().toString()+"'";
					} else {
						str=" AND Comment='"+Comment.getSelectedItem().toString()+"'";
					}
				}
				
				if(CloseContractCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(CloseYes.isSelected()) {
							str="CloseContract="+1;
						} else if(CloseNo.isSelected()) {
							str="CloseContract="+0;
						}
					} else {
						if(CloseYes.isSelected()) {
							str=" AND CloseContract="+1;
						} else if(CloseNo.isSelected()) {
							str=" AND CloseContract="+0;
						}
					}
					
					parameters.put("CloseContract", str);
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
				//System.out.println(createStringParameters());
			}
		   });
		   view.setLayout(new BorderLayout());
		   buttonpanel.setLayout(new GridBagLayout());
		   samples.add(params, BorderLayout.NORTH);
		   samples.add(buttonsparam, BorderLayout.SOUTH);
		   view.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		   view.add(jsp);
		   add(samples, BorderLayout.WEST);
		   JButton newContract=new JButton("Новый договор");
		   JButton updateContract=new JButton("Редактировать");
		   updateContract.setEnabled(false);
		   JButton deleteContract=new JButton("Удалить");
		   deleteContract.setEnabled(false);
		   JButton newTicket=new JButton("Новая квитанция");
		   newTicket.setEnabled(false);
		   table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateContract.setEnabled(true);
				deleteContract.setEnabled(true);
				newTicket.setEnabled(true);
				
			}
			   
		   });
		   newContract.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new NewContractPhysface();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			   
		   });
		   updateContract.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				ContractOrderPhysface contract;
				try {
					contract=contractphysfacedao.getContractOrderPhysfaceById(id);
					Physface physface=contract.getPhysface();
					new UpdateContractPhysface(contract);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			   
		   });
		   newReport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    ReportGenerator generator=new ReportGenerator();
			    try {
					generator.generateReport(contractphysfacedao.getContractPhysfaceList());
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			   
		   });
		   buttonpanel.setLayout(new GridBagLayout());
		   buttonpanel.add(newContract, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   buttonpanel.add(updateContract, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   buttonpanel.add(deleteContract, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   buttonpanel.add(newTicket, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   buttonpanel.add(newReport, new GridBagConstraints(4, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   view.add(buttonpanel, BorderLayout.SOUTH);
		   add(view, BorderLayout.CENTER);
		   
	}
	
	public void createSamples() throws ClientProtocolException, IOException {
		ArrayList<ContractOrderPhysface> contractlist=contractphysfacedao.getContractPhysfaceList();
		for(ContractOrderPhysface contract : contractlist) {
			FIO.addItem(contract.getFIO());
			Cource.addItem(contract.getCource());
			Comment.addItem(contract.getComment());
			Detail.addItem(contract.getDetailsContract());
		}
		DateContractBegin.setEnabled(false);
		DateContractEnd.setEnabled(false);
		FIO.setEnabled(false);
		Cource.setEnabled(false);
		Number.setEnabled(false);
		PriceBegin.setEnabled(false);
		PriceEnd.setEnabled(false);
		DatePayBegin.setEnabled(false);
		DatePayEnd.setEnabled(false);
		NumberTicketBegin.setEnabled(false);
		NumberTicketEnd.setEnabled(false);
		Detail.setEnabled(false);
		Comment.setEnabled(false);
		CloseYes.setEnabled(false);
		CloseNo.setEnabled(false);
	}
	
	public String createStringParameters() {
		String str="";
		for(Map.Entry entry : parameters.entrySet()) {
			str+=entry.getValue();
		}
		return str;
	}
	
	public static void updateFrame() throws ClientProtocolException, IOException {
		EconomPhysfaceContract.model=new ContractPhysfaceTableModel(contractphysfacedao.getContractPhysfaceList());
		EconomPhysfaceContract.table.setModel(EconomPhysfaceContract.model);
		EconomPhysfaceContract.table.updateUI();
	}
	
	public static void updateAtParams(String params) throws ClientProtocolException, IOException {
		EconomPhysfaceContract.model=new ContractPhysfaceTableModel(contractphysfacedao.getContractPhysfaceListAtParams(params));
		EconomPhysfaceContract.table.setModel(EconomPhysfaceContract.model);
		EconomPhysfaceContract.table.updateUI();
	}

}
