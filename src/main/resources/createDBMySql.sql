DROP TABLE IF EXISTS logdate;

create table logdate
(
  guid      int primary key,
  date_time timestamp default CURRENT_TIMESTAMP not null,
  status    varchar(25)                         not null,
  constraint logdate_guid_uindex
    unique (guid)
);

--    STATUS    ENUM('created','running','finished') ,







