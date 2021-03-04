package com.zup.orangeTalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.orangeTalent.model.UserModel;

//@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
