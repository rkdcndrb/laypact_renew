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
@Table(name = "users")
public class User extends AuditBaseEntity<String> {

	@Id
	@Column(name = "user_id", length = 75)
	private String userId;
	
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "auth", length = 10)
	private String auth;
	@Column(name = "email_addr", length = 80)
	private String emailAddr;
	
	
	
}
