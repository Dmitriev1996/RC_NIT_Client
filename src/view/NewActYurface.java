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
import javax.swing.JCheckBox;
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

import logic.dao.ActOrderYurfaceDAO;
import logic.dao.ContractOrderYurfaceDAO;
import logic.entity.ActOrderYurface;
import logic.entity.ContractOrderYurface;

public class NewActYurface extends JFrame {
	protected JLabel DateActText=new JLabel("Дата акта");
	protected JDateChooser DateAct=new JDateChooser();
	protected JLabel SumText=new JLabel("Сумма");
	protected JTextField Sum=new JTextField(10);
	protected JLabel DatePayText=new JLabel("Дата оплаты");
	protected JDateChooser DatePay=new JDateChooser();
	protected JLabel ReturnActText=new JLabel("Возврат акта");
	protected JCheckBox ReturnAct=new JCheckBox();
	protected JLabel CommentText=new JLabel("Примечание");
	protected JTextField Comment=new JTextField(10);
	protected static JTable table;
	protected static TableModel model;
	protected JScrollPane jsp;
	protected static ContractOrderYurfaceDAO contractyurfacedao;
	protected ActOrderYurfaceDAO actyurfacedao;
	protected JPanel editpanel;
	protected JPanel contractbuttonpanel;
	protected JButton newContract=new JButton("Новый договор");
	protected JButton updateContract=new JButton("Редактировать");
	protected JButton ok=new JButton("OK");
	protected JButton cancel=new JButton("Отмена");
	
	public NewActYurface() throws ClientProtocolException, IOException {
		contractyurfacedao=new ContractOrderYurfaceDAO();
		actyurfacedao=new ActOrderYurfaceDAO();
		updateContract.setEnabled(false);
		table=new JTable();
		model=new ContractYurfaceTableModel(contractyurfacedao.getContractYurfaceList());
		table.setModel(model);
		jsp=new JScrollPane(table);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		Box contentBox=new Box(BoxLayout.Y_AXIS);
		editpanel=new JPanel();
		editpanel.setLayout(new GridBagLayout());
		editpanel.add(DateActText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(DateAct, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(SumText, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(Sum, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(DatePayText, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(DatePay, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(ReturnActText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(ReturnAct, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(CommentText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editpanel.add(Comment, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateContract.setEnabled(true);
				
			}
			   
		   });
		newActionListener();
		updateActionListener();
		okActionListener();
		contractbuttonpanel=new JPanel();
		contractbuttonpanel.setLayout(new GridBagLayout());
		contractbuttonpanel.add(newContract, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		contractbuttonpanel.add(updateContract, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		contractbuttonpanel.add(ok, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		contractbuttonpanel.add(cancel, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		contentBox.add(editpanel);
		contentBox.add(jsp);
		contentBox.add(contractbuttonpanel);
		add(contentBox);
		setSize(500, 500);
		setVisible(true);
		
		
	}
	
	
	protected void newActionListener() {
		newContract.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new NewContractYurfaceInAct();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
			
	}
	
	protected void updateActionListener() {
		updateContract.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				ContractOrderYurface contract;
				try {
					contract=contractyurfacedao.getContractOrderYurfaceById(id);
					new UpdateContractYurfaceInAct(contract);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
	}
	
	protected void okActionListener() {
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				ActOrderYurface act=new ActOrderYurface();
				act.setContractsOrdersYurfaces_ID(id);
				java.sql.Date dateact=new java.sql.Date(DateAct.getDate().getTime());
				act.setDateAct(dateact);
				act.setPrice(Double.parseDouble(Sum.getText()));
				java.sql.Date datepay=new java.sql.Date(DatePay.getDate().getTime());
				act.setDatePay(datepay);
				act.setComment(Comment.getText());
				byte returnact=0;
				if(ReturnAct.isSelected()) {
					returnact=1;
				} else {
					returnact=0;
				}
				act.setReturnAct(returnact);
				String message="";
				try {
					message=actyurfacedao.insertActOrderYurface(act);
					updateParentFrame();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, message);
			}
			
		});
	}
	
	protected static void updateFrame() throws ClientProtocolException, IOException {
		model=new ContractYurfaceTableModel(contractyurfacedao.getContractYurfaceList());
		table.setModel(model);
		table.updateUI();
	}
	
	protected void updateParentFrame() throws ClientProtocolException, IOException {
		EconomYurfaceAct.updateFrame();
	}
	

}
