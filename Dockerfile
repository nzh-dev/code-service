FROM postgres:11
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB dev
COPY ./database/src/main/resources/nzh/db/schema/init_db.sql /docker-entrypoint-initdb.d/
COPY ./database/src/main/resources/nzh/db/data/code_continent.csv /opt/
COPY ./database/src/main/resources/nzh/db/data/code_country.csv /opt/
COPY ./database/src/main/resources/nzh/db/data/code_relation.csv /opt/
