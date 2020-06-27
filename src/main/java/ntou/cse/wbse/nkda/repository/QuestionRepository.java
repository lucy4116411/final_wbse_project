package ntou.cse.wbse.nkda.repository;


import ntou.cse.wbse.nkda.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
    public Question findQuestionByYear(String year);
}
