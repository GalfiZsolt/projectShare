package com.ubb.projectshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubb.projectshare.domain.Donation;


@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

	Donation findByTitle(String title);
}
