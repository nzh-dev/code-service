CREATE TABLE "public"."code"
(
    id SERIAL,
    name TEXT NOT NULL,
    value TEXT NULL,
    created TIMESTAMP NOT NULL,
    modified TIMESTAMP NULL,
    creator TEXT  NOT NULL,
    modifier TEXT NULL,
    optlock INTEGER DEFAULT 0 NULL
) ;

ALTER TABLE "public"."code" ADD CONSTRAINT code_pk
PRIMARY KEY (id);