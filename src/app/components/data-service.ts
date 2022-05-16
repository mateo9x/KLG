import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import { DataModel } from './data-model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private jsonURL = './assets/response_1548851123961.json';

  constructor(private http: HttpClient) {
  }

  getDataFromJsonFile(): Observable<any> {
     return this.http.get(this.jsonURL);
  }

}
