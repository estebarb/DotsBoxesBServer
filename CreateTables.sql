
--DROP TABLE "Usuarios" cascade constraints;
CREATE TABLE "Usuarios"
(
  id bigserial NOT NULL PRIMARY KEY,
  email character varying(255),
  nombre character varying(255),
  passwordhash character varying(255),
  ranking integer
);
CREATE INDEX "mail_idx" on "Usuarios" (lower(email));
CREATE INDEX "nombre_idx" on "Usuarios" (lower(nombre));
CREATE INDEX "ranking_idx" on "Usuarios" (ranking);
ALTER TABLE "Usuarios"
  OWNER TO proyecto;
--                       ---------------------------------
--DROP TABLE "Equipos" cascade constraints;
create table "Equipos"
(
    id bigserial not null primary key,
    Nombre character varying(255),
    ranking integer
);
create index on "Equipos" (lower(Nombre));
create index on "Equipos" (ranking);
ALTER TABLE "Equipos"
  OWNER TO proyecto;

--DROP TABLE "MiembrosEquipo" cascade constraints;
create table "MiembrosEquipo"
(
    id bigserial not null primary key,
    jugador bigint,
    CONSTRAINT "jugador_con" FOREIGN KEY (jugador)
      REFERENCES "Usuarios" (id) MATCH SIMPLE,
    equipo bigint,
    CONSTRAINT "equipo_con" FOREIGN KEY (equipo)
      REFERENCES "Equipos" (id) MATCH SIMPLE
);
ALTER TABLE "MiembrosEquipo"
  OWNER TO proyecto;


--------------------------------------------

CREATE TABLE "JugadoresPC"
(
  id bigserial NOT NULL PRIMARY KEY,
  nombre character varying(255),
  descripcion character varying(255),
  ranking integer
);
ALTER TABLE "JugadoresPC"
  OWNER TO proyecto;

--------------------------------------------
--DROP TABLE "Juegos" cascade constraints;
CREATE TABLE "Juegos" (
    id bigserial NOT NULL PRIMARY KEY,
    isTerminado boolean,
    ganador bigint,
    turnoActual int,
    fecha timestamp,
    torneo bigint --opcional
);
ALTER TABLE "Juegos"
  OWNER TO proyecto;

--DROP TABLE "JugadoresJuego" cascade constraints;
CREATE TABLE "JugadoresJuego"
(
  id bigserial NOT NULL primary key,
  juego bigint,
  jugador bigint,
  puntaje integer
);
ALTER TABLE "JugadoresJuego"
  OWNER TO proyecto;


-------------------------------------------
--DROP TABLE "Pendientes" cascade constraints;
CREATE TABLE "Pendientes"
(
  id bigserial NOT NULL PRIMARY KEY,
  jugador bigint,
  juego bigint
);
--create index on "Pendientes" (Jugador);
ALTER TABLE "Pendientes"
  OWNER TO proyecto;



-------------------------

--DROP TABLE "Ganadores" cascade constraints;
Create TABLE "Ganadores"
(
    id bigserial not null primary key,
    juego bigint    
);
ALTER TABLE "Ganadores"
  OWNER TO proyecto;

--------------------------------------------
create table "Jugadores"
(
    id bigserial not null primary key,
    type int,
    usuario bigint,
    equipo bigint,
    ganador bigint,
    jugadorpc bigint   
);
alter table "Jugadores"
    owner to proyecto;



-----------------------------------------------
create table "ParticipantesTorneo"
(
    id bigserial NOT NULL PRIMARY KEY,
    jugador bigint,
    torneo bigint
);
ALTER TABLE "ParticipantesTorneo"
  OWNER TO proyecto;

CREATE TABLE "Torneos"
(
  id bigserial not null primary key,
  administrador bigint,
  tipotorneo int,
  numParticipantes int,
  nombretorneo character varying NOT NULL
);
ALTER TABLE "Torneos"
  OWNER TO proyecto;


-- Agrega las constraints --


-- Jugadores --
alter table "Jugadores" add CONSTRAINT "usuario_con" FOREIGN KEY (usuario)
        references "Usuarios"(id) MATCH SIMPLE;
alter table "Jugadores" add CONSTRAINT "equipo_con" FOREIGN KEY (equipo)
        references "Equipos"(id) MATCH SIMPLE;
alter table "Jugadores" add CONSTRAINT "ganador_con" FOREIGN KEY (ganador)
        references "Ganadores"(id) MATCH SIMPLE;
alter table "Jugadores" add CONSTRAINT "jugadorpc_con" FOREIGN KEY (jugadorpc)
        references "JugadoresPC"(id) MATCH SIMPLE;

-- Participantes torneo --
alter table "ParticipantesTorneo" add CONSTRAINT jugador_fk foreign key (jugador)
        references "Jugadores"(id) MATCH SIMPLE;
alter table "ParticipantesTorneo" add CONSTRAINT torneo_fk foreign key (torneo)
        references "Torneos"(id) MATCH SIMPLE;

-- Torneo --
alter table "Torneos" add CONSTRAINT torneo_admin_fkey FOREIGN KEY (administrador)
      REFERENCES "Usuarios" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

-- Ganadores --
alter table "Ganadores" add CONSTRAINT "juego_con" FOREIGN KEY (juego)
        references "Juegos"(id) MATCH SIMPLE;

-- Pendientes --
alter table "Pendientes" add CONSTRAINT "jugador_fk" FOREIGN KEY (jugador)
      REFERENCES "Usuarios" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
alter table "Pendientes" add CONSTRAINT "juego_fk" FOREIGN KEY (juego)
      REFERENCES "Juegos" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

-- Juegos --
alter table "Juegos" add CONSTRAINT "ganador_fkey" FOREIGN KEY (ganador)
      REFERENCES "Jugadores" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

-- JugadoresJuego --
alter table "JugadoresJuego" add   CONSTRAINT "JugadoresJuego_juego_fkey" FOREIGN KEY (juego)
      REFERENCES "Juegos" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
alter table "JugadoresJuego" add CONSTRAINT "JugadoresJuego_jugadores_fkey" FOREIGN KEY (jugador)
      REFERENCES "Jugadores" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;