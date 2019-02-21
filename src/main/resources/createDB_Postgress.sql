DROP TABLE IF EXISTS logdate;

create table logdate
(
  id        serial
    constraint logdate_pk
      primary key,
  guid      int         not null,
  date_time timestamp,
  status    varchar(25) not null
);

create unique index logdate_guid_uindex
  on logdate (guid);









