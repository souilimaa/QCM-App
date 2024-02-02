package com.example.QCM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QCM.entity.EtudiantAnswer;

@Repository
public interface EtudiantAnswerRepository extends JpaRepository<EtudiantAnswer, Long> {

    // You can add custom query methods if needed, for example:
    // List<EtudiantAnswer> findBySomeCriteria(...);

}