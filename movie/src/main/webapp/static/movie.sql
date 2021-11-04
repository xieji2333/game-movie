CREATE DATABASE IF NOT EXISTS movie;

CREATE TABLE IF NOT EXISTS t_user(
	`id` INT PRIMARY KEY auto_increment,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL
	
);

INSERT INTO t_user VALUES(1,'admin','admin');

create table if not exists game (
   `id`   int primary key auto_increment,
   `name` varchar(50),
   `tag`  varchar(100),
   `year` varchar(100),
   `info` text,
   `src`  varchar(50)
);
insert into game values(null,'Dead by Daylight','This is a horrible game',
                        'static/dummy/dead-by-daylight.jpg','horror,survival',2016);

insert into game values(null,'Far Cry 6','Classic Ubisoft game',
                        'static/dummy/far-cry6.jpg','open world,co-op,action',2021);

insert into game values(null,'Eurapa Universalis IV','Master the art of war',
                        'static/dummy/europa.jpg','historical,military',2013);

insert into game values(null,'Ghost Runner','Run and kill',
                        'static/dummy/ghost-runner.jpg','action,cyberpunk',2020);

insert into game values(null,'Surviving Mars','Are you ready? Mars is waiting for you',
                        'static/dummy/mars.jpg','survival,strategy',2018);

insert into game values(null,'Watch Dogs','Chicago hacker',
                        'static/dummy/watch-dogs.jpg','open world,action',2014);

insert into game values(null,'Forza Horizon 4','Explore beautiful and historic Britain in you car',
                        'static/dummy/horizon.jpg','open world,racing',2021);

insert into game values(null,'Just Cause 4','Explode everything you can see',
                        'static/dummy/just-cause.jpg','open world,action,destruction',2018);