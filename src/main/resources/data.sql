insert into CATEGORY (id, category_name) values (1, '가죽공예');
insert into CATEGORY (id, category_name) values (2, '목공');
insert into CATEGORY (id, category_name) values (3, '베이킹');
insert into CATEGORY (id, category_name) values (4, '도자기');
insert into CATEGORY (id, category_name) values (5, '향초');
insert into CATEGORY (id, category_name) values (6, '향수');
insert into CATEGORY (id, category_name) values (7, '기타');

insert into PRODUCT (name, price, remaining, is_discounted, discounted_price, category_id, created_at, modified_at) values ('상품1', 10000, 10, false, 10000, 1 , now(), now());

--insert into SITE_USER (name, email, password) values ('seil', 'seil@seil.com', '1311');
--insert into PRODUCT_IMAGE (image_url) values ('https://storage.cloud.google.com/my-atelier-project-images/product-images/node-js.svg');