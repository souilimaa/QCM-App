package com.example.QCM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QCM.entity.Choix;

@Repository
public interface ChoixRepository extends JpaRepository<Choix, Long> {
	List<Choix> findByQuestionId(Long questionId);
}
