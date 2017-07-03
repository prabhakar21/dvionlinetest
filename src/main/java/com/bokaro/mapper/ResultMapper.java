package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.ResultDTO;
import com.bokaro.entity.Result;

@Mapper(componentModel = "spring", uses = {})
public interface ResultMapper {

	ResultDTO resultToResultDTO(Result result);
	Result resultDTOToResult(ResultDTO resultDTO);
	List<Result> resultDTOListToResultList(List<ResultDTO> resultDTOList);
	List<ResultDTO> resultListToResultDTOList(List<Result> resultList);
}
