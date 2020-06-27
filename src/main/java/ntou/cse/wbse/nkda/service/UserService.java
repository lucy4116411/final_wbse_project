package ntou.cse.wbse.nkda.service;

import ntou.cse.wbse.nkda.entity.Reply;
import ntou.cse.wbse.nkda.entity.User;
import ntou.cse.wbse.nkda.repository.ReplyRepository;
import ntou.cse.wbse.nkda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getUserInformation(String userName) {
        return repository.findByUserName(userName);
    }

    public User updateUser(String userName, User user) {
        User oldUser = repository.findByUserName(userName);

        User newUser = new User();
        newUser.setId(oldUser.getId());
        newUser.setUserName(oldUser.getUserName());
        newUser.setAuth(oldUser.getAuth());
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        newUser.setSchool(user.getSchool());
        newUser.setDepartment(user.getDepartment());
        newUser.setGrade(user.getGrade());
        newUser.setGender(user.getGender());
        newUser.setPhone(user.getPhone());
        newUser.setEmail(user.getEmail());
        newUser.setFacebook(user.getFacebook());
        newUser.setHowToKnow(user.getHowToKnow());

        return repository.save(newUser);
    }

    public ArrayList<User> getAllUsersInformation() {
        ArrayList<User> users = repository.findAll();
        return users;
    }

    public void deleteUser(String userName) {
        User user = repository.findByUserName(userName);
        if (user != null) {
            repository.delete(user);
        }
    }
}