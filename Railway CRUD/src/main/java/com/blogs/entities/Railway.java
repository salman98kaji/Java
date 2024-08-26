package com.blogs.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="railway")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Railway {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="train_id")
	private Long id;
	
	@NotBlank
	@Column(name="train_name",nullable = false)
	private String trainName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Category category;
	
	@JsonFormat(pattern="HH:mm:ss")
	@Column(name="start_time",nullable = false)
	private LocalTime startTime;
	
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name="end_time",nullable = false)
	private LocalTime endTime;
	
	@Column(name="source",nullable = false)
	private String source;
	
	@Column(name="desti",nullable = false)
	private String destination;
	
	@Column(name="stn_code",nullable = false)
	private String stationCode;
	
	@Column(name="distance",nullable = false)
	private int distance;
	
	@Column(name="freq",nullable = false)
	private String frequency;
	
	@PrePersist
	@PreUpdate
	private void validateTime() {
		if(startTime.isAfter(endTime)) {
			throw new IllegalArgumentException("Start time cannot be after end time ");
		}
	}
}
