# **Movie Booking Application - By Arnab Basu**
##A full stack java project


## Project Overview

This Java Full Stack project is designed to showcase my skills and understanding of various technologies involved in full-stack development. It incorporates both frontend and backend components to create a complete web application.

This is a movie booking application, which has seperate usages for **Admin** & **User**.

Admin can add, update, search and delete movies. Each movie has its name, movie id, theatre name and available seats. Admin can also check the transaction details of each movie and also check the list of users who are using their application

A user can signup and then login to book tickets for a movie according to his/her choice. The user just needs to provide the no of heads and the booking date. That's it, the tickets are booked and the user can check his M-tickets in My-Bookings section

## Technologies Used

The project utilizes the following technologies:

- **Frontend:**
  - HTML5
  - CSS3
  - TypeScript
  - Angular framework
  
- **Backend:**
  - Java
  - Spring Framework (Spring Boot)
  - Hibernate 
  - RESTful APIs

- **Database:**
  - MySQL
  
- **Development Tools:**
  - IDE (IntelliJ, Eclipse, or any other Java IDE)
  - Git (for version control)
  - Maven (for project management)
  - npm (for frontend dependencies)

- **Hosting:**
  - Backend - Amazon S3, EC2, Rest API Gateway
  - Frontend - Amazon S3 Static web Hosting

## Prerequisites

Before running the project, ensure that you have the following installed:

- Java Development Kit (JDK)
- IDE of your choice
- MySQL Workbench
- Git
- Node.js 

## Project Setup - Backend

Follow the steps below to set up the project:

1. Clone the project repository from GitHub using the following command:
   ```
   git clone <repository-url>
   ```

2. Open the project in your preferred IDE.

3. Set up the project dependencies by running the following command in the project's root directory:
   ```
   mvn clean install
   ```

4. Configure the database connection settings in the project's configuration file - `application.properties`

5. Run the project using the IDE's build and run functionality or by executing the generated JAR file.


## Project Setup - Frontend

Follow the steps below to set up the project:

1. Clone the project repository from GitHub using the following command:
   ```
   git clone <repository-url>
   ```

2. Open the frontend folder in your preferred IDE.

3. Set up the project dependencies by running the following command in the project's root directory:
   ```
   npm install
   ```

4. Run the project by running the following command in the project's root directory:
   ```
   ng serve 
   ```

## Usage

Once the project is set up and running, you can access the web application by opening a web browser and navigating to the appropriate URL (e.g., `http://localhost:4200/`).

Default Admin credentials-

Username - admin   
Password - admin
                                                                                                              
User can sign up and then login to use the application
---

## Thank You !
