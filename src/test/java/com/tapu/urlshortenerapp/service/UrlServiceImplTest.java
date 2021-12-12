package com.tapu.urlshortenerapp.service;

import com.example.urldemo.model.Url;
import com.example.urldemo.repository.UrlRepository;
import com.tapu.urlshortenerapp.model.Url;
import com.tapu.urlshortenerapp.repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UrlServiceImplTest {

    @Mock
    UrlRepository mockUrlRepository;

    @InjectMocks
    UrlServiceImpl urlService;

    @Test
    void getEncodedUrl() {
        //given
        Url url = new Url("https://www.google.com","abc123");
        when(mockUrlRepository.findByShortened(url.getShortened())).thenReturn(url);

        //when
        Url findUrl = mockUrlRepository.findByShortened(url.getShortened());

        //Then
        assertNotNull(findUrl.getShortened());

    }

    @Test
    void saveUrl() {
        Url url = new Url("https://www.google.com","abc123");
        when(urlService.saveUrl(any(Url.class))).thenReturn(url);



        Url savedUrl = mockUrlRepository.save(url);


        assertNotNull(savedUrl.getUrl());

    }

    @Test
    void findShortLinkByUserId() {
//    //given
//    when(mockUrlRepository.isExistUser(1l)).thenReturn(Boolean.TRUE);
//    List<String> list = mockUrlRepository.findByShortLinkByUserId(1l);
//
//    //when
//    when(urlService.findShortLinkByUserId(1l)).thenReturn(list);
//
//    //then
//    assertNotNull(list);

    }
}