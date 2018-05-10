package com.ubb.projectshare.service.dto;

import com.ubb.projectshare.domain.Donation;
import javax.validation.constraints.*;
import java.time.Instant;

/**
 * A DTO representing a donation.
 */
public class DonationDTO {

    private Long id;

    @Size(max = 100)
    private String title;

    @Size(max = 300)
    private String description;

	@Size(max = 50)
	private String type;

	@Size(max = 50)
	private String quantity;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;


    public DonationDTO() {
        // Empty constructor needed for Jackson.
    }

    public DonationDTO(Donation donation) {
        this.id = donation.getId();
        this.title = donation.getTitle();
        this.description = donation.getDescription();
        this.type = donation.getType();
        this.quantity = donation.getQuantity();
        this.createdBy = donation.getCreatedBy();
        this.createdDate = donation.getCreatedDate();
        this.lastModifiedBy = donation.getLastModifiedBy();
        this.lastModifiedDate = donation.getLastModifiedDate();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "DonationDTO [id=" + id + ", title=" + title + ", description=" + description + ", type=" + type
				+ ", quantity=" + quantity + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

   
}
