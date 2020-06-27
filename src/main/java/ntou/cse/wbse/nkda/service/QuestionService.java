package ntou.cse.wbse.nkda.service;

import ntou.cse.wbse.nkda.entity.Question;
import ntou.cse.wbse.nkda.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public ArrayList<String> getQuestionsOfAYear(String year) {
        Question questionOfAYear = questionRepository.findQuestionByYear(year);
        Map<String, Integer> questionsMap = questionOfAYear.getQuestions();
        ArrayList<String> questions = new ArrayList<String>(questionsMap.keySet());
        return questions;
    }
}