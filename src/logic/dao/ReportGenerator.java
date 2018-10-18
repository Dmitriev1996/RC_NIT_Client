package logic.dao;

import java.util.ArrayList;
import java.util.HashMap;

import logic.entity.ContractOrderPhysface;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportGenerator {
	String Path="C:\\RCNIT";
	
	public void generateReport(ArrayList<ContractOrderPhysface> list) {
		try {
			JasperReport jasperReport=JasperCompileManager.compileReport(Path+"\\Leaf_Green.jrxml");
			/*JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, new HashMap(), new JRBeanCollectionDataSource(list));
			JasperViewer jasperViewer=new JasperViewer(jasperPrint);
			jasperViewer.setVisible(true);
			JasperExportManager.exportReportToPdfFile(jasperPrint, Path+"\\report.pdf");*/
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
