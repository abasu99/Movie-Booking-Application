import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  movieObj:Movie=new Movie();
  movie=new Movie();

  constructor(private movieService:MovieService,private storage:StorageService,private router:Router){}

  searchMovie(){
    this.movieService.getMovieByName(this.movieObj.movieName).subscribe(data=>{
      this.movie=data;
      console.log(data);
      
    },error=>{alert('Please enter a movie name');console.log(error);
    })
  }

  deleteMovie(movieId:number){
     this.movieService.deleteMovie(movieId).subscribe(data=>
      {
        window.location.reload();
        // this.router.navigate(['/home']);
      },
      
      error=>{
        alert('Please enter a movie name');
        console.log(error);
      })
   }

   isAdmin(){
    if(this.storage.getRole()==='Admin' && this.storage.isLoggedIn()){
     return true;
    }
    return false;
   }

   bookMovie(movieId:number){
    this.router.navigate(['/movie',movieId]);
    
   }

  

}
