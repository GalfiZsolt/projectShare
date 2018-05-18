import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';
import { Donation } from './donation.model';
import { HttpResponse } from '@angular/common/http';

@Injectable()
export class JhiDonationService {
    private resourceUrl = SERVER_API_URL + 'api/donations';

    constructor(private http: HttpClient) {}

   create(donation: Donation): Observable<HttpResponse<Donation>> {
        return this.http.post<Donation>(this.resourceUrl, donation, { observe: 'response' });
    }

      update(donation: Donation): Observable<HttpResponse<Donation>> {
        return this.http.put<Donation>(this.resourceUrl, donation, { observe: 'response' });
    }

    getAllDonations(): Observable<HttpResponse<Donation[]>>{
        return this.http.get<Donation[]>(this.resourceUrl, { observe: 'response' });
    }

}
