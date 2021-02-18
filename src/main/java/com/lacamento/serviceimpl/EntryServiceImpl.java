package com.lacamento.serviceimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacamento.model.Entry;
import com.lacamento.repository.filter.EntryFilter;
import com.lacamento.serviceinterfaces.EntryService;

public class EntryServiceImpl implements EntryService{

	@Override
	public Page<Entry> list(EntryFilter entryFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry search(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry save(Entry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<ResultEntry> resumir(EntryFilter entryFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry update(Long id, Entry entry) {
		// TODO Auto-generated method stub
		return null;
	}

}
