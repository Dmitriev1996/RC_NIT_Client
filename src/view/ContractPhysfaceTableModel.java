package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.ContractOrderPhysface;

public class ContractPhysfaceTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<ContractOrderPhysface> contractphysfacelist;
	
	public ContractPhysfaceTableModel(ArrayList<ContractOrderPhysface> contractphysfacelist) {
		this.contractphysfacelist=contractphysfacelist;
	}

	@Override
	public int getRowCount() {
		return contractphysfacelist.size();
	}

	@Override
	public int getColumnCount() {
		return 10;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "№";
		case 1:
			return "Дата договора";
		case 2:
			return "ФИО";
		case 3:
			return "Курс";
		case 4:
			return "Кол-во";
		case 5:
			return "Стоимость";
		case 6:
			return "Дата оплаты";
		case 7:
			return "Реквизиты";
		case 8:
			return "Примечание";
		case 9:
			return "Договор закрыт";
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
		ContractOrderPhysface contractphysface=contractphysfacelist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return contractphysface.getContractsOrdersPhysfaces_ID();
		case 1:
			return contractphysface.getDateContract();
		case 2:
			return contractphysface.getFIO();
		case 3:
			return contractphysface.getCource();
		case 4:
			return contractphysface.getNumber();
		case 5:
			return contractphysface.getPrice();
		case 6:
			return contractphysface.getDatePay();
		case 7:
			return contractphysface.getDetailsContract();
		case 8:
			return contractphysface.getComment();
		case 9:
			return contractphysface.getCloseContract();
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
