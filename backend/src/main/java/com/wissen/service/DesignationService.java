package com.wissen.service;

import com.wissen.entity.Designation;

import java.util.List;

/**
 * Interface class responsible for designation related things.
 */
public interface DesignationService {

    /**
     * Method to save designations.
     *
     * @param designations
     * @return designations
     */
    public List<Designation> saveDesignations(final List<String> designations);

    /**
     * Method to search designation.
     *
     * @param searchString
     * @return designations
     */
    public List<Designation> searchDesignations(final String searchString);

    /**
     * Method to get all designations.
     *
     * @return designations
     */
    public List<Designation> getAllDesignation();

    /**
     * Method to get designation by Id.
     *
     * @param id
     * @return designation
     */
    public Designation getDesignationById(int id);

    /**
     * Method to designation by name.
     *
     * @param name
     * @return designation
     */
    public Designation getDesignationByName(String name);
}
