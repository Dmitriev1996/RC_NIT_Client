package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.Yurface;

public class OrganizationTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<Yurface> yurfacelist;
	
	public OrganizationTableModel(ArrayList<Yurface> yurfacelist) {
		this.yurfacelist=yurfacelist;
	}
	
	@Override
	public int getRowCount() {
		return yurfacelist.size();
	}
	@Override
	public int getColumnCount() {
		return 7;
	}
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "№";
		case 1:
			return "Наименование организации";
		case 2:
			return "Директор";
		case 3:
			return "Юр. адрес";
		case 4:
			return "Факт. адрес";
		case 5:
			return "Телефон/факс";
		case 6:
			return "E-mail";
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
		Yurface yurface=yurfacelist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return yurface.getYur_ID();
		case 1:
			return yurface.getNameOrganization();
		case 2:
			return yurface.getDirector();
		case 3:
			return yurface.getYurAdress();
		case 4:
			return yurface.getFactAdress();
		case 5:
			return yurface.getEmail();
		case 6:
			return yurface.getPhoneFax();
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
