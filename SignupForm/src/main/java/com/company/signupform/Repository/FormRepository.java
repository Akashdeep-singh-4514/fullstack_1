package com.company.signupform.Repository;

import com.company.signupform.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface FormRepository extends CrudRepository<User,String> {
}
