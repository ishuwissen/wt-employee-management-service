package com.wissen.service;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeSkill;
import com.wissen.entity.Skill;

import java.util.List;

public interface EmployeeSkillService {

    /**
     * @author Anushka Saxena
     * @param employeeSkillList
     * @return save employee skills
     */
    public List<EmployeeSkill> saveEmployeeSkills(List<EmployeeSkill> employeeSkillList);

    /**
     * @author Anushka Saxena
     * @param skillId
     * @param employeeId
     * @param levels
     * @return Employee Skill
     */
    public EmployeeSkill saveSkillEmployeeMapping(final int skillId, final int employeeId, final int levels);

    /**
     * @author Anushka Saxena
     * @param skillId
     * @param employeeId
     * @param employeeSkillId
     * @param levels
     * @return Update Level of employee Skill
     */
    public EmployeeSkill updateSkillEmployeeMapping(final int skillId, final int employeeId, final int employeeSkillId, final int levels);

    /**
     * @author Anushka Saxena
     * @param employeeId
     * @return Employee Skill
     */
    public List<EmployeeSkill> getSkillEmployeeMapping(int employeeId);

    /**
     * @author Anushka Saxena
     * @param employeeSkillId
     * @return Delete Employee Skill
     */
    public String deleteSkillEmployeeMapping(int employeeSkillId);
}
