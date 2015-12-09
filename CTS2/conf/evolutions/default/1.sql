# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tools (
  id                        bigserial not null,
  name                      varchar(255),
  description               varchar(255),
  owner                     varchar(255),
  category                  varchar(255),
  comment                   varchar(255),
  toollist                  varchar(255),
  constraint pk_tools primary key (id))
;

create table toolcategory (
  cid                       bigserial not null,
  cname                     varchar(255),
  constraint pk_toolcategory primary key (cid))
;

create table users (
  id                        bigserial not null,
  username                  varchar(255),
  password_hash             varchar(255),
  firstname                 varchar(255),
  lastname                  varchar(255),
  address                   varchar(255),
  email                     varchar(255),
  phone                     varchar(255),
  constraint uq_users_username unique (username),
  constraint pk_users primary key (id))
;




# --- !Downs

drop table if exists tools cascade;

drop table if exists toolcategory cascade;

drop table if exists users cascade;

