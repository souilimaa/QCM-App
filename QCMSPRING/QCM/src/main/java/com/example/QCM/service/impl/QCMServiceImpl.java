package com.example.QCM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.QCM.service.QCMService;
import com.example.QCM.entity.QCM;
import com.example.QCM.repository.QCMRepository;


@Service
public class QCMServiceImpl implements QCMService {

    @Autowired
    private QCMRepository qcmRepository;

    @Override
    public List<QCM> getAllQCMs() {
        return qcmRepository.findAll();
    }

 
    @Override
    public List<QCM> getQcmByMatiereId(Long matiereId) {
        return qcmRepository.findByMatiereId(matiereId);
    }
    @Override
    public QCM getQCMById(Long qcmId) {
        return qcmRepository.findById(qcmId).orElse(null);
    }

    @Override
    public QCM createQCM(QCM qcm) {
        return qcmRepository.save(qcm);
    }
	
}
