package com.tapu.urlshortenerapp.repository;


import com.tapu.urlshortenerapp.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    Url findByShortened(String shortened);

    @Query("SELECT u.shortened FROM Url u WHERE u.user.Id = ?1")
    List<String> findByShortLinkByUserId(Long userId);

   @Query("SELECT u.shortened FROM Url u WHERE u.user.Id = ?1 AND u.Id=?2")
   List<String> findByShortLinkByUserIdAndId(Long userId, Long urlId);

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
    boolean isExistUser(Long id);

    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(u)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM Url u " +
            "WHERE u.shortened= ?1")
    boolean isShortLinkExist(String shortened);




}
