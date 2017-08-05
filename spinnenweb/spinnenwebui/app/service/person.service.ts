import { Injectable} from '@angular/core';
import { Observer} from 'rxjs/Rx';
import { Http, Response }          from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { share} from "rxjs/operator/share";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

export class Person {
  id: number;
  naam: string;
}

export class WebData {
  categorie: string;
  labels: string[];
  data: any[];
}

@Injectable()
export class PersonService {
  private personUrl = 'http://localhost:8080/person';
  private personWebDataUrl = 'http://localhost:8080/person/?1/webdata';

  constructor (private http: Http) {}

  getPersons(): Observable<Person[]> {
    return this.http.get(this.personUrl)
      .map(this.extractData)
      .catch(this.handleError);
  }

  getPersonWebData(personId: number): Observable<WebData[]> {
    return this.http.get(this.personWebDataUrl.replace(/\?1/g, personId.toString()))
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    return res.json();
  }
  private handleError (error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
