import {DonationEditComponent} from './donation-edit.component';
import {DonationComponent} from './donation.component';
import {Route} from '@angular/router';

export const donationRoute: Route =
  {
    path: 'donations',
    component: DonationComponent,
    data: {
      pageTitle: 'donation.title'
    }
  };

export const donationCreateRoute: Route =

  {
    path: 'donations/create',
    component: DonationEditComponent
  };
export const donationEditRoute: Route =
  {
    path: 'donations/create',
    component: DonationEditComponent
  };