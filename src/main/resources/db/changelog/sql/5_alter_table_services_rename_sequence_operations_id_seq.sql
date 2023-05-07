--liquibase formatted sql

--changeset <vchepiha>:<5_alter_table_services_rename_sequence_operations_id_seq.sql>
ALTER SEQUENCE public.services_id_seq RENAME TO operations_id_seq;

--rollback ALTER SEQUENCE public.operations_id_seq RENAME TO services_id_seq;
