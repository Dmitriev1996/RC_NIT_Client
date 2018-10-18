package view;

import java.awt.BorderLayout;
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
import service.CheckValue;

public class NewContractPhysface extends JFrame {
	private JLabel DateContractText=new JLabel("Дата договора");
	private JLabel FIOText=new JLabel("ФИО");
	private JLabel WorkText=new JLabel("Услуга");
	private JLabel NumberText=new JLabel("Количество");
	private JLabel PriceText=new JLabel("Стоимость");
	private JLabel DatePayText=new JLabel("Дата оплаты");
	private JLabel DetailsText=new JLabel("Реквизиты");
	private JLabel CommentText=new JLabel("Примечание");
	private JDateChooser DateContract=new JDateChooser();
	private JComboBox FIO=new JComboBox();
	private JComboBox Work=new JComboBox();
	private JTextField Number=new JTextField(50);
	private JTextField Price=new JTextField(10);
	private JDateChooser DatePay=new JDateChooser();
	private JTextField Details=new JTextField(10);
	private JTextField Comment=new JTextField(20);
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private ContractOrderPhysfaceDAO contractphysfacedao;
	private PhysfaceDAO physfacedao;
	private CourceDAO courcedao;
	private JPanel editPanel;
	private Box contentBox;
	private static TableModel model;
	private static JTable table;
	private static JScrollPane jsp;
	private ArrayList<Physface> physfacelist;
	private JPanel buttonPanel;
	
	public NewContractPhysface() throws ClientProtocolException, IOException {
		ok.setEnabled(false);
		physfacedao=new PhysfaceDAO();
		courcedao=new CourceDAO();
		contractphysfacedao=new ContractOrderPhysfaceDAO();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		physfacelist=physfacedao.getPhysfaceList();
		model=new PhysfaceListTableModel(physfacelist);
		table=new JTable();
		table.setModel(model);
		jsp=new JScrollPane(table);
		contentBox=new Box(BoxLayout.Y_AXIS);
		editPanel=new JPanel();
		editPanel.setLayout(new GridBagLayout());
		setLayout(new BorderLayout());
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
		/*editPanel.add(ok, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));*/
		editPanel.add(PriceText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Price, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(DatePayText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(DatePay, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(DetailsText, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Details, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(CommentText, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Comment, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		/*editPanel.add(cancel, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));*/
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		createComboBoxes();
		 table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					ok.setEnabled(true);
					
				}
				   
			   });
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String errorList="";
				ContractOrderPhysface contractphysface=new ContractOrderPhysface();
				if(DateContract.getDate()!=null) {
					java.sql.Date dateContract=new java.sql.Date(DateContract.getDate().getTime());
					contractphysface.setDateContract(dateContract);
				}
				int Phys_ID=physfacelist.get(table.getSelectedRow()).getPhys_ID();
				/*try {
					for(Physface physface : physfacedao.getPhysfaceList()) {
						if(physface.getFIO().equals(FIO.getSelectedItem().toString())) {
							Phys_ID=physface.getPhys_ID();
						}
					}
				} catch (ClientProtocolException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}*/
				contractphysface.setPhys_ID(Phys_ID);
				int Cource_ID=0;
				try {
					for(Cource cource : courcedao.getCourceList()) {
						if(cource.getCource().equals(Work.getSelectedItem().toString())) {
							Cource_ID=cource.getCource_ID();
						}
					}
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				contractphysface.setCource_ID(Cource_ID);
				if(!CheckValue.isNumber(Number.getText())&&!Number.getText().equals("")) {
					errorList+="Поле Количество должно являться числом!\n";
				} else if(!Number.getText().equals("")) {
					contractphysface.setNumber(Integer.parseInt(Number.getText()));
				}
			    if(!CheckValue.isNumber(Price.getText())&&!Price.getText().equals("")) {
			    	errorList+="Поле Стоимость должно являться числом!\n";
			    } else if(!Price.getText().equals("")) {
			    	contractphysface.setPrice(Double.parseDouble(Price.getText()));
			    }
				if(DatePay.getDate()!=null) {
					java.sql.Date datePay=new java.sql.Date(DatePay.getDate().getTime());
					contractphysface.setDatePay(datePay);
				}
				contractphysface.setDetailsContract(Details.getText());
			    contractphysface.setComment(Comment.getText());
			    byte id=0;
			    contractphysface.setCloseContract(id);
				if(errorList.isEmpty()) {
					try {
						String message=contractphysfacedao.insertContractOrderPhysface(contractphysface);
						JOptionPane.showMessageDialog(null, message);
						EconomPhysfaceContract.updateFrame();
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
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		contentBox.add(editPanel);
		contentBox.add(jsp);
		contentBox.add(buttonPanel);
		add(contentBox);
		setSize(500, 500);
		setVisible(true);
	}
	
	public void createComboBoxes() throws ClientProtocolException, IOException {
		for(Physface physface : physfacedao.getPhysfaceList()) {
			FIO.addItem(physface.getFIO());
		}
		for(Cource cource : courcedao.getCourceList()) {
			Work.addItem(cource.getCource());
		}
	}
	
	

}
