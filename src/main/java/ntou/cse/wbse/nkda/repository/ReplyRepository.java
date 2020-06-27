package ntou.cse.wbse.nkda.repository;


import ntou.cse.wbse.nkda.entity.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface ReplyRepository extends MongoRepository<Reply, String> {
    public ArrayList<Reply> findByUserName(String userName);

    public ArrayList<Reply> findByYear(String year);
}

