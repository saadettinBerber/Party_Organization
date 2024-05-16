-- Sequence Oluşturma
CREATE SEQUENCE USERID_SEQ START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

-- KULLANICI Tablosu
CREATE TABLE KULLANICI(
    USERID INT DEFAULT NEXTVAL('userid_seq') PRIMARY KEY,
    PAROLA VARCHAR(255),
    EMAIL VARCHAR(255),
    FULLNAME VARCHAR(255)
);

-- SIRKET Tablosu
CREATE TABLE SIRKET(
    COMPANYID SERIAL PRIMARY KEY,
    COMPANYNAME VARCHAR(255),
    SERVICETYPE VARCHAR(255),
    ADRESS VARCHAR(255),
    OFFERCOUNT INT,
    MINIMUMGUEST INT,
    MAXIMUMGUEST INT
);

-- PRICING Tablosu
CREATE TABLE PRICING(
    COMID INT,
    SEASON VARCHAR(255),
    TIMEOFDAY VARCHAR(255),
    PRICEPERPERSON NUMERIC,
    CONSTRAINT PK_PRICING PRIMARY KEY (COMID, SEASON, TIMEOFDAY),
    CONSTRAINT FK_PRICING FOREIGN KEY (COMID) REFERENCES SIRKET(COMPANYID) ON DELETE CASCADE,
    CONSTRAINT PRICING_PRICE_CK CHECK (PRICEPERPERSON > 0)
);

-- URUN Tablosu
CREATE TABLE URUN(
    COMID INT,
    PRODUCTNAME VARCHAR(255),
    PRODUCTPRICE NUMERIC,
    STOCKQUANTITY INT,
    CONSTRAINT PK_URUN PRIMARY KEY (COMID, PRODUCTNAME),
    CONSTRAINT FK_URUN FOREIGN KEY (COMID) REFERENCES SIRKET(COMPANYID) ON DELETE CASCADE,
    CONSTRAINT URUN_STOCK_CK CHECK (STOCKQUANTITY >= 0)
);

-- SEPET Tablosu
CREATE TABLE SEPET(
    USERID INT,
    STATUS INT DEFAULT 0,
    SEPETID SERIAL PRIMARY KEY,
    SEPETTOTALCOST NUMERIC,
    CONSTRAINT FK_SEPET FOREIGN KEY (USERID) REFERENCES KULLANICI(USERID) ON DELETE CASCADE
);

-- SEPETICINDEKILER Tablosu
CREATE TABLE SEPETICINDEKILER(
    SEPID INT,
    COMID INT,
    PRODUCTNAME VARCHAR(255),
    ADET INT,
    CONSTRAINT PK_ICINDEKILER PRIMARY KEY (COMID, SEPID, PRODUCTNAME),
    CONSTRAINT FK_ICINDEKILER_COM FOREIGN KEY (COMID) REFERENCES SIRKET(COMPANYID) ON DELETE CASCADE,
    CONSTRAINT FK_ICINDEKILER_PRODUCT FOREIGN KEY (COMID, PRODUCTNAME) REFERENCES URUN(COMID, PRODUCTNAME) ON DELETE CASCADE,
    CONSTRAINT FK_ICINDEKILER_SEPID FOREIGN KEY (SEPID) REFERENCES SEPET(SEPETID) ON DELETE CASCADE
);

-- ETKINLIK Tablosu
CREATE TABLE ETKINLIK(
    COMID INT,
    USERID INT,
    ETKINLIKID SERIAL,
    SEASON VARCHAR(255),
    TIMEOFDAY VARCHAR(255),
    TOTALPERSON INT,
    CONSTRAINT PK_ETKINLIK PRIMARY KEY (COMID, USERID, ETKINLIKID),
    CONSTRAINT FK_ETKINLIK_COM FOREIGN KEY (COMID) REFERENCES SIRKET(COMPANYID) ON DELETE CASCADE,
    CONSTRAINT FK_ETKINLIK_USER FOREIGN KEY (USERID) REFERENCES KULLANICI(USERID) ON DELETE CASCADE,
    CONSTRAINT ETKINLIK_PERSON_CHECK CHECK (TOTALPERSON > 0)
);


