import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from '../models/ticket';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private http:HttpClient) { }

  private baseTicketApi="http://localhost:8082/api/v1.0/ticketbooking";
  // private baseTicketApi="http://ec2-34-220-181-255.us-west-2.compute.amazonaws.com:8082/api/v1.0/ticketbooking";
  // private baseTicketApi="https://idz0hv0mf7.execute-api.us-west-2.amazonaws.com/2141421-Arnab-MovieAPP/movieapp-endpoints";
  
  public bookTicket(movieId:number,ticket:Ticket):Observable<Ticket>{
    return this.http.post<Ticket>(`${this.baseTicketApi}/book/${movieId}`,ticket);
    // return this.http.post<Ticket>(`${this.baseTicketApi}/${movieId}`,ticket);

  }

  public getMyTickets(userName:string):Observable<Ticket[]>{
    return this.http.get<Ticket[]>(`${this.baseTicketApi}/tickets/${userName}`);

  }
}
