package com.laypact.renew.domain;

import com.laypact.renew.common.audit.AuditBaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table(name = "qna")
public class Qna extends AuditBaseEntity<String> {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq", length = 5)
	private long seq;
	
	@Column(name = "question", length = 300)
	private String question;
	@Column(name = "ans_main", length = 500)
	private String ansMain;
	@Column(name = "ans_sub", length = 500)
	private String ansSub;
	@Column(name = "use_yn", length = 1)
	private Boolean useYn;
}
