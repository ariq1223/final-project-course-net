#  Microservice Project – Gabungan Project 4 & 5  
Java Spring Boot • Docker • REST API • Microservice Architecture

Proyek ini merupakan penggabungan dari **Project 4(fitur pembayaran & saldo) ** dan **Project 5(Integrasi third Party API)** menjadi satu arsitektur **Microservice** yang saling terhubung 

---


# Teknologi yang Digunakan

- **Java Spring Boot**
- **MySQL**
- **Docker Compose**
- **Spring Cloud Netflix**
- **Reloadly (3rd API)**
- **Eureka Discovery Server **

---

# Daftar Service

###  Users Service  
Base URL: `/api/users`  
Fungsi: menyimpan data user & saldo  

###  Products Service  
Base URL: `/api/products`  
Fungsi: menyediakan katalog produk  

###  Transactions Service  
Base URL: `/api/transactions`  
Fungsi: mengelola transaksi pembelian pulsa  

---

#  Endpoint Lengkap

##  Users Service

| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | `/api/users/{id}` | Ambil data user berdasarkan ID |
| PUT | `/api/users/{id}/saldo` | Update saldo user |

---

##  Products Service

| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | `/api/products/{id}` | Ambil detail produk |

---

##  Transactions Service

| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| POST | `/api/transactions/pulsa` | Transaksi pembelian pulsa |
| GET | `/api/transactions/history/{id}` | Riwayat transaksi user |

---





