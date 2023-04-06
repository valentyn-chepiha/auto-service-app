--liquibase formatted sql

--changeset <vchepiha>:<2_create_sequence_services_id>
CREATE SEQUENCE IF NOT EXISTS public.services_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.services_id_seq;
