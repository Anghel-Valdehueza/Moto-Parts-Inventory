DROP TABLE IF EXISTS user_accounts;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS item_type;

CREATE TABLE user_accounts(id INTEGER NOT NULL AUTO_INCREMENT, last_name CHAR(50) NOT NULL, first_name CHAR(50) NOT NULL, middle_name CHAR(50), username VARCHAR(50) NOT NULL, password VARCHAR(100) NOT NULL, PRIMARY KEY(id));

CREATE TABLE inventory(item_code VARCHAR(50) NOT NULL, item_type_id VARCHAR(100) NOT NULL, quantity INTEGER NOT NULL, date_added VARCHAR(100) NOT NULL, added_by INTEGER NOT NULL, PRIMARY KEY(item_code), FOREIGN KEY(added_by) REFERENCES user_accounts(id));

CREATE TABLE items(item_code VARCHAR(50) NOT NULL, item_type_id INTEGER NOT NULL, item_name VARCHAR(100) NOT NULL, unit_cost DOUBLE NOT NULL, markup DOUBLE NOT NULL, unit_price DOUBLE NOT NULL, UNIQUE(item_type_id), PRIMARY KEY(item_code), FOREIGN KEY(item_code) REFERENCES inventory(item_code));

CREATE TABLE item_type(item_type_id INTEGER NOT NULL AUTO_INCREMENT, item_type_name ENUM('Gasket_And_Sealant', 'Bolt_And_Nut', 'Filter', 'Cleaner', 'Electrical', 'Others'), PRIMARY KEY(item_type_id), FOREIGN KEY(item_type_id) REFERENCES items(item_type_id));

