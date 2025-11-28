# PROJECT 3

Implementasi Autentikasi JWT dan Role-Based Access Control (RBAC) menggunakan Spring Boot.

##  Implementasi Autentikasi JWT dan Role-Based Access Control (RBAC)
Proyek ini adalah implementasi Project 3: Autentikasi & Keamanan menggunakan Java Spring Boot. Aplikasi ini menampilkan autentikasi pengguna menggunakan JWT (JSON Web Token) dan proteksi endpoint berdasarkan Role-Based Access Control (RBAC).

Pengguna dapat login, lalu mengakses endpoint tertentu sesuai dengan role (ADMIN atau USER). Database MySQL digunakan untuk penyimpanan data pengguna.

---

##  Fitur Utama
- **Autentikasi JWT** – Generate token JWT saat login.
- **Proteksi Endpoint** – Setiap request diverifikasi melalui filter JWT.
- **Role-Based Access Control** – Proteksi berdasarkan role (ADMIN / USER).
- **MySQL Database** – Penyimpanan user + role.
- **BCrypt Password Hashing** – Password lebih aman.
- **Stateless Session** – Menggunakan JWT, tanpa session server.

---

##  Prasyarat
- Java 21 
- Maven dEAMON
- MySQL 5.7 / 8.0+
- Postman
- Microsoft Visual Code
---

##  Instalasi
###  Clone Repository
```bash
git clone https://github.com/your-username/jwt-rbac-app.git
cd project3
```

###  Install Dependencies
```bash
mvnd clean install
```

---


##  Menjalankan Aplikasi
```bash
mvnd spring-boot:run
```
Aplikasi berjalan di: **http://localhost:8080**

---

##  API Endpoints
###  Autentikasi
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

##  Endpoint Dilindungi (Harus pakai token)
Tambahkan header:
```
Authorization: Bearer <token>
```

###  **GET /users/profile**
Role: USER & ADMIN

###  **GET /users/all**
Role: ADMIN only

###  **POST /users/manage**
Role: ADMIN only

---

##  Pengujian dengan Postman
1. Register user baru
2. Login (dapatkan token)
3. Gunakan token untuk akses endpoint
4. Coba akses ADMIN endpoint menggunakan token USER → harus 403 Forbidden

---

##  Struktur Proyek
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

## Catatan Tambahan
- Jangan share **jwt.secret** ke publik
- Jika token expired → 401 Unauthorized
- Role bisa dikembangkan sesuai kebutuhan

---

Selesai! 

