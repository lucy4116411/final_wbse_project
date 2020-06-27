package ntou.cse.wbse.nkda.controller;

import ntou.cse.wbse.nkda.entity.User;
import ntou.cse.wbse.nkda.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/api/register")
    public ResponseEntity<User> registerUser(@RequestBody User user, HttpServletResponse response) {
        User createUser = registerService.createUser(user);
        if (createUser != null) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/api/register")
                    .buildAndExpand(user.getName())
                    .toUri();
            return ResponseEntity.created(location).body(createUser);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
