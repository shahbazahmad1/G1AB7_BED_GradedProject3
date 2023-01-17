package com.greatlearning.ticketManagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "content")
	private String content;

	@Temporal(TemporalType.DATE)
	@Column(name = "createdOn", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Temporal(TemporalType.DATE)
	@Column(name = "updatedOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedOn;

	@PrePersist
	private void onCreate() {
		date = new Date();
	}

	@PreUpdate
	private void onUpdate() {
		updatedOn = new Date();
	}

}