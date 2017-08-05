import {Injectable} from '@angular/core';
import {Observable, Observer } from 'rxjs/Rx';
import {Http, Response } from '@angular/http';

export class EvaluatieRequest {
  public naam:string;
  public doel:string;
  public relatie:string;
}

@Injectable()
export class DocumentService {
  private documentUrl = 'http://localhost:8080/document';  // URL to web API

  constructor (private http: Http) {}

  sendDocument (evaluatieDocument: any): Observable<any> {

    return Observable.create( (observer:Observer<String>) => {
      let formData: FormData = new FormData(),
        xhr: XMLHttpRequest = new XMLHttpRequest();

      formData.append("evaluatieDocument", evaluatieDocument);

      xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
          if (xhr.status === 200) {
            observer.complete();
          } else {
            observer.error(xhr.response);
          }
        }
      };

      xhr.open('PUT', this.documentUrl);
      xhr.setRequestHeader('Content-Type', 'application/json');
      xhr.send(JSON.stringify(evaluatieDocument));
    });

/*    return this.http.post(this.documentUrl + '/save', evaluatieDocument)
      .catch(this.handleError);*/
  }

  private handleError (error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
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
