package com.feldmann.dsmovie.repositories;

import com.feldmann.dsmovie.entities.Movie;
import com.feldmann.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}