package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.GroupClass;

public class GroupClassTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<GroupClass> classlist;
	
	public GroupClassTableModel(ArrayList<GroupClass> classlist) {
		this.classlist=classlist;
	}

	@Override
	public int getRowCount() {
		return classlist.size();
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
		case 1:
			return "Курс";
		case 2:
			return "Дата занятия";
		case 3:
			return "Преподаватель";
		case 4:
			return "№ аудитории";
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
		GroupClass classes=classlist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return classes.getGroupClasses_ID();
		case 1:
			return classes.getGroup().getCource().getCource();
		case 2:
			return classes.getDateClass();
		case 3:
			return classes.getGroup().getTeacher().getTeacher();
		case 4:
			return classes.getNumberAudience();
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
