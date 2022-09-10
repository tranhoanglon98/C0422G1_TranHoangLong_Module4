CREATE TABLE APP_USER (
    USER_ID BIGINT NOT NULL,
    USER_NAME VARCHAR(36) NOT NULL,
    ENCRYTED_PASSWORD VARCHAR(128) NOT NULL,
    ENABLED BIT NOT NULL
);
 alter table APP_USER add constraint APP_USER_PK primary key (USER_ID);

alter table APP_USER add constraint APP_USER_UK unique (USER_NAME);

CREATE TABLE APP_ROLE (
    ROLE_ID BIGINT NOT NULL,
    ROLE_NAME VARCHAR(30) NOT NULL
); 
alter table APP_ROLE add constraint APP_ROLE_PK primary key (ROLE_ID);

alter table APP_ROLE add constraint APP_ROLE_UK unique (ROLE_NAME);

CREATE TABLE USER_ROLE (
    ID BIGINT NOT NULL,
    USER_ID BIGINT NOT NULL,
    ROLE_ID BIGINT NOT NULL
); 
alter table USER_ROLE add constraint USER_ROLE_PK primary key (ID);

alter table USER_ROLE add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID);

alter table USER_ROLE add constraint USER_ROLE_FK1 foreign key (USER_ID) references APP_USER (USER_ID);

alter table USER_ROLE add constraint USER_ROLE_FK2 foreign key (ROLE_ID) references APP_ROLE (ROLE_ID);

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into app_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');

insert into app_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER');

insert into user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1);

insert into user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2);

insert into user_role (ID, USER_ID, ROLE_ID) values (3, 2, 2);