import { Component } from '@angular/core';
import { Ticket } from 'src/app/models/ticket';
import { StorageService } from 'src/app/services/storage.service';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-mytickets',
  templateUrl: './mytickets.component.html',
  styleUrls: ['./mytickets.component.css']
})
export class MyticketsComponent {

  ticket=new Ticket();
  dataObj:[]|any;
  

  constructor(private ticketService:TicketService,private storage:StorageService){}

  ngOnInit(){
    this.viewMyTickets();
  }

  viewMyTickets(){
    this.ticket.userName=this.storage.getUsername();
    this.ticketService.getMyTickets(this.ticket.userName).subscribe((data)=>{
      this.dataObj=data;
      console.log(this.dataObj);
      
    },error=>{
      console.log(error);
      
    })
  }

}
