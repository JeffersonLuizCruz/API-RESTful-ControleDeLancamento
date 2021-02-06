package com.lacamento.exceptionhandler;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ApiError implements Serializable{
	private static final long serialVersionUID = 1L;

	private int code;
	private String msg;
	private LocalDate date;
}
