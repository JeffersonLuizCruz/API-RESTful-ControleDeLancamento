package com.lacamento.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class Event extends ApplicationEvent{
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private Long id;
	
	public Event(Object source, HttpServletResponse response, Long id) {
		super(source);
		this.response = response;
		this.id = id;
	}

}
