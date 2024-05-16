--Not: '?' işareti olan sorgularda prestatement olacak


--1)Arayüzden en az birer tane insert, update ve delete işlemi gerçekleştirilebilmelidir.
--Prestatement kullanılacak
Insert Into sepeticindekiler (sepid, comid, productname, adet) values (?,?,?,?);
Delete From sepeticindekiler where comid = ? and productname = ? and sepetid = ?;
Update sepeticindekiler set adet = ? where comid = ? and productname = ? and sepetid = ?;

Insert Into etkinlik (comid, userid, etkinlikid, season, timeofday, totalperson) values (?,?,?,?,?,?);

--2)Arayüzden girilecek bir değere göre ekrana sonuçların listelendiği bir sorgu yazmalısınız.

--2.1) KUllanıcının isteklerine göre şirketleri listeleyen fonksiyon
create type sirket_type as (comid int, comname varchar(255), priceperperson numeric, offerCount int);

Create or replace function list_sirket(ser_type varchar(255), total_person int, season varchar(255),timeofday varchar(255), sirket_location varchar(255))
Returns sirket_type[] As $$
Declare
	sirkets sirket_type[];
	cur_sirkets cursor for (select companyid, companyname, priceperperson, offercount from sirket s, pricing p
						   where s.companyid = p.comid and ser_type = s.servicetype and list_sirket.season = p.season
						   and total_person between s.minimumguest and s.maximumguest and list_sirket.timeofday = p.timeofday
							intersect
							select companyid, companyname, priceperperson, offercount from sirket s, pricing p
						   where adress like sirket_location and s.companyid = p.comid
							);
	i int default  1;
Begin
	for sirket in cur_sirkets loop
		sirkets[i] = sirket;
		i = i + 1;
	End loop;
	Return sirkets;
End;
$$ LAnguage 'plpgsql';

Select list_sirket('Düğün', 150, 'Yaz', 'İstanbul');

--2.2)Kullanıcının isteklerine listeleyen fonksiyon
create type urun_record as (productname varchar(255), productprice numeric, comID int, stockQuantity int);

Create or replace function list_urun(pro_name varchar(255), pro_adet int)
returns urun_record[] AS $$
Declare
	uruns urun_record[];
	i int default 1;
	cur_uruns cursor for (Select productname, productprice, comID, stockquantity
						 from urun
						 where pro_name = productname and pro_adet <= stockQuantity);

Begin
	for urun in cur_uruns loop
		uruns[i] = urun;
		i = i + 1;
	end loop;
	Return uruns;
End;
$$ Language 'plpgsql';



--4) Sequence yazılması gerek en az 1 tane
--userid_seq
CREATE SEQUENCE USERID_SEQ START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

--5) Union, intersect ya da except kullanın. 
--2.1 maddesinde bu şey karşılıyor.

--6)
--6.1)Kullanıcı geçmiş siparişlerini döndüren sorgu

Select sepetid, totalCost
From sepet, kullanici
group by sepetid
having status = 1 and sepetid = ?;

--6.2)Kullanıcı geçmiş organizasyonlarını sorgula
Select eventid, companyName, season, totalperson
From etkinlik e, company
where comid = companyid and comid = ? and e.userid = ?;

--7)Yaz usta yaz. Trigger bizden sorulur. Nettt

--7.1)
Create trigger buy_urun
Before Update
on sepet
for each row execute procedure trig_fonk_buy_urun();

Create or replace function trig_fonk_buy_urun()
Returns Trigger As $$
Declare
	cur_sepet_uruns cursor for (Select u.comid, u.productname, adet, stockquantity from sepeticindekiler s, urun u
							  where sepid = new.sepetid and u.productname = s.productname and s.comid = u.comid);
Begin
	for urun in cur_sepet_uruns loop
		if(urun.adet > urun.stockquantity) then
			Return old;
		End if;
	end loop;
	
	Update sepet Set status = 1 where sepetid = new.sepetid;
	
	for i in cur_sepet_uruns loop
		update urun set stockquantity = stockquantity - i.adet where comid = i.comid and productname = i.productname;
	end loop;
	Return new;
End;
$$ Language 'plpgsql';


--7.2)
Create trigger remove_product
After Update
on sepet
for each row execute procedure trig_fonk_remove_procduct();

Create or replace function trig_fonk_remove_procduct()
Returns Trigger As $$
Declare
	comid int;
	productname varchar(255);
	cur_cont_uruns cursor for (select comid, productname, stockquantity from sepet s, sepeticindekiler si
						 where s.sepetid = si.sepid and sepetid = new.sepetid);
Begin
	for stock in cur_cont_uruns loop
		if(stock.stockquantity = 0) then
			Delete from urun where comid = stock.comid and productname = stock.productname;
		End if;
	End loop;
End;
$$ Language 'plpgsql';

--7.3)
Create Trigger offer_count
After Insert
on etkinlik
for each row execute procedure trig_fonk_incrementOfferCount();

Create Or Replace function trig_fonk_incrementOfferCount()
Returns Trigger As $$
Begin
	Update sirket Set offercount = offercount + 1 where new.comid = companyid;
	return New;
End;
$$ Language 'plpsql';

--7.4)
Create Trigger user_sepet
After Insert
on kullanici
for each row execute procedure trig_fonk_create_user_sepet();

Create or  Replace Function trig_fonk_create_user_sepet()
returns trigger AS $$
Begin
	Insert INto sepet (userid, status, sepettotalcost) Values (new.userid, 0,0);
	Return new;
End;
$$ Language 'plpgsql';

--8)
Create or replace function totalPriceEvent(cID int, seas varchar(255), timeday varchar(255), total int)
Returns numeric AS $$
Declare
	pricePerPerson numeric;
Begin	
	Select priceperperson into pricePerPerson
	from  sirket, pricing
	where cID = companyid and timeday = timeofday and seas = season;
	
	return total * pricePerPerson;
end;
$$ language 'plpgsql';


--Sonradan eklenen sorgular

Select *
From sirket s, urun u
where u.comid = s.companyid And u.productname = ?;

Select *
From sepet s
where s.userid = ? and s.status = 0;

--Görüntüleme fonksiyonlarını yazılacak javada.
--Sepetteki ürünler view olacak
--Etkinlikler view olacak
--geçmiş sepetler view olacak
--View

Create View user_uruns 
As
Select sepetid, comid, productname,adet
from sepeticindekiler
where sepetid = ?;

Select * from user_uruns;


Create View urun_toplam
As
Select si.sepid, si.comid, si.productname, si.adet * u.productprice
From sepetinicindekiler si, sepet s, urun u
group by si.sepid, si.comid, si.productname
having(s.sepetid = si.sepid and u.comid = si.comid and u.productname = si.productname)

