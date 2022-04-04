package com.gyf.JasperGYF.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyf.JasperGYF.entities.JasperFileKeys;
import com.gyf.JasperGYF.entities.SedeEntity;
import com.gyf.JasperGYF.entities.keys;
import com.gyf.JasperGYF.jasper.AmparoSource;
import com.gyf.JasperGYF.jasper.BeneficiariosSource;
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
	private BeneficiariosSource beneficiarioSource;
	@Autowired
	private AmparoSource amparoSource;
	@Autowired
	private JasperFileKeys jasperFileKeys;
	private String uuidCondiciones;
	private String uuidMain;
	@Autowired
	private keys key;
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
			createTempPDFs();
			mergePdfTemps();

		}catch(JRException e) {
			System.out.println("Error");
		}
	}
	
	public JasperPrint getCondicionesPDF() throws JRException {	
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("subreport_c1", jasperFileKeys.condiciones_1);
		parameters.put("subreport_c2", jasperFileKeys.condiciones_2);
		parameters.put("subreport_c3", jasperFileKeys.condiciones_3);
		parameters.put("logo_url", jasperFileKeys.logo_report);
		

		JasperPrint print = JasperFillManager.fillReport(jasperFileKeys.condiciones, parameters,
							new JREmptyDataSource());
			
		return print;
	}
	
	public JasperPrint getDatosPdf() throws JRException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("beneficiarios_subreport", jasperFileKeys.beneficiarios);
		parameters.put("amparo_subreport", jasperFileKeys.amparos);
		parameters.put("beneficiarios_source", beneficiarioSource);
		parameters.put("amparo_source", amparoSource);
		parameters.put("logo_url", jasperFileKeys.logo_report);
		parameters.put("firma_report",jasperFileKeys.firma_report);
		JasperReport jasper = (JasperReport) JRLoader.loadObject(new File(jasperFileKeys.main_report));	
		
		JasperPrint print = JasperFillManager.fillReport(jasper, parameters,new JREmptyDataSource());
		return print;
	}

	public void createTempPDFs() throws JRException {
		uuidCondiciones = UUID.randomUUID().toString();
		uuidMain = UUID.randomUUID().toString();
		JasperPrint print_condiciones = getCondicionesPDF();
		JasperPrint print_main = getDatosPdf();
		JasperExportManager.exportReportToPdfFile(print_condiciones, jasperFileKeys.base_certificados
				+"/temp/"+uuidCondiciones+".pdf");
		JasperExportManager.exportReportToPdfFile(print_main, jasperFileKeys.base_certificados
				+"/temp/"+uuidMain+".pdf");
	}

	public void mergePdfTemps() throws IOException {
		File condiciones = new File(jasperFileKeys.base_certificados+"/temp/"+uuidCondiciones+".pdf");
		File main = new File(jasperFileKeys.base_certificados+"/temp/"+uuidMain+".pdf");

		PDFMergerUtility pdm = new PDFMergerUtility();
		
		pdm.addSource(main);
		pdm.addSource(condiciones);
		
		pdm.setDestinationFileName(jasperFileKeys.base_certificados+key.getNumeroDocumento()+".pdf");
		pdm.mergeDocuments(null);
	}
}
