package com.wissen.repository;

import com.wissen.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Skill repository class.
 */
public interface SkillRespository extends JpaRepository<Skill, Integer> {

    @Query("SELECT c FROM Skill c WHERE c.skillName LIKE CONCAT('%',:searchString, '%')")
    public List<Skill> getSkillByPattern(String searchString);

    @Query("SELECT CASE WHEN count(c) > 0 THEN true ELSE false END FROM Skill c where UPPER(c.skillName) = UPPER(:skillName)")
    boolean isSkillExists(String skillName);
}

