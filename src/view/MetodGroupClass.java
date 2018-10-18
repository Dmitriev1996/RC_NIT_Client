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
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import com.toedter.calendar.JDateChooser;

import logic.dao.CourceDAO;
import logic.dao.GroupClassDAO;
import logic.dao.TeacherDAO;
import logic.entity.Cource;
import logic.entity.Teacher;

public class MetodGroupClass extends JPanel {
	private JLabel HeaderText=new JLabel("Выборка по:");
	private JLabel BeginText=new JLabel("с");
	private JLabel EndText=new JLabel("по");
	private JLabel CourceText=new JLabel("Курс");
	private JComboBox Cource=new JComboBox();
	private JCheckBox CourceCheck=new JCheckBox();
	private JLabel DateText=new JLabel("Дата занятия");
	private JDateChooser DateFirst=new JDateChooser();
	private JDateChooser DateSecond=new JDateChooser();
	private JCheckBox DateCheck=new JCheckBox();
	private JLabel TeacherText=new JLabel("Преподаватель");
	private JComboBox Teacher=new JComboBox();
	private JCheckBox TeacherCheck=new JCheckBox();
	private JLabel NumberText=new JLabel("№ аудитории");
	private JTextField NumberFirst=new JTextField(5);
	private JTextField NumberSecond=new JTextField(5);
	private JCheckBox NumberCheck=new JCheckBox();
	private JPanel paramPanel;
	private JPanel buttonParamPanel;
	private JPanel samples;
	private JPanel view;
	private JPanel buttonPanel;
	private JPanel datePanel;
	private JPanel numberPanel;
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private JButton newClass=new JButton("Добавить занятие");
	private JButton updateClass=new JButton("Редактиоровать");
	private JButton deleteClass=new JButton("Удалить");
	private TableModel classModel;
	private JTable classTable;
	private JScrollPane classJsp;
	private CourceDAO courcedao=new CourceDAO();
	private TeacherDAO teacherdao=new TeacherDAO();
	private GroupClassDAO classdao=new GroupClassDAO();
	private Map<String, String> parameters=new LinkedHashMap<String, String>();
	
	public MetodGroupClass() throws ClientProtocolException, IOException {
		setSize(300, 300);
		setLayout(new BorderLayout());
		updateClass.setEnabled(false);
		deleteClass.setEnabled(false);
		samples=new JPanel();
		samples.setLayout(new BorderLayout());
		paramPanel=new JPanel();
		paramPanel.setLayout(new GridBagLayout());
		buttonParamPanel=new JPanel();
		buttonParamPanel.setLayout(new GridBagLayout());
		view=new JPanel();
		view.setLayout(new BorderLayout());
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		classModel=new GroupClassTableModel(classdao.getClassList());
		classTable=new JTable(classModel);
		classJsp=new JScrollPane(classTable);
		buttonParamPanel.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonParamPanel.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberPanel=new JPanel();
	    numberPanel.setLayout(new GridBagLayout());
	    numberPanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberPanel.add(NumberFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberPanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberPanel.add(NumberSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
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
	    paramPanel.add(HeaderText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(CourceText, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(CourceCheck, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Cource, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(DateText, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(DateCheck, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(datePanel, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(TeacherText, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(TeacherCheck, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(Teacher, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(NumberText, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(NumberCheck, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    paramPanel.add(numberPanel, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonPanel.add(newClass, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonPanel.add(updateClass, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonPanel.add(deleteClass, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    samples.add(paramPanel, BorderLayout.NORTH);
	    samples.add(buttonParamPanel, BorderLayout.SOUTH);
	    Dimension size=new Dimension(50, 20);
	    Cource.setPreferredSize(size);
	    Teacher.setPreferredSize(size);
	    createSamples();
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
	    NumberCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					NumberFirst.setEnabled(true);
					NumberSecond.setEnabled(true);
				} else {
					NumberFirst.setEnabled(false);
					NumberSecond.setEnabled(false);
				}
				
			}
	    	
	    });
	    ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameters.clear();
				String str="";
				if(CourceCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Cource='"+Cource.getSelectedItem().toString()+"'";
					} else {
						str=" AND Cource='"+Cource.getSelectedItem().toString()+"'";
					}
					parameters.put("Cource", str);
					str="";
				}
				if(DateCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(DateFirst.getDate().toString()!="") {
							Date ubegindate=DateFirst.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateClass>='"+sbegindate+"'";
						}
						if(DateSecond.getDate().toString()!="") {
							Date uenddate=DateSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							if(str!="") {
							   str+=" AND DateClass<='"+senddate+"'";
							} else {
								str="DateClass<='"+senddate+"'";
							}
						}
					} else {
						if(DateSecond.getDate().toString()!="") {
							Date ubegindate=DateSecond.getDate();
							java.sql.Date sbegindate=new java.sql.Date(ubegindate.getTime());
							str="DateClass>='"+sbegindate+"'";
						}
						if(DateSecond.getDate().toString()!="") {
							Date uenddate=DateSecond.getDate();
							java.sql.Date senddate=new java.sql.Date(uenddate.getTime());
							str+=" AND DateClass<='"+senddate+"'";
						}
					}
					parameters.put("DateClass", str);
					str="";
				}
				if(TeacherCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Teacher='"+Teacher.getSelectedItem().toString()+"'";
					} else {
						str=" AND Teacher='"+Teacher.getSelectedItem().toString()+"'";
					}
				}
				if(NumberCheck.isSelected()) {
					if(parameters.isEmpty()) {
						if(NumberFirst.getText()!="") {
						  str="NumberAudience>="+NumberFirst.getText();
						}
						if(NumberSecond.getText()!="") {
							if(str!="") {
								str+=" AND NumberAudience<="+NumberSecond.getText();
							} else {
								str+="NumberAudience<="+NumberSecond.getText();
							}
						}
					} else {
						if(NumberFirst.getText()!="") {
							str="AND NumberAudience>="+NumberFirst.getText();
						}
						if(NumberSecond.getText()!="") {
							str+="AND NumberAudience<="+NumberSecond.getText();
						}
					}
					parameters.put("NumberAudience", str);
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
	    view.add(classJsp);
	    view.add(buttonPanel, BorderLayout.SOUTH);
	    add(samples, BorderLayout.WEST);
	    add(view, BorderLayout.CENTER);
	}
	
	private void createSamples() throws ClientProtocolException, IOException {
		for(Cource cource : courcedao.getCourceList()) {
			Cource.addItem(cource.getCource());
		}
		for(Teacher teacher : teacherdao.getTeacherList()) {
			Teacher.addItem(teacher.getTeacher());
		}
		Cource.setEnabled(false);
		DateFirst.setEnabled(false);
		DateSecond.setEnabled(false);
		Teacher.setEnabled(false);
		NumberFirst.setEnabled(false);
		NumberSecond.setEnabled(false);
	}
	
	private String createStringParameters() {
	String str="";
		for(Map.Entry entry : parameters.entrySet()) {
			str+=entry.getValue();
		}
		return str;
    }

	private void updateAtParams(String params) throws ClientProtocolException, IOException {
		classModel=new GroupClassTableModel(classdao.getClassListAtParams(params));
		classTable.setModel(classModel);
		classTable.updateUI();
	}

}
