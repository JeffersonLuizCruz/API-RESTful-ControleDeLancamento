package com.lacamento.repository.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.lacamento.model.Person;
import com.lacamento.repository.person.PersonRepositoryQuery;

public class PersonRepositoryImpl implements PersonRepositoryQuery{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Page<Person> filterByPerson(PersonFilter personFilter, Pageable pageable) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		
		Root<Person> root = criteriaQuery.from(Person.class);
		
		Predicate[] predicates = this.createRestrictions(personFilter, criteriaBuilder, root);
		criteriaQuery.where(predicates);
		
		TypedQuery<Person> typedQuery = entityManager.createQuery(criteriaQuery);
		addPaginationRestriction(typedQuery, pageable);
		
		
		return new PageImpl<>(typedQuery.getResultList(), pageable, this.total(personFilter));
	}
	
	private Predicate[] createRestrictions(PersonFilter personFilter, CriteriaBuilder criteriaBuilder, Root<Person> root) {
		
		List<Predicate> listaPredicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(personFilter.getName())) {
			listaPredicates.add(criteriaBuilder.like(
									criteriaBuilder.lower(root.get("nome")), 
									"%"+personFilter.getName()+"%"));
		}
		
		if(!StringUtils.isEmpty(personFilter.getActive())) {
			listaPredicates.add(criteriaBuilder.equal(
									root.get("ativo"), 
									personFilter.getActive()));
		}
		
		return listaPredicates.toArray(new Predicate[listaPredicates.size()]);
	}
	
	//Observação: mudar esse código
	private void addPaginationRestriction(TypedQuery<?> typedQuery, Pageable pageable) {
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		typedQuery.setFirstResult(primeiroRegistroDaPagina);
		typedQuery.setMaxResults(totalRegistroPorPagina);
	}
	
	private Long total(PersonFilter personFilter) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		
		Root<Person> root = criteriaQuery.from(Person.class);
		
		Predicate[] predicates = this.createRestrictions(personFilter, criteriaBuilder, root);
		
		criteriaQuery.where(predicates);
		
		criteriaQuery.select(criteriaBuilder.count(root));
		
		return entityManager.createQuery(criteriaQuery).getSingleResult();
		
	}

}
