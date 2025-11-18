# 📦 Microservice Project – Gabungan Project 4 & 5  
Java Spring Boot • Docker • REST API • Microservice Architecture

Proyek ini merupakan penggabungan dari **Project 4(fitur pembayaran & saldo) ** dan **Project 5(Integrasi third Party API)** menjadi satu arsitektur **Microservice** yang saling terhubung 

---


# 🔧 Teknologi yang Digunakan

- **Java Spring Boot**
- **MySQL / MariaDB**
- **Docker Compose**
- **Spring Cloud Netflix**
- **Reloadly (3rd API)**
- **Eureka Discovery Server **

---

# 🧩 Daftar Service

### 1️⃣ Users Service  
Base URL: `/api/users`  
Fungsi: menyimpan data user & saldo  

### 2️⃣ Products Service  
Base URL: `/api/products`  
Fungsi: menyediakan katalog produk  

### 3️⃣ Transactions Service  
Base URL: `/api/transactions`  
Fungsi: mengelola transaksi pembelian pulsa  

---

# 📌 Endpoint Lengkap

## 🔹 Users Service

| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | `/api/users/{id}` | Ambil data user berdasarkan ID |
| PUT | `/api/users/{id}/saldo` | Update saldo user |

---

## 🔹 Products Service

| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | `/api/products/{id}` | Ambil detail produk |

---

## 🔹 Transactions Service

| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| POST | `/api/transactions/pulsa` | Transaksi pembelian pulsa |
| GET | `/api/transactions/history/{id}` | Riwayat transaksi user |

---

# 🗄️ Struktur Database

## 📌 Users Service
| Field | Type | Keterangan |
|-------|------|------------|
| id | INT (PK) | ID user |
| name | VARCHAR | Nama user |
| email | VARCHAR | Email user |
| saldo | INT | Saldo user |
| created_at | TIMESTAMP | Waktu pembuatan |

---

## 📌 Products Service
| Field | Type | Keterangan |
|-------|------|------------|
| id | INT (PK) | ID produk |
| name | VARCHAR | Nama produk |
| type | VARCHAR | Tipe produk (pulsa/data) |
| price | INT | Harga produk |
| provider | VARCHAR | Provider (Telkomsel/XL/dll) |

---

## 📌 Transactions Service
| Field | Type | Keterangan |
|-------|------|------------|
| id | INT (PK) | ID transaksi |
| user_id | INT (FK) | Relasi ke users |
| product_id | INT (FK) | Relasi ke products |
| amount | INT | Total harga |
| status | VARCHAR | SUCCESS/FAILED |
| created_at | TIMESTAMP | Waktu transaksi |

---




