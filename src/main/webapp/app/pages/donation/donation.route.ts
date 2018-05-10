import { DonationComponent } from './donation.component';
import { Route } from '@angular/router';

export const donationRoute: Route = {
    path: 'donations',
    component: DonationComponent,
    data: {
        pageTitle: 'donation.title'
    }
};
