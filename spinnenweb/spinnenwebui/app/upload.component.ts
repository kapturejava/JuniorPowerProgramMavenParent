import { Component, Directive } from '@angular/core';
import { UploadService } from './service/upload.service';
import {DocumentService, EvaluatieRequest} from './service/document.service';

@Component({
  selector: 'upload',
  templateUrl: 'template/upload.html',
  providers: [ UploadService, DocumentService ]
})

export class UploadComponent  {
  nieuweEvaluatie:EvaluatieRequest = new EvaluatieRequest();

  step:number = 1;
  evaluatieDocument:any;
  files:any[];

  constructor(private uploadService:UploadService, private documentService:DocumentService) {
    this.uploadService.progress$.subscribe(
      data => {
        console.log('progress = '+data);
      });
  }

  onChange(event: any) {
    this.files = event.srcElement.files;
  }

  onClick(event: any) {
    this.uploadService.makeFileRequest('http://localhost:8080/document', [], this.files).subscribe((response) => {
      this.step = 2;
      this.evaluatieDocument = response;
    });
  }

  onSelectDoel(nieuwDoel: string) {
    this.nieuweEvaluatie.doel = nieuwDoel;
  }

  onSelectRelatie(nieuweRelatie: string) {
    this.nieuweEvaluatie.relatie = nieuweRelatie;
  }

  categorieList () {
    if (this.evaluatieDocument) {
      return this.evaluatieDocument.evaluatieCategorieList;
    }
    else {
      return [];
    }
  }

  scoreTekst(scoreCode: String) {
    switch (scoreCode) {
      case 'GEEN_EVALUATIE': return "Zonder score";
      case 'LEVEL_0': return "0";
      case 'LEVEL_1': return "1";
      case 'LEVEL_2': return "2";
      case 'LEVEL_3': return "3";
      case 'LEVEL_4': return "4";
      case 'LEVEL_5': return "5";
    }

    return scoreCode;
  }

  verwijderCategorie (categorieToRemove: any) {
    var newList:any[] = [];

    newList = this.evaluatieDocument.evaluatieCategorieList.filter((value: any) => {
      return value != categorieToRemove;
      });

    this.evaluatieDocument.evaluatieCategorieList = newList;
  }

  verwijderSubcategorie (categorie: any, subcategorieToRemove: any) {
    var newList:any[] = [];

    newList = categorie.evaluatieSubcategorieList.filter((value: any) => {
      return value != subcategorieToRemove;
    });

    categorie.evaluatieSubcategorieList = newList;
  }

  verwijderSkill (subcategorie: any, skillToRemove: any) {
    var newList:any[] = [];

    newList = subcategorie.evaluatieSkillList.filter((value: any) => {
      return value != skillToRemove;
    });

    subcategorie.evaluatieSkillList = newList;
  }

  verstuurGegevens() {
    this.evaluatieDocument.persoon.naam = this.nieuweEvaluatie.naam;
    this.evaluatieDocument.persoon.persoonType = this.nieuweEvaluatie.relatie;
    this.evaluatieDocument.evaluatieDoel = this.nieuweEvaluatie.doel;

    this.documentService.sendDocument(this.evaluatieDocument).subscribe(
      x => console.log('onNext: %s', x),
      e => console.log('onError: %s', e),
      () => {
        this.step = 3;
      });
  }
}

