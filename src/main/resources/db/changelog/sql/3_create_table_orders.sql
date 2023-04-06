--liquibase formatted sql

--changeset <vchepiha>:<3_create_table_orders.sql>
CREATE TABLE IF NOT EXISTS public.orders
(
    id      bigint       NOT NULL,
    car_id  bigint    NOT NULL,
    description   varchar(256)   NOT NULL,
    date_start  date   NOT NULL,
    status_paid  varchar(256)   NOT NULL,
    total  real   NOT NULL,
    date_end date,
    owner_id bigint NOT NULL,
    CONSTRAINT orders_pk PRIMARY KEY (id),
    CONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES cars (id),
    CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES owners (id)
    );

--rollback DROP TABLE public.orders;
