--liquibase formatted sql

--changeset <vchepiha>:<5_alter_table_orders_services_rename_column_operations_id.sql>
ALTER TABLE public.orders_operations RENAME COLUMN service_id TO operation_id;

--rollback ALTER TABLE public.orders_operations RENAME COLUMN operation_id TO service_id;
