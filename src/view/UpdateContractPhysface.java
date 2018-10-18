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

import logic.dao.ContractOrderPhysfaceDAO;
import logic.dao.CourceDAO;
import logic.dao.PhysfaceDAO;
import logic.entity.ContractOrderPhysface;
import logic.entity.Cource;
import logic.entity.Physface;

public class UpdateContractPhysface extends JFrame {
	private JLabel DateContractText=new JLabel("Дата договора");
	private JLabel FIOText=new JLabel("ФИО");
	private JLabel WorkText=new JLabel("Услуга");
	private JLabel NumberText=new JLabel("Количество");
	private JLabel PriceText=new JLabel("Стоимость");
	private JLabel DatePayText=new JLabel("Дата оплаты");
	private JLabel DetailsText=new JLabel("Реквизиты");
	private JLabel CommentText=new JLabel("Примечание");
	private JLabel CloseContractText=new JLabel("Договор закрыт");
	private JDateChooser DateContract=new JDateChooser();
	private JTextField FIO=new JTextField(20);
	private JComboBox Work=new JComboBox();
	private JTextField Number=new JTextField(50);
	private JTextField Price=new JTextField(10);
	private JDateChooser DatePay=new JDateChooser();
	private JTextField Details=new JTextField(10);
	private JTextField Comment=new JTextField(20);
	private JCheckBox CloseContract=new JCheckBox();
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private JButton update=new JButton("Редактировать");
	private CourceDAO courcedao;
	private PhysfaceDAO physfacedao;
	private ContractOrderPhysfaceDAO contractphysfacedao;
	private static JTable table;
	private JScrollPane jsp;
	private static TableModel model;
	private static ArrayList<Physface> physfaceList;
	private JPanel editPanel;
	private JPanel physButtonPanel;
	private static Physface physface;
	
	public UpdateContractPhysface(ContractOrderPhysface contract) throws ClientProtocolException, IOException {
		FIO.setEditable(true);
		physfacedao=new PhysfaceDAO();
		courcedao=new CourceDAO();
		contractphysfacedao=new ContractOrderPhysfaceDAO();
		physfaceList=new ArrayList<Physface>();
		update.setEnabled(false);
		Box contentBox=new Box(BoxLayout.Y_AXIS);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		physface=contract.getPhysface();
		physfaceList.add(physface);
		model=new PhysfaceListTableModel(physfaceList);
		table=new JTable();
		table.setModel(model);
		jsp=new JScrollPane(table);
		editPanel=new JPanel();
		editPanel.setLayout(new GridBagLayout());
		editPanel.add(DateContractText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(DateContract, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(FIOText, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(FIO, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(WorkText, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Work, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(NumberText, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Number, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(PriceText, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Price, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		/*editPanel.add(ok, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));*/
		editPanel.add(DatePayText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(DatePay, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(DetailsText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Details, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(CommentText, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Comment, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(CloseContractText, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(CloseContract, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		/*editPanel.add(cancel, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));*/
		contentBox.add(editPanel);
		contentBox.add(jsp);
		physButtonPanel=new JPanel();
		physButtonPanel.setLayout(new GridBagLayout());
		physButtonPanel.add(update, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		physButtonPanel.add(ok, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		physButtonPanel.add(cancel, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				update.setEnabled(true);
				
			}
			   
		   });
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdatePhysfaceInContract(physface);
				
			}
			
		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Date udatecontract=DateContract.getDate();
				java.sql.Date sdatecontract=new java.sql.Date(udatecontract.getTime());
				contract.setDateContract(sdatecontract);
				int id=0;
			    try {
					for(Cource cource : courcedao.getCourceList()) {
						if(cource.getCource().equals(Work.getSelectedItem().toString())) {
							id=cource.getCource_ID();
						}
					}
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    contract.setCource_ID(id);
				contract.setNumber(Integer.parseInt(Number.getText()));
				contract.setPrice(Double.parseDouble(Price.getText()));
				Date udatepay=DatePay.getDate();
			    java.sql.Date sdatepay=new java.sql.Date(udatepay.getTime());
			    contract.setDatePay(sdatepay);
			    contract.setDetailsContract(Details.getText());
			    contract.setComment(Comment.getText());
			    String message;
			    
				try {
					message = contractphysfacedao.updateContractOrderPhysface(contract);
					physfacedao.updatePhysface(physface);
				    JOptionPane.showMessageDialog(null, message);
				    EconomPhysfaceContract.updateFrame();
				} catch (ClientProtocolException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			
		});
		contentBox.add(physButtonPanel);
		add(contentBox);
		createComboBoxes();
		createData(contract);
		setSize(500, 500);
		setVisible(true);
	}
	
	public void createData(ContractOrderPhysface contract) {
		DateContract.setDate(contract.getDateContract());
		FIO.setText(contract.getFIO());
		Work.setSelectedItem(contract.getCource());
		Number.setText(contract.getNumber()+"");
		Price.setText(contract.getPrice()+"");
		DatePay.setDate(contract.getDatePay());
		Details.setText(contract.getDetailsContract());
		Comment.setText(contract.getComment());
		if(contract.getCloseContract()==0) {
			CloseContract.setSelected(true);
		} else {
			CloseContract.setEnabled(false);
		}
	}
	
	public void createComboBoxes() throws ClientProtocolException, IOException {
		for(Cource cource : courcedao.getCourceList()) {
			Work.addItem(cource.getCource());
		}
	}
	
	public static void setPhysface(Physface phys) {
		physface=phys;
	}
	
	public static void updateFrame() {
		physfaceList.clear();
		physfaceList.add(physface);
		model=new PhysfaceListTableModel(physfaceList);
		table.setModel(model);
		table.updateUI();
	}

}
