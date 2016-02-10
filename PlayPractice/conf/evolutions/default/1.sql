# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table dbaccess_model (
  id                        integer not null,
  column_one                varchar(10),
  constraint pk_dbaccess_model primary key (id))
;

create sequence dbaccess_model_seq;




# --- !Downs

drop table if exists dbaccess_model cascade;

drop sequence if exists dbaccess_model_seq;

