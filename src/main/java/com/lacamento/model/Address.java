package com.lacamento.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Embeddable
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String street;
	private Long number;
	private String complement;
	private String city;

}
