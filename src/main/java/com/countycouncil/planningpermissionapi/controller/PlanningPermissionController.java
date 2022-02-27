package com.countycouncil.planningpermissionapi.controller;

import com.countycouncil.planningpermissionapi.entity.PlanningPermission;
import com.countycouncil.planningpermissionapi.repository.PlanningPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // Allow from Origins other than localhost for Swagger to work
@RequestMapping("/api/residential")
//@Service
public class PlanningPermissionController {

    @Autowired
    PlanningPermissionRepository planningPermissionRepository;

    /**
     * Retrieve all planning permission applications
     *
     * @return List<PlanningPermission>
     */
    @RequestMapping(value= {"/planningpermissions", "/planningpermissions/"},  method= RequestMethod.GET)
    List<PlanningPermission> getAllHouseApplicationForApplications(){
        return planningPermissionRepository.findAll();
    }

    /**
     * Retrieve a single planning permission application by referenceId
     *
     * @return Optional<PlanningPermission>
     */
    @RequestMapping(value="/planningpermissions/{referenceId}", method= RequestMethod.GET)
    Optional<PlanningPermission> getHouseApplication(@PathVariable("referenceId") int referenceId){
        return planningPermissionRepository.findById(referenceId);
    }

    /**
     * Retrieve all planning permission applications with a specific oneOffHousingId
     *
     * @param oneOffHousingId - id defining the type of planning permission application
     * applicationTypeId = 0 - residential planning permission
     * applicationTypeId = 1 - commercial planning permission
     * @return List<PlanningPermission>
     */
    @RequestMapping(value= {"/planningpermissions/types", "/planningpermissions/"},  method= RequestMethod.GET)
    List<PlanningPermission> getHouseApplicationForApplicationType(@RequestParam("oneOffHousingId") int oneOffHousingId){
        return planningPermissionRepository.findByOneOffHousingId(oneOffHousingId);
    }

    /**
     * Create a new Planning Permission application on the system
     *
     * @param planningPermission - details of the new application
     * @return ResponseEntity<PlanningPermission>
     */
    @RequestMapping(value= {"/planningpermissions"}, method= RequestMethod.POST)
    ResponseEntity<PlanningPermission>insertHousingApplication(@RequestBody PlanningPermission planningPermission){
        PlanningPermission savedPlanningPermission = planningPermissionRepository.save(planningPermission);
        return new ResponseEntity<PlanningPermission>(savedPlanningPermission, HttpStatus.OK);
    }

    /**
     * Update an existing Planning Permission application on the system
     *
     * @param referenceId - the referenceId of the application to update
     * @param planningPermission - details of the application to update
     *
     * @return ResponseEntity<PlanningPermission>
     */
    @RequestMapping(value= "/planningpermissions/{referenceId}", method= RequestMethod.PUT)
    PlanningPermission updateHousingApplication(@PathVariable("referenceId") int referenceId, @RequestBody PlanningPermission planningPermission){
        Optional<PlanningPermission> optionalPlanningPermission = planningPermissionRepository.findById(referenceId);
        PlanningPermission existingPlanningPermission = optionalPlanningPermission.get();

        existingPlanningPermission.setApplicantFirstName(planningPermission.getApplicantFirstName());
        existingPlanningPermission.setApplicantLastName(planningPermission.getApplicantLastName());
        existingPlanningPermission.setHouseArea(planningPermission.getHouseArea());
        existingPlanningPermission.setApplicationStatus(planningPermission.getApplicationStatus());
        existingPlanningPermission.setOneOffHousingId(planningPermission.getOneOffHousingId());

        PlanningPermission savedPlanningPermission = planningPermissionRepository.save(existingPlanningPermission);
        return savedPlanningPermission;
    }

    /**
     * Delete a Planning Permission application on the system
     *
     * @param  referenceId - the referenceId of the application to delete
     * @return String
     */
    @RequestMapping(value= "/planningpermissions/{referenceId}", method= RequestMethod.DELETE)
    String deleteHousingApplication(@PathVariable("referenceId") int referenceId){
        Optional<PlanningPermission> optionalPlanningPermission = planningPermissionRepository.findById(referenceId);
        PlanningPermission existingPlanningPermission = optionalPlanningPermission.get();

        planningPermissionRepository.delete(existingPlanningPermission);
//        return "existingPlanningPermission";
        return "Planning Permission application referenceId: "+existingPlanningPermission.getReferenceId()+" has been deleted";
    }

}
