package com.tbannaarr.com.roomwebapp.service;

import com.tbannaarr.com.roomwebapp.data.StaffRepository;
import com.tbannaarr.com.roomwebapp.models.StaffMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    //    private static final List<StaffMember> staff = new ArrayList<>();

//    static{
//        staff.add(new StaffMember(UUID.randomUUID().toString(), "John","Doe", Position.CONCIERGE));
//        staff.add(new StaffMember(UUID.randomUUID().toString(), "Jane","Doe", Position.FRONT_DESK));
//        staff.add(new StaffMember(UUID.randomUUID().toString(), "Bane","Doe", Position.SECURITY));
//        staff.add(new StaffMember(UUID.randomUUID().toString(), "Dell","Doe", Position.HOUSEKEEPING));
//    }

    public List<StaffMember> getAllStaff(){
        return staffRepository.findAll();
       // return staff;
    }
}
