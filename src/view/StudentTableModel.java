package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.Student;

public class StudentTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<Student> studentlist;
	
	public StudentTableModel(ArrayList<Student> studentlist) {
		this.studentlist=studentlist;
	}
	
	@Override
	public int getRowCount() {
		return studentlist.size();
	}
	@Override
	public int getColumnCount() {
		return 5;
	}
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "№";
		case 1 :
			return "ФИО";
		case 2:
			return "Должность";
		case 3:
			return "Телефон";
		case 4:
			return "Дата выдачи/отчисления";
		}
		return "";
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student=studentlist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return student.getStudent_ID();
		case 1:
			return student.getPhysface().getFIO();
		case 2:
			return student.getPhysface().getPost();
		case 3:
			return student.getPhysface().getPhoneFax();
		case 4:
			return student.getDateCertification();
		}
		return "";
	}
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addTableModelListener(TableModelListener listener) {
		listeners.add(listener);
		
	}
	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
