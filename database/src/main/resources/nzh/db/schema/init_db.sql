CREATE SEQUENCE "public"."code_id_seq" INCREMENT BY 1 START WITH 10000;

CREATE TABLE "public"."code"
(
    id INTEGER DEFAULT nextval('code_id_seq'::regclass) NOT NULL,
    code_id TEXT NOT NULL,
    code_text TEXT NOT NULL,
    value_id TEXT NOT NULL,
    value_text TEXT NOT NULL,
    created TIMESTAMP NOT NULL,
    modified TIMESTAMP NULL,
    creator TEXT  NOT NULL,
    modifier TEXT NULL,
    optlock INTEGER DEFAULT 0 NULL
);

ALTER TABLE "public"."code" ADD CONSTRAINT code_pk PRIMARY KEY(id);

ALTER TABLE "public"."code"
    ADD CONSTRAINT code_value_id_idx UNIQUE (value_id);

CREATE SEQUENCE "public"."code_relation_id_seq" INCREMENT BY 1 START WITH 10000;

CREATE TABLE "public"."code_relation"
(
    id INTEGER DEFAULT nextval('code_relation_id_seq'::regclass) NOT NULL,
    parent_value_id TEXT NOT NULL,
    child_value_id TEXT NOT NULL,
    created TIMESTAMP NOT NULL,
    creator TEXT  NOT NULL,
    modified TIMESTAMP NULL,
    optlock INTEGER DEFAULT 0 NULL
);

ALTER TABLE "public"."code_relation" ADD CONSTRAINT code_relation_pk
    PRIMARY KEY (id);

ALTER TABLE "public"."code_relation" ADD CONSTRAINT code_relation_parent_value_id_fk
	FOREIGN KEY (parent_value_id) REFERENCES "public"."code" (value_id)
  ON UPDATE NO ACTION ON DELETE CASCADE;

ALTER TABLE "public"."code_relation" ADD CONSTRAINT code_relation_child_value_id_fk
	FOREIGN KEY (child_value_id) REFERENCES "public"."code" (value_id)
  ON UPDATE NO ACTION ON DELETE CASCADE;

/* Insert code data to database */
COPY "public"."code" FROM '/opt/code_continent.csv' CSV HEADER;
COPY "public"."code" FROM '/opt/code_country.csv' CSV HEADER;
COPY "public"."code_relation" FROM '/opt/code_relation.csv' CSV HEADER;
