drop table if exists Bills;

create table Bills(
Bill_ID INT AUTO_INCREMENT PRIMARY KEY,
Biller_Name VARCHAR(200),
Total_Bill_Amount INT,
Paid BOOLEAN
);