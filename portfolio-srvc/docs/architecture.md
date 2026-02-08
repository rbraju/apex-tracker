# Portfolio Service Architecture & Design

## 1. Overview
The `portfolio-srvc` manages stock holdings in a PostgreSQL database.

## 2. Component Diagram


## 3. Database Schema
Managed by Hibernate.

| Column | Type | Constraints |
| :--- | :--- | :--- |
| `id` | BigInt | Primary Key, Auto-increment |
| `symbol` | Varchar(10) | Not Null |
| `quantity` | Int | Not Null |
| `purchase_price`| Decimal(10,2)| Not Null |

## 4. Business Rules & Validation
Validated in the Service layer (`PortfolioService`):
* **Quantity**: Must be greater than 0. If 0 or less, `IllegalArgumentException` is thrown.
* **Symbol**: Must not be null or empty.

## 5. Security
* **Authentication**: Basic Auth (`user` / password from logs).
* **CSRF**: Disabled for REST API testing (`SecurityConfig`).