--liquibase formatted sql

--changeset <vchepiha>:<5_alter_table_services_rename_operations.sql>
ALTER TABLE public.services RENAME TO operations;

--rollback ALTER TABLE public.operations RENAME TO services;
