package com.wissen.service.impl;

import com.wissen.entity.Skill;
import com.wissen.exception.DataAlreadyExistException;
import com.wissen.repository.SkillRespository;
import com.wissen.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class for skill related things.
 */
@Service
@Slf4j
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRespository skillRespository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Skill> saveSkills(final List<Skill> skills) throws DataAlreadyExistException {
        skills.stream().forEach(skill -> {
            if(skillRespository.isSkillExists(skill.getSkillName())) {
                log.error("This Skill details already present : " + skill.toString());
                throw new DataAlreadyExistException("This Skill details already present : " + skill.toString());
            }
        });

        return this.skillRespository.saveAll(skills);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Skill> searchSkills(String searchString) {
        List<Skill> skills = new ArrayList<>();
        skills.addAll(this.skillRespository.getSkillByPattern(searchString));
        return skills;
    }

    private Skill getSkill(final String skills){
        Skill skillEntity = new Skill();
        skillEntity.setSkillName(skills);

        return skillEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Skill> getAllSkills(){
        List<Skill> skills = new ArrayList<Skill>();
        skillRespository.findAll().forEach(skill -> skills.add(skill));
        return skills;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Skill getSkillById(int id){
        return skillRespository.findById(id).get();
    }
}
