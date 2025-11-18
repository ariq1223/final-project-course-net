# 📦 Proyek 2 — Fitur Akun (Registrasi, Login, Verifikasi, Keamanan Data)


#### Nama: Ariq Radhi Arganto
Proyek ini mengimplementasikan fitur manajemen akun pengguna pada platform e-commerce menggunakan **Spring Boot**, **MySQL**, dan **Spring Security**. Fokus utama adalah memastikan keamanan data sesuai **UU Perlindungan Data Pribadi (PDP)**, khususnya dalam penyimpanan password dan akses data sensitif.

---

## 🚀 Teknologi yang Digunakan

| Teknologi | Fungsi |
|----------|--------|
| **Java Spring Boot** | Membuat REST API |
| **MySQL** | Database relasional |
| **Spring Data JPA** | ORM untuk operasi database |
| **Spring Security (BCrypt)** | Hashing password |
| **Validation** | Validasi input pengguna |
| **Postman** | Pengujian endpoint API |

---

## 🛡 Kepatuhan UU PDP

Proyek ini mengikuti prinsip dasar **UU PDP**, termasuk:

-  Password disimpan dalam bentuk **hash BCrypt**, bukan plain text  
- Input pengguna divalidasi (email, panjang password, dll)  
- Data pribadi hanya diakses oleh endpoint yang sah  
- Tidak menyimpan data sensitif yang tidak diperlukan  

---


## ⚙️ application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/login_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=9090

## 🧩 Fitur yang Diimplementasikan
####  Registrasi Akun

 -Password di-hash otomatis menggunakan BCrypt
 -Email harus unik
 -Validasi input

 Endpoint:
```bash
POST /api/users/register
```

#### Contoh Body Request:
```bash
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```
#### Login Pengguna

1. Mengecek email
2. Mencocokkan password dengan BCrypt matches()
3. Mengembalikan status verified

Endpoint:
```bash
POST /api/users/login
```

Body:
```bash
{
  "email": "ariq@example.com",
  "password": "password12345"
}
```
####  Upgrade Akun (Simulasi Verifikasi Email)

Mengubah field verified → TRUE

Endpoint:
```bash
POST /api/users/verify
```

Body:
```bash
{
  "email": "john@example.com"
}
```
#### Pengujian Dengan Postman
Fitur	Endpoint	Status
1. Registrasi	POST /api/users/register	
2. Berhasil (password ter-hash)
3. Login	POST /api/users/login	
4. (mengembalikan status verified)
Verifikasi Akun	POST /api/users/verify

## Skema Database

Tabel utama: **users**

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,   -- hash BCrypt
    verified BOOLEAN DEFAULT FALSE
);
