package com.laypact.renew.common.audit;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import lombok.Getter;

@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditBaseEntity<U> {
	
	@CreatedBy
	@Column(name = "created_by", updatable = false)
	protected U createdBy;
	
	@LastModifiedBy
	@Column(name = "updated_by")
	protected U updatedBy;
	
	@CreatedDate
	@Column(name = "created_dt", updatable = false)
	protected LocalDateTime createdDt;
	
	@CreatedDate
	@Column(name = "updated_dt", updatable = false)
	protected LocalDateTime updatedDt;
}
