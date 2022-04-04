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
}
