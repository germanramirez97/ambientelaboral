/* 
 * Author:  Eduardo
 * Created: 22/05/2020
 */
CREATE TABLE public.pregunta
(
    textopregunta text COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pregunta
    OWNER to postgres;