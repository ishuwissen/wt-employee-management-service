package com.wissen.service;

import com.wissen.entity.Skill;
import com.wissen.exception.DataAlreadyExistException;

import java.util.List;

/**
 * Interface responsible for skill related things.
 *
 * @author Anushka Saxena
 */
public interface SkillService {

    /**
     * @author Anushka Saxena
     * @param skills
     * @return Save Skill
     */
    public List<Skill> saveSkills(final List<Skill> skills) throws DataAlreadyExistException;

    /**
     * @author Anushka Saxena
     * @param searchString
     * @return Search skills
     */
    public List<Skill> searchSkills(final String searchString);

    /**
     * @author Anushka Saxena
     * @return Fetch all the skills
     */
    public List<Skill> getAllSkills();

    /**
     * @author Anushka Saxena
     * @param id
     * @return Fetch skill by id
     */
    public Skill getSkillById(int id);
}
