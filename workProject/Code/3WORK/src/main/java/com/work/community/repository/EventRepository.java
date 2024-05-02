package com.work.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.work.community.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{


}
