package com.bokaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bokaro.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query("select q from Question q group by q.testSetId")
	List<Question> findByQuestionSetGroupBy();

	List<Question> findByTestSetId(String testTypeId);

	@Modifying
	@Query("delete from Question q where q.testSetId=?1")
	void deleteByTestSetId(String id);

	@Query("select count(q) from Question q where q.testSetId=?1")
	Long findBySetId(String testSetId);
}
