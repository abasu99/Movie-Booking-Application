import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  movies:Movie[] |any;
  moviearr:Array<Movie>=[];


  constructor(private router:Router, private movieService:MovieService,private storage:StorageService){}

  ngOnInit(){
    this.getAllMovies();
  }




  getAllMovies(){
    this.movieService.getAllMovies().subscribe(data=>{
      this.movies=data;
      console.log(data);
      
    },error=>{
      console.log(error);
      
    })
  }

  deleteMovie(movieId:number){
     this.movieService.deleteMovie(movieId).subscribe(data=>
      {

        window.location.reload();
        // this.router.navigate(['/home']);
      },
      error=>{console.log(error);
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

   updateMovie(movieId:number){
    this.router.navigate(['/update',movieId]);
    
   }

}
