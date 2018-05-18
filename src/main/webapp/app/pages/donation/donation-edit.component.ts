import { JhiLanguageHelper } from '../../shared';
import { Donation } from './donation.model';
import { Component, OnInit, OnDestroy } from '@angular/core';

import { JhiEventManager } from 'ng-jhipster';

import { JhiDonationService } from './donation.service';

@Component({
       selector: 'jhi-donation-edit',
     templateUrl: './donation-edit.component.html',
})
export class DonationEditComponent implements OnInit {

    donation: Donation;
    languages: any[];
    authorities: any[];
    isSaving: Boolean;

    constructor(
        private languageHelper: JhiLanguageHelper,
        private donationService: JhiDonationService,
        private eventManager: JhiEventManager
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.languageHelper.getAll().then((languages) => {
            this.languages = languages;
        });
    }


    save() {
        this.isSaving = true;
        if (this.donation.id !== null) {
            this.donationService.update(this.donation).subscribe((response) => this.onSaveSuccess(response), () => this.onSaveError());
        } else {
            this.donationService.create(this.donation).subscribe((response) => this.onSaveSuccess(response), () => this.onSaveError());
        }
    }

    private onSaveSuccess(result) {
        this.eventManager.broadcast({ name: 'donationListModification', content: 'OK' });
        this.isSaving = false;
    }

    private onSaveError() {
        this.isSaving = false;
    }
}
