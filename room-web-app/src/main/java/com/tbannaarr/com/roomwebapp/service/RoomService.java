package com.tbannaarr.com.roomwebapp.service;

import com.tbannaarr.com.roomwebapp.data.RoomRepository;
import com.tbannaarr.com.roomwebapp.models.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    //private static final List<Room> rooms = new ArrayList<>();

    private final RoomRepository roomRepository;
    //Inject via constructor which is a good practice in spring

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getById(long id) {
        return roomRepository.findById(id).get();
    }
    //    static{
//        for(int i = 0; i <10; i++){
//            rooms.add(new Room(i, "Room "+i, "R"+i,"Q"));
//        }
//    }
//    public List<Room> getAllRooms() {
//        return rooms;
//    }
}
