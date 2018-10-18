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
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import logic.dao.CourceDAO;
import logic.dao.GroupDAO;
import logic.dao.TeacherDAO;
import logic.entity.Cource;
import logic.entity.Group;
import logic.entity.Student;
import logic.entity.Teacher;

public class NewGroup extends JFrame {
	private JLabel NameCourceText=new JLabel("Наименование курса");
	private JComboBox NameCource=new JComboBox();
	private JLabel CertificationText=new JLabel("Выдача удостоверения");
	private JComboBox Certification=new JComboBox();
	private JLabel TeacherText=new JLabel("Преподаватель");
	private JComboBox Teacher=new JComboBox();
	private static JTable table;
	private JScrollPane jsp;
	private static TableModel model;
	private static ArrayList<Student> studentList;
	private JPanel editPanel;
	private JPanel buttonPanel;
	private JPanel studentButtonPanel;
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private JButton newStudent=new JButton("Добавить студента");
	private JButton updateStudent=new JButton("Редактировать");
	private JButton deleteStudent=new JButton("Удалить");
	private Box content;
	private CourceDAO courcedao=new CourceDAO();
	private TeacherDAO teacherdao=new TeacherDAO();
	private GroupDAO groupdao=new GroupDAO();
	
	public NewGroup() throws ClientProtocolException, IOException {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		Dimension size=new Dimension(500, 20);
		NameCource.setPreferredSize(size);
		Certification.setPreferredSize(size);
		Teacher.setPreferredSize(size);
		studentList=new ArrayList<Student>();
		model=new StudentTableModel(studentList);
		table=new JTable(model);
		jsp=new JScrollPane(table);
		Box contentBox=new Box(BoxLayout.Y_AXIS);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String validateNameCource=NameCource.getSelectedItem()+"";
				String validateTeacher=Teacher.getSelectedItem()+"";
				String validateCertification=Certification.getSelectedItem()+"";
				Group group=new Group();
				Cource cource=new Cource();
				Teacher teacher=new Teacher();
				if(!validateNameCource.equals("null")) {
					cource.setCource(NameCource.getSelectedItem().toString());
				}
				if(!validateTeacher.equals("null")) {
					teacher.setTeacher(Teacher.getSelectedItem().toString());
				}
				group.setCource(cource);
				if(!validateCertification.equals("null")) {
					if(Certification.getSelectedItem().toString()=="Да") {
						group.setCertification((byte)1);
					} else if(Certification.getSelectedItem().toString()=="Нет") {
						group.setCertification((byte)0);
					}
				}
				group.setTeacher(teacher);
				group.setStatusScience_ID(1);
				group.setStudentList(studentList);
				String message="";
				try {
					message=groupdao.insertGroup(group);
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
		newStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new NewStudent();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
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
		editPanel.add(TeacherText, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		editPanel.add(Teacher, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		studentButtonPanel=new JPanel();
		studentButtonPanel.setLayout(new GridBagLayout());
		studentButtonPanel.add(newStudent, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		studentButtonPanel.add(updateStudent, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		studentButtonPanel.add(deleteStudent, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		createTextData();
		content=new Box(BoxLayout.Y_AXIS);
		content.add(editPanel);
		content.add(jsp);
		content.add(studentButtonPanel);
		content.add(buttonPanel);
		add(content, BorderLayout.CENTER);
		setVisible(true);
	}
	
	private void createTextData() throws ClientProtocolException, IOException {
		for(Cource cource : courcedao.getCourceList()) {
			NameCource.addItem(cource.getCource());
		}
		for(Teacher teacher : teacherdao.getTeacherList()) {
			Teacher.addItem(teacher.getTeacher());
		}
		Certification.addItem("Да");
		Certification.addItem("Нет");
	}
	
	private void updateParentFrame() throws ClientProtocolException, IOException {
		MetodGroup.updateFrame();
	}
	
	public static void updateFrame() {
		model=new StudentTableModel(studentList);
		table.setModel(model);
		table.updateUI();
	}
	
	public static void addStudent(Student student) {
		studentList.add(student);
	}
	

}
