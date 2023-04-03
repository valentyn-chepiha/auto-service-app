--liquibase formatted sql

--changeset <vchepiha>:<2_alter_table_cars_add_fk_owner_id.sql>
ALTER TABLE cars ADD CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES owners (id);

--rollback ALTER TABLE cars DROP CONSTRAINT cars_fk_owner_id;
