package com.example.QCM.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QCM.entity.QCM;

@Repository
public interface QCMRepository extends JpaRepository<QCM, Long> {
    List<QCM> findByMatiereId(Long matiereId);
    Optional<QCM> findById(Long qcmId);
    }
