# Cihaz Kontrol Uygulaması - Backend

## Genel Bakış

Bu proje, IoT cihaz bilgilerini ve garanti durumunu yöneten bir Cihaz Kontrol sisteminin backend uygulamasıdır. Uygulama, cihaz bilgilerini saklar ve cihazların garanti durumunu kontrol eder.

## Özellikler

- **Cihaz Ekleme**: Seri numarası, marka, model ve satın alma tarihi ile yeni bir cihaz ekleyin.
- **Cihaz Güncelleme**: Mevcut cihaz bilgilerini güncelleyin.
- **Cihaz Silme**: Bir cihazı sistemden kaldırın.
- **Garanti Kontrolü**: Cihazların garanti durumunu alış tarihine göre kontrol edin ve durumu güncelleyin.

## Kullanılan Teknolojiler

- **Java 17**: Uygulamanın geliştirilmesi için kullanılan dil.
- **Spring Boot 3.3.1**: Uygulama çatısı.
- **PostgreSQL**: Veritabanı yönetim sistemi.
- **Hibernate**: ORM (Object-Relational Mapping) aracı.
- **Lombok**: Kod yazımını kolaylaştıran bir kütüphane.

## Kurulum

### Gereksinimler

- Java 17
- PostgreSQL
- Maven

### Adımlar

1. **Depoyu klonlayın:**

    ```bash
    git clone https://github.com/aleyna-yildizli/device-controller.git
    cd device-controller
    ```

2. **Veritabanını yapılandırın:**

   PostgreSQL veritabanında bir şema oluşturun ve `application.properties` dosyasında gerekli veritabanı yapılandırmasını yapın.

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/device_management
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
    spring.jpa.hibernate.ddl-auto=update
    ```

## Postman Dökümantasyonu

### Postman Koleksiyonu

Postman koleksiyonuna bu [linkten](https://www.postman.com/mission-technologist-64183790/workspace/device-management-api/request/32453856-85d9a7b2-8642-41fc-b871-6924eac23579) ulaşabilirsiniz.

1. **Postman'i Açın:**
2. **Yeni İstekler Ekleyin:**

#### GET Tüm Cihazları Getirme
- **Ad**: Get All Devices
- **Metod**: GET
- **URL**: `http://localhost:5680/api/v1/roltek/devices`
- **Headers**:
   - Key: `Content-Type`
   - Value: `application/json`

#### POST Yeni Cihaz Ekleme
- **Ad**: Add Device
- **Metod**: POST
- **URL**: `http://localhost:5680/api/v1/roltek/devices`
- **Headers**:
   - Key: `Content-Type`
   - Value: `application/json`
- **Body**:
  ```json
  {
    "serialNumber": "A12345",
    "brand": "Iphone",
    "model": "12pro",
    "purchaseDate": "2024-08-10"
  }
  
    ```

#### PUT Cihaz Güncelleme
- **Ad**:  Update Device
- **Metod**: PUT
- **URL**: `http://localhost:5680/api/v1/roltek/devices/{id}`
- **Headers**:
    - Key: `Content-Type`
    - Value: `application/json`
- **Body**:
  ```json
  {
    "serialNumber": "A12345",
    "brand": "Iphone",
    "model": "15pro",
    "purchaseDate": "2024-08-10"
  }

    ```

#### DELETE Cihaz Silme
- **Ad**:  Delete Device
- **Metod**: DELETE
- **URL**: `http://localhost:5680/api/v1/roltek/devices/{id}`
- **Headers**:
    - Key: `Content-Type`
    - Value: `application/json`
