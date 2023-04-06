--liquibase formatted sql

--changeset <vchepiha>:<1_create_table_masters.sql>
CREATE TABLE IF NOT EXISTS public.masters
(
    id     bigint       NOT NULL,
    pib   varchar(256) NOT NULL,
    CONSTRAINT masters_pk PRIMARY KEY (id)
    );

--rollback DROP TABLE public.masters;
