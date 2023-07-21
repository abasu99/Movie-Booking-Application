package com.backend.moviebooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.backend.moviebooking.model.Movie;
import com.backend.moviebooking.model.Ticket;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
	@Query(value="select t from Ticket t where t.movieId_fk = :movieId")
	public List<Ticket> getTicketList(int movieId);
	
	@Query("select  t from Ticket t where t.userName= :userName order by t.transactionId desc")
	public List<Ticket> getTicketsByUserName(String userName);
	
	@Modifying
	@Query(value="delete from Ticket where movieId_fk = :movieId")
	public void deleteTicketData(int movieId);
	
	

}
