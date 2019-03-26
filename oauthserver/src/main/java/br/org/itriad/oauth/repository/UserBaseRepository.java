package br.org.itriad.oauth.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface UserBaseRepository<T> extends Repository<T, Long> {

    Iterable<T> findAll();

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);
}