import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {RouterModule} from '@angular/router';

import {ProjectShareSharedModule} from '../shared';

import {
  donationState,
  DonationComponent,
} from './';
import { DonationEditComponent } from './donation/donation-edit.component';
import { JhiDonationService } from './donation/donation.service';

@NgModule({
  imports: [
    ProjectShareSharedModule,
    RouterModule.forChild(donationState),
    /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
  ],
  declarations: [
    DonationComponent,
    DonationEditComponent
  ],
  entryComponents: [
  ],
  providers: [
    JhiDonationService
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProjectSharePagesModule {}
