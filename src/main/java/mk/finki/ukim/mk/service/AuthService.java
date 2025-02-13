package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.User;

public interface AuthService {
    User login(String username, String password);

    User register(String username, String password, String repeatedPassword, String name, String surname);
}
