package com.example.furniture.service;

import com.example.furniture.model.User;
import com.example.furniture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        User existedUser = userRepository.findByEmail(user.getEmail());
        if(existedUser != null){
            return null;
        }
        return userRepository.save(user);
    }

    public User login(User user) {
        System.out.println(user.toString());
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    public User updateInformation(User info) {
        System.out.println(info.getCardList());
        Optional<User> userOptional = userRepository.findById(info.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(info.getName());
            user.setPassword(info.getPassword());
            user.setDefaultPaymentId(info.getDefaultPaymentId());
            if(info.getDefaultShippingId() != null){
                user.setDefaultShippingId(info.getDefaultShippingId());
            }

            if(Objects.equals(info.getCardList(), "empty")){
                user.setCardList(null);
            } else if(info.getCardList() != null){
                user.setCardList(info.getCardList());
            }



            return userRepository.save(user);
        }
        return info;
    }

    public boolean favourite(User info, String productId) {
        Optional<User> userOptional = userRepository.findById(info.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            String favourites = "";

            if (user.getFavouriteList() == null || user.getFavouriteList().isEmpty()) {
                favourites = favourites + productId;
                user.setFavouriteList(favourites);
            } else {
                favourites = user.getFavouriteList();
                if (favourites.contains(',' + productId + ',')) {
                    favourites = favourites.replace(',' + productId + ',', ",");
                } else if (favourites.contains(',' + productId)) {
                    favourites = favourites.replace(',' + productId, "");
                } else if (favourites.contains(productId + ',')) {
                    favourites = favourites.replace(productId + ',', "");
                } else if (favourites.contains(productId)) {
                    favourites =favourites.replace(productId, "");
                } else {
                    favourites += (',' + productId);
                }
                user.setFavouriteList(favourites);
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }
}