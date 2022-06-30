package com.tbannaarr.com.roomwebapp.data;

import com.tbannaarr.com.roomwebapp.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

//The element that this is serving(the entity object)
// and the id type as the second param for the template
public interface RoomRepository extends JpaRepository<Room, Long> {
}
