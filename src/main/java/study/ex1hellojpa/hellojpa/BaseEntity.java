package study.ex1hellojpa.hellojpa;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	
	private String createdBy;
	private LocalDateTime createdDate;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDateff;
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public LocalDateTime getLastModifiedDateff() {
		return lastModifiedDateff;
	}
	public void setLastModifiedDateff(LocalDateTime lastModifiedDateff) {
		this.lastModifiedDateff = lastModifiedDateff;
	}

}
