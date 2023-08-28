package com.laypact.renew.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laypact.renew.domain.User;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByIdAndPassword(String id, String password);
	
	/*
	 * JPQL
	 
	  @Query("select p from Project p where p.name like :name")
	  List<Project> findByNameLikeQuery(@Param("name") String name);
	*/
	
}
