DROP TABLE IF EXISTS logdate;
create table logdate
(
  guid      integer     not null
    constraint logdate_pk
      primary key,
  date_time timestamp   not null,
  status    varchar(25) not null
);

create unique index logdate_guid_uindex
  on logdate (guid);







