--liquibase formatted sql

--changeset <vchepiha>:<2_create_sequence_owners_id>
CREATE SEQUENCE IF NOT EXISTS public.owners_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.owners_id_seq;
