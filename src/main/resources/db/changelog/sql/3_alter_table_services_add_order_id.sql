--liquibase formatted sql

--changeset <vchepiha>:<3_alter_table_services_add_order_id.sql>
ALTER TABLE public.services ADD COLUMN order_id bigint;

--rollback ALTER TABLE public.services DROP COLUMN order_id;
