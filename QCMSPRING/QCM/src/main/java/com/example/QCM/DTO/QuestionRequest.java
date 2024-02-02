package com.example.QCM.DTO;


public class QuestionRequest {
    private Long idQcm;
    private String ennonce;

    public QuestionRequest() {
    }

    public Long getIdQcm() {
        return idQcm;
    }

    public void setIdQcm(Long idQcm) {
        this.idQcm = idQcm;
    }

    public String getEnnonce() {
        return ennonce;
    }

    public void setEnnonce(String ennonce) {
        this.ennonce = ennonce;
    }
    
    
}
