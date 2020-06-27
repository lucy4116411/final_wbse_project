package ntou.cse.wbse.nkda.repository;

import ntou.cse.wbse.nkda.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByUserName(String userName);

    public ArrayList<User> findAll();

    Boolean existsByUserName(String userName);

}
