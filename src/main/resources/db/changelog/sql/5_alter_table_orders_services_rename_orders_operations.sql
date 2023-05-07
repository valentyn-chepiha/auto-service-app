--liquibase formatted sql

--changeset <vchepiha>:<5_alter_table_orders_services_rename_orders_operations.sql>
ALTER TABLE public.orders_services RENAME TO orders_operations;

--rollback ALTER TABLE public.orders_operations RENAME TO orders_services;
