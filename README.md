
# Building and running the Project for testing purposes
make sure the postgreSQL database is up and running
in root dir, run ./gradlew build, then run ./gradlew bootRun
the Database will be populated with dummy data

# Project structure
The project is structured into entities : Article, Author, Newspaper, Owner, Publisher, Topic

For each Entity the following Invariants hold.

An entity has its own table in the Database, its own DTOs, mappers, controller and testing folder. There is a one to one mapping between the table, DTO, entity class through the attributes. Each entity has an Analytics attribute which implements the Analytics interface. Also each Entity has its own project folder where all files it conerns are there. 

DONT BREAK ANY OF THESE INVARIANTS.

on the Database side, the tables are all related through Ids as foreign keys. if a request returns an entity instead of the id (which would make subsequent requests necessary to get all the data) , the full json is returned with nested dictionaries, see test file ArticleControllerTest.java to get an example 

# Tests
The Tests are done via SprintbootTest webenvironment which should be equivalent to real http request, nothing is mocked, every endpoint is covered.

# Naming
Naming in the entity files is implicit whereas naming in the Database is explicit , because otherwise when two tables are joined, one would need to specify an alias, this ways this is not necessary. For example names see the database tables and the entity files