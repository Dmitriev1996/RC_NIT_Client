package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.Group;

public class GroupTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<Group> grouplist;
	
	public GroupTableModel(ArrayList<Group> grouplist) {
		this.grouplist=grouplist;
	}

	@Override
	public int getRowCount() {
		return grouplist.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "№";
		case 1:
			return "Наименование курса";
		case 2:
			return "Выдача удостоверения";
		case 3:
			return "Преподаватель";
		case 4:
			return "Кол-во часов";
		case 5:
			return "Статус";
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
		Group group=grouplist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return group.getGroup_ID();
		case 1:
			return group.getCource().getCource();
		case 2:
			if(group.getCertification()==1) {
				return "Да";
			} else {
				return "Нет";
			}
		case 3:
			return group.getTeacher().getTeacher();
		case 4:
			return group.getCource().getNumberHours();
		case 5:
			return group.getStatusScience();
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
