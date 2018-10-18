package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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

import logic.dao.CourceDAO;
import logic.dao.IndividualStudentDAO;
import logic.dao.PhysfaceDAO;
import logic.dao.TeacherDAO;
import logic.entity.Cource;
import logic.entity.Physface;
import logic.entity.Teacher;

public class MetodIndividualStudent extends JPanel {
	private JLabel HeaderText=new JLabel("Выборка по:");
	private JLabel BeginText=new JLabel("c");
	private JLabel EndText=new JLabel("по");
	private JLabel FIOText=new JLabel("ФИО");
	private JComboBox FIO=new JComboBox();
	private JCheckBox FIOCheck=new JCheckBox();
	private JLabel PostText=new JLabel("Должность");
	private JComboBox Post=new JComboBox();
	private JCheckBox PostCheck=new JCheckBox();
	private JLabel PhoneText=new JLabel("Телефон");
	private JComboBox Phone=new JComboBox();
	private JCheckBox PhoneCheck=new JCheckBox();
	private JLabel CourceText=new JLabel("Курс");
	private JComboBox Cource=new JComboBox();
	private JCheckBox CourceCheck=new JCheckBox();
	private JLabel NumberHoursText=new JLabel("Кол-во часов");
	private JTextField NumberHoursFirst=new JTextField(5);
	private JTextField NumberHoursSecond=new JTextField(5);
	private JCheckBox NumberHoursCheck=new JCheckBox();
	private JLabel DateCertificationText=new JLabel("Дата выдачи/отчисления");
	private JDateChooser DateFirst=new JDateChooser();
	private JDateChooser DateSecond=new JDateChooser();
	private JCheckBox DateCheck=new JCheckBox();
	private JLabel CertificationText=new JLabel("Выдача удостоверения");
	private JComboBox Certification=new JComboBox();
	private JCheckBox CertificationCheck=new JCheckBox(); 
	private JLabel TeacherText=new JLabel("Преподаватель");
	private JComboBox Teacher=new JComboBox();
	private JCheckBox TeacherCheck=new JCheckBox();
	private JTable studentTable;
	private JScrollPane studentJsp;
	private JPanel samples;
	private JPanel paramPanel;
	private JPanel buttonsParamPanel;
	private JPanel buttonPanel;
	private JPanel view;
	private JPanel numberPanel;
	private JPanel datePanel;
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private JButton newStudent=new JButton("Новый студент");
	private JButton updateStudent=new JButton("Редактировать");
	private JButton deleteStudent=new JButton("Удалить");
	private IndividualStudentDAO studentdao=new IndividualStudentDAO();
	private PhysfaceDAO physfacedao=new PhysfaceDAO();
	private CourceDAO courcedao=new CourceDAO();
	private TeacherDAO teacherdao=new TeacherDAO();
	private TableModel studentModel;
	private Map<String, String> parameters=new LinkedHashMap<String, String>();
	
	public MetodIndividualStudent() throws ClientProtocolException, IOException{
		setSize(300, 300);
		setLayout(new BorderLayout());
		updateStudent.setEnabled(false);
		deleteStudent.setEnabled(false);
		samples=new JPanel();
		samples.setLayout(new BorderLayout());
		paramPanel=new JPanel();
		paramPanel.setLayout(new GridBagLayout());
		buttonsParamPanel=new JPanel();
		buttonsParamPanel.setLayout(new GridBagLayout());
		view=new JPanel();
		view.setLayout(new BorderLayout());
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		studentModel=new IndividualStudentTableModel(studentdao.getStudentList());
		studentTable=new JTable(studentModel);
		studentJsp=new JScrollPane(studentTable);
		buttonsParamPanel.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonsParamPanel.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberPanel=new JPanel();
	    numberPanel.setLayout(new GridBagLayout());
	    numberPanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberPanel.add(NumberHoursFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberPanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberPanel.add(NumberHoursSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    datePanel=new JPanel();
	    datePanel.setLayout(new GridBagLayout());
	    datePanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    datePanel.add(DateFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    datePanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    datePanel.add(DateSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(FIOText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(FIOCheck, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(FIO, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(PostText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(PostCheck, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Post, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(PhoneText, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(PhoneCheck, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Phone, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(CourceText, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(CourceCheck, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Cource, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(NumberHoursText, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(NumberHoursCheck, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(numberPanel, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(DateCertificationText, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(DateCheck, new GridBagConstraints(0, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(datePanel, new GridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(CertificationText, new GridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(CertificationCheck, new GridBagConstraints(0, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Certification, new GridBagConstraints(1, 13, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(TeacherText, new GridBagConstraints(1, 14, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(TeacherCheck, new GridBagConstraints(0, 15, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Teacher, new GridBagConstraints(1, 15, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonPanel.add(newStudent, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonPanel.add(updateStudent, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonPanel.add(deleteStudent, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    samples.add(paramPanel, BorderLayout.NORTH);
	    samples.add(buttonsParamPanel, BorderLayout.SOUTH);
	    Dimension size=new Dimension(50, 20);
	    FIO.setPreferredSize(size);
	    Post.setPreferredSize(size);
	    Phone.setPreferredSize(size);
	    Cource.setPreferredSize(size);
	    Certification.setPreferredSize(size);
	    Teacher.setPreferredSize(size);
	    createSamples();
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
	    PostCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Post.setEnabled(true);
				} else {
					Post.setEnabled(false);
				}
				
			}
	    	
	    });
	    PhoneCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Phone.setEnabled(true);
				} else {
					Phone.setEnabled(false);
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
	    NumberHoursCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					NumberHoursFirst.setEnabled(true);
					NumberHoursSecond.setEnabled(true);
				} else {
					NumberHoursFirst.setEnabled(false);
					NumberHoursSecond.setEnabled(false);
				}
				
			}
	    	
	    });
	    DateCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					DateFirst.setEnabled(true);
					DateSecond.setEnabled(true);
				} else {
					DateFirst.setEnabled(false);
					DateSecond.setEnabled(false);
				}
				
			}
	    	
	    });
	    CertificationCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Certification.setEnabled(true);;
				} else {
					Certification.setEnabled(false);
				}
				
			}
	    	
	    });
	    TeacherCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					Teacher.setEnabled(true);
				} else {
					Teacher.setEnabled(false);
				}
				
			}
	    	
	    });
	    ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameters.clear();
				String str="";
				if(FIOCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="FIO='"+FIO.getSelectedItem().toString()+"'";
					} else {
						str=" AND FIO='"+FIO.getSelectedItem().toString()+"'";
					}
					parameters.put("FIO", str);
					str="";
				}
				if(PostCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Post='"+Post.getSelectedItem().toString()+"'";
					} else {
						str=" AND Post='"+Post.getSelectedItem().toString()+"'";
					}
					parameters.put("Post", str);
					str="";
				}
				if(PhoneCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="PhoneFax='"+Phone.getSelectedItem().toString()+"'";
					} else {
						str=" AND PhoneFax='"+Phone.getSelectedItem().toString()+"'";
					}
					parameters.put("PhoneFax", str);
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
				if(NumberHoursCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(NumberHoursFirst.getText()!="") {
						  str="NumberHours>="+NumberHoursFirst.getText();
						}
						if(NumberHoursSecond.getText()!="") {
							if(str!="") {
								str+=" AND NumberHours<="+NumberHoursSecond.getText();
							} else {
								str+="NumberHours<="+NumberHoursSecond.getText();
							}
						}
					} else {
						if(NumberHoursFirst.getText()!="") {
							str="AND NumberHours>="+NumberHoursFirst.getText();
						}
						if(NumberHoursSecond.getText()!="") {
							str+="AND NumberHours<="+NumberHoursSecond.getText();
						}
					}
					parameters.put("NumberHours", str);
					str="";
				}
				if(DateCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(DateFirst.getDate().toString()!="") {
							Date ubegindate=DateFirst.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateCertification>='"+sbegindate+"'";
						}
						if(DateSecond.getDate().toString()!="") {
							Date uenddate=DateSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							if(str!="") {
							   str+=" AND DateCertification<='"+senddate+"'";
							} else {
								str="DateCertification<='"+senddate+"'";
							}
						}
					} else {
						if(DateFirst.getDate().toString()!="") {
							Date ubegindate=DateFirst.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateCertification>='"+sbegindate+"'";
						}
						if(DateSecond.getDate().toString()!="") {
							Date uenddate=DateSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							str+=" AND DateCertification<='"+senddate+"'";
						}
					}
					parameters.put("DateCertification", str);
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
	    studentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateStudent.setEnabled(true);
				deleteStudent.setEnabled(true);
				
			}
	    	
	    });
	    view.add(studentJsp);
	    view.add(buttonPanel, BorderLayout.SOUTH);
	    add(samples, BorderLayout.WEST);
	    add(view, BorderLayout.CENTER);
		
	}
	
	private void createSamples() throws ClientProtocolException, IOException {
		for(Physface physface : physfacedao.getPhysfaceList()) {
			FIO.addItem(physface.getFIO());
			Post.addItem(physface.getPost());
			Phone.addItem(physface.getPhoneFax());
		}
		for(Cource cource : courcedao.getCourceList()) {
			Cource.addItem(cource.getCource());
		}
		Certification.addItem("Да");
		Certification.addItem("Нет");
		for(Teacher teacher : teacherdao.getTeacherList()) {
			Teacher.addItem(teacher.getTeacher());
		}
		FIO.setEnabled(false);
		Post.setEnabled(false);
		Phone.setEnabled(false);
		Cource.setEnabled(false);
		NumberHoursFirst.setEnabled(false);
		NumberHoursSecond.setEnabled(false);
		DateFirst.setEnabled(false);
		DateSecond.setEnabled(false);
		Certification.setEnabled(false);
		Teacher.setEnabled(false);
	}
	
	private void updateAtParams(String params) throws ClientProtocolException, IOException {
		studentModel=new IndividualStudentTableModel(studentdao.getStudentListAtParams(params));
		studentTable.setModel(studentModel);
		studentTable.updateUI();
	}
	
	private String createStringParameters() {
		String str="";
		for(Map.Entry entry : parameters.entrySet()) {
			str+=entry.getValue();
		}
		return str;
	}

}
