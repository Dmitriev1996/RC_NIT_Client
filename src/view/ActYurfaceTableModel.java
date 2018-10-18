package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.ActOrderYurface;

public class ActYurfaceTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<ActOrderYurface> actyurfacelist;
	
	public ActYurfaceTableModel(ArrayList<ActOrderYurface> actyurfacelist) {
		this.actyurfacelist=actyurfacelist;
	}
	
	@Override
	public int getRowCount() {
		return actyurfacelist.size();
	}
	@Override
	public int getColumnCount() {
		return 9;
	}
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "№";
		case 1:
			return "№ договора";
		case 2:
			return "Дата акта";
		case 3:
			return "Наименование организации";
		case 4:
			return "Услуга";
		case 5:
			return "Сумма";
		case 6:
			return "Дата оплаты";
		case 7:
			return "Примечание";
		case 8:
			return "Возврат акта";
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
		ActOrderYurface actyurface=actyurfacelist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return actyurface.getActsOrdersYurface_ID();
		case 1:
			return actyurface.getContractsOrdersYurfaces_ID();
		case 2:
			return actyurface.getDateAct();
		case 3:
			return actyurface.getNameOrganization();
		case 4:
			return actyurface.getCource();
		case 5:
			return actyurface.getPrice();
		case 6:
			return actyurface.getDatePay();
		case 7:
			return actyurface.getComment();
		case 8:
			return actyurface.getReturnAct();
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
