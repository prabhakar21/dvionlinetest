package com.bokaro.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bokaro.dto.QuestionDTO;
import com.bokaro.entity.Question;
import com.bokaro.mapper.QuestionMapper;
import com.bokaro.repository.QuestionRepository;
import com.bokaro.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Value("${imageFolder}")
	private String imagePath;
	
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public QuestionDTO create(QuestionDTO questionDTO, MultipartFile[] uploadfiles, String language,String rootPath,String testSetId) {
		List<MultipartFile> files = Arrays.asList(uploadfiles);
//		String extraPath = "images"+File.separator+"questions"+File.separator;
//		System.getProperty("user.home");
		String targetFolder = rootPath+"images"+File.separator+"questionImages";
		File targetFolderGenerated = new File(targetFolder);
		if(!targetFolderGenerated.exists())
			targetFolderGenerated.mkdirs();
		String imagePath = System.getProperty("user.home")+File.separator+this.imagePath+File.separator;
		int count =0;
		String randomStringImage = null;
		 for (MultipartFile file : files) {
			 count++;
			 String randomString = RandomStringUtils.randomAlphanumeric(5);
			 randomStringImage = randomString+RandomStringUtils.randomAlphanumeric(5)+count +".jpg";
			 String dbImagePath = File.separator+"images"+File.separator+"questionImages"+File.separator+randomStringImage;
			 if (file.isEmpty()) {
				 continue; 
	        }
//			 try {
//					BufferedImage image = ImageIO.read(file.getInputStream());
//					Integer width = image.getWidth();
//					Integer height = image.getHeight();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(imagePath+ randomStringImage);
				Path path1 = Paths.get(targetFolder+File.separator+ randomStringImage);
				Files.write(path, bytes);
				Files.write(path1, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(count==1){
				questionDTO.setQuestion(dbImagePath);
				questionDTO.setQuestionType("i");
			}else if(count == 2){
				questionDTO.setAnswer1(dbImagePath);
				questionDTO.setAnswer1Type("i");
			}else if(count == 3){
				questionDTO.setAnswer2(dbImagePath);
				questionDTO.setAnswer2Type("i");
			}else if(count == 4){
				questionDTO.setAnswer3(dbImagePath);
				questionDTO.setAnswer3Type("i");
			}else if(count == 5){
				questionDTO.setAnswer4(dbImagePath);
				questionDTO.setAnswer4Type("i");
			}else if(count == 6){
				questionDTO.setCorrectAnswer(dbImagePath);
				questionDTO.setCorrectAnswerType("i");
			}
		 }
		questionDTO.setLanguageType(language);
		questionDTO.setDateCreated(new Date());
		Question question = questionMapper.questionDTOToQuestion(questionDTO);
		question = questionRepository.saveAndFlush(question);
		return questionMapper.questionToQuestionDTO(question);
	}

	@Override
	public List<QuestionDTO> findAll() {
		List<Question> questionList = questionRepository.findAll();
		return questionMapper.questionListToQuestionDTOList(questionList);
	}

	@Override
	public List<QuestionDTO> findByQuestionSetGroupBy() {
		List<Question> questions = questionRepository.findByQuestionSetGroupBy();
		return questionMapper.questionListToQuestionDTOList(questions);
	}

	@Override
	public List<QuestionDTO> findByTestSetId(String testTypeId) {
		List<Question> questionList = questionRepository.findByTestSetId(testTypeId);
		return questionMapper.questionListToQuestionDTOList(questionList);
	}

	@Override
	public QuestionDTO findById(Long questionId) {
		Question question = questionRepository.findOne(questionId);
		return questionMapper.questionToQuestionDTO(question);
	}

	@Override
	public Long getNumberOfQuestion(String testSetId) {
		Long totalQuestion = questionRepository.findBySetId(testSetId);
		return totalQuestion;
	}

}
