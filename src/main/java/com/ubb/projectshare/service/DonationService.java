package com.ubb.projectshare.service;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubb.projectshare.domain.Donation;
import com.ubb.projectshare.repository.DonationRepository;
import com.ubb.projectshare.service.dto.DonationDTO;


@Service
@Transactional
public class DonationService {

	private final Logger log = LoggerFactory.getLogger(DonationService.class);

	private final DonationRepository donationRepository;

	public DonationService(DonationRepository donationRepository) {
		super();
		this.donationRepository = donationRepository;
	}

	public Donation findDonationByTitle(String title) {
		Donation donation = donationRepository.findByTitle(title);
		return donation;
	}

	
    public Donation createDonation(DonationDTO donationDTO) {
        Donation donation = new Donation();
        donation.setTitle(donationDTO.getTitle());
        donation.setDescription(donationDTO.getDescription());
        donation.setType(donationDTO.getType());
        donation.setQuantity(donationDTO.getQuantity());
        donationRepository.save(donation);
        log.debug("Created Information for Donation: {}", donation);
        return donation;
    }
	
    /**
     * Update all information for a specific donation, and return the modified donation.
     *
     * @param donationDTO donation to update
     * @return updated donation
     */
    public Optional<DonationDTO> updateDonation(DonationDTO donationDTO) {
        return Optional.of(donationRepository
            .findOne(donationDTO.getId()))
            .map(donation -> {
                donation.setTitle(donationDTO.getTitle());
                donation.setDescription(donationDTO.getDescription());
                donation.setType(donationDTO.getType());
                donation.setQuantity(donationDTO.getQuantity());
                log.debug("Changed Information for Donation: {}", donation);
                return donation;
            })
            .map(DonationDTO::new);
    }
    
    @Transactional(readOnly = true)
    public Page<DonationDTO> getAllDonations(Pageable pageable) {
        return donationRepository.findAll(pageable).map(DonationDTO::new);
    }
}