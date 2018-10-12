package com.demochatbot.jbot.core.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demochatbot.jbot.core.facebook.models.User;

/**
 * @author rpatra16
 * @since 30/08/2018
 */
@Service
public class FbService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FbApiEndpoints fbApiEndpoints;

    public User getUser(String id, String pageAccessToken) {
        return restTemplate.getForEntity(fbApiEndpoints.getUserApi(), User.class, id, pageAccessToken).getBody();
    }
}
