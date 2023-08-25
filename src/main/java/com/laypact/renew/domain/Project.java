package com.laypact.renew.domain;

import java.time.LocalDate;

import com.laypact.renew.common.audit.AuditBaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Entity
@Table(name = "project")
public class Project extends AuditBaseEntity<String> {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "short_desc", length = 500)
	private String shortDesc;
	@Column(name = "comp_name", length = 50)
	private String compName;
	@Column(name = "start_dt")
	private LocalDate startDt;
	@Column(name = "end_dt")
	private LocalDate endDt;
	
	
	
}
