\c host_agent


CREATE TABLE PUBLIC.host_info (
    id serial PRIMARY KEY not null,
    hostname varchar not null,
    cpu_number smallint not null,
    cpu_architecture varchar not null,
    cpu_model varchar not null,
    cpu_mhz float(3) not null,
    L2_cache smallint not null,
    total_mem int not null,
    "timestamp" timestamp not null
    );


CREATE TABLE PUBLIC.host_usage (
    "timestamp" timestamp not null,
    host_id  serial REFERENCES host_info (id),
    memory_free smallint not null,
    cpu_idle smallint not null,
    cpu_kernal smallint not null,
    disk_io int not null,
    disk_available int not null
    );


