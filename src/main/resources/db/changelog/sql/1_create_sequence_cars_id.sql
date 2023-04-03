--liquibase formatted sql

--changeset <vchepiha>:<1_create_sequence_cars_id>
CREATE SEQUENCE IF NOT EXISTS public.cars_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.cars_id_seq;
