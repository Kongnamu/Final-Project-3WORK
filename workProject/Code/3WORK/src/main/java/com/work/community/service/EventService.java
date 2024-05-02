package com.work.community.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.work.community.dto.EventDTO;
import com.work.community.entity.Event;
import com.work.community.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EventService {

	private final EventRepository eventRepository;
	
	//이벤트 생성
	public Event addEvent(EventDTO eventDTO) {
		Event event;
		event = Event.addEventDTO(eventDTO);
		eventRepository.save(event);
		return event;
	}
	
    // 이벤트 출력 - 모든 이벤트 조회
    public List<EventDTO> getAllEvents() {
    	List<Event> eventList = eventRepository.findAll();
    	return eventList.stream()
    			.map(EventDTO::getEventDTO)
    			.collect(Collectors.toList());
    	
    }
}
