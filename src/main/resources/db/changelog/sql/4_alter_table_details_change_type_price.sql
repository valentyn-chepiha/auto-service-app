--liquibase formatted sql

--changeset <vchepiha>:<4_alter_table_details_change_type_price.sql>
ALTER TABLE public.details ALTER COLUMN price SET DATA TYPE numeric(19, 2);

--rollback ALTER TABLE public.details ALTER COLUMN price SET DATA TYPE real;
