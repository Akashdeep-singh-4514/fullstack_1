package com.company.signupform.Services;

import com.company.signupform.Model.User;
import com.company.signupform.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormServices {
    @Autowired
    private FormRepository formRepository;

    public List<User> getAllUsers()
    {
        List<User> users=new ArrayList<>();
        formRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User addUser( User user)
    {
        formRepository.save(user);
        return user;
    }


    public Optional<User> getUsersInfo(String email)
    {
        return formRepository.findById(email);
    }

    public Optional<User> editUser(User user, String email)
    {
        formRepository.deleteById(email);
        formRepository.save(user);

        return formRepository.findById(email);
    }

    public void deleteUser(String email)
    {
        formRepository.deleteById(email);
    }

    public void deleteAllUser() {
        formRepository.deleteAll();
    }


//    public User verify( User logger)
//    {
//        List<User> users=new ArrayList<>();
//        formRepository.findAll().forEach(user -> users.add(user));
//        User client=null;
//        for (int i = 0; i < users.size(); i++)
//        {
//            if (users.get(i).getEmail().equals(logger.getEmail()) && users.get(i).getPassword().equals(logger.getPassword()))
//            {
//                client=users.get(i);
//            }
//        }
//        return  client;
//    }
}
