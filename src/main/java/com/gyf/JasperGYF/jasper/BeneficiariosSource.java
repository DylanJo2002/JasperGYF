package com.gyf.JasperGYF.jasper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gyf.JasperGYF.entities.SedeEntity;
import com.gyf.JasperGYF.entities.keys;
import com.gyf.JasperGYF.respositories.SedeRepository;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

@Component
public class BeneficiariosSource implements JRDataSource{
	
	private List<SedeEntity> sedes;
	private int index;
	
	
	@Autowired
	private SedeRepository sedeRepository;
	@Autowired
	private keys keys;
	
	@PostConstruct
	private void init() {
		sedes = new ArrayList<SedeEntity>();
		index = -1;
	}

	@Override
	public boolean next() throws JRException {
		index++;
		return index<sedes.size();
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;
		String fieldName = jrField.getName();
		
		SedeEntity sede = sedes.get(index);
		
		switch(fieldName) {
			case "nombres": 
				valor = sede.getNombres();
				break;
				
			case "parentesco": 
				valor = sede.getParentesco();
				break;
				
			case "porcentaje": 
				valor = sede.getPorcentaje();
				break;
				
			case "edad": 
				valor = sede.getEdad();
				break;
				
			case "pais": 
				valor = sede.getPais();
				break;			
			
		}
		
		return valor;
	}
	
	public void resetInfo() {
		sedes.clear();
		sedeRepository.findAll().forEach(sede -> sedes.add(sede));
		
		if(sedes.size() == 0) {
			sedes.add(new SedeEntity());
		}
		
		index = -1;
	}
}
