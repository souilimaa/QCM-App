package com.example.QCM.DTO;

public class ChoiceRequestDto {
	 private Long questionId;
	    private String choixEnonce;
	    private boolean correct;
		public Long getQuestionId() {
			return questionId;
		}
		public void setQuestionId(Long questionId) {
			this.questionId = questionId;
		}
		public String getChoixEnonce() {
			return choixEnonce;
		}
		public void setChoixEnonce(String choixEnonce) {
			this.choixEnonce = choixEnonce;
		}
		public boolean isCorrect() {
			return correct;
		}
		public void setCorrect(boolean correct) {
			this.correct = correct;
		}
	    
}

