package com.tapu.urlshortenerapp.service;


import com.tapu.urlshortenerapp.dto.UrlDTO;
import com.tapu.urlshortenerapp.model.Url;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UrlService {

    Url generateShortLink(UrlDTO urlDto, Long id);

    Url getEncodedUrl(String url);

    Url saveUrl(Url urlToRet);

    List<String> findShortLinkByUserId(Long userId);

    List<String> findShortLinkByUserIdAndId(Long userId, Long urlId);

    void deleteById(Long userId, Long urlId);


}
