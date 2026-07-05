-- ============================================================
-- Inventory Management System
-- Database : inventory_db
-- PostgreSQL
-- Version 1.0
-- Author : Shivashankar Bansode
-- ============================================================

-- ============================================================
-- DROP EXISTING TABLES
-- ============================================================

DROP TABLE IF EXISTS sales_items CASCADE;
DROP TABLE IF EXISTS sales_orders CASCADE;
DROP TABLE IF EXISTS purchase_items CASCADE;
DROP TABLE IF EXISTS purchase_orders CASCADE;
DROP TABLE IF EXISTS stock_transactions CASCADE;
DROP TABLE IF EXISTS inventory CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS warehouses CASCADE;
DROP TABLE IF EXISTS suppliers CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS roles CASCADE;

-- ============================================================
-- ROLES
-- ============================================================

CREATE TABLE roles (

    role_id BIGSERIAL PRIMARY KEY,

    role_name VARCHAR(50) NOT NULL UNIQUE

);

-- ============================================================
-- USERS
-- ============================================================

CREATE TABLE users (

    user_id BIGSERIAL PRIMARY KEY,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100),

    username VARCHAR(100) NOT NULL UNIQUE,

    email VARCHAR(150) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

    enabled BOOLEAN DEFAULT TRUE,

    role_id BIGINT NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_user_role
        FOREIGN KEY(role_id)
        REFERENCES roles(role_id)

);

-- ============================================================
-- CATEGORIES
-- ============================================================

CREATE TABLE categories (

    category_id BIGSERIAL PRIMARY KEY,

    category_name VARCHAR(100) NOT NULL UNIQUE,

    description TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

-- ============================================================
-- SUPPLIERS
-- ============================================================

CREATE TABLE suppliers (

    supplier_id BIGSERIAL PRIMARY KEY,

    supplier_name VARCHAR(150) NOT NULL,

    contact_person VARCHAR(100),

    email VARCHAR(150) UNIQUE,

    phone VARCHAR(20),

    address TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

-- ============================================================
-- WAREHOUSES
-- ============================================================

CREATE TABLE warehouses (

    warehouse_id BIGSERIAL PRIMARY KEY,

    warehouse_name VARCHAR(100) NOT NULL,

    location VARCHAR(200),

    manager_name VARCHAR(100),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);
-- ============================================================
-- PRODUCTS
-- ============================================================

CREATE TABLE products (

    product_id BIGSERIAL PRIMARY KEY,

    product_name VARCHAR(150) NOT NULL,

    description TEXT,

    barcode VARCHAR(100) UNIQUE,

    price NUMERIC(10,2) NOT NULL,

    status VARCHAR(20) DEFAULT 'ACTIVE',

    category_id BIGINT NOT NULL,

    supplier_id BIGINT NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_product_category
        FOREIGN KEY(category_id)
        REFERENCES categories(category_id),

    CONSTRAINT fk_product_supplier
        FOREIGN KEY(supplier_id)
        REFERENCES suppliers(supplier_id)

);
-- ============================================================
-- INVENTORY
-- ============================================================

CREATE TABLE inventory (

    inventory_id BIGSERIAL PRIMARY KEY,

    product_id BIGINT NOT NULL,

    warehouse_id BIGINT NOT NULL,

    quantity INTEGER NOT NULL DEFAULT 0,

    reserved_quantity INTEGER NOT NULL DEFAULT 0,

    minimum_quantity INTEGER NOT NULL DEFAULT 10,

    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_inventory_product
        FOREIGN KEY(product_id)
        REFERENCES products(product_id),

    CONSTRAINT fk_inventory_warehouse
        FOREIGN KEY(warehouse_id)
        REFERENCES warehouses(warehouse_id)

);
-- ============================================================
-- STOCK TRANSACTIONS
-- ============================================================

CREATE TABLE stock_transactions (

    transaction_id BIGSERIAL PRIMARY KEY,

    product_id BIGINT NOT NULL,

    warehouse_id BIGINT NOT NULL,

    transaction_type VARCHAR(30) NOT NULL,

    quantity INTEGER NOT NULL,

    remarks TEXT,

    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_transaction_product
        FOREIGN KEY(product_id)
        REFERENCES products(product_id),

    CONSTRAINT fk_transaction_warehouse
        FOREIGN KEY(warehouse_id)
        REFERENCES warehouses(warehouse_id)

);
-- ============================================================
-- PURCHASE ORDERS
-- ============================================================

CREATE TABLE purchase_orders (

    purchase_order_id BIGSERIAL PRIMARY KEY,

    supplier_id BIGINT NOT NULL,

    purchase_date DATE NOT NULL,

    status VARCHAR(30) DEFAULT 'PENDING',

    total_amount NUMERIC(12,2) DEFAULT 0,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_purchase_supplier
        FOREIGN KEY(supplier_id)
        REFERENCES suppliers(supplier_id)

);
-- ============================================================
-- PURCHASE ITEMS
-- ============================================================

CREATE TABLE purchase_items (

    purchase_item_id BIGSERIAL PRIMARY KEY,

    purchase_order_id BIGINT NOT NULL,

    product_id BIGINT NOT NULL,

    quantity INTEGER NOT NULL,

    price NUMERIC(10,2) NOT NULL,

    CONSTRAINT fk_purchase_order
        FOREIGN KEY(purchase_order_id)
        REFERENCES purchase_orders(purchase_order_id),

    CONSTRAINT fk_purchase_product
        FOREIGN KEY(product_id)
        REFERENCES products(product_id)

);
-- ============================================================
-- SALES ORDERS
-- ============================================================

CREATE TABLE sales_orders (

    sales_order_id BIGSERIAL PRIMARY KEY,

    customer_name VARCHAR(150),

    sales_date DATE NOT NULL,

    status VARCHAR(30) DEFAULT 'PENDING',

    total_amount NUMERIC(12,2) DEFAULT 0,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);
-- ============================================================
-- SALES ITEMS
-- ============================================================

CREATE TABLE sales_items (

    sales_item_id BIGSERIAL PRIMARY KEY,

    sales_order_id BIGINT NOT NULL,

    product_id BIGINT NOT NULL,

    quantity INTEGER NOT NULL,

    price NUMERIC(10,2) NOT NULL,

    CONSTRAINT fk_sales_order
        FOREIGN KEY(sales_order_id)
        REFERENCES sales_orders(sales_order_id),

    CONSTRAINT fk_sales_product
        FOREIGN KEY(product_id)
        REFERENCES products(product_id)

);

SELECT table_name
FROM information_schema.tables
WHERE table_schema='public'
ORDER BY table_name;