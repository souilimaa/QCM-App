package com.example.QCM.service;

import java.util.List;

import com.example.QCM.entity.QCM;

public interface QCMService {
    List<QCM> getAllQCMs();
    QCM createQCM(QCM qcm);
    List<QCM> getQcmByMatiereId(Long matiereId);
    QCM getQCMById(Long qcmId);
}
