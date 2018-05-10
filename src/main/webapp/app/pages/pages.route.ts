import {Routes} from '@angular/router';

import {
  donationRoute
} from './';

import {UserRouteAccessService} from '../shared';

const DONATION_ROUTES = [
  donationRoute
];

export const donationState: Routes = [{
  path: '',
  data: {
    authorities: ['ROLE_USER']
  },
  canActivate: [UserRouteAccessService],
  children: DONATION_ROUTES
}
];
