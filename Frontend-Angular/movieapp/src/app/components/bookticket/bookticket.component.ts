import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { Ticket } from 'src/app/models/ticket';
import { MovieService } from 'src/app/services/movie.service';
import { StorageService } from 'src/app/services/storage.service';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-bookticket',
  templateUrl: './bookticket.component.html',
  styleUrls: ['./bookticket.component.css']
})
export class BookticketComponent {

  movieId:number|any;
  movie=new Movie();
  ticket=new Ticket();

  // mobj:Movie = new Movie();
  // bookData:Array<Movie>=[];
  // response:any;

  constructor(private movieService:MovieService, private ticketService:TicketService ,
    private router:Router,private activatedRoute:ActivatedRoute, private storage:StorageService){}

  ngOnInit() {


    this.movieId = this.activatedRoute.snapshot.params['movieId'];
    let id=Number(this.movieId);
    this.movieService.getMovieById(id).subscribe(data => {
    this.movie = data;
    // this.bookData = Object.values(response);
    // this.response = JSON.stringify(response);
    console.log(data);
    },error=>{
      console.log(error);
    })
    
  }

  bookTicket(){
    this.ticket.movieId_fk=this.movie.movieId;
    this.ticket.userName=this.storage.getUsername();
    this.ticketService.bookTicket(this.movie.movieId,this.ticket).subscribe(data=>{
      console.log(data);
      alert(this.ticket.bookedSeats+' tickets booked successfully');
      this.router.navigate(['/my-tickets']);
      // this.router.navigate(['/home']);
      
    },error=>{console.log(error);})
  }

  isAdmin(){
    if(this.storage.getRole()==='Admin' && this.storage.isLoggedIn()){
     return true;
    }
    return false;
   }
  }
