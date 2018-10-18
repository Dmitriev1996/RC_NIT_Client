package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.OrderAdmission;

public class OrderAdmissionYurfaceTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<OrderAdmission> orderlist;
	
	public OrderAdmissionYurfaceTableModel(ArrayList<OrderAdmission> orderlist) {
		this.orderlist=orderlist;
	}

	@Override
	public int getRowCount() {
		return orderlist.size();
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
			return "№ договора";
		case 2:
			return "Курс";
		case 3:
			return "Дата начала обучения";
		case 4:
			return "Дата окончания обучения";
		case 5:
			return "Преподаватель";
		case 6:
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
		OrderAdmission order=orderlist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return order.getOrderAdmission_ID();
		case 1:
			return order.getContractsOrdersYurfaces_ID();
		case 2:
			return order.getCource();
		case 3:
			return order.getDateBeginScience();
		case 4:
			return order.getDateEndScience();
		case 5:
			return order.getTeacher();
		case 6:
			return order.getStatusOrder();
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
