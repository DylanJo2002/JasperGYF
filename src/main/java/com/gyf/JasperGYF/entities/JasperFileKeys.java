package com.gyf.JasperGYF.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JasperFileKeys {
	@Value("${base_files}${c_report}")
	public String condiciones;
	@Value("${base_files}${c1_subreport}")
	public String condiciones_1;
	@Value("${base_files}${c2_subreport}")
	public String condiciones_2;
	@Value("${base_files}${c3_subreport}")
	public String condiciones_3;
	@Value("${base_files}${logo_report}")
	public String logo_report;
	@Value("${base_files}${amparos_report}")
	public String amparos;
	@Value("${base_files}${beneficiarios_report}")
	public String beneficiarios;
	@Value("${base_files}${main_report}")
	public String main_report;
	@Value("${base_files}${firma_report}")
	public String firma_report;
	@Value("${base_certificados}")
	public String base_certificados;
}
