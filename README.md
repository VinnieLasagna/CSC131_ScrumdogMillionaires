# CSC131_ScrumdogMillionaires
Group Project : Software Engineering - Fall 2020 
Oscars Movies API Documentation

The Oscars Movies API utilizes the REST web service in order to take a list of movie entries and output the resulting entries based on the user’s inputted filters such as category and the year the film was created. 

Included in our API are HTTP GET methods that accept the movie data and return the results as ArrayList objects formatted in JSON. 

Regarding the GET method, there are seven String parameters passed in for the HTTP requests, representing the following categories from the movie entry data: the year the film was released, the year of the oscars ceremony the nomination was chosen for, the ceremony number the film was present at, the film’s category, the film’s creator, the film’s name, and whether the movie was a winner at its ceremony or not. The methods then return the movie data in the form of an ArrayList object of String arrays to be accessed for use. 

-----
Endpoints 

/movies/all

Example Endpoints
GET /movies/all

This endpoint represents and displays all movies and their corresponding entry data that has been entered via a GET request from the client. When calling a GET request, this endpoint will return all movies in the form of an ArrayList object of String arrays.

---

/movies/year_film/{year_film}
/movies/year_film/{year_film}/true

Example Endpoints
GET /movies/year_film/1990
GET /movies/year_film/1990/true

The “year_film” path variable represents the year a film premiered, in the format of a String. Entering this endpoint requires the client to identify the input year for “year_film” in place of “{year_film}”; for example, calling the endpoint “/movies/year_film/1990” specifies and returns all films that premiered in 1990. Additionally, “/true” can be attached to the end of the endpoint to specify all winning films that premiered in the specified year value, such as with “/movies/year_film/1990/true”.

---

/movies/year_ceremony/{year_ceremony}
/movies/year_ceremony/{year_ceremony}/true

Example Endpoints
GET /movies/year_ceremony/1985
GET /movies/year_ceremony/1985/true

The “year_ceremony” field represents the year of the Oscars ceremony a film was nominated for, formatted as a String. Entering this endpoint requires the client to identify the input value for “year_ceremony” in place of “{year_ceremony}”; calling the endpoint “/movies/year_ceremony/1985”, for example, specifies and returns films that were nominated for the 1985 Oscars ceremony. Additionally, “/true” can be attached to the end of the endpoint to specify all winning films that were nominated for the specified year’s Oscars ceremony, as depicted with “/movies/year_ceremony/1985/true”.

---

/movies/ceremony/{ceremony}

Example Endpoints
GET /movies/ceremony/46

The “ceremony” field represents the numbered ceremony a film was nominated at, in the form of a String. Entering this endpoint requires the client to identify the input value for “ceremony” in place of “{ceremony}”; calling “/movies/ceremony/46” specifies and returns all films that were nominated for the 46th Oscars Academy Awards.

---

/movies/category/{category}

Example Endpoints
GET /movies/category/actor

The “category” field represents the category a film or actor/actress was nominated for, formatted as a String. Entering this endpoint requires the client to identify the input value for “category” in place of “{category}”; calling “/movies/category/actor”, for example, specifies and returns all entries in which people were nominated for the ‘actor’ category.

---

/movies/name/{name}

Example Endpoints
GET /movies/name/John Smith

The “name” field represents the name of the person or group who is responsible for or has worked on the film, formatted as a String. Entering this endpoint requires the client to identify the input value for “name” in place of “{name}”; calling the endpoint “/movies/name/John Smith”, for example, specifies and returns the award entries that the name ‘John Smith’ was nominated for.

---

/movies/film/{film}
/movies/film/{film}/true

Example Endpoints
GET /movies/film/Titanic
GET /movies/film/Titanic/true

The “film” field represents the name of the film that is being nominated for an award, in the form of a String. Entering this endpoint requires the client to identify the input value for “film” in place of “{film}”; calling “/movies/film/Titanic”, for example, specifies and returns all nominations that the film “Titanic” received, regardless of the film winning or not. “/true” can also be attached to the end of the endpoint to specify all winning nominations that the specified film received, as depicted with the example endpoint, “/movies/film/Titanic/true”.

---

/movies/winner/{winner}

Example Endpoints
GET /movies/winner/true
GET /movies/winner/false

The “winner” field represents whether the specified nomination won an Oscars award or not and can contain either the boolean value “true” or “false”. Entering this endpoint requires the client to identify the input value for “winner” in place of “{winner}”. Calling “/movies/winner/true” specifies and returns all nominations that won an award, whereas calling “/movies/winner/false” returns all nominations that did not receive an award.
