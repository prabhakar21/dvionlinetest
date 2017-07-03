package com.bokaro.custom.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bokaro.custom.repository.TestPackageCustomRepository;
import com.bokaro.entity.TestPackage;

@Repository
public class TestPackageCustomRepositoryImpl implements TestPackageCustomRepository{

	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<TestPackage> findByPackageStatus(Date date) {
		StringBuffer queryStr = new StringBuffer("select tp from TestPackage tp where :date Between tp.startDate and tp.endDate");
		TypedQuery<TestPackage> typedQuery = em.createQuery(queryStr.toString(),TestPackage.class);
		typedQuery.setParameter("date", new Date(),TemporalType.DATE);
		List<TestPackage> resultList = typedQuery.getResultList();
		return resultList;
	}

	@Override
	public List<TestPackage> findExpirePackage(Date date) {
		StringBuffer queryStr = new StringBuffer("select tp from TestPackage tp where :date > tp.endDate");
		TypedQuery<TestPackage> typedQuery = em.createQuery(queryStr.toString(),TestPackage.class);
		typedQuery.setParameter("date", new Date(),TemporalType.DATE);
		List<TestPackage> resultList = typedQuery.getResultList();
		return resultList;
	}

	@Override
	public List<TestPackage> findAssignPackage(Date date) {
		StringBuffer queryStr = new StringBuffer("select tp from TestPackage tp where :date < tp.startDate");
		TypedQuery<TestPackage> typedQuery = em.createQuery(queryStr.toString(),TestPackage.class);
		typedQuery.setParameter("date", new Date(),TemporalType.DATE);
		List<TestPackage> resultList = typedQuery.getResultList();
		return resultList;
	}

	@Override
	public TestPackage findByActivePackage(Date date, Long candidateId) {
		StringBuffer queryStr = new StringBuffer("select tp from TestPackage tp where :date between tp.startDate and tp.endDate and tp.candidateId=:candidateId");
		TypedQuery<TestPackage> typedQuery = em.createQuery(queryStr.toString(),TestPackage.class);
		typedQuery.setParameter("date", new Date(),TemporalType.DATE);
		typedQuery.setParameter("candidateId", candidateId);
		TestPackage testpacakge = typedQuery.getSingleResult();
		return testpacakge;
	}

	
}
