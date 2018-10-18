package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.IndividualClass;

public class IndividualClassTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<IndividualClass> classlist;
	
	public IndividualClassTableModel(ArrayList<IndividualClass> classlist) {
		this.classlist=classlist;
	}

	@Override
	public int getRowCount() {
		return classlist.size();
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
			return "ФИО";
		case 2:
			return "Курс";
		case 3:
			return "Дата занятия";
		case 4:
			return "Преподаватель";
		case 5:
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
		IndividualClass classes=classlist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return classes.getIndividualClass_ID();
		case 1:
			return classes.getIndividualStudent().getPhysface().getFIO();
		case 2:
			return classes.getIndividualStudent().getCource().getCource();
		case 3:
			return classes.getDateClass();
		case 4:
			return classes.getIndividualStudent().getTeacher();
		case 5:
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
