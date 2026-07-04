# Database Design

Current Tables

- products
- categories
- suppliers
- inventory

Future Tables

- purchase_orders
- purchase_items
- sales_orders
- sales_items
- users
- roles

Future Relationships

Category (1) -------- (*) Product

Supplier (1) -------- (*) Product

Product (1) -------- (1) Inventory