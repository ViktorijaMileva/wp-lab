package mk.finki.ukim.mk.service.impl;

import mk.finki.ukim.mk.model.User;
import mk.finki.ukim.mk.model.exceptions.InvalidUsernameOrPasswordException;
import mk.finki.ukim.mk.model.exceptions.PasswordDoNotMatchException;
import mk.finki.ukim.mk.model.exceptions.UsernameAlreadyExistsException;
import mk.finki.ukim.mk.repository.jpa.UserRepository;
import mk.finki.ukim.mk.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String password, String repeatPassword,String name, String surname) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordDoNotMatchException();
        }

        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username, password,name, surname);
        return userRepository.save(user);
    }


    /*@Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()-> new UsernameNotFoundException(s));
    }*/

}
