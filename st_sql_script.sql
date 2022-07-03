CREATE TABLE IF NOT EXISTS ST_USER (
    id int auto_increment,
    name varchar(255) not null,
    email varchar(255),
    mobile varchar(10),
    is_admin boolean not null default false,
    password varchar(255),
    primary key (id)
) ;


CREATE TABLE IF NOT EXISTS ST_SKILL (
    id int auto_increment,
    name varchar(255) not null,
    is_technical boolean not null default false,
    primary key (id)
) ;

CREATE TABLE IF NOT EXISTS ST_USER_SKILL (
    id int auto_increment,
    user_id int,
    skill_id int,
    rating int,
    primary key (id),
    CONSTRAINT fk_user
    FOREIGN KEY (user_id) 
    REFERENCES ST_USER(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
	CONSTRAINT fk_skill
    FOREIGN KEY (skill_id) 
    REFERENCES ST_SKILL(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ;

----Insert Script

insert into st_skill(name,is_technical) values("HTML-CSS-JAVASCRIPT",true);
insert into st_skill(name,is_technical) values("ANGULAR",true);
insert into st_skill(name,is_technical) values("REACT",true);
insert into st_skill(name,is_technical) values("SPRING",true);
insert into st_skill(name,is_technical) values("RESTFUL",true);
insert into st_skill(name,is_technical) values("HIBERNATE",true);
insert into st_skill(name,is_technical) values("GIT",true);
insert into st_skill(name,is_technical) values("DOCKER",true);
insert into st_skill(name,is_technical) values("JENKINS",true);
insert into st_skill(name,is_technical) values("AWS",true);

insert into st_skill(name,is_technical) values("SPOKEN",false);
insert into st_skill(name,is_technical) values("COMMUNICATION",false);
insert into st_skill(name,is_technical) values("APTITUDE",false);

----

insert into st_user_skill(user_id,skill_id,rating) values(2,1,9);
insert into st_user_skill(user_id,skill_id,rating) values(2,2,6);
insert into st_user_skill(user_id,skill_id,rating) values(2,3,9);
insert into st_user_skill(user_id,skill_id,rating) values(2,4,8);
insert into st_user_skill(user_id,skill_id,rating) values(2,5,6);
insert into st_user_skill(user_id,skill_id,rating) values(2,6,9);
insert into st_user_skill(user_id,skill_id,rating) values(2,7,8);
insert into st_user_skill(user_id,skill_id,rating) values(2,8,7);
insert into st_user_skill(user_id,skill_id,rating) values(2,9,6);
insert into st_user_skill(user_id,skill_id,rating) values(2,10,9);

insert into st_user_skill(user_id,skill_id,rating) values(2,11,7);
insert into st_user_skill(user_id,skill_id,rating) values(2,12,8);
insert into st_user_skill(user_id,skill_id,rating) values(2,13,7);

----

ALTER TABLE st_user
ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
