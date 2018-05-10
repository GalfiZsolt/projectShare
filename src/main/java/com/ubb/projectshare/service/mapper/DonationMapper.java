package com.ubb.projectshare.service.mapper;

import com.ubb.projectshare.domain.Donation;
import com.ubb.projectshare.service.dto.DonationDTO;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Mapper for the entity Donation and its DTO called DonationDTO.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class DonationMapper {

    public DonationDTO donationToDonationDTO(Donation donation) {
        return new DonationDTO(donation);
    }

    public List<DonationDTO> donationsToDonationDTOs(List<Donation> donations) {
        return donations.stream()
            .filter(Objects::nonNull)
            .map(this::donationToDonationDTO)
            .collect(Collectors.toList());
    }

	public Donation donationDTOToDonation(DonationDTO donationDTO) {
        if (donationDTO == null) {
            return null;
        } else {
            Donation donation = new Donation();
            donation.setId(donationDTO.getId());
            donation.setTitle(donationDTO.getTitle());
            donation.setDescription(donationDTO.getDescription());
            donation.setType(donationDTO.getType());
            donation.setQuantity(donationDTO.getQuantity());
            return donation;
        }
    }

    public List<Donation> donationDTOsToDonations(List<DonationDTO> donationDTOs) {
        return donationDTOs.stream()
            .filter(Objects::nonNull)
            .map(this::donationDTOToDonation)
            .collect(Collectors.toList());
    }

    public Donation donationFromId(Long id) {
        if (id == null) {
            return null;
        }
        Donation donation = new Donation();
        donation.setId(id);
        return donation;
    }

}
