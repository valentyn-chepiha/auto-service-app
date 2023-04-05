--liquibase formatted sql

--changeset <vchepiha>:<3_create_sequence_orders_id.sql>
CREATE SEQUENCE IF NOT EXISTS public.orders_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.orders_id_seq;
