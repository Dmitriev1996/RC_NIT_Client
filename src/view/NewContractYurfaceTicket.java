package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import logic.entity.ContractOrderYurface;

public class NewContractYurfaceTicket extends JFrame {
	private JLabel SerialText=new JLabel("Серия");
	private JTextField Serial=new JTextField(10);
	private JLabel DateText=new JLabel("Дата");
	private JDateChooser Date=new JDateChooser();
	private JLabel ClientText=new JLabel("Клиент");
	private JTextField Client=new JTextField(10);
	private JLabel NameWorkText=new JLabel("Наименование услуги");
	private JTextField NameWork=new JTextField(10);
	private JLabel NumberText=new JLabel("Количество");
	private JTextField Number=new JTextField(10);
	private JLabel SumText=new JLabel("Сумма");
	private JTextField Sum=new JTextField(10);
	private JLabel WorkerText=new JLabel("Исполнитель");
	private JTextField Worker=new JTextField(10);
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	
	public NewContractYurfaceTicket(ContractOrderYurface contract) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());
		add(SerialText, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Serial, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(DateText, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Date, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(ClientText, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Client, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(NameWorkText, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(NameWork, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(ok, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(NumberText, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Number, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(SumText, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Sum, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(WorkerText, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(Worker, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(cancel, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		createTextData(contract);
		setSize(500, 500);
		setVisible(true);
	}
	
	public void createTextData(ContractOrderYurface contract) {
		Date.setDate(new java.util.Date());
		Client.setText(contract.getNameOrganization());
		NameWork.setText(contract.getCource());
		Sum.setText(contract.getPrice()+"");
	}

}
