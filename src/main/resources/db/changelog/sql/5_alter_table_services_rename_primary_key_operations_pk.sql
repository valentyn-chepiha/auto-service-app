--liquibase formatted sql

--changeset <vchepiha>:<5_alter_table_services_rename_sequence_operations_id_seq.sql>
ALTER TABLE public.operations RENAME CONSTRAINT services_pk TO operations_pk;

--rollback ALTER TABLE public.operations RENAME CONSTRAINT operations_pk TO services_pk;
