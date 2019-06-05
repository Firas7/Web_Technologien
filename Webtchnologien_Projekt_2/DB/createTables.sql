

-- Tabellen anlegen.

create table user(
	userID INTEGER AUTO_INCREMENT,
    username varchar(100),
	password varchar(100),
    CONSTRAINT pk_user PRIMARY KEY(userID),
    CONSTRAINT u_username UNIQUE (username)
) AUTO_INCREMENT = 1000;

create table genre(
	genreID INTEGER AUTO_INCREMENT,
    genre varchar(100),
    CONSTRAINT pk_gerne PRIMARY KEY (genreID)
) AUTO_INCREMENT = 1000;

create table person(
	personID INTEGER AUTO_INCREMENT,
	name varchar(100),
    lastname varchar(100),
    sex char,
    CONSTRAINT pk_person PRIMARY KEY(personID)
) AUTO_INCREMENT = 1000;

create table movie(
	movieID INTEGER AUTO_INCREMENT,
	movieTitle varchar(100),
	year INTEGER,
	type char,
    regisseur INTEGER,
    CONSTRAINT pk_movie PRIMARY KEY (movieID),
    CONSTRAINT fk_movie FOREIGN KEY (regisseur) REFERENCES person(personID)
)
AUTO_INCREMENT = 1000;

-- to restart ID : ALTER TABLE airlines AUTO_INCREMENT = 1;

create table movieHasGenre(
    movieID INTEGER,
    genreID INTEGER,
    CONSTRAINT pk_movieGenre PRIMARY KEY(movieID),
    CONSTRAINT fk_movieGenre FOREIGN KEY (genreID) REFERENCES genre(genreID)
);


create table movieCharacter(
	characterID INTEGER AUTO_INCREMENT,
    charact varchar(100),
	movieID INTEGER,
    personID INTEGER,
    CONSTRAINT pk_movieCharacter PRIMARY KEY (characterID),
    CONSTRAINT fk_movieCharacter_movie FOREIGN KEY (movieID) REFERENCES movie(movieID),
    CONSTRAINT fk_mvoieCharacter_person FOREIGN KEY (personID) REFERENCES person(personID)
)
AUTO_INCREMENT = 1000;


