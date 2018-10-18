package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.Examine;

public class ExamineTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<Examine> examinelist;
	
	public ExamineTableModel(ArrayList<Examine> examinelist) {
		this.examinelist=examinelist;
	}

	@Override
	public int getRowCount() {
		return examinelist.size();
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
			return "Кол-во часов";
		case 3:
			return "Дата зачёта";
		case 4:
			return "Преподаватель";
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
		Examine examine=examinelist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return examine.getExamine_ID();
		case 1:
			return examine.getCource();
		case 2:
			return examine.getNumberHours();
		case 3:
			return examine.getDateExamine();
		case 4:
			return examine.getTeacher();
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
