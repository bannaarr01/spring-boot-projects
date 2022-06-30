package com.tbannaarr.com.roomwebapp.controllers;

import com.tbannaarr.com.roomwebapp.models.StaffMember;
import com.tbannaarr.com.roomwebapp.service.StaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/staff")
public class StaffRestController {
    private final StaffService staffService;

    public StaffRestController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<StaffMember> getAllStaffMembers() {
        return staffService.getAllStaff();
    }
}
