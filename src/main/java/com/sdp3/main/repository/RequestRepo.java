package com.sdp3.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sdp3.main.entity.Request;

public interface RequestRepo  extends JpaRepository<Request, Integer>{
	@Query("FROM Request AS e WHERE e.requestBy = :requestBy")
	List<Request> findByRequestedBy(@Param("requestBy") String userName);
}
