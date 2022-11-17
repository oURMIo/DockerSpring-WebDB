package com.bezkoder.spring.datajpa.database;

import org.springframework.data.repository.CrudRepository;

public interface UseForUser extends CrudRepository<User, Long> {
}
