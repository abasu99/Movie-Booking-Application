import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http:HttpClient) { }

  
  baseMovieApi='http://localhost:8082/api/v1.0/moviebooking';
  // baseMovieApi='http://ec2-34-220-181-255.us-west-2.compute.amazonaws.com:8082/api/v1.0/moviebooking';
  // baseMovieApi='https://idz0hv0mf7.execute-api.us-west-2.amazonaws.com/2141421-Arnab-MovieAPP/movieapp-endpoints'

  public getAllMovies():Observable<Movie[]>{
    return this.http.get<Movie[]>(`${this.baseMovieApi}/all`);
    // return this.http.get<Movie[]>(`${this.baseMovieApi}`);
  }

  public addMovie(movie:Movie):Observable<Movie>{
    return this.http.post<Movie>(`${this.baseMovieApi}/admin/addmovie`,movie);
    // return this.http.post<Movie>(`${this.baseMovieApi}`,movie);
  }

  public deleteMovie(movieId:number):Observable<Movie>{
    // return this.http.delete<Movie>(`${this.baseMovieApi}/${movieId}`);
    return this.http.delete<Movie>(`${this.baseMovieApi}/admin/delete/${movieId}`);
  }

  public updateMovie(movie:Movie){
    // return this.http.put(`${this.baseMovieApi}`,movie);
    return this.http.put(`${this.baseMovieApi}/updateMovie`,movie);
  }

  public getMovieById(movieId:number):Observable<Movie>
  {
    return this.http.get<Movie>(`${this.baseMovieApi}/movies/search/${movieId}`);
    // return this.http.get<Movie>(`${this.baseMovieApi}/${movieId}`);

  }

  public getMovieByName(movieName:string):Observable<Movie>
  {
    return this.http.get<Movie>(`${this.baseMovieApi}/search/${movieName}`);
    // return this.http.get<Movie>(`${this.baseMovieApi}/movie-search/${movieName}`);

  }

}
