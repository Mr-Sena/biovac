package com.zup.orangeTalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.orangeTalent.model.VacModel;

//@Repository
public interface VacRepository extends JpaRepository<VacModel, Long> {

}
