

package com.example.QCM.service;

import java.util.List;

import com.example.QCM.entity.Choix;

public interface ChoixService {

    // Other method declarations if any

    /**
     * Adds a new choice to a question.
     *
     * @param questionId   the ID of the question to which the choice is to be added
     * @param choixEnonce  the text of the choice
     * @param isCorrect    whether the choice is correct or not
     * @return the saved choice
     */
    Choix addChoice(Long questionId, String choixEnonce, boolean isCorrect);
	List<Choix> getChoixByQuestionId(long questionId);
	List<Choix> getChoicesForQuestion(long questionId);
    // Other method declarations if any
}
