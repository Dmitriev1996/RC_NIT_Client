package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import logic.dao.CourceDAO;
import logic.dao.GroupDAO;
import logic.dao.StatusScienceDAO;
import logic.dao.StudentDAO;
import logic.dao.TeacherDAO;
import logic.entity.Cource;
import logic.entity.Group;
import logic.entity.StatusScience;
import logic.entity.Student;
import logic.entity.Teacher;

public class UpdateGroup extends JFrame {
	private JLabel NameCourceText=new JLabel("Наименование курса");
	private JComboBox NameCource=new JComboBox();
	private JLabel CertificationText=new JLabel("Выдача удостоверения");
	private JComboBox Certification=new JComboBox();
	private JLabel TeacherText=new JLabel("Преподаватель");
	private JComboBox Teacher=new JComboBox();
	private JLabel StatusScienceText=new JLabel("Статус");
	private JComboBox StatusScience=new JComboBox();
	private static JTable studentTable;
	private static TableModel modelTable;
	private JScrollPane studentJsp;
	private JPanel editPanel;
	private JPanel studentbuttonPanel;
	private JPanel buttonPanel;
	private Box content;
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private JButton newStudent=new JButton("Добавить студента");
	private JButton updateStudent=new JButton("Редактировать");
	private JButton deleteStudent=new JButton("Удалить");
	private GroupDAO groupdao=new GroupDAO();
	private StudentDAO studentdao=new StudentDAO();
	private CourceDAO courcedao=new CourceDAO();
	private TeacherDAO teacherdao=new TeacherDAO();
	private StatusScienceDAO statusdao=new StatusScienceDAO();
	private static ArrayList<Student> studentlist;
	
	public UpdateGroup(Group group) throws ClientProtocolException, IOException {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		Dimension size=new Dimension(200, 20);
		NameCource.setPreferredSize(size);
		Certification.setPreferredSize(size);
		Teacher.setPreferredSize(size);
		StatusScience.setPreferredSize(size);
		updateStudent.setEnabled(false);
		deleteStudent.setEnabled(false);
		editPanel=new JPanel();
		editPanel.setLayout(new GridBagLayout());
		editPanel.add(NameCourceText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(NameCource, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(CertificationText, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Certification, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(TeacherText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Teacher, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(StatusScienceText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(StatusScience, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		createTextData();
		studentlist=group.getStudentList();
		modelTable=new StudentTableModel(studentlist);
		studentTable=new JTable(modelTable);
		studentJsp=new JScrollPane(studentTable);
		studentbuttonPanel=new JPanel();
		studentbuttonPanel.setLayout(new GridBagLayout());
		studentbuttonPanel.add(newStudent, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		studentbuttonPanel.add(updateStudent, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		studentbuttonPanel.add(deleteStudent, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		newStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new NewStudentInUpdateGroup();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		updateStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=studentTable.getSelectedRow();
				int id=(int)modelTable.getValueAt(selectedRow, 0);
				try {
					Student student=studentdao.getStudentById(id);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//UpdateStudentInGroup(student);
				
			}
			
		});
		studentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateStudent.setEnabled(true);
				deleteStudent.setEnabled(true);
				
			}
			   
		   });
		deleteStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=studentTable.getSelectedRow();
				int id=(int)modelTable.getValueAt(selectedRow, 0);
				String message="";
				try {
					message = studentdao.deleteStudent(id);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, message);
				updateFrame();
			}
			
		});
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		content=new Box(BoxLayout.Y_AXIS);
		content.add(editPanel);
		content.add(studentJsp);
		content.add(studentbuttonPanel);
		content.add(buttonPanel);
		add(content, BorderLayout.CENTER);
		setVisible(true);
		
	}
	
	public void createTextData() throws ClientProtocolException, IOException {
		for(Cource cource : courcedao.getCourceList()) {
			NameCource.addItem(cource.getCource());
		}
		Certification.addItem("Да");
		Certification.addItem("Нет");
		for(Teacher teacher : teacherdao.getTeacherList()) {
			Teacher.addItem(teacher.getTeacher());
		}
		for(StatusScience status : statusdao.getStatusList()) {
			StatusScience.addItem(status.getStatusScience());
		}
	}
	
	public static void addStudent(Student student) {
		studentlist.add(student);
	}
	
	public static void updateFrame() {
		modelTable=new StudentTableModel(studentlist);
		studentTable.setModel(modelTable);
		studentTable.updateUI();
	}

}
