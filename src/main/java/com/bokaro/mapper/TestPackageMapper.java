package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.TestPackageDTO;
import com.bokaro.entity.TestPackage;

@Mapper(componentModel = "spring", uses = {})
public interface TestPackageMapper {

	TestPackageDTO testPackageToTestPackageDTO(TestPackage testPackage);
	TestPackage testPackageDTOToTestPackage(TestPackageDTO testPackageDTO);
	List<TestPackage> testPackageDTOListToTestPackageList(List<TestPackageDTO> testPackageDTOList);
	List<TestPackageDTO> testPackageListToTestPackageDTOList(List<TestPackage> testPackageList);
}
