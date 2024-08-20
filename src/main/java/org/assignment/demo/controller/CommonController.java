package org.assignment.demo.controller;


import org.assignment.demo.Model.User;
import org.assignment.demo.service.JwtService;
import org.assignment.demo.service.SecurityService;
import org.assignment.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class CommonController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/signUp")
    public User createUser(@RequestParam("UserName") String username, @RequestParam("password") String password ){
        return userService.createUser(username,password);
    }

    @PostMapping("/SignUpAdmin")
    public User createAdmin(@RequestParam("UserName") String username, @RequestParam("password") String password ){
        return userService.createAdmin(username,password);
    }

   @GetMapping("/logIn")
    public String login(@RequestParam("UserName") String username, @RequestParam("password") String password){
        return userService.verify(new User(username,password,"USER"));
   }

   @GetMapping("/user")
    public String userAuth(){
        return "yes your generated JWT succesfully enable you to logged in to this endpoint";
   }

   @GetMapping("/revokingToken")
    public String revokeToken(@RequestParam("token") String token){
        jwtService.revokeToken(token);
        return "Token is successfully revoked";
   }

   @GetMapping("/refreshToken")
    public String refreshToken(@RequestParam("token") String token){
       jwtService.refreshToken(token);
       return "this is the fresh token " + token;
   }

}
