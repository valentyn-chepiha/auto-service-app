--liquibase formatted sql

--changeset <vchepiha>:<1_create_table_details.sql>
CREATE TABLE IF NOT EXISTS public.details
(
    id     bigint       NOT NULL,
    name   varchar(256) NOT NULL,
    price  real NOT NULL,
    CONSTRAINT details_pk PRIMARY KEY (id)
    );

--rollback DROP TABLE public.details;
