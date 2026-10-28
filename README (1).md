# Restaurant Menu Service

A REST API built with **Java, Spring Boot, Spring Data JPA, and MySQL** to manage restaurants and their food items. The API endpoints are tested using **Swagger UI**.

## Technologies Used

- Java 25
- Spring Boot 4.1.2
- Spring Data JPA / Hibernate
- MySQL
- Maven
- Swagger UI (Springdoc OpenAPI)

## Features

- Create, view, update, and delete restaurants
- Create, view, update, and delete food items
- Retrieve all food items belonging to a specific restaurant
- Persist data in MySQL using Spring Data JPA
- Explore and test REST API endpoints through Swagger UI

## Project Structure

```text
src/main/java/com/vcube/restaurantservice/
├── controller/
│   ├── RestaurantController.java
│   └── FoodItemController.java
├── entity/
│   ├── Restaurant.java
│   └── FoodItem.java
├── repo/
│   ├── RestaurantRepo.java
│   └── FoodItemRepo.java
├── service/
│   ├── RestaurantService.java
│   ├── RestaurantImpl.java
│   ├── FoodItemService.java
│   └── FoodItemImpl.java
└── RestaurantserviceApplication.java
```

## Database Configuration

The application is currently configured to connect to a local MySQL database named `sbdata`.

Create the database before running the application:

```sql
CREATE DATABASE sbdata;
```

Check `src/main/resources/application.properties` and update the MySQL username and password to match your local setup:

```properties
spring.application.name=restaurantservice
server.port=9999

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/sbdata
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Hibernate creates or updates the `restaurant` and `fooditem` tables automatically because `spring.jpa.hibernate.ddl-auto` is set to `update`.

## Run the Application

**Requirements:** Java 25 and Maven (or use the included Maven Wrapper), plus a running MySQL server.

1. Clone or download this repository.
2. Create the `sbdata` database.
3. Update the database credentials in `application.properties`.
4. Open a terminal in the `spbootrestaurantservice` project folder.
5. Run the application:

   **Windows**
   ```bat
   .\mvnw.cmd spring-boot:run
   ```

   **macOS/Linux**
   ```bash
   ./mvnw spring-boot:run
   ```

Once the application starts, it listens on port `9999`.

## Test the API with Swagger UI

Open this URL in your browser after the application has started:

**http://localhost:9999/swagger-ui/index.html**

In Swagger UI, expand an endpoint, click **Try it out**, enter the required path parameters or JSON request body, and click **Execute**. Review the response code and response body.

The OpenAPI document is available at:

`http://localhost:9999/v3/api-docs`

## API Endpoints

### Restaurant APIs

Base path: `/restaurants`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/restaurants/save` | Create a restaurant |
| `GET` | `/restaurants/findAll` | Get all restaurants |
| `GET` | `/restaurants/findRestaurant/{id}` | Get a restaurant by ID |
| `PUT` | `/restaurants/updateRestaurant/{id}` | Update a restaurant |
| `DELETE` | `/restaurants/deleteRestaurant/{id}` | Delete a restaurant |

#### Create a restaurant

`POST /restaurants/save`

Request body:

```json
{
  "name": "Spice Garden"
}
```

Example response:

```json
{
  "id": 1,
  "name": "Spice Garden"
}
```

The generated ID in your response may be different.

#### Update a restaurant

`PUT /restaurants/updateRestaurant/1`

```json
{
  "name": "Spice Garden Restaurant"
}
```

### Food Item APIs

Base path: `/fooditems`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/fooditems/save` | Create a food item |
| `GET` | `/fooditems/findAll` | Get all food items |
| `GET` | `/fooditems/findFoodItem/{id}` | Get a food item by ID |
| `GET` | `/fooditems/findAll/{rstId}` | Get all food items for a restaurant |
| `PUT` | `/fooditems/updateFoodItem/{id}` | Update a food item |
| `DELETE` | `/fooditems/deleteFoodItem/{id}` | Delete a food item |

#### Create a food item

First create a restaurant and note its generated ID. Then use that ID in the `rst` object when creating a food item.

`POST /fooditems/save`

```json
{
  "item_name": "Paneer Biryani",
  "item_price": 220.0,
  "rst": {
    "id": 1
  }
}
```

Here, `1` must be replaced with an existing restaurant ID in your database.

#### Get food items for a restaurant

`GET /fooditems/findAll/1`

Replace `1` with the restaurant ID.

#### Update a food item

`PUT /fooditems/updateFoodItem/1`

```json
{
  "item_name": "Special Paneer Biryani",
  "item_price": 250.0,
  "rst": {
    "id": 1
  }
}
```

#### Delete a food item

`DELETE /fooditems/deleteFoodItem/1`

Replace `1` with the food item ID you want to delete.

## Suggested Testing Order

1. Create a restaurant using `POST /restaurants/save`.
2. Get all restaurants using `GET /restaurants/findAll` and note a restaurant ID.
3. Create a food item using `POST /fooditems/save`, supplying that restaurant ID in `rst.id`.
4. Retrieve food items using `GET /fooditems/findAll` or `GET /fooditems/findAll/{rstId}`.
5. Test getting a record by ID, updating it, and deleting it using the relevant endpoints.

## Notes

- The application uses a `ManyToOne` relationship: each food item is associated with a restaurant through the `restaurant_id` foreign-key column.
- Endpoint paths above match the current controller mappings.
- Error handling and validation are not explicitly implemented in the current code, so responses for missing IDs or invalid input may depend on Spring and JPA behavior.
