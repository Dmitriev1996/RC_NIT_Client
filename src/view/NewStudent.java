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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import com.toedter.calendar.JDateChooser;

import logic.dao.PhysfaceDAO;
import logic.entity.Physface;
import logic.entity.Student;

public class NewStudent extends JFrame {
	protected JLabel DateCertificationText=new JLabel("Дата выдачи/отчисления");
	protected JDateChooser DateCertification=new JDateChooser();
	protected JPanel editPanel=new JPanel();
	protected JPanel physButtonPanel=new JPanel();
	protected JPanel buttonPanel=new JPanel();
	protected static JTable table;
	protected JButton newPhysface=new JButton("Добавить физ. лицо");
	protected JButton updatePhysface=new JButton("Редактировать");
	protected JButton deletePhysface=new JButton("Удалить");
	protected JButton ok=new JButton("OK");
	protected JButton cancel=new JButton("Отмена");
	protected JScrollPane jsp;
	protected static TableModel model;
	protected Box contentBox=new Box(BoxLayout.Y_AXIS);
	protected static ArrayList<Physface> physfacelist;
	protected static PhysfaceDAO physfacedao=new PhysfaceDAO();
	
	public NewStudent() throws ClientProtocolException, IOException {
		createGUI();
		createActions();
	}
	
	protected void createGUI() throws ClientProtocolException, IOException {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updatePhysface.setEnabled(false);
		deletePhysface.setEnabled(false);
		ok.setEnabled(false);
		setLayout(new BorderLayout());
		editPanel.setLayout(new GridBagLayout());
		editPanel.add(DateCertificationText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(DateCertification, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		physfacelist=physfacedao.getPhysfaceList();
		model=new PhysfaceListTableModel(physfacelist);
		table=new JTable(model);
		jsp=new JScrollPane(table);
		physButtonPanel.setLayout(new GridBagLayout());
		physButtonPanel.add(newPhysface, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		physButtonPanel.add(updatePhysface, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		physButtonPanel.add(deletePhysface, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		contentBox.add(editPanel);
		contentBox.add(jsp);
		contentBox.add(physButtonPanel);
		contentBox.add(buttonPanel);
		add(contentBox, BorderLayout.CENTER);
		setVisible(true);
	}
	
	protected void createActions() {
		newPhysface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewPhysfaceInStudent();
				
			}
			
		});
		updatePhysface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Physface updatePhysface=null;
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				for(Physface physface : physfacelist) {
					if(physface.getPhys_ID()==id) {
						updatePhysface=physface;
					}
				}
				new UpdatePhysfaceInStudent(updatePhysface);
				
			}
			
		});
		deletePhysface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				String message="";
				Physface physface=new Physface();
				physface.setPhys_ID(id);
				try {
					message=physfacedao.deletePhysface(physface);
					updateFrame();
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
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updatePhysface.setEnabled(true);
				deletePhysface.setEnabled(true);
				ok.setEnabled(true);
				
			}
			   
		   });
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String validateDateCertification=DateCertification.getDateEditor().getDate()+"";
				Student student=new Student();
				if(!validateDateCertification.equals("null")) {
					java.sql.Date date=new java.sql.Date(DateCertification.getDate().getTime());
					student.setDateCertification(date);
				}
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				for(Physface physface : physfacelist) {
					if(physface.getPhys_ID()==id) {
						student.setPhysface(physface);
					}
				}
				student.setPhys_ID(id);
				updateParentFrame(student);
			}
			
		});
	}
	
	protected void updateParentFrame(Student student) {
		NewGroup.addStudent(student);
		NewGroup.updateFrame();
	}
	
	public static void updateFrame() throws ClientProtocolException, IOException {
		physfacelist=physfacedao.getPhysfaceList();
		model=new PhysfaceListTableModel(physfacelist);
		table.setModel(model);
	}

}
