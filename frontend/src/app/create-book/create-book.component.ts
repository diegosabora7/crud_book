import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../models/book';
import { BookService } from '../services/dto.services';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { NgbDateStructAdapter } from '@ng-bootstrap/ng-bootstrap/datepicker/adapters/ngb-date-adapter';

const now = new Date();

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.scss']
})
export class CreateBookComponent implements OnInit {

  book: Book = new Book();
  submitted = false;

  model: NgbDateStruct = {
    year: now.getFullYear(),
    month: now.getMonth() + 1,
    day: now.getDate()
  };
  
  //date: {year: number, month: number};
  //date:Date = new Date();

  constructor(private bookService: BookService,
    private router: Router, private calendar: NgbCalendar) { }

  ngOnInit(): void {
    
  }

  newEmployee(): void {
    this.submitted = false;
    this.book = new Book();
  }

  save() {
    this.bookService
    .createBook(this.book).subscribe(data => {
      console.log(data)
      this.book = new Book();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/books']);
  }

  selectToday() {
    this.model = this.calendar.getToday();
  }
  
}
