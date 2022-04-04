package com.gyf.JasperGYF.jasper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gyf.JasperGYF.entities.AmparoEntity;
import com.gyf.JasperGYF.entities.SedeEntity;
import com.gyf.JasperGYF.entities.keys;
import com.gyf.JasperGYF.respositories.AmparoRepository;
import com.gyf.JasperGYF.respositories.SedeRepository;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

@Component
public class AmparoSource implements JRDataSource{
	
	private List<AmparoEntity> amparos;
	private int index;
	
	
	@Autowired
	private AmparoRepository amparoRepository;
	@Autowired
	private keys keys;
	
	@PostConstruct
	private void init() {
		amparos = new ArrayList<AmparoEntity>();
		index = -1;
	}

	@Override
	public boolean next() throws JRException {
		index++;
		return index<amparos.size();
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;
		String fieldName = jrField.getName();
		
		AmparoEntity amparo = amparos.get(index);
		
		switch(fieldName) {
			case "amparo": 
				valor = amparo.getAmparo();
				break;			
		}
		
		return valor;
	}
	
	
	public void resetInfo() {
		amparos.clear();
		amparoRepository.findAll().forEach(sede -> amparos.add(sede));
		
		if(amparos.size() == 0) {
			amparos.add(new AmparoEntity());
		}
		
		index = -1;
	}
}
