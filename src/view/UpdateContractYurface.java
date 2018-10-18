package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import com.toedter.calendar.JDateChooser;

import logic.dao.ContractOrderYurfaceDAO;
import logic.dao.CourceDAO;
import logic.dao.PayPeriodDAO;
import logic.dao.PayTypeDAO;
import logic.dao.TypeContractDAO;
import logic.dao.YurfaceDAO;
import logic.entity.ContractOrderYurface;
import logic.entity.Cource;
import logic.entity.PayPeriod;
import logic.entity.PayType;
import logic.entity.TypeContract;
import logic.entity.Yurface;
import service.CheckValue;

public class UpdateContractYurface extends JFrame {
	private JLabel DateContractText=new JLabel("Дата договора");
	private JDateChooser DateContract=new JDateChooser();
	private JLabel NameOrganizationText=new JLabel("Наименование организации");
	private JComboBox NameOrganization=new JComboBox();
	private JLabel WorkText=new JLabel("Услуга");
	private JComboBox Work=new JComboBox();
	private JLabel TypeContractText=new JLabel("Вид договора");
	private JComboBox TypeContract=new JComboBox();
	private JLabel TypePayText=new JLabel("Вид оплаты");
	private JComboBox TypePay=new JComboBox();
	private JLabel DateBeginText=new JLabel("Дата начала");
	private JDateChooser DateBegin=new JDateChooser();
	private JLabel DateEndText=new JLabel("Дата окончания");
	private JDateChooser DateEnd=new JDateChooser();
	private JLabel PriceText=new JLabel("Стоимость");
	private JTextField Price=new JTextField(20);
	private JLabel PayPeriodText=new JLabel("Период оплаты");
	private JComboBox PayPeriod=new JComboBox();
	private JLabel SumPayText=new JLabel("Сумма к оплате");
	private JTextField SumPay=new JTextField(20);
	private JLabel SumYearText=new JLabel("Сумма в год");
	private JTextField SumYear=new JTextField(20);
	private JLabel DetailsText=new JLabel("Реквизиты");
	private JTextField Details=new JTextField(20);
	private JLabel CommentText=new JLabel("Примечание");
	private JTextField Comment=new JTextField(20);
	private JLabel CloseContractText=new JLabel("Договор закрыт");
	private JCheckBox CloseContract=new JCheckBox();
	private JButton updateYurface=new JButton("Редактировать");
	private JButton newYurface=new JButton("Новое юр. лицо");
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private YurfaceDAO yurfacedao;
	private ContractOrderYurfaceDAO contractdao=new ContractOrderYurfaceDAO();
	private CourceDAO courcedao;
	private TypeContractDAO typecontractdao;
	private PayTypeDAO paytypedao;
	private PayPeriodDAO payperioddao;
	private JPanel editpanel;
	private JPanel buttonpanel;
	private static JTable table;
	private static TableModel model;
	private JScrollPane jsp;
	private static ArrayList<Yurface> yurfacelist;
	
	public UpdateContractYurface(ContractOrderYurface contract) throws ClientProtocolException, IOException {
		yurfacedao=new YurfaceDAO();
		courcedao=new CourceDAO();
		typecontractdao=new TypeContractDAO();
		paytypedao=new PayTypeDAO();
		payperioddao=new PayPeriodDAO();
		updateYurface.setEnabled(false);
		yurfacelist=new ArrayList<Yurface>();
		yurfacelist.add(yurfacedao.getYurfaceById(contract.getYur_ID()));
		model=new YurfaceTableModel(yurfacelist);
		table=new JTable();
		table.setModel(model);
		jsp=new JScrollPane(table);
		Box contentBox=new Box(BoxLayout.Y_AXIS);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		editpanel=new JPanel();
		buttonpanel=new JPanel();
		editpanel.setLayout(new GridBagLayout());
		editpanel.add(DateContractText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(DateContract, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(NameOrganizationText, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(NameOrganization, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(WorkText, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(Work, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(TypeContractText, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(TypeContract, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(TypePayText, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(TypePay, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(DateBeginText, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(DateBegin, new GridBagConstraints(0, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(DateEndText, new GridBagConstraints(0, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(DateEnd, new GridBagConstraints(0, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(PriceText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(Price, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(PayPeriodText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(PayPeriod, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(SumPayText, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(SumPay, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(SumYearText, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(SumYear, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(DetailsText, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(Details, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(CommentText, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(Comment, new GridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(CloseContractText, new GridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(CloseContract, new GridBagConstraints(1, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonpanel.setLayout(new GridBagLayout());
		buttonpanel.add(newYurface, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonpanel.add(updateYurface, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonpanel.add(ok, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonpanel.add(cancel, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateYurface.setEnabled(true);
				
			}
			   
		   });
		newYurface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new NewYurfaceInContract();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		updateYurface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				Yurface yurface;
				try {
					yurface=yurfacedao.getYurfaceById(id);
					new UpdateYurfaceInContract(yurface);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String errorList="";
				ContractOrderYurface aftercontract=contract;
				String validateDateContract=DateContract.getDateEditor().getDate()+"";
				String validateWork=Work.getSelectedItem()+"";
				String validateTypeContract=TypeContract.getSelectedItem()+"";
				String validateTypePay=TypePay.getSelectedItem()+"";
				String validateDateBegin=DateBegin.getDateEditor().getDate()+"";
				String validateDateEnd=DateEnd.getDateEditor().getDate()+"";
				String validatePayPeriod=PayPeriod.getSelectedItem()+"";
				if(!validateDateContract.equals("null")) {
					java.sql.Date sdatecontract=new java.sql.Date(DateContract.getDate().getTime());
					aftercontract.setDateContract(sdatecontract);
				}
				if(!validateWork.equals("null")) {
					aftercontract.setCource(Work.getSelectedItem().toString());
				}
				if(!validateTypeContract.equals("null")) {
					aftercontract.setTypeContract(TypeContract.getSelectedItem().toString());
				}
				if(!validateTypePay.equals("null")) {
					aftercontract.setPayType(TypePay.getSelectedItem().toString());
				}
				if(!validateDateBegin.equals("null")) {
					java.sql.Date sdatebegin=new java.sql.Date(DateBegin.getDate().getTime());
					aftercontract.setDateBegin(sdatebegin);
				}
				if(!validateDateEnd.equals("null")) {
					java.sql.Date sdateend=new java.sql.Date(DateEnd.getDate().getTime());
					aftercontract.setDateEnd(sdateend);
				}
				aftercontract.setPrice(Double.parseDouble(Price.getText()));
				if(!validatePayPeriod.equals("null")) {
					aftercontract.setPayPeriod(PayPeriod.getSelectedItem().toString());
				}
				if(!CheckValue.isNumber(SumPay.getText())&&!SumPay.getText().equals("")) {
					errorList+="Поле Сумма к оплате должно являться числом\n";
				} else if(!SumPay.getText().equals("")) {
					aftercontract.setSumPay(Double.parseDouble(SumPay.getText()));
				}
				if(!CheckValue.isNumber(SumYear.getText())&&!SumYear.getText().equals("")) {
					errorList+="Поле Сумма в год должно являться числом\n";
				} else if(!SumYear.getText().equals("")) {
					aftercontract.setSumYear(Double.parseDouble(SumYear.getText()));
				}
				aftercontract.setDetailsContract(Details.getText());
				aftercontract.setComment(Comment.getText());
				byte close=0;
				if(CloseContract.isSelected()) {
					close=1;
				} else {
					close=0;
				}
				aftercontract.setCloseContract(close);
				String message="";
				if(!errorList.isEmpty()) {
					try {
						message=contractdao.updateContractOrderYurface(aftercontract);
					} catch (ClientProtocolException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, message);
				} else {
					JOptionPane.showMessageDialog(null, errorList);
				}
				
				
			}
			
		});
		createComboBoxes();
		createData(contract);
		contentBox.add(editpanel);
		contentBox.add(jsp);
		contentBox.add(buttonpanel);
		add(contentBox);
		setSize(500, 500);
		setVisible(true);
	}
	
	public void createComboBoxes() throws ClientProtocolException, IOException {
		for(Yurface yurface : yurfacedao.getYurfaceList()) {
			NameOrganization.addItem(yurface.getNameOrganization());
		}
		
		for(Cource cource : courcedao.getCourceList()) {
			Work.addItem(cource.getCource());
		}
		
		for(TypeContract type : typecontractdao.getTypeContractList()) {
			TypeContract.addItem(type.getTypeContract());
		}
		
		for(PayType paytype : paytypedao.getPayTypeList()) {
			TypePay.addItem(paytype.getPayType());
		}
		
		for(PayPeriod payperiod : payperioddao.getPayPeriodList()) {
			PayPeriod.addItem(payperiod.getPayPeriod());
		}
		
	}
	
	public void createData(ContractOrderYurface contract) {
		DateContract.setDate((Date)contract.getDateContract());
		NameOrganization.setSelectedItem(contract.getNameOrganization());
		Work.setSelectedItem(contract.getCource());
		TypeContract.setSelectedItem(contract.getTypeContract());
		TypePay.setSelectedItem(contract.getPayType());
		DateBegin.setDate((Date)contract.getDateBegin());
		DateEnd.setDate((Date)contract.getDateEnd());
		Price.setText(contract.getPrice()+"");
		PayPeriod.setSelectedItem(contract.getPayPeriod());
		SumPay.setText(contract.getSumPay()+"");
		SumYear.setText(contract.getSumYear()+"");
		Details.setText(contract.getDetailsContract());
		Comment.setText(contract.getComment());
		if(contract.getCloseContract()==1) {
			CloseContract.setSelected(true);
		} else {
			CloseContract.setSelected(false);
		}
	}
	
	protected void updateParentFrame() throws ClientProtocolException, IOException {
		EconomYurfaceContract.updateFrame();
	}
	
	public static void updateFrame() {
		model=new YurfaceTableModel(yurfacelist);
		table.setModel(model);
		table.updateUI();
	}

	public ArrayList<Yurface> getYurfacelist() {
		return yurfacelist;
	}

	public static void setYurfacelist(ArrayList<Yurface> list) {
		yurfacelist = list;
	}
	
	

}
