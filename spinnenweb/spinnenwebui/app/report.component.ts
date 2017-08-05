import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Person, WebData, PersonService} from "./service/person.service";
import 'rxjs/add/operator/switchMap';

@Component({
  templateUrl: 'template/report.html',
  providers: [ PersonService ]
})

export class ReportComponent implements OnInit {

  public webData:WebData[] = [
    {
      categorie: 'Core development',
      labels: ['Agile dev', 'Design', 'Database', 'OS', 'Documentatie'],
      data: [
        {data: [4, 2, 4, 3, 3], label: 'Average'},
        {data: [4, 3, 4, 2, 4], label: 'Referentie'}
      ]},
    {
      categorie: 'Web frontend',
      labels: ['Html', 'Styling', 'Javascript', 'Dev tools', 'Json', 'Js frameworks', 'Testing'],
      data: [
        {data: [3, 1, 3, 3, 4, 2, 1], label: 'Average'},
        {data: [2, 2, 3, 4, 4, 3, 4], label: 'Referentie'}
      ]},
    {
      categorie: 'Derde',
      labels: ['Html', 'Styling', 'Javascript', 'Dev tools', 'Json', 'Js frameworks', 'Testing'],
      data: [
        {data: [0, 1, 3, 3, 4, 2, 1], label: 'Average'},
        {data: [2, 2, 3, 4, 4, 3, 5], label: 'Referentie'}
      ]}
  ];

  public options = {
    scale: {
      scaleOverride: true,
      scaleSteps: 10,
      scaleStepWidth: 1,
      scaleStartValue: 0,
      scaleEndValue: 5
    }
  };

  constructor(private route: ActivatedRoute,
              private router: Router,
              private personService:PersonService) {

  }

  public persons: Person[];
  public errorMessage: any;
  public selectedPerson: Person;

  ngOnInit() {
      this.personService.getPersons().subscribe(
        persons => this.persons = persons,
        error =>  this.errorMessage = <any>error);
  };

  onSelectPerson(person: Person) {
    this.selectedPerson = person;
    this.webData = [];

    this.personService.getPersonWebData(person.id).subscribe(
        data => this.webData = data,
        error =>  this.errorMessage = <any>error
    )
  };

  hasSelectedPerson(): boolean {
    return this.selectedPerson != undefined;
  };
}


