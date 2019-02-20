DROP TABLE IF EXISTS logdate;

create table logdate
(
  id        INT(8)    NOT NULL AUTO_INCREMENT,
  guid      INT(11)   NOT NULL,
  date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status    VARCHAR(25),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#   STATUS    ENUM('created','running','finished') ,







