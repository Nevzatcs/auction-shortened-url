package com.tapu.urlshortenerapp.controller;


import com.tapu.urlshortenerapp.service.UrlService;
import com.tapu.urlshortenerapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UrlControllerTest {

    @Mock
    UrlService mockUrlService;

    @Mock
    UserService mockUserService;

    @InjectMocks
    UrlController urlController;



//   @Test
//   void findAll() {
//       //given
//       List<String> list = Arrays.asList(
//               new String("abc123")
//       );
//
//       //when
//       when(mockUrlService.findShortLinkByUserId(1L)).thenReturn(list);
//
//       //then
//       assertNotNull(list);
//
//   }

    @Test
    void getUrlDetail() {

    }

    @Test
    void deleteUrlId() {

    }
}