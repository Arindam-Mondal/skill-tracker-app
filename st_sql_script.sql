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
