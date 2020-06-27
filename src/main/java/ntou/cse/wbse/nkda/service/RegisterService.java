package ntou.cse.wbse.nkda.service;

import ntou.cse.wbse.nkda.entity.Reply;
import ntou.cse.wbse.nkda.entity.User;
import ntou.cse.wbse.nkda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class RegisterService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private ReplyService replyService;

    public User createUser(User user) {
        User existUser = repository.findByUserName(user.getUserName());
        if (existUser != null) {
            return null;
        } else {
            repository.insert(user);
            Reply reply = new Reply();
            reply.setUserName(user.getUserName());
            ArrayList<String> replies = new ArrayList<String>(Arrays.asList("", "", "", "", ""));
            reply.setReplies(replies);
            reply.setYear("2020");
            replyService.createReply(reply);
            return user;
        }
    }
}
