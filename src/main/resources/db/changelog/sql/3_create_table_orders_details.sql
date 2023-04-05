--liquibase formatted sql

--changeset <vchepiha>:<3_create_table_orders_details.sql>
CREATE TABLE IF NOT EXISTS public.orders_details
(
    order_id   bigint   NOT NULL,
    detail_id  bigint   NOT NULL,
    CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk_detail_id FOREIGN KEY (detail_id) REFERENCES details (id)
    );

--rollback DROP TABLE public.orders_details;
