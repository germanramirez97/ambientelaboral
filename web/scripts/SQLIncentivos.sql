/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  German
 * Created: 28/05/2020
 */

-- Table: public.incentivo

-- DROP TABLE public.incentivo;

CREATE TABLE public.incentivo
(
    id numeric NOT NULL,
    nombre text COLLATE pg_catalog."default",
    fecha date,
    fechafinal date,
    CONSTRAINT incentivo_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.incentivo
    OWNER to postgres;