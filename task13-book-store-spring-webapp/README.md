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

## ERD
<img width="257" alt="image" src="https://github.com/Jalal-Assaly/Fawry-Internship-Summer2023/assets/140311958/cda6e9e0-3bf3-4b45-a5fd-2fe8056b9f08">


## UI
<img width="1080" alt="image" src="https://github.com/Jalal-Assaly/Fawry-Internship-Summer2023/assets/140311958/072c8a09-9409-4cbd-b277-7864d273474f">
<img width="1080" alt="image" src="https://github.com/Jalal-Assaly/Fawry-Internship-Summer2023/assets/140311958/86d866c9-0a3e-4195-8a83-72531a7f199c">
<img width="1080" alt="image" src="https://github.com/Jalal-Assaly/Fawry-Internship-Summer2023/assets/140311958/dc621457-c440-4c6a-83d4-7eecfd014932">
<img width="1080" alt="image" src="https://github.com/Jalal-Assaly/Fawry-Internship-Summer2023/assets/140311958/db319493-f89e-4647-bc5d-75df54f06009">


## Usage
- Users can browse and search for books by iban, title, author, or category.
- Users can add, delete and update books as wished through intuitive forms.
- Comprehensive validation ensures data integrity and security.
