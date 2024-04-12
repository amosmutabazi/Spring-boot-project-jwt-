package com.learning.cruddemo.Service;

import com.learning.cruddemo.models.UserAccount;
import com.learning.cruddemo.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class UserServiceImp implements UserService{
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Override
    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public Optional<UserAccount> findById(Long id) {
        return userAccountRepository.findById(id);
    }
    @Override
    public UserAccount save(UserAccount userAccount) {
        // Implement the logic to save the user account using userRepository
        return userAccountRepository.save(userAccount);
    }

    @Override
    public void createUser(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }

    @Override
    public String deleteUser(Long id) {
        userAccountRepository.deleteById(id);
        return "successfully deleted";
    }

    @Override
    public String updateUser(UserAccount userAccount, Long id) {
        // Retrieve the user account from the repository by its ID
        Optional<UserAccount> optionalUser = userAccountRepository.findById(id);

        // Check if the user account exists
        if (optionalUser.isPresent()) {
            // Update the user account with the new data
            UserAccount existingUser = optionalUser.get();
            existingUser.setEmail(userAccount.getEmail());
            existingUser.setPassword(userAccount.getPassword());
            existingUser.setFirstName(userAccount.getFirstName());
            existingUser.setLastName(userAccount.getLastName());
            existingUser.setPhoneNumber(userAccount.getPhoneNumber());
           // existingUser.setRole(userAccount.getRole());

            // Save the updated user account back to the repository
            userAccountRepository.save(existingUser);

            return "User with ID " + id + " updated successfully.";
        } else {
            return "User with ID " + id + " not found.";
        }
    }



}
