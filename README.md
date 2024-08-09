
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