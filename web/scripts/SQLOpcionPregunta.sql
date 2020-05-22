/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Eduardo
 * Created: 22/05/2020
 */

CREATE TABLE public.opcionespreguntas
(
    opcionunica text COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.opcionespreguntas
    OWNER to postgres;