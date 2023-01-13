package com.wissen.repository;

import com.wissen.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Designation repository class.
 *
 * @author Vishal Tomar
 */
public interface DesignationRepository extends JpaRepository<Designation, Integer> {

    /**
     * Find designation by name.
     *
     * @param name
     * @return designation
     */
    public Designation findByDesgName(String name);

    /**
     * Find designation by pattern.
     *
     * @param searchString
     * @return designations
     */
    @Query("SELECT c FROM Designation c WHERE c.desgName LIKE CONCAT('%',:searchString, '%')")
    public List<Designation> getDesignationByPattern(String searchString);

    /**
     * Find designation by name.
     *
     * @param name
     * @return designation
     */
    public Designation getDesignationByDesgName(String name);
}
