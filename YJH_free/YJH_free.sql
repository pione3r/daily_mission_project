CREATE TABLE member_free (
	id VARCHAR(20),
	passwd VARCHAR(20),
	username VARCHAR(20),
	mobile VARCHAR(20),
    email VARCHAR(20),
    primary key(id)
);

CREATE TABLE mission_free (
	mission_id INT auto_increment,
	id VARCHAR(20),
	missionname VARCHAR(20),
	goal VARCHAR(20),
	reward VARCHAR(20),
    primary key(mission_id)
);

alter table mission_free add foreign key(id) references member_free(id) on delete cascade;

set SQL_SAFE_UPDATES = 0;
DELETE FROM mission_free;
DELETE FROM member_free;
set SQL_SAFE_UPDATES = 1;