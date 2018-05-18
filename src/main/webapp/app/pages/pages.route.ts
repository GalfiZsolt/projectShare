import {Routes} from '@angular/router';

import {
  donationRoute,
donationCreateRoute,
donationEditRoute
} from './';

import {UserRouteAccessService} from '../shared';

const DONATION_ROUTES = [
  donationRoute,
  donationCreateRoute,
  donationEditRoute
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
