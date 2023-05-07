--liquibase formatted sql

--changeset <vchepiha>:<5_alter_table_orders_services_rename_foreign_key_fk_operation_id.sql>
ALTER TABLE public.orders_operations RENAME CONSTRAINT fk_service_id TO fk_operation_id;

--rollback ALTER TABLE public.orders_operations RENAME CONSTRAINT fk_operation_id TO fk_service_id;
