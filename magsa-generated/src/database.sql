CREATE TABLE Zamestnanec (
	ident_Zamestnanec INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	meno varchar2,
	priezvisko varchar2(16) NOT NULL,
	vek int);
CREATE TABLE Oddelenie (
	ident_Oddelenie INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nazov varchar2,
	kod varchar2,
	poschodie int);
