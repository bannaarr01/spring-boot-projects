package com.tbannaarr.com.roomwebapp.data;

import com.tbannaarr.com.roomwebapp.models.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffMember, String> {
}
