package tn.formation.boot.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import tn.formation.boot.model.entities.User;
@Repository
@RepositoryRestResource(path="user")
public interface UserRepository extends JpaRepository<User, Long>{

}
