create sequence hibernate_sequence_car start 1 increment 1;
create sequence hibernate_sequence_place start  1 increment 1;
create sequence hibernate_sequence_timeandprice start  1 increment 1;

create table car (
    id          bigint not null,
    name_car    varchar(255),
    number_car  varchar(255),
    primary key (id)
);

create table place (
    id bigint      not null,
    action         varchar(255),
    number_place   varchar(255),
    primary key (id)
 );
create table timeandprice (
    id              bigint not null,
    price_place     varchar(255),
    time_place      varchar(255),
    car_id          bigint,
    place_id        bigint,
    primary key (id)
);

alter table timeandprice
add constraint car_fk foreign key (car_id) references car;
alter table timeandprice
add constraint place_fk foreign key (place_id) references place;