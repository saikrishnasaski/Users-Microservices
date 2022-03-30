package com.csk.services.department.service.controller;

import com.csk.services.department.service.entity.Department;
import com.csk.services.department.service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment of DepartmentControoler......");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId,
                                        @RequestParam("time") int time) throws InterruptedException {
        log.info("Inside getDepartmentById of DepartmentControoler......");
        Thread.sleep(time);
        return departmentService.getDepartmentById(departmentId);
    }
}
