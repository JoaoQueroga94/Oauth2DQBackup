package br.org.itriad.oauth.repository;

import br.org.itriad.oauth.model.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository("userRepository")
public interface UserRepository extends UserBaseRepository<User> {
    User findByLogin(String login);
}