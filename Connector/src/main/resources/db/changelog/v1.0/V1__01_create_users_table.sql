create table Users (
    ID bigint primary key generated by default as identity,
    NAME varchar(50),
    EMAIL varchar(100)
);

alter table public.users replica identity full;