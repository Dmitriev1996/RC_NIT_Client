package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.Examinee;

public class ExamineeTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<Examinee> studentList;
	
	public ExamineeTableModel(ArrayList<Examinee> studentList) {
		this.studentList=studentList;
	}

	@Override
	public int getRowCount() {
		return studentList.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "№";
		case 1:
			return "ФИО";
		case 2:
			return "Оценка";
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
		Examinee student=studentList.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return student.getStudent_ID();
		case 1:
			return student.getFIO();
		case 2:
			return student.getMark();
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
