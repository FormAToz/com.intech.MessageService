CREATE TABLE public.purchase
(
  id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
action character varying(32) COLLATE pg_catalog."default",
msisdn integer NOT NULL,
"timestamp" timestamp with time zone,
CONSTRAINT purchase_pkey PRIMARY KEY (id)
);

CREATE TABLE public.subscription
(
  id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
action character varying(32) COLLATE pg_catalog."default",
msisdn integer NOT NULL,
"timestamp" timestamp with time zone,
CONSTRAINT subscription_pkey PRIMARY KEY (id)
);