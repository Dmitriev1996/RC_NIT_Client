package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

public class NewContractYurface extends JFrame {
	protected JLabel DateContractText=new JLabel("Дата договора");
	protected JDateChooser DateContract=new JDateChooser();
	protected JLabel NameOrganizationText=new JLabel("Наименование организации");
	protected JComboBox NameOrganization=new JComboBox();
	protected JLabel WorkText=new JLabel("Услуга");
	protected JComboBox Work=new JComboBox();
	protected JLabel TypeContractText=new JLabel("Вид договора");
	protected JComboBox TypeContract=new JComboBox();
	protected JLabel TypePayText=new JLabel("Вид оплаты");
	protected JComboBox TypePay=new JComboBox();
	protected JLabel DateBeginText=new JLabel("Дата начала");
	protected JDateChooser DateBegin=new JDateChooser();
	protected JLabel DateEndText=new JLabel("Дата окончания");
	protected JDateChooser DateEnd=new JDateChooser();
	protected JLabel PriceText=new JLabel("Стоимость");
	protected JTextField Price=new JTextField(20);
	protected JLabel PayPeriodText=new JLabel("Период оплаты");
	protected JComboBox PayPeriod=new JComboBox();
	protected JLabel SumPayText=new JLabel("Сумма к оплате");
	protected JTextField SumPay=new JTextField(20);
	protected JLabel SumYearText=new JLabel("Сумма в год");
	protected JTextField SumYear=new JTextField(20);
	protected JLabel DetailsText=new JLabel("Реквизиты");
	protected JTextField Details=new JTextField(20);
	protected JLabel CommentText=new JLabel("Примечание");
	protected JTextField Comment=new JTextField(20);
	protected JButton ok=new JButton("OK");
	protected JButton cancel=new JButton("Отмена");
	protected JButton newYurface=new JButton("Новое юр. лицо");
	protected JButton updateYurface=new JButton("Редактировать");
	protected static YurfaceDAO yurfacedao;
	protected CourceDAO courcedao;
	protected TypeContractDAO typecontractdao;
	protected PayTypeDAO paytypedao;
	protected PayPeriodDAO payperioddao;
	protected ContractOrderYurfaceDAO contractyurfacedao;
	protected JPanel editpanel;
	protected static JTable table;
	protected static TableModel model;
	protected JScrollPane jsp;
	protected JPanel yurbuttonpanel;
	
	
	public NewContractYurface() throws ClientProtocolException, IOException {
		contractyurfacedao=new ContractOrderYurfaceDAO();
		yurfacedao=new YurfaceDAO();
		courcedao=new CourceDAO();
		typecontractdao=new TypeContractDAO();
		paytypedao=new PayTypeDAO();
		payperioddao=new PayPeriodDAO();
		updateYurface.setEnabled(false);
		table=new JTable();
		model=new YurfaceTableModel(yurfacedao.getYurfaceList());
		table.setModel(model);
		jsp=new JScrollPane(table);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		Box contentBox=new Box(BoxLayout.Y_AXIS);
		editpanel=new JPanel();
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
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateYurface.setEnabled(true);
				
			}
			   
		   });
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String errorList="";
				String validateDateContract=DateContract.getDateEditor().getDate()+"";
				String validateWork=Work.getSelectedItem()+"";
				String validateTypeContract=TypeContract.getSelectedItem()+"";
				String validatePayType=TypePay.getSelectedItem()+"";
				String validateDateBegin=DateBegin.getDateEditor().getDate()+"";
				String validateDateEnd=DateEnd.getDateEditor().getDate()+"";
				String validatePayPeriod=PayPeriod.getSelectedItem()+"";
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				Yurface yurface=null;
				try {
					yurface=yurfacedao.getYurfaceById(id);
				} catch (ClientProtocolException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ContractOrderYurface contract=new ContractOrderYurface();
				if(!validateDateContract.equals("null")){
					java.sql.Date dateContract=new java.sql.Date(DateContract.getDate().getTime());
					contract.setDateContract(dateContract);
				}
				contract.setYur_ID(yurface.getYur_ID());
				if(!validateWork.equals("null")) {
					contract.setCource(Work.getSelectedItem().toString());
				}
				if(!validateTypeContract.equals("null")) {
					contract.setTypeContract(TypeContract.getSelectedItem().toString());
				}
				if(!validatePayType.equals("null")) {
					contract.setPayType(TypePay.getSelectedItem().toString());
				}
				if(!validateDateBegin.equals("null")) {
					java.sql.Date dateBegin=new java.sql.Date(DateBegin.getDate().getTime());
					contract.setDateBegin(dateBegin);
				}
				if(!validateDateEnd.equals("null")) {
					java.sql.Date dateEnd=new java.sql.Date(DateEnd.getDate().getTime());
					contract.setDateEnd(dateEnd);
				}
				if(!CheckValue.isNumber(Price.getText())&&!Price.getText().equals("")) {
					errorList+="Поле Стоимость должно являться числом\n";
				} else if(!Price.getText().equals("")) {
					contract.setPrice(Double.parseDouble(Price.getText()));
				}
				if(!validatePayPeriod.equals("null")) {
					contract.setPayPeriod(PayPeriod.getSelectedItem().toString());
				}
				if(!CheckValue.isNumber(SumPay.getText())&&!SumPay.getText().equals("")) {
					errorList+="Поле Сумма к оплате должно являться числом\n";
				} else if(!SumPay.getText().equals("")) {
					contract.setSumPay(Double.parseDouble(SumPay.getText()));
				}
				if(!CheckValue.isNumber(SumYear.getText())&&!SumYear.getText().equals("")) {
					errorList+="Поле Сумма в год должно являться числом\n";
				} else if(!SumYear.getText().equals("")) {
					contract.setSumYear(Double.parseDouble(SumYear.getText()));
				}
				contract.setDetailsContract(Details.getText());
				contract.setComment(Comment.getText());
				byte status=0;
				contract.setCloseContract(status);
				if(!errorList.isEmpty()) {
					try {
						String message=contractyurfacedao.insertContractOrderYurface(contract);
						JOptionPane.showMessageDialog(null, message);
						updateParentFrame();
					} catch (ClientProtocolException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, errorList);
				}
				
			}
			
		});
		createComboBoxes();
		yurbuttonpanel=new JPanel();
		yurbuttonpanel.setLayout(new GridBagLayout());
		yurbuttonpanel.add(newYurface, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		yurbuttonpanel.add(updateYurface, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		yurbuttonpanel.add(ok, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		yurbuttonpanel.add(cancel, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		newYurface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewYurfaceInNewContract();
				
			}
			
		});
		updateYurface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				Yurface yurface=null;
				try {
					yurface=yurfacedao.getYurfaceById(id);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new UpdateYurfaceInNewContract(yurface);
				
			}
			
		});
		contentBox.add(editpanel);
		contentBox.add(jsp);
		contentBox.add(yurbuttonpanel);
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
	
	
	protected void updateParentFrame() throws ClientProtocolException, IOException {
		EconomYurfaceContract.updateFrame();
	}
	
	public static void updateFrame() throws ClientProtocolException, IOException {
		model=new YurfaceTableModel(yurfacedao.getYurfaceList());
		table.setModel(model);
		table.updateUI();
		
	}

}
