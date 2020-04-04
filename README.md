# Meet The Family

Our story is set in the planet of Lengaburu......in the distant, distant galaxy of Tara B. And our protagonists are King Shan, Queen Anga & their family.  
King Shan is the emperor of Lengaburu and has been ruling the planet for the last 350 years (they have long lives in Lengaburu, you see!). 

Write code to model out the King Shan family tree so that: 
* Given a ‘name’ and a ‘relationship’, you should output the people corresponding to the relationship in the order in which they were added to the family tree. Assume the names of the family members are unique.
* You should be able to add a child to any family in the tree through the mother. 

Full description of the problem can be found at [Meet The Family](https://www.geektrust.in/coding-problem/backend/family)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* [Maven](http://maven.apache.org/download.cgi)
* [JDK 1.8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)

### Steps to run

* Open cmd and change directory to family folder
* Run: **mvn clean install**
* Run: **java -jar ./target/geektrust.jar path_to_input_file**

The family tree is initialized using **init.txt** file which is at **family/src/main/resources/init.txt**.

## Sample IO

**INPUT**
```````
GET_RELATIONSHIP Arit Son
GET_RELATIONSHIP Arit Daughter
GET_RELATIONSHIP Asva Siblings
```````

**OUTPUT**
``````
Laki
Lavnya
Atya Vyas
``````

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Java 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) - Programming language used


## Acknowledgments

* GeekTrust Team
