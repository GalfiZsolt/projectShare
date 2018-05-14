import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';
import { Donation } from './donation.model';
import { HttpResponse } from '@angular/common/http';

@Injectable()
export class JhiDonationService {

    constructor(private http: HttpClient) {}

    getAllDonations(): Observable<HttpResponse<Donation[]>>{
        return this.http.get<Donation[]>(SERVER_API_URL + 'api/donations', { observe: 'response' });
    }

}
