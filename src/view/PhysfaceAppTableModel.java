package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import logic.entity.AppTeach;

public class PhysfaceAppTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<AppTeach> appteachlist;
	
	public PhysfaceAppTableModel(ArrayList<AppTeach> appteachlist) {
		this.appteachlist=appteachlist;
	}
	

	@Override
	public int getRowCount() {
		return appteachlist.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
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
			return "Выдача удостоверений";
		case 4:
			return "Оплата";
		case 5:
			return "Тип обучения";
		case 6:
			return "Статус заявки";
		case 7:
			return "Примечание";
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
		AppTeach appteach=appteachlist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return appteach.getAppTeach_ID();
		case 1:
			return appteach.getFIO();
		case 2:
			return appteach.getCource();
		case 3:
			return appteach.getCertification();
		case 4:
			return appteach.getPay();
		case 5:
			return appteach.getTypeScience();
		case 6:
			return appteach.getStatusApp();
		case 7:
			return appteach.getComment();
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
