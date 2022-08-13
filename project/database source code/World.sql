CREATE DATABASE World

USE World

/*COUNTRIES TABLE*/
DROP TABLE IF EXISTS Countries
CREATE TABLE Countries
(
	Country_id INT IDENTITY(1,1) NOT NULL,
	Country_code CHAR(3) NOT NULL,
	Country_name VARCHAR(60) NOT NULL,
	Continent VARCHAR(30) NOT NULL,
	Region VARCHAR(30) NOT NULL CONSTRAINT DF_Countries_Region DEFAULT(''),
	Population INT NOT NULL CONSTRAINT DF_Countries_Population DEFAULT('0'),
	Surface_area DECIMAL(10,2) NOT NULL CONSTRAINT DF_Countries_Surface_area DEFAULT('0.00'),
	Government_form VARCHAR(50) NOT NULL CONSTRAINT DF_Countries_Government_form DEFAULT(''),

	CONSTRAINT PK_Countries_Country_id PRIMARY KEY(Country_id),
	CONSTRAINT UQ_Countries_Country_code UNIQUE(Country_code),
	CONSTRAINT CK_Countries_Continent CHECK(Continent IN('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')),
	CONSTRAINT CK_Countries_Population CHECK(Population >= 0),	
	CONSTRAINT CK_Countries_Surface_area CHECK(Surface_area >= 0)
)

UPDATE Countries SET Country_name = TRIM(Country_name)
UPDATE Countries SET Region = TRIM(Region)
UPDATE Countries SET Government_form = TRIM(Government_form)

CREATE NONCLUSTERED INDEX IX_Countries_Country_name ON Countries
(
	Country_name ASC
)WITH(FILLFACTOR = 70)


/*CITIES TABLE*/
DROP TABLE IF EXISTS Cities
CREATE TABLE Cities
(
	City_id INT IDENTITY(1,1),
	City_name VARCHAR(40) NOT NULL CONSTRAINT DF_Cities_City_name DEFAULT(''),
	Country_code CHAR(3) NOT NULL,
	District VARCHAR(30) NOT NULL CONSTRAINT DF_Cities_District DEFAULT(''),
	Population INT NOT NULL CONSTRAINT DF_Cities_Population DEFAULT('0'),

	CONSTRAINT PK_Cities_City_id PRIMARY KEY(City_id),
	CONSTRAINT FK_Cities_Country_code FOREIGN KEY(Country_code) REFERENCES Countries(Country_code),
	CONSTRAINT CK_Cities_Population CHECK(Population >= 0) 
)

UPDATE Cities SET City_name = TRIM(City_name)
UPDATE Cities SET District = TRIM(District)

CREATE NONCLUSTERED INDEX IX_Cities_City_name ON Cities
(
	City_name ASC
)WITH(FILLFACTOR = 70)

/*COUNTRYLANGUAGES TABLE*/
DROP TABLE IF EXISTS Languages
CREATE TABLE Languages
(
	Language_id INT IDENTITY(1,1),
	Country_code CHAR(3) NOT NULL,
	Language VARCHAR(30) NOT NULL CONSTRAINT DF_Languages_Language DEFAULT(''),
	is_official CHAR(1) NOT NULL,
	Percentage DECIMAL(4,1) NOT NULL CONSTRAINT DF_Languages_Percentage DEFAULT('0.0'),

	CONSTRAINT PK_Languages_Language_id PRIMARY KEY(Language_id),
	CONSTRAINT FK_Languages_Country_code FOREIGN KEY(Country_code) REFERENCES Countries(Country_code),
	CONSTRAINT CK_Languages_Is_official CHECK(is_official IN('T','F')),
	CONSTRAINT CK_Languages_Percentage CHECK(Percentage >= 0)
)

UPDATE Languages SET Language = TRIM(Language)

CREATE NONCLUSTERED INDEX IX_Country_languages_Language ON Languages
(
	Language ASC
)WITH(FILLFACTOR = 70)


/*VIEWS*/
CREATE VIEW VW_Country_city 
WITH ENCRYPTION 
AS
SELECT 
CO.Country_code AS 'Country_code',
CO.Country_name AS 'Country_name',
CT.City_name AS 'City_name',
CT.Population AS 'Population'
FROM Countries AS CO 
INNER JOIN Cities AS CT ON CO.Country_code = CT.Country_code

CREATE VIEW VW_Official_Languages_Of_The_Country
WITH ENCRYPTION 
AS
SELECT
CO.Country_code AS 'Country_code',
CO.Country_name AS 'Country_name',
L.Language AS 'Language'
FROM Countries AS CO 
INNER JOIN Languages AS L ON CO.Country_code = L.Country_code
WHERE L.is_official = 'T'