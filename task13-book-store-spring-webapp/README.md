# Bookstore Web Application

---

**Welcome to the Bookstore Web Application!** This project is built using **Spring Boot** 
and follows the **Model-View-Controller (MVC) architecture**, making it a robust 
and user-friendly platform for managing and purchasing books.

## Key Features
### Development
- **Spring Boot**: We leveraged Spring Boot and its many tools to simplify application setup and development, 
allowing for efficient development and deployment.

- **JSP Files**: JavaServer Pages (JSP) are used to create dynamic web pages, 
providing a user interface that adapts by using tools like JSTL tags.

- **MySQL Database**: We use MySQL as the primary database to store the books information, namely 
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


## UI
<img width="1079" alt="image" src="https://github.com/Jalal-Assaly/Fawry-Internship-Summer2023/assets/140311958/100fd5a7-5860-49ba-911e-04d98619c531">
<img width="1080" alt="image" src="https://github.com/Jalal-Assaly/Fawry-Internship-Summer2023/assets/140311958/d1f8da95-515e-400c-8572-1f72f88904a2">
<img width="1080" alt="image" src="https://github.com/Jalal-Assaly/Fawry-Internship-Summer2023/assets/140311958/3676bc93-c105-4cd1-a6ef-a490c77bfc45">
<img width="1080" alt="image" src="https://github.com/Jalal-Assaly/Fawry-Internship-Summer2023/assets/140311958/b521b7f3-6139-44c5-9513-4fe6d6937cba">


## Usage
- Users can browse and search for books by iban, title, author, or category.
- Users can add, delete and update books as wished through intuitive forms.
- Comprehensive validation ensures data integrity and security.
