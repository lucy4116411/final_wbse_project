package ntou.cse.wbse.nkda.controller;

import ntou.cse.wbse.nkda.entity.SessionInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/session")
public class SessionController {
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<SessionInfo> getSessionInfo(HttpServletRequest request) {
        SessionInfo sessionInfo = new SessionInfo();
        String userName = (String) request.getSession().getAttribute("logged_in");
        String auth = (String) request.getSession().getAttribute("user_type");
        sessionInfo.setUserName(userName);
        sessionInfo.setAuth(auth);
        if (sessionInfo.getUserName() != null) {
            return ResponseEntity.ok().body(sessionInfo);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
}
