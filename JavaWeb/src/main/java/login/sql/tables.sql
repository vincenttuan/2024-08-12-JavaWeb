/*
+------------+------------------+----------+----------------+
| product_id | product_name     | price    | stock_quantity |
+------------+------------------+----------+----------------+
| 1          | PC               | 30000.00 | 50             |
| 2          | Mobile           | 15000.00 | 100            |
| 3          | MusicBox         | 3000.00  | 200            |
| 4          | Pad              | 20000.00 | 75             |
| 5          | Watch            | 8000.00  | 150            |
+------------+------------------+----------+----------------+
*/
-- 創建商品表
create table if not exists product (
	product_id int primary key auto_increment comment '商品Id',
	product_name varchar(50) not null unique comment '商品名稱',
	price decimal(10, 2) not null comment '商品價格',
	stock_quantity int not null default 0 comment '商品庫存'
); 
-- 新增商品紀錄
insert into product(product_name, price, stock_quantity) values('PC', 30000.00, 50);
insert into product(product_name, price, stock_quantity) values('Mobile', 15000.00, 100);
insert into product(product_name, price, stock_quantity) values('MusicBox', 3000.00, 200);
insert into product(product_name, price, stock_quantity) values('Pad', 20000.00, 75);
insert into product(product_name, price, stock_quantity) values('Watch', 8000.00, 150);

+----------+-------------+------------+--------------+--------------+
| order_id | customer_id | order_date | total_amount | order_status |
+----------+-------------+------------+--------------+--------------+
| 1        | 1           | 2024-09-19 | 33000.00     | Finished     |
| 2        | 2           | 2024-09-20 | 15000.00     | Pending      |
| 3        | 3           | 2024-09-21 | 23000.00     | Finished     |
| 4        | 4           | 2024-09-22 | 8000.00      | Pending      |
| 5        | 5           | 2024-09-23 | 18000.00     | Cancel       |
+----------+-------------+------------+--------------+--------------+

-- 建立訂單檔
CREATE TABLE IF NOT EXISTS `sales_order` (
  `order_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '訂單唯一標識符',
  `customer_id` INT NOT NULL COMMENT '客戶唯一標識符',
  `order_date` datetime NOT NULL DEFAULT current_timestamp COMMENT '訂單創建日期',
  `total_amount` DECIMAL(10, 2) NOT NULL COMMENT '訂單總金額',
  `order_status` ENUM('Pending', 'Finished', 'Cancel') NOT NULL DEFAULT 'Pending' COMMENT '訂單狀態'
) COMMENT '存儲銷售訂單主要信息的表格';

-- 建立訂單資料
INSERT INTO `sales_order` (`customer_id`, `order_date`, `total_amount`, `order_status`) VALUES
(1, '2024-09-19', 33000.00, 'Finished'),
(2, '2024-09-20', 15000.00, 'Pending'),
(3, '2024-09-21', 23000.00, 'Finished'),
(4, '2024-09-22', 8000.00, 'Pending'),
(5, '2024-09-23', 18000.00, 'Cancel');

+---------+----------+------------+----------+------------+
| item_id | order_id | product_id | quantity | unit_price |
+---------+----------+------------+----------+------------+
| 1       | 1        | 1          | 1        | 30000.00   |
| 2       | 1        | 3          | 1        | 3000.00    |
| 3       | 2        | 2          | 1        | 15000.00   |
| 4       | 3        | 4          | 1        | 20000.00   |
| 5       | 3        | 3          | 1        | 3000.00    |
| 6       | 4        | 5          | 1        | 8000.00    |
| 7       | 5        | 2          | 1        | 15000.00   |
| 8       | 5        | 3          | 1        | 3000.00    |
+---------+----------+------------+----------+------------+

-- 創建訂單項目表
CREATE TABLE IF NOT EXISTS `order_item` (
  `item_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '訂單項目唯一標識符',
  `order_id` INT NOT NULL COMMENT '關聯的訂單ID',
  `product_id` INT NOT NULL COMMENT '關聯的商品ID',
  `quantity` INT NOT NULL COMMENT '購買數量',
  `unit_price` DECIMAL(10, 2) NOT NULL COMMENT '商品單價',
  
  
) COMMENT '存儲訂單項目詳情的表格';