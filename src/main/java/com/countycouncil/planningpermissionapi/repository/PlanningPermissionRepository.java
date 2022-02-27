package com.countycouncil.planningpermissionapi.repository;

import com.countycouncil.planningpermissionapi.entity.PlanningPermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanningPermissionRepository extends CrudRepository<PlanningPermission, Integer> {
    List<PlanningPermission> findByOneOffHousingId(int oneOffHousingId);

    List<PlanningPermission> findAll();
}
