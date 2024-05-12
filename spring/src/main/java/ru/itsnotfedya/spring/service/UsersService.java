package ru.itsnotfedya.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsnotfedya.spring.model.User;
import ru.itsnotfedya.spring.repositories.UsersRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UsersService {
    private final UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public void addUser(User user) {
        usersRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        usersRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        usersRepository.deleteById(id);
    }

    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    public User getUserById(long id) {
        return usersRepository.findById(id).orElse(null);
    }
}
