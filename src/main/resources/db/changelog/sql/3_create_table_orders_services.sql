--liquibase formatted sql

--changeset <vchepiha>:<3_create_table_orders_services.sql>
CREATE TABLE IF NOT EXISTS public.orders_services
(
    order_id   bigint   NOT NULL,
    service_id  bigint   NOT NULL,
    CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk_service_id FOREIGN KEY (service_id) REFERENCES services (id)
    );

--rollback DROP TABLE public.orders_services;
