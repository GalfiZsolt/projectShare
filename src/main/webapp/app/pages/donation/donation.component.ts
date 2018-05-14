import { Donation } from './donation.model';
import {JhiDonationService} from './donation.service';
import { HttpResponse } from '@angular/common/http';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'jhi-donation',
  templateUrl: './donation.component.html',
  styles: []
})
export class DonationComponent implements OnInit {
  donations: Donation[];

  constructor(private donationService: JhiDonationService) {}

  ngOnInit() {
    this.donationService.getAllDonations().subscribe((res: HttpResponse<Donation[]>) => {
      this.donations = res.body;
      console.log("donations:" + res);
    });
  }


}
