package view;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.apache.http.client.ClientProtocolException;

public class MetodistMain extends JFrame {
	public MetodistMain() throws ClientProtocolException, IOException {
		super("Методист");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JTabbedPane jtp=new JTabbedPane();
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtp.addTab("Группы", new MetodGroup());
		jtp.addTab("Индивидуальные слушатели", new MetodIndividualStudent());
		jtp.addTab("Индивидуальное расписание", new MetodIndividualClass());
		jtp.addTab("Групповое раписание", new MetodGroupClass());
		jtp.addTab("Приказы о зачислении (юр. лица)", new MetodOrderAdmissionYurface());
		jtp.addTab("Приказы о зачислении (физ. лица)", new MetodOrderAdmissionPhysface());
		jtp.addTab("Приказы об отчислении", null/*new MetodOrderDismissal()*/);
		jtp.addTab("Зачёты", new MetodExamine());
		add(jtp, BorderLayout.CENTER);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
