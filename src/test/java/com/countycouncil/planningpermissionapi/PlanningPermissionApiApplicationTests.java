package com.countycouncil.planningpermissionapi;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.countycouncil.planningpermissionapi.controller.PlanningPermissionController;

@SpringBootTest
class PlanningPermissionApiApplicationTests {
    @Autowired
    private PlanningPermissionController controller;
    @Test
    void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }

}
