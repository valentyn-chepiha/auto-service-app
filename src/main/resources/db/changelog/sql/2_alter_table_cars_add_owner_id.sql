--liquibase formatted sql

--changeset <vchepiha>:<2_alter_table_cars_add_owner_id.sql>
ALTER TABLE public.cars ADD COLUMN owner_id bigint;

--rollback ALTER TABLE public.cars DROP COLUMN owner_id;
