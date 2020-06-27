package ntou.cse.wbse.nkda.controller;

import ntou.cse.wbse.nkda.entity.Reply;
import ntou.cse.wbse.nkda.entity.SaveReply;
import ntou.cse.wbse.nkda.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ArrayList<Reply>> getAllRepliesByYear() {
        return ResponseEntity.ok().body(replyService.getAllReplyByYear("2020"));
    }

    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Reply> getReply(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("logged_in");
        if (userName != null) {
            return ResponseEntity.ok().body(replyService.getReply(userName, "2020"));
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/{userName}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Reply> getUserReply(@PathVariable String userName) {
        return ResponseEntity.ok().body(replyService.getReply(userName, "2020"));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Reply> createReply(@RequestBody Reply reply) {
        Reply newReply = replyService.createReply(reply);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand(reply.getUserName())
                .toUri();
        return ResponseEntity.created(location).body(newReply);
    }

    @PutMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Reply> updateReply(HttpServletRequest request, @RequestBody SaveReply saveReply) {
        String userName = (String) request.getSession().getAttribute("logged_in");
        ArrayList<String> data = saveReply.getRepliesToSave();
        if (userName != null) {
            return ResponseEntity.ok().body(replyService.updateReply(userName, "2020", data));
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<Reply> deleteReply(@PathVariable String userName) {
        replyService.deleteReply(userName);
        return ResponseEntity.noContent().build();
    }
}
