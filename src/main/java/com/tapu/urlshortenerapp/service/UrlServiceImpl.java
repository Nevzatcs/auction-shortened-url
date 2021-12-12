package com.tapu.urlshortenerapp.service;

import com.google.common.hash.Hashing;
import com.tapu.urlshortenerapp.dto.UrlDTO;
import com.tapu.urlshortenerapp.exceptions.ShortenedUrlIsAlreadyExistException;
import com.tapu.urlshortenerapp.exceptions.UrlIsNotFoundException;
import com.tapu.urlshortenerapp.exceptions.UserIsNotFoundException;
import com.tapu.urlshortenerapp.model.Url;
import com.tapu.urlshortenerapp.repository.UrlRepository;
import com.tapu.urlshortenerapp.utils.ShortLinkGenerationConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlServiceImpl implements UrlService {

    private Random random = new Random();

    private  final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
       this.urlRepository = urlRepository;
    }

    @Override
    @Transactional
    public Url generateShortLink(UrlDTO urlDto, Long id) {

        boolean isExist = urlRepository.isExistUser(id);
        boolean isShortLinkExist = urlRepository.isShortLinkExist(urlDto.getUrl());
        if((!urlDto.getUrl().isEmpty())) {
            if (isExist) {
                String encodedUrl = encodeUrl(urlDto.getUrl());
                Url url = new Url();
                url.setUrl(urlDto.getUrl());
                url.setShortened(encodedUrl);
                if(!isShortLinkExist) {
                    return saveUrl(url);
                }else {
                    throw new ShortenedUrlIsAlreadyExistException("Shortened Url is already exist ! ");
                }

            }else {
                throw new UserIsNotFoundException("User with id: " + id + " is not found !");
            }
        }
        else {
            throw new UrlIsNotFoundException("Url is not found !");
        }
    }


    private String encodeUrl(String url)
    {
        char[] result = new char[ShortLinkGenerationConstants.NUM_CHARS_SHORT_LINK];

        for (int i = 0; i < ShortLinkGenerationConstants.NUM_CHARS_SHORT_LINK; ++i) {
            int randomIndex = random.nextInt(ShortLinkGenerationConstants.ALPHABET.length() - 1);
            result[i] = ShortLinkGenerationConstants.ALPHABET.charAt(randomIndex);
        }
        String shortLink = new String(result);

        return  shortLink;
    }


    @Override
    @Transactional
    public Url getEncodedUrl(String url) {
        return urlRepository.findByShortened(url);
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
