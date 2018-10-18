package view;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.apache.http.client.ClientProtocolException;

public class EconomistMain extends JFrame {
	public EconomistMain() throws ClientProtocolException, IOException {
		super("Экономист");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JTabbedPane jtp=new JTabbedPane();
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtp.addTab("Договоры с физ. лицами", new EconomPhysfaceContract());
		jtp.addTab("Договоры с юр. лицами", new EconomYurfaceContract());
		jtp.addTab("Акты с физ. лицами", null/*new EconomPhysfaceAct()*/);
		jtp.add("Акты с юр. лицами", new EconomYurfaceAct());
		add(jtp, BorderLayout.CENTER);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
