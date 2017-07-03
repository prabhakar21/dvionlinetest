package com.bokaro.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bokaro.custom.repository.TestPackageCustomRepository;
import com.bokaro.dto.TestPackageDTO;
import com.bokaro.entity.TestPackage;
import com.bokaro.entity.User;
import com.bokaro.exception.ProgramException;
import com.bokaro.mapper.TestPackageMapper;
import com.bokaro.repository.TestPackageRepository;
import com.bokaro.repository.UserRepository;
import com.bokaro.service.ResultService;
import com.bokaro.service.TestPackageService;

@Service
@Transactional
public class TestPackageServiceImpl implements TestPackageService {

	@Autowired
	private TestPackageMapper testPackageMapper;
	@Autowired
	private TestPackageRepository testPackageRepository;
	@Autowired
	private ResultService resultService;
	@Autowired
	private TestPackageCustomRepository TestPackageCustomRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public TestPackageDTO create(TestPackageDTO testPackageDTO)throws ProgramException {
		TestPackage testPackage1 = testPackageRepository.findByCadidateId(testPackageDTO.getCandidateId(),new Date());
		if(testPackage1 == null){
			if(testPackageDTO.getActualAmount() > testPackageDTO.getAmountPaid() && testPackageDTO.getDiscount() == 0){
				testPackageDTO.setPaymentStatus("pending");
			}else if(testPackageDTO.getDiscount() != 0 || testPackageDTO.getDiscount() == null){
				testPackageDTO.setPaymentStatus("discount");
			}else{
				testPackageDTO.setPaymentStatus("full");
			}
			testPackageDTO.setPackageStatus("Active");
			testPackageDTO.setCreateDate(new Date());
			TestPackage testPackage = testPackageMapper.testPackageDTOToTestPackage(testPackageDTO);
			testPackage = testPackageRepository.saveAndFlush(testPackage);
			return testPackageMapper.testPackageToTestPackageDTO(testPackage);
		}
		return null;
	}

	@Override
	public List<TestPackageDTO> findActivePackage() throws ProgramException{
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-mm-dd");
		String currentDate = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1)+"-"+now.get(Calendar.DATE);
		String strOutput1 = null;
		Date date = null;
		try {
			strOutput1 = sdfmt.format(sdfmt.parse(currentDate));
			date = sdfmt.parse(strOutput1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<TestPackage> testPackages = TestPackageCustomRepository.findByPackageStatus(date);
		List<TestPackageDTO> testPackageDTOList = testPackageMapper.testPackageListToTestPackageDTOList(testPackages);
		for(TestPackageDTO testPackageDto : testPackageDTOList){
			Long noOfGivenTest = resultService.getNoOfTestByCandidateId(testPackageDto.getCandidateId());
			testPackageDto.setNoOfTest(testPackageDto.getNoOfTest()-noOfGivenTest);
			User user = userRepository.findByCandidateId(testPackageDto.getCandidateId());
			testPackageDto.setUsername(user.getUserName());
		}
		return testPackageDTOList;
	}

	@Override
	public List<TestPackageDTO> findExpirePackage() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-mm-dd");
		String currentDate = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1)+"-"+now.get(Calendar.DATE);
		String strOutput1 = null;
		Date date = null;
		try {
			strOutput1 = sdfmt.format(sdfmt.parse(currentDate));
			date = sdfmt.parse(strOutput1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<TestPackage> testPackages = TestPackageCustomRepository.findExpirePackage(date);
		List<TestPackageDTO> testPackageDTOList = testPackageMapper.testPackageListToTestPackageDTOList(testPackages);
		for(TestPackageDTO testPackageDto : testPackageDTOList){
			Long noOfGivenTest = resultService.getNoOfTestByCandidateId(testPackageDto.getCandidateId());
			testPackageDto.setNoOfTest(testPackageDto.getNoOfTest()-noOfGivenTest);
			User user = userRepository.findByCandidateId(testPackageDto.getCandidateId());
			testPackageDto.setUsername(user.getUserName());
			testPackageDto.setPackageStatus("Expire");
		}
		return testPackageDTOList;
	}

	@Override
	public List<TestPackageDTO> findAssignPackage() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-mm-dd");
		String currentDate = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1)+"-"+now.get(Calendar.DATE);
		String strOutput1 = null;
		Date date = null;
		try {
			strOutput1 = sdfmt.format(sdfmt.parse(currentDate));
			date = sdfmt.parse(strOutput1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<TestPackage> testPackages = TestPackageCustomRepository.findAssignPackage(date);
		List<TestPackageDTO> testPackageDTOList = testPackageMapper.testPackageListToTestPackageDTOList(testPackages);
		for(TestPackageDTO testPackageDto : testPackageDTOList){
			Long noOfGivenTest = resultService.getNoOfTestByCandidateId(testPackageDto.getCandidateId());
			testPackageDto.setNoOfTest(testPackageDto.getNoOfTest()-noOfGivenTest);
			User user = userRepository.findByCandidateId(testPackageDto.getCandidateId());
			testPackageDto.setUsername(user.getUserName());
			testPackageDto.setPackageStatus("Not Active");
		}
		return testPackageDTOList;
	}

	@Override
	public TestPackageDTO findActivePackage(Long candidateId) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-mm-dd");
		String currentDate = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1)+"-"+now.get(Calendar.DATE);
		String strOutput1 = null;
		Date date = null;
		try {
			strOutput1 = sdfmt.format(sdfmt.parse(currentDate));
			date = sdfmt.parse(strOutput1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		TestPackage testPackages = TestPackageCustomRepository.findByActivePackage(date,candidateId);
		return testPackageMapper.testPackageToTestPackageDTO(testPackages);
	}

}
