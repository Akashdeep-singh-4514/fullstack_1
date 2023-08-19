package com.company.signupform.Controller;

import com.company.signupform.Model.User;
import com.company.signupform.Services.FormServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
public class FormController {

    @Autowired
    FormServices formServices;

//    GET
    @RequestMapping(method = RequestMethod.GET,value = "/users")
    public List<User> getAllUsers()
    {
       return formServices.getAllUsers();

    }
    @RequestMapping(method = RequestMethod.GET,value = "/users/{email}")
    public Optional<User> getUsersInfo(@PathVariable String email)
    {
        return formServices.getUsersInfo(email);

    }

//    POST
    @RequestMapping(method = RequestMethod.POST,value = "/signup")
    public User addUser(@RequestBody User user)
    {
        return formServices.addUser(user);
    }

//    PUT
    @RequestMapping(method = RequestMethod.PUT,value = "/users/{email}")
    public Optional<User> editUser(@RequestBody User user,@PathVariable String email)
    {
        return formServices.editUser(user,email);

    }

//    DELETE
    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{email}")
    public void deleteUser(@PathVariable String email)
    {
        formServices.deleteUser(email);

    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/users")
    public void deleteAllUser()
    {
        formServices.deleteAllUser();

    }



//    @RequestMapping(method = RequestMethod.POST,value = "/Signin")
//    public User verify(@RequestBody User logger)
//    {
//        return formServices.verify(logger);
//    }








}
