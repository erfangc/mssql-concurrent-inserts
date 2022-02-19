create table ids
(
    id varchar(36) primary key not null
)

create table transactions
(
    asset char(10)    not null,
    qty   numeric,
    ex_id varchar(36) not null
)

create table positions
(
    asset char(10) not null,
    qty   numeric
)
