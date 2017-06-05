DELETE FROM customer;
DELETE FROM account;
DELETE FROM account_addresses;
DELETE FROM address;

INSERT INTO account VALUES (111, 'account_test', 9999);

INSERT INTO address VALUES (222, 0,'Street Name', 'City Name', 'ST', 999999);

INSERT INTO account_addresses VALUES (111, 222);

INSERT INTO customer VALUES (333, 'First Name', 'Last Name', 'mail@domain.com', @account_id)