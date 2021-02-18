package com.lacamento.serviceinterfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacamento.model.Entry;
import com.lacamento.repository.filter.EntryFilter;
import com.lacamento.serviceimpl.ResultEntry;

public interface EntryService {
	
	
	public Page<Entry> list(EntryFilter entryFilter, Pageable pageable);
	
	public Entry search(Long id);
	
	public Entry save(Entry entry);

	public void delete(Long id);

	public Page<ResultEntry> resumir(EntryFilter entryFilter, Pageable pageable);
	
	public Entry update(Long id, Entry entry);

}
