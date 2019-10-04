FROM postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB dev
COPY ./database/src/main/resources/nzh/db/schema/init_db.sql /docker-entrypoint-initdb.d/