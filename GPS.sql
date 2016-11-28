/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     28/11/2016 21:56:02                          */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_CARRO_EXISTE_MODELO') then
    alter table CARRO
       delete foreign key FK_CARRO_EXISTE_MODELO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CARRO_TEM_MARCA') then
    alter table CARRO
       delete foreign key FK_CARRO_TEM_MARCA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MODELO_POSSUI_MOTOR') then
    alter table MODELO
       delete foreign key FK_MODELO_POSSUI_MOTOR
end if;

drop index if exists CARRO.EXISTE_FK;

drop index if exists CARRO.TEM_FK;

drop index if exists CARRO.CARRO_PK;

drop table if exists CARRO;

drop index if exists MARCA.MARCA_PK;

drop table if exists MARCA;

drop index if exists MODELO.POSSUI_FK;

drop index if exists MODELO.MODELO_PK;

drop table if exists MODELO;

drop index if exists MOTOR.MOTOR_PK;

drop table if exists MOTOR;

/*==============================================================*/
/* Table: CARRO                                                 */
/*==============================================================*/
create table CARRO 
(
   ID_CARRO             integer                        not null,
   ID_MODELO            numeric(8)                     not null,
   ID_MARCA             numeric(8)                     not null,
   ANO                  numeric(8)                     null,
   constraint PK_CARRO primary key (ID_CARRO)
);

/*==============================================================*/
/* Index: CARRO_PK                                              */
/*==============================================================*/
create unique index CARRO_PK on CARRO (
ID_CARRO ASC
);

/*==============================================================*/
/* Index: TEM_FK                                                */
/*==============================================================*/
create index TEM_FK on CARRO (
ID_MARCA ASC
);

/*==============================================================*/
/* Index: EXISTE_FK                                             */
/*==============================================================*/
create index EXISTE_FK on CARRO (
ID_MODELO ASC
);

/*==============================================================*/
/* Table: MARCA                                                 */
/*==============================================================*/
create table MARCA 
(
   ID_MARCA             numeric(8)                     not null,
   NOME                 char(256)                      null,
   constraint PK_MARCA primary key (ID_MARCA)
);

/*==============================================================*/
/* Index: MARCA_PK                                              */
/*==============================================================*/
create unique index MARCA_PK on MARCA (
ID_MARCA ASC
);

/*==============================================================*/
/* Table: MODELO                                                */
/*==============================================================*/
create table MODELO 
(
   ID_MODELO            numeric(8)                     not null,
   ID_MOTOR             numeric(8)                     not null,
   VERSAO               char(256)                      null,
   N_PORTAS             numeric(8)                     null,
   COMBUSTIVEL          char(256)                      null,
   constraint PK_MODELO primary key (ID_MODELO)
);

/*==============================================================*/
/* Index: MODELO_PK                                             */
/*==============================================================*/
create unique index MODELO_PK on MODELO (
ID_MODELO ASC
);

/*==============================================================*/
/* Index: POSSUI_FK                                             */
/*==============================================================*/
create index POSSUI_FK on MODELO (
ID_MOTOR ASC
);

/*==============================================================*/
/* Table: MOTOR                                                 */
/*==============================================================*/
create table MOTOR 
(
   ID_MOTOR             numeric(8)                     not null,
   NOME                 char(256)                      null,
   ACELERACAO           char(256)                      null,
   CO2                  char(256)                      null,
   constraint PK_MOTOR primary key (ID_MOTOR)
);

/*==============================================================*/
/* Index: MOTOR_PK                                              */
/*==============================================================*/
create unique index MOTOR_PK on MOTOR (
ID_MOTOR ASC
);

alter table CARRO
   add constraint FK_CARRO_EXISTE_MODELO foreign key (ID_MODELO)
      references MODELO (ID_MODELO)
      on update restrict
      on delete restrict;

alter table CARRO
   add constraint FK_CARRO_TEM_MARCA foreign key (ID_MARCA)
      references MARCA (ID_MARCA)
      on update restrict
      on delete restrict;

alter table MODELO
   add constraint FK_MODELO_POSSUI_MOTOR foreign key (ID_MOTOR)
      references MOTOR (ID_MOTOR)
      on update restrict
      on delete restrict;

