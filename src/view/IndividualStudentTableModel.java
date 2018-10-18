package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logic.entity.IndividualStudent;

public class IndividualStudentTableModel implements TableModel {
	private Set<TableModelListener> listeners=new HashSet<TableModelListener>();
	private ArrayList<IndividualStudent> studentlist;
	
	public IndividualStudentTableModel(ArrayList<IndividualStudent> studentlist) {
		this.studentlist=studentlist;
	}

	@Override
	public int getRowCount() {
		return studentlist.size();
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
			return "ФИО";
		case 2:
			return "Должность";
		case 3:
			return "Телефон";
		case 4:
			return "Курс";
		case 5:
			return "Кол-во часов";
		case 6:
			return "Выдача удостоверения";
		case 7:
			return "Дата выдачи/отчисления";
		case 8:
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
		IndividualStudent student=studentlist.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return student.getIndividualStudent_ID();
		case 1:
			return student.getPhysface().getFIO();
		case 2:
			return student.getPhysface().getPost();
		case 3:
			return student.getPhysface().getPhoneFax();
		case 4:
			return student.getCource().getCource();
		case 5:
			return student.getCource().getNumberHours();
		case 6:
			return student.getDateCertification();
		case 7:
			if(student.getCertification()==1) {
				return "Да";
			} else if(student.getCertification()==0) {
				return "Нет";
			}
		case 8:
			return student.getTeacher();
			
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
