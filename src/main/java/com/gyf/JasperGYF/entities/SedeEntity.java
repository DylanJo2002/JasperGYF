package com.gyf.JasperGYF.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="certificado")
@Data
public class SedeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombres;
	@Column
	private String parentesco;
	@Column
	private String porcentaje;
	@Column
	private String edad;
	@Column
	private String pais;


}
