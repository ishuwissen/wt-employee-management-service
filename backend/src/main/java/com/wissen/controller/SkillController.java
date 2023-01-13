package com.wissen.controller;

import com.wissen.entity.Department;
import com.wissen.entity.Designation;
import com.wissen.entity.EmployeeSkill;
import com.wissen.entity.Skill;
import com.wissen.service.EmployeeSkillService;
import com.wissen.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Validated
@Slf4j
@RestController
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private EmployeeSkillService employeeSkillService;

    /**
     * @author Anushka Saxena
     * @param skills
     * @return Save skill
     */
    @PostMapping
    public ResponseEntity<List<Skill>> saveSkill(@RequestBody @NotEmpty(message = "Skill list is empty") final List<Skill> skills){
        log.info("Starting to save Skills");
        List<Skill> savedSkills = this.skillService.saveSkills(skills);
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedSkills);
    }

    /**
     * @author Anushka Saxena
     * @param skillId
     * @param employeeId
     * @param levels
     * @return Employee Skill
     */
    @PostMapping("/saveSkillEmployeeMapping")
    public ResponseEntity<EmployeeSkill> saveSkillEmployeeMapping(@RequestParam @NotNull(message = "Skill id is null") final int skillId,
                                                                  @RequestParam @NotNull(message = "Employee id is null") final int employeeId,
                                                                  @RequestParam @NotNull(message = "Level is null") final int levels){
        log.info("START: Saving skill employee mapping");
        log.info("Skill id: {}, Employee id: {}, level: {}", skillId, employeeId, levels);
        EmployeeSkill employeeSkill = this.employeeSkillService.saveSkillEmployeeMapping(skillId, employeeId, levels);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeSkill);
    }

    /**
     * @author Anushka Saxena
     * @param skillId
     * @param employeeId
     * @param levels
     * @param employeeSkillId
     * @return Update employee skill
     */
    @PutMapping("/updateSkillEmployeeMapping")
    public ResponseEntity<EmployeeSkill> updateSkillEmployeeMapping(@RequestParam @NotNull(message = "Skill id is null") final int skillId,
                                                                  @RequestParam @NotNull(message = "Employee id is null") final int employeeId,
                                                                  @RequestParam @NotNull(message = "Employee skill id is null") final int employeeSkillId,
                                                                  @RequestParam @NotNull(message = "Level is null") final int levels){
        log.info("START: Saving skill employee mapping");
        log.info("Skill id: {}, Employee id: {}, level: {}", skillId, employeeId, levels);
        EmployeeSkill employeeSkill = this.employeeSkillService.updateSkillEmployeeMapping(skillId, employeeId, employeeSkillId, levels);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeSkill);
    }

    /**
     * @author Anushka Saxena
     * @param employeeId
     * @return Get employee skills
     */
    @GetMapping("/getSkillEmployeeMapping")
    public ResponseEntity<List<EmployeeSkill>> getSkillEmployeeMapping(@RequestParam @NotNull(message = "Employee id is null") int employeeId){
        log.info("START: Get employee skills");
        List<EmployeeSkill> employeeSkillList = this.employeeSkillService.getSkillEmployeeMapping(employeeId);
        log.info("END: Fetched employee skills");
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeSkillList);
    }

    /**
     * @author Anushka Saxena
     * @param skill
     * @return Search skills
     */
    @GetMapping("/search")
    public ResponseEntity<List<Skill>> searchSkills(@RequestParam final String skill) {
        log.info("START: Getting skills");
        List<Skill> skills = this.skillService.searchSkills(skill);
        log.info("START: Getting skills");
        return ResponseEntity.status(HttpStatus.OK)
                .body(skills);
    }

    /**
     * @author Anushka Saxena
     * @return Fetch all skills
     */
    @GetMapping
    public List<Skill> getAllSkills(){
        log.info("Starting to fetch the skills");
        return skillService.getAllSkills();
    }

    /**
     * @author Anushka Saxena
     * @param id
     * @return Fetch skill by id
     */
    @GetMapping({"/{id}"})
    public ResponseEntity<Skill> getSkillById(@PathVariable int id){
        return new ResponseEntity<>(skillService.getSkillById(id),HttpStatus.OK);
    }

    /**
     * @author Anushka Saxena
     * @param employeeSkillId
     * @return delete an employee skill
     */
    @DeleteMapping("/deleteEmployeeSkill")
    public ResponseEntity<String> deleteEmployeeSkill(@RequestParam @NotNull(message = "Employee Skill id is null") int employeeSkillId){
        return new ResponseEntity<String>(employeeSkillService.deleteSkillEmployeeMapping(employeeSkillId), HttpStatus.OK);
    }

}
