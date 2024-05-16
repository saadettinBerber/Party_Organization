INSERT INTO KULLANICI (USERID, PAROLA, EMAIL, FULLNAME) VALUES
(1, '123456', 'ahmet.yilmaz@example.com', 'Ahmet Yılmaz'),
(2, 'parola123', 'ayse.kaya@example.com', 'Ayşe Kaya'),
(3, 'sifre321', 'mehmet.ali@example.com', 'Mehmet Ali'),
(4, '654321', 'elif.basak@example.com', 'Elif Başak'),
(5, 'parola12345', 'fatma.gul@example.com', 'Fatma Gül'),
(6, '123456789', 'emre.kurt@example.com', 'Emre Kurt'),
(7, 'asdfghjkl', 'deniz.tekin@example.com', 'Deniz Tekin'),
(8, 'zxcvbnm', 'yasemin.uzun@example.com', 'Yasemin Uzun'),
(9, 'qweasdzxc', 'kemal.sunal@example.com', 'Kemal Sunal'),
(10, '123qweasd', 'leyla.aydemir@example.com', 'Leyla Aydemir');

INSERT INTO SIRKET (COMPANYNAME, SERVICETYPE, ADRESS, OFFERCOUNT, MINIMUMGUEST, MAXIMUMGUEST) VALUES
('Yıldız Catering', 'Wedding', 'Istanbul', 5, 10, 200),
('Güneş Organizasyon', 'Engagement', 'Ankara', 3, 20, 500),
('Ay Teknoloji', 'Engagement', 'Izmir', 8, 5, 100),
('Deniz Turizm', 'Birthday', 'Batman', 6, 30, 300),
('Dağ İnşaat', 'Birthday', 'Kocaeli', 4, 15, 150),
('Göl Restoran', 'Wedding', 'Istanbul', 7, 12, 250),
('Orman Kamp', 'Wedding', 'Balıkesir', 2, 10, 60),
('Nehir Spor', 'Engagement', 'Sakarya', 5, 20, 400),
('Okyanus Balıkçılık', 'Wedding', 'Ankara', 3, 8, 80),
('Bulut Bilişim', 'Birthday', 'Batman', 9, 10, 100);

INSERT INTO PRICING (COMID, SEASON, TIMEOFDAY, PRICEPERPERSON) VALUES
(1, 'Summer', 'Afternoon', 50),
(2, 'Winter', 'Evening', 100),
(3, 'Spring', 'Morning', 30),
(4, 'Autumn', 'Afternoon', 40),
(5, 'Summer', 'Evening', 70),
(6, 'Winter', 'Morning', 60),
(7, 'Spring', 'Afternoon', 55),
(8, 'Autumn', 'Evening', 80),
(9, 'Summer', 'Morning', 45),
(10, 'Winter', 'Afternoon', 65);

INSERT INTO URUN (COMID, PRODUCTNAME, PRODUCTPRICE, STOCKQUANTITY) VALUES
(1, 'Tavuk Döner', 20, 100),
(2, 'Kalem', 1.5, 200),
(3, 'Bilgisayar', 4500, 10),
(4, 'Tatil Paketi', 3000, 15),
(5, 'Tuğla', 0.50, 1000),
(6, 'Izgara Balık', 25, 50),
(7, 'Çadır', 150, 20),
(8, 'Spor Ayakkabı', 200, 30),
(9, 'Balık Oltası', 75, 40),
(10, 'Klavye', 100, 25);

INSERT INTO SEPET (USERID, SEPETID, SEPETTOTALCOST) VALUES
(1, 101, 500),
(2, 102, 300),
(3, 103, 1500),
(4, 104, 750),
(5, 105, 600),
(6, 106, 350),
(7, 107, 1200),
(8, 108, 450),
(9, 109, 900),
(10, 110, 550);

INSERT INTO SEPETICINDEKILER (SEPID, COMID, PRODUCTNAME, ADET) VALUES
(101, 1, 'Tavuk Döner', 5),
(102, 2, 'Kalem', 100),
(103, 3, 'Bilgisayar', 1),
(104, 4, 'Tatil Paketi', 1),
(105, 5, 'Tuğla', 300),
(106, 6, 'Izgara Balık', 7),
(107, 7, 'Çadır', 2),
(108, 8, 'Spor Ayakkabı', 1),
(109, 9, 'Balık Oltası', 3),
(110, 10, 'Klavye', 2);

INSERT INTO ETKINLIK (COMID, USERID, ETKINLIKID, SEASON, TIMEOFDAY, TOTALPERSON) VALUES
(1, 1, 1001, 'Summer', 'Afternoon', 50),
(2, 2, 1002, 'Winter', 'Evening', 100),
(3, 3, 1003, 'Spring', 'Morning', 30),
(4, 4, 1004, 'Autumn', 'Afternoon', 40),
(5, 5, 1005, 'Summer', 'Evening', 70),
(6, 6, 1006, 'Winter', 'Sabah', 60),
(7, 7, 1007, 'Spring', 'Afternoon', 55),
(8, 8, 1008, 'Autumn', 'Evening', 80),
(9, 9, 1009, 'Summer', 'Morning', 45),
(10, 10, 1010, 'Winter', 'Afternoon', 65);


SELECT * FROM ETKINLIK;
SELECT * FROM KULLANICI;
SELECT * FROM PRICING;
SELECT * FROM SEPET;
SELECT * FROM SEPETICINDEKILER;
SELECT * FROM SIRKET;
SELECT * FROM URUN;