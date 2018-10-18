package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.Physface;

public class PhysfaceListTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<Physface> physfacelist;
	
	public PhysfaceListTableModel(ArrayList<Physface> physfacelist) {
		this.physfacelist=physfacelist;
	}
	
	@Override
	public int getRowCount() {
		return physfacelist.size();
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
			return "ФИО";
		case 2:
			return "Должность";
		case 3:
			return "Телефон/факс";
		case 4:
			return "Web-сайт";
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
		Physface physface=physfacelist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return physface.getPhys_ID();
		case 1:
			return physface.getFIO();
		case 2:
			return physface.getPost();
		case 3:
			return physface.getPhoneFax();
		case 4:
			return physface.getWebsite();
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
