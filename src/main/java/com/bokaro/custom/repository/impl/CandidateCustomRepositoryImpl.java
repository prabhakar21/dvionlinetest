package com.bokaro.custom.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.bokaro.custom.repository.CandidateCustomRepository;
import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.entity.CandidateRegistration;

@Repository
public class CandidateCustomRepositoryImpl implements CandidateCustomRepository {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<CandidateRegistration> searchCandidate(String name, String email, String mobileNumber, String date) {
		StringBuffer queryStr = new StringBuffer("select c from CandidateRegistration c where c.fullname like :name");
		boolean hasEmail = false, hasMobileNumber = false, hasDate = false;
		if (StringUtils.isNotEmpty(email)) {
			queryStr.append(" and c.email = :email");
			hasEmail = true;
		}
		if (StringUtils.isNotEmpty(mobileNumber)) {
			queryStr.append(" and c.contactNumber = :mobileNumber");
			hasMobileNumber = true;
		}
		if (StringUtils.isNotEmpty(date)) {
			queryStr.append(" and c.date = :date");
			hasDate = true;
		}
		TypedQuery<CandidateRegistration> typedQuery = em.createQuery(queryStr.toString(), CandidateRegistration.class);
		typedQuery.setParameter("name", "%" + name + "%");
		if (hasEmail) {
			typedQuery.setParameter("email", email);
		}
		if (hasMobileNumber) {
			typedQuery.setParameter("mobileNumber", mobileNumber);
		}
		if (hasDate) {
			typedQuery.setParameter("date", date);
		}
		List<CandidateRegistration> resultList = typedQuery.getResultList();
		return resultList;
	}

	@Override
	public List<CandidateRegistrationDTO> findByTestSetId(Long testSetId) {
		StringBuffer queryStr = new StringBuffer("SELECT cts.id,c.fullname,c.email FROM candidate_registration c,candidate_test_set_configuration cts,test_set tt where cts.candidate_id=c.id and cts.test_set_id=tt.id and tt.id=:testSetId");
		Query query = em.createNativeQuery(queryStr.toString());
		query.setParameter("testSetId", testSetId);
		List<Object[]> objects = query.getResultList();
		List<CandidateRegistrationDTO> candidateRegistrationDTOList= new ArrayList<CandidateRegistrationDTO>();
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) == null)
                continue;
			CandidateRegistrationDTO candidateRegistrationDTO = new CandidateRegistrationDTO();
			if(objects.get(i)[0] != null)
				candidateRegistrationDTO.setCandidateTestSetConfigurationId((new Long(objects.get(i)[0].toString())));
			if(objects.get(i)[1] != null)
				candidateRegistrationDTO.setFullname(objects.get(i)[1].toString());
			if(objects.get(i)[2] != null)
				candidateRegistrationDTO.setEmail(objects.get(i)[2].toString());
			candidateRegistrationDTOList.add(candidateRegistrationDTO);
		}
		return candidateRegistrationDTOList;
	}

}
