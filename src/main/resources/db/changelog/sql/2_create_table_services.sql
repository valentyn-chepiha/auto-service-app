--liquibase formatted sql

--changeset <vchepiha>:<2_create_table_services.sql>
CREATE TABLE IF NOT EXISTS public.services
(
    id      bigint       NOT NULL,
    master_id  bigint    NOT NULL,
    cost    real         NOT NULL,
    status_paid  varchar(256)   NOT NULL,
    CONSTRAINT services_pk PRIMARY KEY (id),
    CONSTRAINT fk_master_id FOREIGN KEY (master_id) REFERENCES masters (id)
    );

--rollback DROP TABLE public.services;
