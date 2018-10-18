package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.apache.http.client.ClientProtocolException;

import logic.dao.YurfaceDAO;
import logic.entity.Yurface;

public class NewYurfaceApp extends JFrame {
	public static TableModel model;
	public static JTable table;
	private JScrollPane jsp;
	private static YurfaceDAO yurfacedao;
	private Yurface yurface;
	
	
	public NewYurfaceApp() throws ClientProtocolException, IOException {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel view=new JPanel();
		JPanel buttonpanel=new JPanel();
		view.setLayout(new BorderLayout());
		buttonpanel.setLayout(new GridBagLayout());
		yurfacedao=new YurfaceDAO();
		model=new OrganizationTableModel(yurfacedao.getYurfaceList());
		table=new JTable();
		table.setModel(model);
		jsp=new JScrollPane(table);
		JButton newYurface=new JButton("Новое юр. лицо");
		JButton newPhysface=new JButton("Добавить заявку");
		newPhysface.setEnabled(false);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				newPhysface.setEnabled(true);
				
			}
			   
		   });
		newYurface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewYurface();
				
			}
			
		});
		newPhysface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				try {
					yurface=yurfacedao.getYurfaceById(id);
					new NewPhysfaceList(yurface);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		buttonpanel.add(newYurface, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	    buttonpanel.add(newPhysface, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		view.add(jsp);
		add(view, BorderLayout.CENTER);
		add(buttonpanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void updateFrame() throws ClientProtocolException, IOException {
		NewYurfaceApp.model=new OrganizationTableModel(yurfacedao.getYurfaceList());
		NewYurfaceApp.table.setModel(NewYurfaceApp.model);
		NewYurfaceApp.table.updateUI();
	}

}
