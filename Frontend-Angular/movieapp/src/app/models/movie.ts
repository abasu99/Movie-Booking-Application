import { Ticket } from "./ticket";

export class Movie {

    movieId:number |any;
    movieName:string |any;
    theatreName:string|any;
    totalSeats:number |any;
    availableSeats:number|any;
    price:number|any;
    ticketDetails: Array<Ticket> =[];
}
