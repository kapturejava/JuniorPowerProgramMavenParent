import {Injectable} from '@angular/core';
import {Observable, Observer} from 'rxjs/Rx';
import {share} from "rxjs/operator/share";

@Injectable()
export class UploadService {
  progress$: Observable<number>;
  progressObserver: any;

  constructor () {
    this.progress$ = Observable.create( (observer:Observer<String>) => {
      this.progressObserver = observer
    }).share();
  }

  public makeFileRequest (url: string, params: string[], files: File[]): Observable<number> {
    return Observable.create( (observer:Observer<String>) => {
      let formData: FormData = new FormData(),
        xhr: XMLHttpRequest = new XMLHttpRequest();


      formData.append("file", files[0], files[0].name);
      formData.append("naam", "TEST");

      xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
          if (xhr.status === 200) {
            observer.next(JSON.parse(xhr.response));
            observer.complete();
          } else {
            observer.error(xhr.response);
          }
        }
      };

      xhr.upload.onprogress = (event) => {
        var progress = Math.round(event.loaded / event.total * 100);

        this.progressObserver.next(progress);
      };

      xhr.open('POST', url, true);
      xhr.send(formData);
    });
  }
}
