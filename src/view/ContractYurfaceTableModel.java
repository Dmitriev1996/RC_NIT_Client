package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.ContractOrderYurface;

public class ContractYurfaceTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<ContractOrderYurface> contractyurfacelist;
	
	public ContractYurfaceTableModel(ArrayList<ContractOrderYurface> contractyurfacelist) {
		this.contractyurfacelist=contractyurfacelist;
	}

	@Override
	public int getRowCount() {
		return contractyurfacelist.size();
	}

	@Override
	public int getColumnCount() {
		return 15;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "№";
		case 1:
			return "Дата договора";
		case 2:
			return "Наименование организации";
		case 3:
			return "Услуга";
		case 4:
			return "Вид договора";
		case 5:
			return "Вид оплаты";
		case 6:
			return "Дата начала";
		case 7:
			return "дата окончания";
		case 8:
			return "Стоимость";
		case 9:
			return "Период оплаты";
		case 10:
			return "Сумма к оплате";
		case 11:
			return "Сумма в год";
		case 12:
			return "Реквизиты";
		case 13:
			return "Примечание";
		case 15:
			return "Договор закрыт";
		}
		return "";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String .class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ContractOrderYurface contractyurface=contractyurfacelist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return contractyurface.getContractsOrdersYurfaces_ID();
		case 1:
			return contractyurface.getDateContract();
		case 2:
			return contractyurface.getNameOrganization();
		case 3:
			return contractyurface.getCource();
		case 4:
			return contractyurface.getTypeContract();
		case 5:
			return contractyurface.getPayType();
		case 6:
			return contractyurface.getDateBegin();
		case 7:
			return contractyurface.getDateEnd();
		case 8:
			return contractyurface.getPrice();
		case 9:
			return contractyurface.getPayPeriod();
		case 10:
			return contractyurface.getSumPay();
		case 11:
			return contractyurface.getSumYear();
		case 12:
			return contractyurface.getDetailsContract();
		case 13:
			return contractyurface.getComment();
		case 14:
			return contractyurface.getCloseContract();
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
