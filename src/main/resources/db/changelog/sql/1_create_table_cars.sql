--liquibase formatted sql

--changeset <vchepiha>:<1_create_table_cars.sql>
CREATE TABLE IF NOT EXISTS public.cars
(
    id         bigint       NOT NULL,
    brand   varchar(256) NOT NULL,
    model   varchar(256) NOT NULL,
    year       integer,
    car_number varchar(256) NOT NULL,
    CONSTRAINT cars_pk PRIMARY KEY (id)
    );

--rollback DROP TABLE public.cars;
