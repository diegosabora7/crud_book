import { RouterModule, Routes } from "@angular/router";
import {CreateBookComponent} from './create-book/create-book.component';
import { NgModule } from '@angular/core';
import { BookListComponent } from "./book-list/book-list.component";
import { UpdateBookComponent } from "./update-book/update-book.component";
import { BookDetailsComponent } from "./book-details/book-details.component";


const routes: Routes = [
    { path: '', redirectTo: 'book', pathMatch: 'full' },
    { path: 'books', component: BookListComponent },
    { path: 'add', component: CreateBookComponent },
    { path: 'update/:id', component: UpdateBookComponent },
    { path: 'details/:id', component: BookDetailsComponent },
  ];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }