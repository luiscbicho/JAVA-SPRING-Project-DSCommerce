# DSCommerce

DSCommerce is an e-commerce system designed to manage products, orders, and users. The system allows customers to browse the product catalog, add items to the cart, place orders, and track their status. Administrators have permissions to manage users, products, and categories.

## Features

- **Product catalog** with name filtering.
- **Shopping cart** where users can add, remove, and update item quantities.
- **Order management** with payment and shipping statuses.
- **User authentication** (customers and administrators).
- **Admin panel** for managing users, products, and categories.

## System Model

The system consists of the following main entities:

- **User:** Name, email, phone, birth date, password, and role (customer or administrator).
- **Product:** Name, description, price, and image.
- **Category:** Classification of products.
- **Order:** Contains a list of items, timestamp of purchase, and status (waiting for payment, paid, shipped, delivered, canceled).
- **Order Item:** Links a product to an order, recording the quantity and price of the product at the time of purchase.
- **Payment:** Timestamp when the payment was made.

### UML Diagram

[![uml-diagram-fixed.png](https://i.postimg.cc/NMtbs8C5/uml-diagram-fixed.png)](https://postimg.cc/8FyLwvSS)

## Technologies Used

- **Back-end:** Java, Spring Boot
- **Database:** H2 (for development), PostgreSQL or MySQL (for production)
- **Authentication:** Spring Security

## How to Run the Project

### Requirements

- Java 17+
- Maven
- Configured database (H2, PostgreSQL, or MySQL)

### Execution Steps

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/dscommerce.git
   ```
2. Navigate to the project folder:
   ```sh
   cd dscommerce
   ```
3. Configure the database in `application.properties`.
4. Run the project using Maven:
   ```sh
   mvn spring-boot:run
   ```
5. The system will be available at `http://localhost:8080`.

