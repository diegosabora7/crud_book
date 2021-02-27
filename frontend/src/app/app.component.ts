import { Component } from '@angular/core';
import { BookService } from './services/dto.services';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Test Tecnico';

  numberOnly(event:any): boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }
    return true;

  }
}
  //constructor(private dtoServicios: DtoService) {
  
  /*

  test(){
    console.log("PRUEBA")
    let param = 'addbook';
    let data = {
      nombre:"Libro45",
      autor:"2IS",
      fecha_pub:"2020-05-01",
      num_ejem:"0",
      costo:"1000",
      descripcion:":V"
  }
  this.dtoServicios.execPost(param,data).subscribe((resp:any)=>{
    let dato = resp;
    console.log(dato);
  });
  console.log();
  }
}
*/
