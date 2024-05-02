package com.work.community.dto;

import java.time.LocalDateTime;

import com.work.community.entity.Event;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class EventDTO {
	
	private Integer eno;
	
	private String title;
	
	private LocalDateTime startDateTime;
	
	private LocalDateTime endDateTime;
	
	public static EventDTO getEventDTO(Event event) {
		EventDTO eventDTO = EventDTO.builder()
				.eno(event.getEno())
				.title(event.getTitle())
				.startDateTime(event.getStartDateTime())
				.endDateTime(event.getEndDateTime())
				.build();
		
		return eventDTO;
	}

}
