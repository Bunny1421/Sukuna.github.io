package com.cpe.sukuna.repository;

import com.cpe.sukuna.entity.RoomDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDetailRepository extends JpaRepository<RoomDetail,Integer> {

    @Query(
            value = "select * from room_details where rd_id_branch = ?1",
            nativeQuery = true)
    List<RoomDetail> findAllByRd_id_branch(int id);
}
