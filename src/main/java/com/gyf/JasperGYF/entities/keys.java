package com.gyf.JasperGYF.entities;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class keys {
	
	@Value("${asesor}")
	private String asesor;
	@Value("${ip}")
	private String ip;
	@Value("${agencia}")
	private String agencia;
	@Value("${cobro}")
	private String cobro;
	@Value("${descripcionAgencia}")
	private String descripcionAgencia;
	@Value("${asesor}")
	private String cobroTransaccion;
	@Value("${fechaExpedicion}")
	private String fechaExpedicion;
	@Value("${valorPrima}")
	private String valorPrima;
	@Value("${vigenciaPoliza}")
	private String vigenciaPoliza;
	@Value("${valorAsegurado}")
	private String valorAsegurado;
	@Value("${medioPago}")
	private String medioPago;
	@Value("${nombreCompleto}")
	private String nombreCompleto;
	@Value("${numeroDocumento}")
	private String numeroDocumento;
	@Value("${telefono}")
	private String telefono;
	@Value("${departamento}")
	private String departamento;
	@Value("${celular}")
	private String celular;
	@Value("${fechaNacimiento}")
	private String fechaNacimiento;
	@Value("${genero}")
	private String genero;
	@Value("${ocupacion}")
	private String ocupacion;
	@Value("${empresa}")
	private String empresa;
	@Value("${tipoDocumento}")
	private String tipoDocumento;
	@Value("${direccion}")
	private String direccion;
	@Value("${ciudad}")
	private String ciudad;
	@Value("${correo}")
	private String correo;
	@Value("${nacionalidad}")
	private String nacionalidad;
	@Value("${lugarNacimiento}")
	private String lugarNacimiento;
	@Value("${estadoCivil}")
	private String estadoCivil;
	@Value("${ingresosMensuales}")
	private String ingresosMensuales;
	@Value("${ppe}")
	private String ppe;
	
	public Map<String, Object> getKeys(){
		Map<String, Object> keys = new HashMap<String, Object>();
		
		keys.put("asesor", asesor);
		keys.put("ip", ip);
		keys.put("agencia", agencia);
		keys.put("cobro", cobro);	
		keys.put("descripcionAgencia", descripcionAgencia);	
		keys.put("cobroTransaccion",cobroTransaccion );	
		keys.put("fechaExpedicion", fechaExpedicion);	
		keys.put("valorPrima", valorPrima);	
		keys.put("vigenciaPoliza", vigenciaPoliza);	
		keys.put("valorAsegurado", valorAsegurado);	
		keys.put("medioPago",medioPago );	
		keys.put("nombreCompleto", nombreCompleto);	
		keys.put("numeroDocumento", numeroDocumento);	
		keys.put("telefono",telefono );	
		keys.put("departamento",departamento );	
		keys.put("celular", celular);
		keys.put("fechaNacimiento",fechaNacimiento );
		keys.put("genero", genero);
		keys.put("ocupacion", ocupacion);
		keys.put("empresa", empresa);
		keys.put("tipoDocumento", tipoDocumento);
		keys.put("direccion", direccion);
		keys.put("ciudad", ciudad);
		keys.put("correo", correo);
		keys.put("nacionalidad", nacionalidad);
		keys.put("lugarNacimiento",lugarNacimiento );
		keys.put("estadoCivil", estadoCivil);
		keys.put("ingresosMensuales", ingresosMensuales);
		keys.put("ppe", ppe);
		
		
		return keys;
	}

}
