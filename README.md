# simplelib
iş bu program özgür yazılım aş staj başvurusuna binaen geliştirilmiştir.
basit bir kütüphane otomasyon yazılımıdır.  
İsterlerden tek yerine getiremediğim JPA yerine JDBC kullanmak oldu.

Thymeleaf, Maven, Spring Boot ve PostgreSQL kullanarak geliştirdim. Projenin templateini [buradan](https://start.spring.io/) edindim. Frontendde bootstrap kullandım.

### uygulamayı edinme çalıştırma

#### programı indirme bağımlılıkları edinme ve compile etme
```bash
$ git clone https://github.com/mrkaurelius/simplelib
$ cd simplelib
$ mvn ınstall
```
#### database bağımlılıkları
- database bağımlılıkları için src/main/db/ddl_dml.sql dosyasını postgreste çalıştırmalısınız.
- database'in bağlantı bilgilerini "target/classes/application.properties" dosyasına tanımlamalısınız.  

Bu aşamadan sonra uygulamaya localhost:8080 den ulaşabilirsiniz.

### uygulmayı geliştirirken yaptığım teknik seçimler/kabuller
Bu yazılımda teknik seçimleri benden ziyade kullandığım platformalar yaptı.
Springde Bir uygulama yazdığınız zaman çoğu şeyi springin istediği gibi yapmak durumundasınız. Dependency İnjection, IoC gibi kararları benden önce spring veriyor. Ben sadece veri servislerinin erişimlerini ileride daha farklı şekillerde de kullanacak bir biçimde implent etmeye çalıştım fakat daha öncede değindim gibi bunlar zaten ya frameworkun zorlamaları yada best practice'leri (Bildiğim kadarıyla)