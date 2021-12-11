package com.tapu.urlshortenerapp.repository;

import com.tapu.urlshortenerapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(u)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM User u " +
            "WHERE u.username = ?1")
    boolean isExistsByUsername(String username);

    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(u)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM User u " +
            "WHERE u.Id= ?1")
    boolean isExistsById(Long id);
}
