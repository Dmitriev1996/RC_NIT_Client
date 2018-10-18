package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

public class NewYurfaceInContract extends JFrame {
	private static JTable table;
	private static TableModel model;
	private JScrollPane jsp;
	private Box contentBox;
	private JPanel buttonPanel;
	private YurfaceDAO yurfacedao;
	private JButton newYurface=new JButton("Новое юр.лицо");
	private JButton updateYurface=new JButton("Редактировать");
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Отмена");
	
	public NewYurfaceInContract() throws ClientProtocolException, IOException {
		updateYurface.setEnabled(false);
		ok.setEnabled(false);
		yurfacedao=new YurfaceDAO();
		model=new YurfaceTableModel(yurfacedao.getYurfaceList());
		table=new JTable();
		table.setModel(model);
		jsp=new JScrollPane(table);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.add(newYurface, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(updateYurface, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(ok, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		buttonPanel.add(cancel, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateYurface.setEnabled(true);
				ok.setEnabled(true);
				
			}
			   
		   });
		newYurface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewYurface() {
					@Override
					protected void updateParentFrame() {
						NewYurfaceInContract.updateFrame();
					}
				};
				
			}
			
		});
		updateYurface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				Yurface yurface=null;
				try {
					yurface=yurfacedao.getYurfaceById(id);
					new UpdateYurface(yurface) {
						@Override
						protected void updateParentFrame() {
							NewYurfaceInContract.updateFrame();
						}
					};
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				int id=(int)model.getValueAt(selectedRow, 0);
				Yurface yurface=null;
				try {
					yurface=yurfacedao.getYurfaceById(id);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Yurface> yurfacelist=new ArrayList<Yurface>();
				yurfacelist.add(yurface);
				UpdateContractYurface.setYurfacelist(yurfacelist);
				UpdateContractYurface.updateFrame();
				
				
			}
			
		});
		contentBox=new Box(BoxLayout.Y_AXIS);
		contentBox.add(jsp);
		contentBox.add(buttonPanel);
		add(contentBox);
		setSize(500, 500);
		setVisible(true);
		
	}
	
	public static void updateFrame() {
		
	}
	
	public void updateParentFrame() {
		UpdateContractYurface.updateFrame();
	}

}
