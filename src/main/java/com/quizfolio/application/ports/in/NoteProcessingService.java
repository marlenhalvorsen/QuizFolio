package com.quizfolio.application.ports.in;

import com.quizfolio.domain.model.Question;
import java.util.List;

public interface NoteProcessingService {
    List<Question> generateQuestionFromNotes(String rawNotes);
}
