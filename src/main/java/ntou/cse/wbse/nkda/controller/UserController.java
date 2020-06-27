package ntou.cse.wbse.nkda.controller;

import ntou.cse.wbse.nkda.entity.User;
import ntou.cse.wbse.nkda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<User> getUser(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("logged_in");
        System.out.println(userName);
        return ResponseEntity.ok().body(userService.getUserInformation(userName));
    }

    @GetMapping("/info/{userName}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUserByAdmin(@PathVariable String userName) {
        return ResponseEntity.ok().body(userService.getUserInformation(userName));
    }

    @PutMapping("/info/update/{userName}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userName) {
        User updateUser = userService.updateUser(userName, user);
        return ResponseEntity.ok().body(updateUser);
    }

    @GetMapping("/info/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ArrayList<User>> getAllUsers() {
        ArrayList<User> users = userService.getAllUsersInformation();
        return ResponseEntity.ok().body(users);
    }

    @DeleteMapping("/delete/{userName}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> deleteUser(@PathVariable("userName") String userName) {
        userService.deleteUser(userName);
        return ResponseEntity.noContent().build();
    }
}