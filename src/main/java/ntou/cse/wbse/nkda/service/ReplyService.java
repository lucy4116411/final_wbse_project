package ntou.cse.wbse.nkda.service;

import ntou.cse.wbse.nkda.entity.Reply;
import ntou.cse.wbse.nkda.repository.ReplyRepository;
import ntou.cse.wbse.nkda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;


    public ArrayList<Reply> getAllReplyByYear(String year) {
        return replyRepository.findByYear(year);
    }

    public Reply getReply(String userName, String year) {
        ArrayList<Reply> replies = replyRepository.findByUserName(userName);
        for (Reply reply : replies) {
            if (year.equals(reply.getYear())) {
                return reply;
            }
        }
        return null;
    }

    public Reply createReply(Reply reply) {
        ArrayList<Reply> redundantReply = replyRepository.findByUserName(reply.getUserName());
        if (redundantReply != null) {
            for (Reply rep : redundantReply) {
                if (rep.getYear() == reply.getYear()) {
                    return null;
                }
            }
        }
        return replyRepository.insert(reply);
    }

    public Reply updateReply(String userName, String year, ArrayList<String> saveData) {
        ArrayList<Reply> replies = replyRepository.findByUserName(userName);
        Reply oldReply = replies.get(0);
        Reply newReply = new Reply();
        if (oldReply != null) {
            newReply.setId(oldReply.getId());
            newReply.setUserName(oldReply.getUserName());
            newReply.setYear("2020");
            newReply.setReplies(saveData);
            return replyRepository.save(newReply);
        } else {
            return null;
        }
    }

    public void deleteReply(String userName) {
        ArrayList<Reply> replies = replyRepository.findByUserName(userName);
        if (replies != null) {
            replyRepository.deleteAll(replies);
        }
    }
}