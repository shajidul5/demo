package com.teaneck_squad.demo.Repositories;

import com.teaneck_squad.demo.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
