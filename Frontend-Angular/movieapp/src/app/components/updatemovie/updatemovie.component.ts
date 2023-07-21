import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { Ticket } from 'src/app/models/ticket';
import { MovieService } from 'src/app/services/movie.service';
import { StorageService } from 'src/app/services/storage.service';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-updatemovie',
  templateUrl: './updatemovie.component.html',
  styleUrls: ['./updatemovie.component.css']
})
export class UpdatemovieComponent {

  movieId:number|any;
  movie=new Movie();
  ticket=new Ticket();

  // movieObj:Movie = new Movie();

  constructor(private movieService:MovieService, private ticketService:TicketService ,
    private router:Router,private activatedRoute:ActivatedRoute, private storage:StorageService){}

  ngOnInit() {


    this.movieId = this.activatedRoute.snapshot.params['movieId'];
    let id=Number(this.movieId);
    this.movieService.getMovieById(id).subscribe(data => {
    this.movie = data;

    console.log(data);
    },
    error=>{
      console.log(error);
    })
    
  }

  updateMovieDetails(){
    this.movieService.updateMovie(this.movie).subscribe(data=>{
      console.log(data);
      this.router.navigate(['/home']);
    },
    error=>{
      alert('Cannot update !')
      console.log(error);
      
    })
  }

}
