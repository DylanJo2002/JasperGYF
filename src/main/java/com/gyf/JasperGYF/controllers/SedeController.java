package com.gyf.JasperGYF.controllers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyf.JasperGYF.entities.JasperFileKeys;
import com.gyf.JasperGYF.entities.SedeEntity;
import com.gyf.JasperGYF.jasper.JasperSede;
import com.gyf.JasperGYF.respositories.SedeRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@RestController
@RequestMapping("/")
public class SedeController {
	
	@Autowired
	private JasperSede jasperSede;
	@Autowired
	private JasperFileKeys jasperFileKeys;
	@GetMapping
	public void getPDF() throws IOException {

		try {
			
//			File file = new File(jasperFileKeys.condiciones_1);
//			
//			JasperReport jasper = (JasperReport) JRLoader.loadObject(file);	
//			
//			JasperPrint print = JasperFillManager.fillReport(jasper, null,new JREmptyDataSource());
//
//			JasperExportManager.exportReportToPdfFile(print, "C:/Users/dbergano/Desktop/certificados/report.pdf");
			
			JasperPrint print = getCondicionesPDF();
			JasperExportManager.exportReportToPdfFile(print,"C:/Users/dbergano/Desktop/certificados/report.pdf");
			
		}catch(JRException e) {

		}
	}
	
	public JasperPrint getCondicionesPDF() throws JRException {
//		JasperReport subreport_c1 = (JasperReport) JRLoader.loadObjectFromFile(jasperFileKeys.condiciones_1);
//		JasperReport subreport_c2 = (JasperReport) JRLoader.loadObjectFromFile(jasperFileKeys.condiciones_2);
//		JasperReport subreport_c3 = (JasperReport) JRLoader.loadObjectFromFile(jasperFileKeys.condiciones_3);
//		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("subreport_c1", jasperFileKeys.condiciones_1);
		parameters.put("subreport_c2", jasperFileKeys.condiciones_2);
		parameters.put("subreport_c3", jasperFileKeys.condiciones_3);
		parameters.put("logo_url", jasperFileKeys.logo_report);
		

		JasperPrint print = JasperFillManager.fillReport(jasperFileKeys.condiciones, parameters,
							new JREmptyDataSource());
			
		return print;
	}
	

}
