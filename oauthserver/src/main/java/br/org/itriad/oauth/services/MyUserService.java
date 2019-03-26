package br.org.itriad.oauth.services;

import br.org.itriad.oauth.model.User;
import br.org.itriad.oauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userRepository.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("User " + login + " not found in database.");
        }

        return user;
    }
}