package com.work.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.work.community.dto.EventDTO;
import com.work.community.entity.Event;
import com.work.community.service.EventService;


@RestController
@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;

    //유저 홈페이지에 이벤트 생성
    @PostMapping("/user/userpage/{uno}")
    public ResponseEntity<Event> addEvent(@RequestBody EventDTO eventDTO) {
        Event savedEvent = eventService.addEvent(eventDTO);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED); 
    }
}
