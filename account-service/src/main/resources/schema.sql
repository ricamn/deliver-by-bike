DROP TABLE account IF EXISTS
CREATE TABLE account (id BIGINT PRIMARY KEY NOT NULL, account_number VARCHAR(15), user_id BIGINT)

DROP TABLE account_addresses IF EXISTS
CREATE TABLE account_addresses (account_id BIGINT NOT NULL, addresses_id BIGINT NOT NULL, PRIMARY KEY (account_id, addresses_id))

DROP TABLE address IF EXISTS
CREATE TABLE address (id BIGINT NOT NULL, address_type integer, street VARCHAR(100), city VARCHAR(50), state VARCHAR(2), zip_code integer, PRIMARY KEY (id))

DROP TABLE customer IF EXISTS
CREATE TABLE customer (id BIGINT NOT NULL, first_name VARCHAR(50), last_name VARCHAR(50), email VARCHAR(50), account_id BIGINT, PRIMARY KEY (id))

alter table account_addresses add constraint UK_r2ahplt2rqwvx1pnd5bbo7o70 unique (addresses_id)
alter table account_addresses add constraint FK2lksxt4h2eauvgp1duv9gkh4u foreign key (addresses_id) references address
alter table account_addresses add constraint FKk29q8n02ecu2edpjd40ge1xdy foreign key (account_id) references account
alter table customer add constraint FKn9x2k8svpxj3r328iy1rpur83 foreign key (account_id) references account