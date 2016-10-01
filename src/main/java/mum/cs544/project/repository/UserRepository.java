package mum.cs544.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.project.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
User findByUserName(String userName);
User findByFirstName(String firstName);

}
