package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.User;



public interface UserService {

    User register(String username, String password, String repeatPassword,String name, String surname);
}
