# 📦 Inventory Management System

A full-stack **Inventory Management System** built using **Spring Boot**, **PostgreSQL**, and modern DevOps practices. This project is being developed incrementally following enterprise software development principles and will eventually be deployed on AWS using a complete CI/CD pipeline.

---

## 🚀 Tech Stack

### Backend
- Java 21
- Spring Boot 3
- Spring Data JPA (Hibernate)
- Maven
- PostgreSQL
- Lombok
- Jakarta Validation

### Database
- PostgreSQL
- pgAdmin 4

### API Testing
- Postman

### Version Control
- Git
- GitHub

### Planned DevOps Stack
- Docker
- Docker Compose
- Jenkins
- SonarQube
- OWASP Dependency Check
- Trivy
- Kubernetes
- Helm
- ArgoCD
- Terraform
- AWS (EC2 / EKS / RDS)
- Prometheus
- Grafana

---

# 📁 Project Structure

```
inventory-management-app
│
├── backend
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   ├── service
│   ├── service/impl
│   ├── config
│   ├── exception
│   └── util
│
├── frontend (Coming Soon)
├── database (Coming Soon)
├── docker (Coming Soon)
└── README.md
```

---

# ✅ Features Implemented

### Product Management
- Create Product
- Get All Products
- Get Product by ID
- Update Product
- Delete Product

### Category Management
- Create Category
- Get All Categories
- Get Category by ID
- Update Category
- Delete Category

### Supplier Management
- Create Supplier
- Get All Suppliers
- Get Supplier by ID
- Update Supplier
- Delete Supplier

### Inventory Management
- Inventory Entity
- Inventory CRUD APIs
- PostgreSQL Integration

---

# 📚 REST APIs

## Product APIs

| Method | Endpoint |
|---------|----------|
| POST | `/api/products` |
| GET | `/api/products` |
| GET | `/api/products/{id}` |
| PUT | `/api/products/{id}` |
| DELETE | `/api/products/{id}` |

---

## Category APIs

| Method | Endpoint |
|---------|----------|
| POST | `/api/categories` |
| GET | `/api/categories` |
| GET | `/api/categories/{id}` |
| PUT | `/api/categories/{id}` |
| DELETE | `/api/categories/{id}` |

---

## Supplier APIs

| Method | Endpoint |
|---------|----------|
| POST | `/api/suppliers` |
| GET | `/api/suppliers` |
| GET | `/api/suppliers/{id}` |
| PUT | `/api/suppliers/{id}` |
| DELETE | `/api/suppliers/{id}` |

---

## Inventory APIs

| Method | Endpoint |
|---------|----------|
| POST | `/api/inventory` |
| GET | `/api/inventory` |
| GET | `/api/inventory/{id}` |
| PUT | `/api/inventory/{id}` |
| DELETE | `/api/inventory/{id}` |

---

# 🗄️ Database Tables

Current tables:

- products
- categories
- suppliers
- inventory

---

# 📌 Upcoming Features

- Product ↔ Category Relationship
- Product ↔ Supplier Relationship
- Purchase Management (Stock In)
- Sales Management (Stock Out)
- Stock Transaction History
- Low Stock Alerts
- Dashboard
- Reports

---

# 🔒 Security (Planned)

- Spring Security
- JWT Authentication
- Role-Based Access Control (Admin / Manager / Employee)

---

# ⚙️ DevOps Roadmap

- Dockerize Spring Boot Application
- Docker Compose
- Jenkins CI/CD Pipeline
- SonarQube Code Analysis
- OWASP Dependency Check
- Trivy Image Scanning
- Kubernetes Deployment
- Helm Charts
- GitOps with ArgoCD
- Terraform Infrastructure
- AWS Deployment
- Prometheus Monitoring
- Grafana Dashboard

---

# 🧪 Testing

- Postman API Testing
- Unit Testing (Planned)
- Integration Testing (Planned)

---

# 📈 Project Status

| Module | Status |
|----------|--------|
| Spring Boot Setup | ✅ Completed |
| PostgreSQL Integration | ✅ Completed |
| Product CRUD | ✅ Completed |
| Category CRUD | ✅ Completed |
| Supplier CRUD | ✅ Completed |
| Inventory CRUD | ✅ Completed |
| Purchase Module | ⏳ In Progress |
| Sales Module | ⏳ Planned |
| JWT Authentication | ⏳ Planned |
| Docker | ⏳ Planned |
| Jenkins CI/CD | ⏳ Planned |
| Kubernetes | ⏳ Planned |
| AWS Deployment | ⏳ Planned |

---

# 👨‍💻 Author

**Shivashankar Bansode**

- GitHub: https://github.com/basodes
- LinkedIn: https://www.linkedin.com/in/shivashankar-b-074213321

---

## ⭐ If you found this project useful, consider giving it a star!
