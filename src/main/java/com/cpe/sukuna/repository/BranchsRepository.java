package com.cpe.sukuna.repository;

import com.cpe.sukuna.entity.Branchs;
import com.cpe.sukuna.entity.RoomDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchsRepository extends JpaRepository<Branchs,Integer> {
}
