import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { getTestBed, TestBed } from "@angular/core/testing";
import { Movie } from "../models/movie";

import { MovieService } from './movie.service';

describe('MovieService', () => {
  let service: MovieService;
  let injector: TestBed;
  let httpMock: HttpTestingController;

  afterEach(() => {
        httpMock.verify();

  });

  beforeEach(()=>{
    //configuring the testbed
    TestBed.configureTestingModule({
        imports:[HttpClientTestingModule],
        providers:[MovieService]

    });

    service=TestBed.get(MovieService);
    injector= getTestBed();

    httpMock=injector.get(HttpTestingController);
});

it('should be created',()=>{

    expect(service).toBeTruthy();

  });


it('should check addMovie() method',()=>{

    const movie:Movie={

        "movieId": 113,
        "movieName": "Adipurush",
        "theatreName": "Inox, Delhi",
        "totalSeats": 100,
        "availableSeats": 100,
        "ticketDetails":[]

    };

 service.addMovie(movie).subscribe(resp=>expect(resp).toEqual(movie));

 const req = httpMock.expectOne(`${service.baseMovieApi}/admin/addmovie`);
 expect(req.request.method).toBe('POST');

 req.flush(movie);

});

it('should check deleteMovie() method',()=>{

 

  const movie:Movie={

      "movieId": 115,
      "movieName": "Adipurush",
      "theatreName": "Inox, Delhi",
      "totalSeats": 100,
      "availableSeats": 100,
      "ticketDetails":[]

  };



  service.deleteMovie(115).subscribe(resp=>console.log(resp));

  const req = httpMock.expectOne(`${service.baseMovieApi}/admin/delete/${movie.movieId}`);

 expect(req.request.method).toBe('DELETE');

 req.flush(movie);





});

});
