package tn.project.demo.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	@CreatedDate
	@Column(name= "creationDate", nullable = false, updatable = false)
	private Instant creationDate;
	
	@LastModifiedDate
	@Column(name= "lastModifiedDate")
	private Instant lastModifiedDate;
}
