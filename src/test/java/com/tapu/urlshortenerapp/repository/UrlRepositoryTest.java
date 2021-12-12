package com.tapu.urlshortenerapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UrlRepositoryTest {

    @Autowired
    UrlRepository repository;

//    @Test
//    void shouldReturnListofShortenedUrls() {
//        User user = new User();
//        user.setUsername("test");
//        user.setPassword("test");
//        Url url = new Url("https://www.google.com" ,"abc123");
//        url.setUsers(user);
//
//        repository.save(url);
//
//        List<String> list = repository.findByShortLinkByUserId(url.getUsers().getId());
//
//        assertNotNull(list);
//    }
//
//    @Test
//    void isExistUser() {
//
//    }
//
//    @Test
//    void shouldReturnShortLinkExist() {
//        // given
//        Url url = new Url("https://www.google.com" ,"abc123");
//        repository.save(url);
//
//        // when
//        boolean expected = repository.isShortLinkExist(url.getShortened());
//
//        // then
//        assertTrue(expected);
//    }
//
//    @Test
//    void shouldReturnListofShortenedUrlByShortLinkByUserIdAndId() {
//        User user = new User();
//        user.setUsername("test");
//        user.setPassword("test");
//        Url url = new Url("https://www.google.com" ,"abc123");
//        url.setUsers(user);
//
//        repository.save(url);
//
//        List<String> list = repository.findByShortLinkByUserIdAndId(url.getUsers().getId(),url.getId());
//
//        assertNotNull(list);
//    }




}