--liquibase formatted sql

--changeset <vchepiha>:<1_create_details_id_sequence>
CREATE SEQUENCE IF NOT EXISTS public.details_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.details_id_seq;
