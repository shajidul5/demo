package com.teaneck_squad.demo.Controllers;

import com.teaneck_squad.demo.Models.User;
import com.teaneck_squad.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user){
        ModelMap modelMap = new ModelMap();
        if(userService.createUser(user)) {
            modelMap.put("Message", "User successfully created");
            return new ResponseEntity<>(modelMap, HttpStatus.OK);
        }
        else{
            modelMap.put("Message", "Unable to add user!");
            modelMap.put("User", user);
            return new ResponseEntity<>(modelMap, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable(name = "id") long id){
        try{
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch (RuntimeException e){
            ModelMap modelMap = new ModelMap();
            modelMap.put("message", "User not found!");
            return new ResponseEntity<>(modelMap, HttpStatus.NOT_FOUND);
        }
    }
}
