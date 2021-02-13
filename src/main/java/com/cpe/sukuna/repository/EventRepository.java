package com.cpe.sukuna.repository;

import com.cpe.sukuna.entity.Event;
import com.cpe.sukuna.entity.RoomDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    @Query(
            value = "select * from event_datail where eventroomid = ?1",
            nativeQuery = true)
    List<Event> findAllByEv_rd_id(int id);

    @Query(
            value = "select * from event_datail where eventroomid = ?1  AND start between ?2 AND ?3",
            nativeQuery = true)
    List<Event> findEvent(int id,String start,String end);
}
