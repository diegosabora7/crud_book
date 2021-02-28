import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Book } from '../models/book';
import { BookService } from '../services/dto.services';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {
  public pageActual: number = 1;
  page = 0;
  size = 10;
  order = "id";
  asc = true;
  isFirst = false;
  isLast = false;
  totalPages: Array<number> = new Array<number>();
  books1: Array<any> = new Array<any>();
  books: Observable<Book[]> = new Observable<Book[]>();

  constructor(private bookService: BookService,
    private router: Router) {}


  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    //this.books = this.bookService.getBooksList();
    this.bookService.getBooksList(this.page,this.size,this.order, this.asc).subscribe(
      data => {
        this.books1 = data.content;
        this.isFirst = data.first;
        this.isLast = data.last;
        this.totalPages = new Array(data['totalPages']);
        console.log(data);
      }
    )
   
  }

  deleteBook(id: number) {
    this.bookService.deleteBook(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  BookDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateBook(id: number){
    this.router.navigate(['update', id]);
  }

  sort(): void {
    this.asc = !this.asc;
    this.reloadData();
  }
  rewind(): void {
    if(!this.isFirst){
      this.page--;
      this.reloadData();
    }
  }
  forward(): void {
    if(!this.isLast){
      this.page++;
      this.reloadData();
    }
  }
  setPage(page:number): void{
    this.page = page;
    this.reloadData();
  }
  setOrder(order:string){
    this.order = order;
    this.reloadData();

  }

}
