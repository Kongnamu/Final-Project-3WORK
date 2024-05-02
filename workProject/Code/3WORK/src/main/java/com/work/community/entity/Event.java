package com.work.community.entity;

import java.time.LocalDateTime;

import com.work.community.dto.EventDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "events")
@Entity
public class Event{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eno; //이벤트 번호
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;
    
    //회원 한명이 여러 이벤트 저장
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uno") // 외래키 설정 및 nullable 설정
    private Users users; // 외래키 설정
	
    public static Event addEventDTO(EventDTO eventDTO) {
		Event event = Event.builder()
				.eno(eventDTO.getEno())
				.title(eventDTO.getTitle())
				.startDateTime(eventDTO.getStartDateTime())
				.endDateTime(eventDTO.getEndDateTime())
				.build();
		
		return event;
	}

}
