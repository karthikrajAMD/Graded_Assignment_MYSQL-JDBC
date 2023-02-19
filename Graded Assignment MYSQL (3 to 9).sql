use gradedassignment_mysql;

/* 3) Display the total number of customers based on gender who have placed individual orders of worth at least Rs.3000. */

select o1.CUS_GENDER,count(*) as 'Total number of customers'  from customer as o1
inner join `order` as o2 on o1.CUS_ID = o2.CUS_ID where o2.ORD_AMOUNT>=3000 group by o1.CUS_GENDER;

/* 4) Display all the orders along with product name ordered by a customer having Customer_Id=2.   */
 
select `order`.ord_id,`order`.ord_amount,`order`.ord_date,`order`.cus_id, product.PRO_NAME from `order` 
inner join customer on `order`.cus_id=customer.cus_id
inner join supplier_pricing on `order`.PRICING_ID=supplier_pricing.PRICING_ID
inner join supplier on supplier.SUPP_ID=supplier_pricing.SUPP_ID
inner join product on supplier_pricing.PRO_ID=product.PRO_ID
where `order`.CUS_ID=2;
 
/* 5) Display the Supplier details who can supply more than one product. */

select s.supp_name, count(p.pro_name) as Product_Count from supplier s inner join supplier_pricing sp on s.supp_id=sp.supp_id
inner join product p on p.pro_id=sp.pro_id group by s.supp_name having count(p.PRO_NAME)>1;

/* 6) Create a view as lowest_expensive_product and display the least expensive product from each
 category and print the table with category id, name, product name and price of the product. */
 
 drop view lowest_expensive_product;
 
create view lowest_expensive_product
as
select ct.cat_id as "category Id", ct.cat_name as "category name", p.pro_name as "product name", sp.supp_price as "Price" from category ct
inner join product p on ct.CAT_ID=p.CAT_ID
inner join supplier_pricing sp on sp.PRO_ID=p.PRO_ID;
 
select * from lowest_expensive_product; 

/* 7) Display the Id and Name of the Product ordered after “2021-10-05”.*/
  
  select pro_id, Pro_name from product where pro_id in
  (select pro_id from supplier_pricing where pricing_id in 
  (select pricing_id from `order` where ord_date > "2021-10-05"));
  
/* 8) Display customer name and gender whose names start or end with character 'A'.*/

select cus_name ,cus_gender from customer where cus_name like 'A%' or cus_name like '%a' ;

/* 9) Create a stored procedure to display supplier id, name, Rating
(Average rating of all the products sold by every customer) and Type_of_Service. 
For Type_of_Service, If rating =5, print “Excellent Service”,If rating >4 print “Good Service”, If rating >2 print
“Average Service” else print “Poor Service”. Note that there should be one rating per supplier.*/

delimiter $$
create procedure ques_9()
begin 
select  pricing_id as Id, avg(rating.RAT_RATSTARS) as rating, case 
when avg(rating.RAT_RATSTARS)=5 then 'Excellent Service'
when avg(rating.RAT_RATSTARS)>4 then 'Good Service'
when avg(rating.RAT_RATSTARS)>2 then 'Average Service'
else 'Poor Service' end as Type_of_Service from `order` 
inner join rating where `order`.ord_id=rating.ord_id group by `order`.pricing_id;
end $$
 
call ques_9();
drop procedure ques_9;




 