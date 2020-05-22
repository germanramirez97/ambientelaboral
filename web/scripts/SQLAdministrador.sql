/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Eduardo
 * Created: 14/05/2020
 */

CREATE TABLE public.administrador
(
    usuarioadm text COLLATE pg_catalog."default",
    contraadm text COLLATE pg_catalog."default",
    nombreadm text COLLATE pg_catalog."default",
    apellidoadm text COLLATE pg_catalog."default",
    cedula numeric NOT NULL,
    CONSTRAINT "Administrador_pkey" PRIMARY KEY (cedula)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.administrador
    OWNER to postgres;