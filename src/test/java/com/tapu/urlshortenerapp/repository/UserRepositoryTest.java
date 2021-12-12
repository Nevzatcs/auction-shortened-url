package com.tapu.urlshortenerapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository repository;

//   @Test
//   void shouldCheckWhenUserIdExist() {
//       // given
//       User user = new User("username" ,"password");
//       repository.save(user);
//
//       // when
//       boolean expected = repository.isExistsById(user.getId());
//
//       // then
//       assertTrue(expected);
//   }
//
//   @Test
//   void shouldCheckWhenUserUserExists() {
//       // given
//       User user = new User("username" ,"password");
//       repository.save(user);
//
//       // when
//       boolean expected = repository.isExistsById(user.getId());
//
//       // then
//       assertTrue(expected);
//   }

}