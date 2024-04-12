package com.learning.cruddemo.Service;

import com.learning.cruddemo.models.UserAccount;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserService {
   public List<UserAccount> findAll();

   public Optional<UserAccount> findById(@PathVariable ("id") Long id);

   public UserAccount save(UserAccount userAccount);


   void createUser(UserAccount userAccount);

  public   String deleteUser(Long id);

  public   String updateUser(UserAccount userAccount, Long id);
}
