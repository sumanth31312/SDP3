package com.sdp3.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sdp3.main.entity.Donate;

public interface DonteRepo extends JpaRepository<Donate, Integer>{

	@Query("FROM Donate AS e WHERE e.donatedBy = :donatedBy")
	List<Donate> findByDonatedBy(@Param("donatedBy") String userName);
	
}
