--liquibase formatted sql

--changeset <vchepiha>:<4_alter_table_services_change_type_cost.sql>
ALTER TABLE public.services ALTER COLUMN cost SET DATA TYPE numeric(19, 2);

--rollback ALTER TABLE public.services ALTER COLUMN cost SET DATA TYPE real;
