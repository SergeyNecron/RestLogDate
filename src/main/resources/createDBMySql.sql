DROP TABLE IF EXISTS logdate;

create table logdate
(
  id        int(8) auto_increment
    primary key,
  guid      int                                 not null,
  date_time timestamp default CURRENT_TIMESTAMP not null,
  status    varchar(25)                         not null,
  constraint logdate_guid_uindex
    unique (guid)
);

#   STATUS    ENUM('created','running','finished') ,







