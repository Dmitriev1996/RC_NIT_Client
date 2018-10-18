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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

import logic.dao.CourceDAO;
import logic.dao.GroupDAO;
import logic.dao.StudentDAO;
import logic.dao.TeacherDAO;
import logic.entity.AppTeach;
import logic.entity.Cource;
import logic.entity.Group;
import logic.entity.Physface;
import logic.entity.Student;
import logic.entity.Teacher;

public class MetodGroup extends JPanel {
	public static JTable groupTable;
	public static JTable studentTable;
	private JScrollPane groupjsp;
	private JScrollPane studentjsp;
	public static TableModel groupModel;
	public static TableModel studentModel;
	private JLabel HeaderText=new JLabel("Выборка по:");
	private JLabel BeginText=new JLabel("от");
	private JLabel EndText=new JLabel("до");
	private JLabel NameGroupText=new JLabel("Название группы");
	private JComboBox NameGroup=new JComboBox();
	private JCheckBox NameGroupCheck=new JCheckBox();
	private JLabel CourceText=new JLabel("Курс");
	private JComboBox Cource=new JComboBox();
	private JCheckBox CourceCheck=new JCheckBox();
	private JLabel TeacherText=new JLabel("Преподаватель");
	private JComboBox Teacher=new JComboBox();
	private JCheckBox TeacherCheck=new JCheckBox();
	private JLabel NumberHoursText=new JLabel("Количество часов");
	private JTextField NumberHoursFirst=new JTextField(5);
	private JTextField NumberHoursSecond=new JTextField(5);
	private JCheckBox NumberHoursCheck=new JCheckBox();
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	private JButton newGroup=new JButton("Новая группа");
	private JButton updateGroup=new JButton("Редактировать");
	private JButton deleteGroup=new JButton("Удалить");
	private Map<String, String> parameters=new LinkedHashMap<String, String>();
	private static GroupDAO groupdao;
	private StudentDAO studentdao;
	private CourceDAO courcedao;
	private TeacherDAO teacherdao;
	private ArrayList<Group> grouplist;
	private JPanel samples;
	private JPanel view;
	private JPanel params;
	private JPanel buttonsparam;
	private JPanel buttonpanel;
	private JPanel numberpanel;
	
	public MetodGroup() throws ClientProtocolException, IOException {
		setSize(300, 300);
		setLayout(new BorderLayout());
		updateGroup.setEnabled(false);
		deleteGroup.setEnabled(false);
		samples=new JPanel();
		samples.setLayout(new BorderLayout());
		view=new JPanel();
		Box tables=new Box(BoxLayout.Y_AXIS);
		courcedao=new CourceDAO();
		teacherdao=new TeacherDAO();
		groupdao=new GroupDAO();
		studentdao=new StudentDAO();
		grouplist=groupdao.getGroupList();
		groupModel=new GroupTableModel(grouplist);
		groupTable=new JTable(groupModel);
		groupjsp=new JScrollPane(groupTable);
		studentTable=new JTable();
		studentjsp=new JScrollPane(studentTable);
		params=new JPanel();
		buttonsparam=new JPanel();
		buttonpanel=new JPanel();
		buttonpanel.setLayout(new GridBagLayout());
		buttonsparam.setLayout(new GridBagLayout());
		buttonsparam.add(ok, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonsparam.add(cancel, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberpanel=new JPanel();
	    numberpanel.setLayout(new GridBagLayout());
	    numberpanel.add(BeginText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberpanel.add(NumberHoursFirst, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberpanel.add(EndText, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    numberpanel.add(NumberHoursSecond, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.setLayout(new GridBagLayout());
	    params.add(HeaderText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(NameGroupText, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(NameGroupCheck, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(NameGroup, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(CourceText, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(CourceCheck, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(Cource, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(TeacherText, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(TeacherCheck, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(Teacher, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(NumberHoursText, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(NumberHoursCheck, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    params.add(numberpanel, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    Dimension size=new Dimension(50, 20);
	    NameGroup.setPreferredSize(size);
	    Cource.setPreferredSize(size);
	    Teacher.setPreferredSize(size);
	    samples.add(params, BorderLayout.NORTH);
		samples.add(buttonsparam, BorderLayout.SOUTH);
		createSamples();
		NameGroupCheck.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					NameGroup.setEnabled(true);
				} else {
					NameGroup.setEnabled(false);
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
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameters.clear();
				String str="";
				if(NameGroupCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Group='"+NameGroup.getSelectedItem().toString()+"'";
					} else {
						str=" AND Group='"+NameGroup.getSelectedItem().toString()+"'";
					}
					parameters.put("Group", str);
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
				if(TeacherCheck.isSelected()) {
					if(parameters.isEmpty()) {
						str="Teacher='"+Teacher.getSelectedItem().toString()+"'";
					} else {
						str=" AND Teacher='"+Teacher.getSelectedItem().toString()+"'";
					}
					parameters.put("Teacher", str);
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
		
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					if(groupTable.getSelectedRowCount()>0) {
						groupTable.clearSelection();
						tables.remove(studentjsp);
						updateGroup.setEnabled(false);
						deleteGroup.setEnabled(false);
						updateUI();
					}
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			   
		   });
		
		groupTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					updateGroup.setEnabled(true);
					deleteGroup.setEnabled(true);
				}
				if(e.getClickCount()==2) {
					tables.add(studentjsp);
					ArrayList<Student> studentlist=null;
					int selectedRow=groupTable.getSelectedRow();
					int id=(int)groupModel.getValueAt(selectedRow, 0);
					Group group=null;
					try {
						group = groupdao.getGroupById(id);
					} catch (ClientProtocolException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					studentlist=group.getStudentList();
						/*for(Group group : grouplist) {
							if(group.getGroup_ID()==id) {
								studentlist=group.getStudentList();
							    
							}
						}*/
					studentModel=new StudentTableModel(studentlist);
					studentTable.setModel(studentModel);
					updateUI();
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			   
		   });
		
		newGroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new NewGroup();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		updateGroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=groupTable.getSelectedRow();
				int id=(int)groupModel.getValueAt(selectedRow, 0);
				try {
					new UpdateGroup(groupdao.getGroupById(id));
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		buttonpanel.add(newGroup, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonpanel.add(updateGroup, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonpanel.add(deleteGroup, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    view.setLayout(new BorderLayout());
	    tables.add(groupjsp);
	    //tables.add(studentjsp);
	    view.add(tables);
	    view.add(buttonpanel, BorderLayout.SOUTH);
	    add(samples, BorderLayout.WEST);
	    add(view, BorderLayout.CENTER);
	   
	}
	
	public void createSamples() throws ClientProtocolException, IOException {
		ArrayList<Cource> courcelist=courcedao.getCourceList();
		ArrayList<Teacher> teacherlist=teacherdao.getTeacherList();
		for(Cource cource : courcelist) {
			Cource.addItem(cource.getCource());
		}
		for(Teacher teacher : teacherlist) {
			Teacher.addItem(teacher.getTeacher());
		}
		NameGroup.setEnabled(false);
		Cource.setEnabled(false);
		Teacher.setEnabled(false);
		NumberHoursFirst.setEnabled(false);
		NumberHoursSecond.setEnabled(false);
	}
	
	public String createStringParameters() {
		String str="";
		for(Map.Entry entry : parameters.entrySet()) {
			str+=entry.getValue();
		}
		return str;
	}
	
	public static void updateAtParams(String params) throws ClientProtocolException, IOException {
		groupModel=new GroupTableModel(groupdao.getGroupListAtParams(params));
		groupTable.setModel(groupModel);
		groupTable.updateUI();
	}
	
	public static void updateFrame() throws ClientProtocolException, IOException {
		groupModel=new GroupTableModel(groupdao.getGroupList());
		groupTable.setModel(groupModel);
		groupTable.updateUI();
	}

}
