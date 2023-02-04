--user_accounts

INSERT INTO user_accounts (last_name, first_name, middle_name, username, password) VALUES('Ramos', 'Hektor', 'Attaway', 'HARamos', 'Mickeymouse12#');

INSERT INTO user_accounts (last_name, first_name, middle_name, username, password) VALUES('Dela Cruz', 'John', 'Doe', 'JDDelaCruz', 'DonlandDuck09*');

--inventory

INSERT INTO inventory(item_code, item_type_id, quantity, date_added, added_by) VALUES('GS0014', 1, 100, '01-16-2023', 1);
INSERT INTO inventory(item_code, item_type_id, quantity, date_added, added_by) VALUES('BN0003', 2, 110, '01-17-2023', 2);
INSERT INTO inventory(item_code, item_type_id, quantity, date_added, added_by) VALUES('FF0001', 3, 120, '01-15-2023', 1);
INSERT INTO inventory(item_code, item_type_id, quantity, date_added, added_by) VALUES('CC0002', 4, 130, '01-14-2023', 2);
INSERT INTO inventory(item_code, item_type_id, quantity, date_added, added_by) VALUES('EL0023', 5, 140, '01-13-2023', 1);
INSERT INTO inventory(item_code, item_type_id, quantity, date_added, added_by) VALUES('OT0003', 6, 150, '01-12-2023', 1);


--items

INSERT INTO items(item_code, item_type_id, item_name, unit_cost,markup, unit_price) VALUES('GS0014', 1, 'O-Seal(t-drive)M3', 30.00, 7.50, 37.50);
INSERT INTO items(item_code, item_type_id, item_name, unit_cost,markup, unit_price) VALUES('BN0003', 2, 'Bolt - 6x20 F/G', 32.00, 8.00, 40.00);
INSERT INTO items(item_code, item_type_id, item_name, unit_cost,markup, unit_price) VALUES('FF0001', 3, 'NS 200 Oil Filter', 50.00, 12.50, 62.50);
INSERT INTO items(item_code, item_type_id, item_name, unit_cost,markup, unit_price) VALUES('CC0002', 4, 'Extreme D-Rust', 85.00, 21.25, 106.25);
INSERT INTO items(item_code, item_type_id, item_name, unit_cost,markup, unit_price) VALUES('EL0023', 5, 'P.Light Blue', 90.00, 22.50, 112.50);
INSERT INTO items(item_code, item_type_id, item_name, unit_cost,markup, unit_price) VALUES('OT0003', 6, 'Paint-Samurai(Silver)', 120.00, 30.00, 150.00);

--item_type

INSERT INTO item_type(item_type_name) VALUES('Gasket_And_Sealant');

INSERT INTO item_type(item_type_name) VALUES('Bolt_And_Nut');

INSERT INTO item_type(item_type_name) VALUES('Filter');

INSERT INTO item_type(item_type_name) VALUES('Cleaner');

INSERT INTO item_type(item_type_name) VALUES('Electrical');

INSERT INTO item_type(item_type_name) VALUES('Others');



