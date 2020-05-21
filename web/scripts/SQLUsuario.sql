/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Eduardo
 * Created: 14/05/2020
 */
CREATE UNLOGGED TABLE public.usuario
(
    usuario text COLLATE pg_catalog."default",
    contra text COLLATE pg_catalog."default",
    nombre text COLLATE pg_catalog."default",
    apellido text COLLATE pg_catalog."default",
    cedula numeric,
    nivel numeric
    
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;