package ntou.cse.wbse.nkda.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection = "reply")
public class Reply {
    @Id
    private String id;
    @Field("userName")
    private String userName;
    @Field("replies")
    private ArrayList<String> replies;
    @Field("year")
    private String year;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setReplies(ArrayList<String> replies) {
        this.replies = replies;
    }

    public ArrayList<String> getReplies() {
        return replies;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }
}