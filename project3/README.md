# JWT RBAC Project

Implementasi Autentikasi JWT dan Role-Based Access Control (RBAC) menggunakan Spring Boot.

## 🚀 Implementasi Autentikasi JWT dan Role-Based Access Control (RBAC)
Proyek ini adalah implementasi Project 3: Autentikasi & Keamanan menggunakan Java Spring Boot. Aplikasi ini menampilkan autentikasi pengguna menggunakan JWT (JSON Web Token) dan proteksi endpoint berdasarkan Role-Based Access Control (RBAC).

Pengguna dapat login, lalu mengakses endpoint tertentu sesuai dengan role (ADMIN atau USER). Database MySQL digunakan untuk penyimpanan data pengguna.

---

## ✨ Fitur Utama
- **Autentikasi JWT** – Generate token JWT saat login.
- **Proteksi Endpoint** – Setiap request diverifikasi melalui filter JWT.
- **Role-Based Access Control** – Proteksi berdasarkan role (ADMIN / USER).
- **MySQL Database** – Penyimpanan user + role.
- **BCrypt Password Hashing** – Password lebih aman.
- **Stateless Session** – Menggunakan JWT, tanpa session server.

---

## 🧩 Prasyarat
- Java 17+ (disarankan)
- Maven
- MySQL 5.7 / 8.0+
- Postman
- IDE (IntelliJ / Eclipse)

---

## 📥 Instalasi
### 1️⃣ Clone Repository
```bash
git clone https://github.com/your-username/jwt-rbac-app.git
cd jwt-rbac-app
```

### 2️⃣ Install Dependencies
```bash
mvn clean install
```

---

## 🗄️ Setup Database
### 1️⃣ Buat Database MySQL
Eksekusi SQL berikut:
```sql
CREATE DATABASE IF NOT EXISTS jwt_app;
USE jwt_app;

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'USER') NOT NULL
);

INSERT INTO users (username, password, role) VALUES 
('admin', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'ADMIN'),
('user', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'USER');
```
> Password bawaan: **password**

### 2️⃣ Konfigurasi `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jwt_app?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=mySecretKey
jwt.expiration=86400000
```

---

## ▶️ Menjalankan Aplikasi
```bash
mvn spring-boot:run
```
Aplikasi berjalan di: **http://localhost:8080**

---

## 📡 API Endpoints
### 🔐 Autentikasi
#### **POST /auth/register**
Body:
```json
{
  "username": "newuser",
  "password": "password",
  "role": "USER"
}
```

#### **POST /auth/login**
Body:
```json
{
  "username": "admin",
  "password": "password"
}
```
Response:
```json
{ "token": "eyJhbGciOiJIUzI1NiJ9..." }
```

---

## 🔒 Endpoint Dilindungi (Harus pakai token)
Tambahkan header:
```
Authorization: Bearer <token>
```

### 👤 **GET /users/profile**
Role: USER & ADMIN

### 📋 **GET /users/all**
Role: ADMIN only

### ⚙️ **POST /users/manage**
Role: ADMIN only

---

## 🧪 Pengujian dengan Postman
1. Register user baru
2. Login (dapatkan token)
3. Gunakan token untuk akses endpoint
4. Coba akses ADMIN endpoint menggunakan token USER → harus 403 Forbidden

---

## 📁 Struktur Proyek
```
jwt-rbac-app/
├── src/main/java/com/example/jwtrbacapp/
│   ├── JwtRbacAppApplication.java
│   ├── config/SecurityConfig.java
│   ├── controller/AuthController.java
│   ├── controller/UserController.java
│   ├── filter/JwtAuthenticationFilter.java
│   ├── model/User.java
│   ├── repository/UserRepository.java
│   ├── service/AuthService.java
│   ├── service/UserDetailsServiceImpl.java
│   └── util/JwtUtil.java
├── src/main/resources/application.properties
├── pom.xml
└── README.md
```

---

## 📌 Catatan Tambahan
- Jangan share **jwt.secret** ke publik
- Jika token expired → 401 Unauthorized
- Role bisa dikembangkan sesuai kebutuhan

---

Selesai! 🎉

