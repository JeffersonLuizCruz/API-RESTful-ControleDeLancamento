package com.lacamento.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EntryFilter {
	
	private String description;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate expirationDateOf; //Data de vencimento de ...
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate expirationDateBy; //Data de vencimento até ...

}
