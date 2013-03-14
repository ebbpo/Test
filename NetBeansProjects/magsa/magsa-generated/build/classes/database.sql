CREATE TABLE Zamestnanec (
	ident INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	meno varchar(10),
	priezvisko varchar(10),
	vek int);
CREATE TABLE Oddelenie (
	ident INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nazov varchar(10),
	kod varchar(10),
	poschodie int);
