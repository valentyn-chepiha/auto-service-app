--liquibase formatted sql

--changeset <vchepiha>:<2_create_table_owners.sql>
CREATE TABLE IF NOT EXISTS public.owners
(
    id      bigint       NOT NULL,
    name    varchar(256) NOT NULL,
    CONSTRAINT owners_pk PRIMARY KEY (id)
    );

--rollback DROP TABLE public.owners;
