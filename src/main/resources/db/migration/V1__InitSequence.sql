-- DROP SCHEMA public;

-- V1__Create_schema.sql
--CREATE SCHEMA IF NOT EXISTS public AUTHORIZATION "postgres.vzhudxwwpgmwegrypynd";

-- DROP SEQUENCE public.cities_city_id_seq;

CREATE SEQUENCE public.cities_city_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.event_categories_event_category_id_seq;

CREATE SEQUENCE public.event_categories_event_category_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.event_feedbacks_event_feedback_id_seq;

CREATE SEQUENCE public.event_feedbacks_event_feedback_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.event_organizers_event_organizer_id_seq;

CREATE SEQUENCE public.event_organizers_event_organizer_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.event_reviews_event_review_id_seq;

CREATE SEQUENCE public.event_reviews_event_review_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.event_tickets_event_ticket_id_seq;

CREATE SEQUENCE public.event_tickets_event_ticket_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.events_event_id_seq;

CREATE SEQUENCE public.events_event_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.provinces_province_id_seq;

CREATE SEQUENCE public.provinces_province_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.roles_roles_id_seq;

CREATE SEQUENCE public.roles_roles_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.transactions_transaction_id_seq;

CREATE SEQUENCE public.transactions_transaction_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.user_points_user_point_id_seq;

CREATE SEQUENCE public.user_points_user_point_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.user_roles_user_roles_id_seq;

CREATE SEQUENCE public.user_roles_user_roles_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.user_tickets_user_ticket_id_seq;

CREATE SEQUENCE public.user_tickets_user_ticket_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.user_vouchers_user_voucher_id_seq;

CREATE SEQUENCE public.user_vouchers_user_voucher_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.users_user_id_seq;

CREATE SEQUENCE public.users_user_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.voucher_types_voucher_type_id_seq;

CREATE SEQUENCE public.voucher_types_voucher_type_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.vouchers_voucher_id_seq;

CREATE SEQUENCE public.vouchers_voucher_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;-- public.event_categories definition
