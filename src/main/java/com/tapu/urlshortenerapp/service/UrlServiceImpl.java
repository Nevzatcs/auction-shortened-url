package com.tapu.urlshortenerapp.service;

import com.example.urldemo.dto.UrlDTO;
import com.example.urldemo.exceptions.UrlIsNotFoundException;
import com.example.urldemo.exceptions.UserIsNotFoundException;
import com.example.urldemo.model.Url;
import com.example.urldemo.repository.UrlRepository;
import com.google.common.hash.Hashing;
import com.tapu.urlshortenerapp.dto.UrlDTO;
import com.tapu.urlshortenerapp.exceptions.UserIsNotFoundException;
import com.tapu.urlshortenerapp.model.Url;
import com.tapu.urlshortenerapp.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {


    private  final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
       this.urlRepository = urlRepository;
    }

    @Override
    @Transactional
    public Url generateShortLink(UrlDTO urlDto, Long id) {

        boolean isExist = urlRepository.isExistUser(id);
        boolean isDuplicate = urlRepository.isDuplicate(urlDto.getUrl());
        if((!urlDto.getUrl().isEmpty())) {
            if (isExist) {
                String encodedUrl = encodeUrl(urlDto.getUrl());
                Url url = new Url();
                url.setUrl(urlDto.getUrl());
                url.setShortened(encodedUrl);
                if(!isDuplicate) {
                    //Url url = saveShortLink(url);
                    return saveShortLink(url);
                }

            }
            throw  new UserIsNotFoundException("User with id: " + id + " is not found");
        }
        else {
            throw new UrlIsNotFoundException("Userrrrr with id: " + id + " is not found");
        }
    }

    @Transactional
    private String encodeUrl(String url)
    {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return  encodedUrl;
    }

    @Override
    @Transactional
    public Url saveShortLink(Url url) {
        Url urlReturn = urlRepository.save(url);
        return urlReturn;
    }

    @Override
    @Transactional
    public Url getEncodedUrl(String url) {
        Url urlReturn = urlRepository.findByShortened(url);
        return urlReturn;
    }


    @Override
    @Transactional
    public Url saveUrl(Url urlToRet) {
        return urlRepository.save(urlToRet);
    }

    @Override
    @Transactional
    public List<String> findShortLinkByUserId(Long userId) {
        boolean isExist = urlRepository.isExistUser(userId);
        if(isExist) {
            return urlRepository.findByShortLinkByUserId(userId);
        }
        throw new UserIsNotFoundException("User is not found");
    }

    @Override
    @Transactional
    public List<String> findShortLinkByUserIdAndId(Long userId, Long urlId) {
        boolean isExist = urlRepository.isExistUser(userId);
        Optional isExistUrl = urlRepository.findById(urlId);
        if(isExist) {
            if(isExistUrl.isPresent()) {
                return urlRepository.findByShortLinkByUserIdAndId(userId, urlId);
            }else{
                throw new UrlIsNotFoundException("Url is not found!");
            }

        }else {
            throw new UserIsNotFoundException("User is not found!");
        }
    }

    @Override
    @Transactional
    public void deleteById(Long userId,Long urlId) {

        boolean isExist = urlRepository.isExistUser(userId);
        Optional isExistUrl = urlRepository.findById(urlId);
        if(isExist) {
            if(isExistUrl.isPresent()) {
                urlRepository.deleteById(urlId);

            }else if(!isExistUrl.isPresent()) {
                throw new UrlIsNotFoundException("Url is not found!");
            }
        } else {
            throw new UserIsNotFoundException("User is not found!");
        }

    }



}
