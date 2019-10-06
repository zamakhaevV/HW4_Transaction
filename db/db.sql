-- Database: sberbank

-- DROP DATABASE sberbank;

-- DROP TABLE devices;
-- DROP TABLE users;

CREATE DATABASE sberbank
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE sberbank
    IS 'database for homewroks';

CREATE TABLE IF NOT EXISTS users (
    user_id serial PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    age integer NOT NULL
);

CREATE TABLE IF NOT EXISTS devices (
    device_id serial PRIMARY KEY,
    type VARCHAR (50) NOT NULL,
    model VARCHAR (50) NOT NULL,
    user_id serial REFERENCES users(user_id)
);

INSERT INTO users(name, age) VALUES ('John', 24);
INSERT INTO users(name, age) VALUES ('Nick', 45);

INSERT INTO devices(type, model, user_id) VALUES ('Laptop', 'Asus', 1);
INSERT INTO devices(type, model, user_id) VALUES ('Laptop', 'Dell', 2);
INSERT INTO devices(type, model, user_id) VALUES ('Phone', 'Xiaomi', 1);
INSERT INTO devices(type, model, user_id) VALUES ('Phone', 'Apple', 2);