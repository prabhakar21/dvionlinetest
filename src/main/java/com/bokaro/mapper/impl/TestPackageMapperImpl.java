package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.TestPackageDTO;
import com.bokaro.entity.TestPackage;
import com.bokaro.mapper.TestPackageMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class TestPackageMapperImpl implements TestPackageMapper {

	@Override
	public TestPackageDTO testPackageToTestPackageDTO(TestPackage testPackage) {
		if(testPackage == null){
			return null;
		}
		TestPackageDTO testPackageDTO = new TestPackageDTO();
		testPackageDTO.setId(testPackage.getId());
		testPackageDTO.setCandidateId(testPackage.getCandidateId());
		testPackageDTO.setAmountPaid(testPackage.getAmountPaid());
		testPackageDTO.setDiscount(testPackage.getDiscount());
		testPackageDTO.setActualAmount(testPackage.getActualAmount());
		testPackageDTO.setNoOfTest(testPackage.getNoOfTest());
		testPackageDTO.setStartDate(testPackage.getStartDate());
		testPackageDTO.setEndDate(testPackage.getEndDate());
		testPackageDTO.setPackageStatus(testPackage.getPackageStatus());
		testPackageDTO.setPaymentStatus(testPackage.getPaymentStatus());
		testPackageDTO.setCreateDate(testPackage.getCreateDate());
		return testPackageDTO;
	}

	@Override
	public TestPackage testPackageDTOToTestPackage(TestPackageDTO testPackageDTO) {
		if(testPackageDTO == null){
			return null;
		}
		TestPackage testPackage = new TestPackage();
		testPackage.setId(testPackageDTO.getId());
		testPackage.setCandidateId(testPackageDTO.getCandidateId());
		testPackage.setAmountPaid(testPackageDTO.getAmountPaid());
		testPackage.setDiscount(testPackageDTO.getDiscount());
		testPackage.setActualAmount(testPackageDTO.getActualAmount());
		testPackage.setNoOfTest(testPackageDTO.getNoOfTest());
		testPackage.setStartDate(testPackageDTO.getStartDate());
		testPackage.setEndDate(testPackageDTO.getEndDate());
		testPackage.setPackageStatus(testPackageDTO.getPackageStatus());
		testPackage.setPaymentStatus(testPackageDTO.getPaymentStatus());
		testPackage.setCreateDate(testPackageDTO.getCreateDate());
		return testPackage;
	}

	@Override
	public List<TestPackage> testPackageDTOListToTestPackageList(List<TestPackageDTO> testPackageDTOList) {
		if(testPackageDTOList ==null){
			return null;
		}
		List<TestPackage> testPackageList = new ArrayList<>();
		for(TestPackageDTO testPackageDTO : testPackageDTOList){
			testPackageList.add(testPackageDTOToTestPackage(testPackageDTO));
		}
		return testPackageList;
	}

	@Override
	public List<TestPackageDTO> testPackageListToTestPackageDTOList(List<TestPackage> testPackageList) {
		if(testPackageList ==null){
			return null;
		}
		List<TestPackageDTO> testPackageDTOList = new ArrayList<>();
		for(TestPackage testPackage : testPackageList){
			testPackageDTOList.add(testPackageToTestPackageDTO(testPackage));
		}
		return testPackageDTOList;
	}

}
