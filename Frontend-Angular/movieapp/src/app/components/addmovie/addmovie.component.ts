import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-addmovie',
  templateUrl: './addmovie.component.html',
  styleUrls: ['./addmovie.component.css']
})
export class AddmovieComponent {

  data:{}|any; 
  movieObj:Movie = new Movie();
  moviearr:Array<Movie>=[];

  constructor(private movieService:MovieService,private router:Router){}

  addNewMovie(){
    this.movieService.addMovie(this.movieObj).subscribe(data=>{
      this.data= JSON.stringify(data);
      this.moviearr.push(this.data);
      window.location.reload();
      // this.router.navigate(['/home']);
    },
    error=>{
      console.log(error);
      
    })
  }

}
