package ru.itsnotfedya.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itsnotfedya.spring.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
