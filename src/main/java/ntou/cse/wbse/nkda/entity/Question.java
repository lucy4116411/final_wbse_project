package ntou.cse.wbse.nkda.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Document(collection = "question")
public class Question {
    @Id
    private String id;
    @Field("year")
    private String year;
    @Field("questions")
    private Map<String, Integer> questions;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public Map<String, Integer> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<String, Integer> questions) {
        this.questions = questions;
    }


}