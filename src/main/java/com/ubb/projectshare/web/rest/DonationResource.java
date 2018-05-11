package com.ubb.projectshare.web.rest;

import com.ubb.projectshare.config.Constants;
import com.codahale.metrics.annotation.Timed;
import com.ubb.projectshare.domain.Donation;
import com.ubb.projectshare.repository.DonationRepository;
import com.ubb.projectshare.security.AuthoritiesConstants;
import com.ubb.projectshare.service.MailService;
import com.ubb.projectshare.service.DonationService;
import com.ubb.projectshare.service.dto.DonationDTO;
import com.ubb.projectshare.web.rest.errors.BadRequestAlertException;
import com.ubb.projectshare.web.rest.errors.EmailAlreadyUsedException;
import com.ubb.projectshare.web.rest.errors.LoginAlreadyUsedException;
import com.ubb.projectshare.web.rest.util.HeaderUtil;
import com.ubb.projectshare.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing Donations.
 * <p>
 * This class accesses the Donation entity.
 * <p>
 */
@RestController
@RequestMapping("/api")
public class DonationResource {

    private final Logger log = LoggerFactory.getLogger(DonationResource.class);

    private final DonationRepository donationRepository;

    private final DonationService donationService;

    public DonationResource(DonationRepository donationRepository, DonationService donationService) {

        this.donationRepository = donationRepository;
        this.donationService = donationService;
    }

    /**
     * POST  /donations  : Creates a new donation.
     * <p>
     * Creates a new donation if the login and email are not already used, and sends an
     * mail with an activation link.
     * The donation needs to be activated on creation.
     *
     * @param donationDTO the donation to create
     * @return the ResponseEntity with status 201 (Created) and with body the new donation, or with status 400 (Bad Request) if the login or email is already in use
     * @throws URISyntaxException if the Location URI syntax is incorrect
     * @throws BadRequestAlertException 400 (Bad Request) if the login or email is already in use
     */
    @PostMapping("/donations")
    @Timed
    @Secured(AuthoritiesConstants.USER)
    public ResponseEntity<Donation> createDonation(@Valid @RequestBody DonationDTO donationDTO) throws URISyntaxException {
        log.debug("REST request to save Donation : {}", donationDTO);

        if (donationDTO.getId() != null) {
            throw new BadRequestAlertException("A new donation cannot already have an ID", "donationManagement", "idexists");
            // Lowercase the donation login before comparing with database
        } else {
            Donation newDonation = donationService.createDonation(donationDTO);
            return ResponseEntity.created(new URI("/api/donations/" + newDonation.getTitle()))
                .headers(HeaderUtil.createAlert( "donationManagement.created", newDonation.getTitle()))
                .body(newDonation);
        }
    }

    /**
     * PUT /donations : Updates an existing Donation.
     *
     * @param donationDTO the donation to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated donation
     * @throws EmailAlreadyUsedException 400 (Bad Request) if the email is already in use
     * @throws LoginAlreadyUsedException 400 (Bad Request) if the login is already in use
     */
    @PutMapping("/donations")
    @Timed
    @Secured(AuthoritiesConstants.USER)
    public ResponseEntity<DonationDTO> updateDonation(@Valid @RequestBody DonationDTO donationDTO) {
        log.debug("REST request to update Donation : {}", donationDTO);
        Optional<DonationDTO> updatedDonation = donationService.updateDonation(donationDTO);

        return ResponseUtil.wrapOrNotFound(updatedDonation,
            HeaderUtil.createAlert("donationManagement.updated", donationDTO.getTitle()));
    }

    /**
     * GET /donations : get all donations.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all donations
     */
    @GetMapping("/donations")
    @Timed
    public ResponseEntity<List<DonationDTO>> getAllDonations(Pageable pageable) {
        final Page<DonationDTO> page = donationService.getAllDonations(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/donations");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }



}
