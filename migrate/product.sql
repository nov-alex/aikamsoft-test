CREATE TABLE IF NOT EXISTS products (
  id SERIAL PRIMARY KEY,
  product_name varchar(100) NOT NULL,
  product_price decimal NOT NULL
);

INSERT INTO products (product_name,product_price) VALUES 
  ( 'Минеральная вода', 30),
  ( 'Виноград', 100),
  ( 'Хлеб', 40),
  ( 'Молоко', 70.50),
  ( 'Кефир', 69.50),
  ( 'Чай', 80),
  ( 'Печенье', 41);