--liquibase formatted sql

--changeset <vchepiha>:<4_alter_table_orders_change_type_total.sql>
ALTER TABLE public.orders ALTER COLUMN total SET DATA TYPE numeric(19, 2);

--rollback ALTER TABLE public.orders ALTER COLUMN total SET DATA TYPE real;
