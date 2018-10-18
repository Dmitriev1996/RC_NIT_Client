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
import logic.dao.ContractOrderYurfaceDAO;
import logic.entity.ContractOrderYurface;

public class EconomYurfaceContract extends JPanel {
	public static JTable table;
	private JScrollPane jsp;
	private static TableModel model;
	private static ContractOrderPhysfaceDAO contractphysfacedao;
	private JLabel HeaderText=new JLabel("Выборка по:");
	private JLabel BeginText=new JLabel("с");
	private JLabel EndText=new JLabel("по");
	private JLabel DateContractText=new JLabel("Дата договора");
	private JDateChooser DateContractBegin=new JDateChooser();
	private JDateChooser DateContractEnd=new JDateChooser();
	private JCheckBox DateContractCheck=new JCheckBox();
	private JLabel NameOrganizationText=new JLabel("Организация");
	private JComboBox NameOrganization=new JComboBox();
	private JCheckBox NameOrganizationCheck=new JCheckBox();
	private JLabel WorkText=new JLabel("Услуга");
	private JComboBox Work=new JComboBox();
	private JCheckBox WorkCheck=new JCheckBox();
	private JLabel TypeContractText=new JLabel("Вид договора");
	private JComboBox TypeContract=new JComboBox();
	private JCheckBox TypeContractCheck=new JCheckBox();
	private JLabel TypePayText=new JLabel("Вид оплаты");
	private JComboBox TypePay=new JComboBox();
	private JCheckBox TypePayCheck=new JCheckBox();
	private JLabel DateBeginText=new JLabel("Дата начала");
	private JDateChooser DateBeginFirst=new JDateChooser();
	private JDateChooser DateBeginSecond=new JDateChooser();
	private JCheckBox DateBeginCheck=new JCheckBox();
	private JLabel DateEndText=new JLabel("Дата окончания");
	private JDateChooser DateEndFirst=new JDateChooser();
	private JDateChooser DateEndSecond=new JDateChooser();
	private JCheckBox DateEndCheck=new JCheckBox();
	private JLabel PriceText=new JLabel("Стоимость");
	private JTextField PriceFirst=new JTextField(10);
	private JTextField PriceSecond=new JTextField(10);
	private JCheckBox PriceCheck=new JCheckBox();
	private JLabel PayPeriodText=new JLabel("Период оплаты");
	private JComboBox PayPeriod=new JComboBox();
	private JCheckBox PayPeriodCheck=new JCheckBox();
	private JLabel SumPayText=new JLabel("Сумма к оплате");
	private JTextField SumPayFirst=new JTextField(10);
	private JTextField SumPaySecond=new JTextField(10);
	private JCheckBox SumPayCheck=new JCheckBox();
	private JLabel SumYearText=new JLabel("Сумма в год");
	private JTextField SumYearFirst=new JTextField(10);
	private JTextField SumYearSecond=new JTextField(10);
	private JCheckBox SumYearCheck=new JCheckBox();
	private JLabel DetailsText=new JLabel("Реквизиты");
	private JComboBox Details=new JComboBox();
	private JCheckBox DetailsCheck=new JCheckBox();
	private JLabel CommentText=new JLabel("Примечание");
	private JComboBox Comment=new JComboBox();
	private JCheckBox CommentCheck=new JCheckBox();
	private JLabel CloseContractText=new JLabel("Договор закрыт");
	private JLabel YesText=new JLabel("да");
	private JLabel NoText=new JLabel("нет");
	private JCheckBox CloseYes=new JCheckBox();
	private JCheckBox CloseNo=new JCheckBox();
	private JCheckBox CloseContractCheck=new JCheckBox();
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private static ContractOrderYurfaceDAO contractyurfacedao;
	private Map<String, String> parameters=new LinkedHashMap<String, String>();
	
	public EconomYurfaceContract() throws ClientProtocolException, IOException {
		   setSize(800, 600);
		   setLayout(new BorderLayout());
		   JPanel samples=new JPanel();
		   JPanel view=new JPanel();
		   JPanel buttonpanel=new JPanel();
		   contractyurfacedao=new ContractOrderYurfaceDAO();
		   model=new ContractYurfaceTableModel(contractyurfacedao.getContractYurfaceList());
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
		   pricepanel.add(PriceFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   pricepanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   pricepanel.add(PriceSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   JPanel datebeginpanel=new JPanel();
		   datebeginpanel.setLayout(new GridBagLayout());
		   datebeginpanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   datebeginpanel.add(DateBeginFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   datebeginpanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   datebeginpanel.add(DateBeginSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   JPanel dateendpanel=new JPanel();
		   dateendpanel.setLayout(new GridBagLayout());
		   dateendpanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   dateendpanel.add(DateEndFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   dateendpanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   dateendpanel.add(DateEndSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   JPanel sumpaypanel=new JPanel();
		   sumpaypanel.setLayout(new GridBagLayout());
		   sumpaypanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   sumpaypanel.add(SumPayFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   sumpaypanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   sumpaypanel.add(SumPaySecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   JPanel sumyearpanel=new JPanel();
		   sumyearpanel.setLayout(new GridBagLayout());
		   sumyearpanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   sumyearpanel.add(SumYearFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   sumyearpanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   sumyearpanel.add(SumYearSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
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
		   params.add(WorkText, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(WorkCheck, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Work, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(TypeContractText, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(TypeContractCheck, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(TypeContract, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(TypePayText, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(TypePayCheck, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(TypePay, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DateBeginText, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DateBeginCheck, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(datebeginpanel, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DateEndText, new GridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DateEndCheck, new GridBagConstraints(0, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(dateendpanel, new GridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(PriceText, new GridBagConstraints(1, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(PriceCheck, new GridBagConstraints(0, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(pricepanel, new GridBagConstraints(1, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(PayPeriodText, new GridBagConstraints(1, 15, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(PayPeriodCheck, new GridBagConstraints(0, 16, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(PayPeriod, new GridBagConstraints(1, 16, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(SumPayText, new GridBagConstraints(1, 17, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(SumPayCheck, new GridBagConstraints(0, 18, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(sumpaypanel, new GridBagConstraints(1, 18, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(SumYearText, new GridBagConstraints(1, 19, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(SumYearCheck, new GridBagConstraints(0, 20, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(sumyearpanel, new GridBagConstraints(1, 20, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DetailsText, new GridBagConstraints(1, 21, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(DetailsCheck, new GridBagConstraints(0, 22, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Details, new GridBagConstraints(1, 22, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CommentText, new GridBagConstraints(1, 23, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CommentCheck, new GridBagConstraints(0, 24, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(Comment, new GridBagConstraints(1, 24, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CloseContractText, new GridBagConstraints(1, 25, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(CloseContractCheck, new GridBagConstraints(0, 26, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   params.add(closepanel, new GridBagConstraints(1, 26, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		   Dimension size=new Dimension(50, 20);
		   NameOrganization.setPreferredSize(size);
		   Work.setPreferredSize(size);
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
		   
		   WorkCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Work.setEnabled(true);
				} else {
					Work.setEnabled(false);
				}
				
			}
			   
		   });
		   
		   TypeContractCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					TypeContract.setEnabled(true);
				} else {
					TypeContract.setEnabled(false);
				}
				
			}
			   
		   });
		   
		   TypePayCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					TypePay.setEnabled(true);
				} else {
					TypePay.setEnabled(false);
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
		   
		   PriceCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					PriceFirst.setEnabled(true);
					PriceSecond.setEnabled(true);
				} else {
					PriceFirst.setEnabled(false);
					PriceSecond.setEnabled(false);
				}
				
			}
			   
		   });
		   
		   PayPeriodCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					PayPeriod.setEnabled(true);
				} else {
					PayPeriod.setEnabled(false);
				}
				
			}
			   
		   });
		   
		   SumPayCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					SumPayFirst.setEnabled(true);
					SumPaySecond.setEnabled(true);
				} else {
					SumPayFirst.setEnabled(false);
					SumPaySecond.setEnabled(false);
				}
				
			}
			   
		   });
		   
		   SumYearCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					SumYearFirst.setEnabled(true);
					SumYearSecond.setEnabled(true);
				} else {
					SumYearFirst.setEnabled(false);
					SumYearSecond.setEnabled(false);
				}
				
			}
			   
		   });
		   
		   DetailsCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Details.setEnabled(true);
				} else {
					Details.setEnabled(false);
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
						str="Cource='"+Work.getSelectedItem().toString()+"'";
					} else {
						str=" AND Cource='"+Work.getSelectedItem().toString()+"'";
					}
					parameters.put("Cource", str);
				}
				
				if(TypeContractCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="TypeContract='"+TypeContract.getSelectedItem().toString()+"'";
					} else {
						str=" AND TypeContract='"+TypeContract.getSelectedItem().toString()+"'";
					}
					parameters.put("TypeContract", str);
				}
				
				if(TypePayCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="TypePay='"+TypePay.getSelectedItem().toString()+"'";
					} else {
						str="TypePay='"+TypePay.getSelectedItem().toString()+"'";
					}
					parameters.put("TypePay", str);
				}
				
				if(DateBeginCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(DateBeginFirst.getDate().toString()!="") {
							Date ubegindate=DateBeginFirst.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateBegin>='"+sbegindate+"'";
						}
						if(DateBeginSecond.getDate().toString()!="") {
							Date uenddate=DateBeginSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							if(str!="") {
								str+=" AND DateBegin<='"+senddate+"'";
							} else {
								str="DateBegin<='"+senddate+"'";
							}
						}
						
					} else {
						if(DateBeginFirst.getDate().toString()!="") {
							Date ubegindate=DateBeginFirst.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateBegin>='"+sbegindate+"'";
						}
						if(DateBeginSecond.getDate().toString()!="") {
							Date uenddate=DateBeginSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
						    str+=" AND DateBegin<='"+senddate+"'";
						}
					}
					parameters.put("DateBegin", str);
					str="";
				}
				
				if(PriceCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(PriceFirst.getText()!="") {
							str="Price>="+Double.parseDouble(PriceFirst.getText());
						}
						if(PriceSecond.getText()!="") {
							if(str!="") {
								str+=" AND Price<="+Double.parseDouble(PriceSecond.getText());
							} else {
								str="Price<="+Double.parseDouble(PriceSecond.getText());
							}
						}
					} else {
						if(PriceFirst.getText()!="") {
							str="Price>="+Double.parseDouble(PriceFirst.getText());
						}
						if(PriceSecond.getText()!="") {
						    str+=" AND Price<="+Double.parseDouble(PriceSecond.getText());
						}
					}
					parameters.put("Price", str);
					str="";
				}
				
				if(PayPeriodCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="PayPeriod='"+PayPeriod.getSelectedItem().toString();
					} else {
						str=" AND PayPeriod='"+PayPeriod.getSelectedItem().toString();
					}
					parameters.put("PayPeriod", str);
					str="";
				}
				
				if(SumPayCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(SumPayFirst.getText()!="") {
							str="SumPay>="+Double.parseDouble(SumPayFirst.getText());
						}
						if(SumPaySecond.getText()!="") {
							if(str!="") {
								str+=" AND SumPay<="+Double.parseDouble(SumPaySecond.getText());
							} else {
								str="SumPay<="+Double.parseDouble(SumPaySecond.getText());
							}
						}
					} else {
						if(SumPayFirst.getText()!="") {
							str="SumPay>="+Double.parseDouble(SumPayFirst.getText());
						}
						if(SumPaySecond.getText()!="") {
							str+=" AND SumPay<="+Double.parseDouble(SumPaySecond.getText());
						}
					}
					parameters.put("SumPay", str);
					str="";
				}
				
				if(SumYearCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(SumYearFirst.getText()!="") {
							str="SumYear>="+Double.parseDouble(SumYearFirst.getText());
						}
						if(SumYearSecond.getText()!="") {
							if(str!="") {
								str+=" AND SumYear<="+Double.parseDouble(SumYearSecond.getText());
							} else {
								str="SumYear<="+Double.parseDouble(SumYearSecond.getText());
							}
						}
					} else {
						if(SumYearFirst.getText()!="") {
							str="SumYear>="+Double.parseDouble(SumYearFirst.getText());
						}
						if(SumYearSecond.getText()!="") {
							str+=" AND SumYear<="+Double.parseDouble(SumYearSecond.getText());
						}
					}
					parameters.put("SumYear", str);
					str="";
				}
				
				if(DetailsCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="DetailsContract='"+Details.getSelectedItem().toString();
					} else {
						str=" AND DetailsContract='"+Details.getSelectedItem().toString();
					}
					parameters.put("Details", str);
					str="";
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
		   JButton deleteContract=new JButton("Удалить");
		   JButton newTicket=new JButton("Новая квитанция");
		   updateContract.setEnabled(false);
		   deleteContract.setEnabled(false);
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
					new NewContractYurface();
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
				ContractOrderYurface contract;
				try {
					contract=contractyurfacedao.getContractOrderYurfaceById(id);
					System.out.println(contract.getNameOrganization());
					new UpdateContractYurface(contract);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			   
		   });
		   newTicket.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				ContractOrderYurface contract;
				try {
					contract=contractyurfacedao.getContractOrderYurfaceById(id);
					new NewContractYurfaceTicket(contract);
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
		   view.add(buttonpanel, BorderLayout.SOUTH);
		   add(view, BorderLayout.CENTER);
		   
		   
	}
	
	public void createSamples() throws ClientProtocolException, IOException {
		ArrayList<ContractOrderYurface> contractlist=contractyurfacedao.getContractYurfaceList();
		for(ContractOrderYurface contract : contractlist) {
			NameOrganization.addItem(contract.getNameOrganization());
			Work.addItem(contract.getCource());
			TypeContract.addItem(contract.getTypeContract());
			TypePay.addItem(contract.getPayType());
			PayPeriod.addItem(contract.getPayPeriod());
			Details.addItem(contract.getDetailsContract());
			Comment.addItem(contract.getComment());
		}
		DateContractBegin.setEnabled(false);
		DateContractEnd.setEnabled(false);
		NameOrganization.setEnabled(false);
		TypeContract.setEnabled(false);
		TypePay.setEnabled(false);
		DateBeginFirst.setEnabled(false);
		DateBeginSecond.setEnabled(false);
		DateEndFirst.setEnabled(false);
		DateEndSecond.setEnabled(false);
		PriceFirst.setEnabled(false);
		PriceSecond.setEnabled(false);
		PayPeriod.setEnabled(false);
		SumPayFirst.setEnabled(false);
		SumPaySecond.setEnabled(false);
		SumYearFirst.setEnabled(false);
		SumYearSecond.setEnabled(false);
		Details.setEnabled(false);
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
		model=new ContractYurfaceTableModel(contractyurfacedao.getContractYurfaceList());
		table.setModel(model);
		table.updateUI();
	}
	
	public static void updateAtParams(String params) throws ClientProtocolException, IOException {
		model=new ContractYurfaceTableModel(contractyurfacedao.getContractYurfaceListAtParams(params));
		table.setModel(model);
		table.updateUI();
	}

}
