package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.TestSetDTO;
import com.bokaro.entity.TestSet;

@Mapper(componentModel = "spring", uses = {})
public interface TestSetMapper {

	TestSetDTO testSetToTestSetDTO(TestSet testSet);
	TestSet testSetDTOToTestSet(TestSetDTO testSetDTO);
	List<TestSet> testSetDTOListToTestSetList(List<TestSetDTO> testSetDTOList);
	List<TestSetDTO> testSetListToTestSetDTOList(List<TestSet> testSetList);
}
