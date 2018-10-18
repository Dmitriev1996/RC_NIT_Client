package view;

import java.awt.BorderLayout;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import org.apache.http.client.ClientProtocolException;

public class SecretaryMain extends JFrame {
	public SecretaryMain() throws ClientProtocolException, IOException {
		super("Секретарь");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JTabbedPane jtp=new JTabbedPane();
		setSize(800, 600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jtp.addTab("Физ. лица", new SecretaryPhysface());
    	jtp.addTab("Юр. лица", new SecretaryYurface());
    	add(jtp, BorderLayout.CENTER);
    	setVisible(true);
    	setLocationRelativeTo(null);
		
	}
	

}
