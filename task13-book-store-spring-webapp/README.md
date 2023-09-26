# Bookstore Web Application

---

**Welcome to the Bookstore Web Application!** This project is built using **Spring Boot** 
and follows the **Model-View-Controller (MVC) architecture**, making it a robust 
and user-friendly platform for managing books.

## Key Features
### Development
- **Spring Boot**: Spring Boot and its many tools were used to simplify application setup and development, 
allowing for efficient development.

- **JSP Files**: JavaServer Pages (JSP) are used to create dynamic web pages, 
providing a user interface that adapts by using tools like JSTL tags.

- **MySQL Database**: A MySQL database was used as the primary database to store the books information, namely 
the IBAN, book title, author name, category and price.

- **JPA & Hibernate**: JPA and its Hibernate ORM implementation are utilized to map Java objects to database tables,
simplifying data access and management.

- **Spring Boot Validation**: Spring Boot validation is implemented to ensure data accuracy and security,
preventing invalid data from entering the system. The many annotations provided 
by the framework make it easy to use and understand.

### Testing 
- **H2 In-Memory Database**: H2 is employed as an in-memory database for testing purposes, independent of the MySQL database, 
allowing for efficient unit testing.
- **Mockito Testing**: We have integrated Mockito for unit testing, ensuring the reliability and functionality of the application.



## Usage
- Users can browse and search for books by iban, title, author, or category.
- Users can add, delete and update books as wished through intuitive forms.
- Comprehensive restrictive validation ensures data integrity and security.
