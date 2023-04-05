--liquibase formatted sql

--changeset <vchepiha>:<3_alter_table_services_add_fk_order_id.sql>
ALTER TABLE services ADD CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES orders (id);

--rollback ALTER TABLE services DROP CONSTRAINT fk_order_id;
