-- Drop table

-- DROP TABLE public.event_categories;

CREATE TABLE public.event_categories (
	event_category_id serial4 NOT NULL,
	"name" varchar(255) NOT NULL,
	description text NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	CONSTRAINT event_categories_pkey PRIMARY KEY (event_category_id)
);


-- public.provinces definition

-- Drop table

-- DROP TABLE public.provinces;

CREATE TABLE public.provinces (
	province_id serial4 NOT NULL,
	"name" varchar(255) NOT NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	CONSTRAINT provinces_name_key UNIQUE (name),
	CONSTRAINT provinces_pkey PRIMARY KEY (province_id)
);


-- public.roles definition

-- Drop table

-- DROP TABLE public.roles;

CREATE TABLE public.roles (
	role_id int4 DEFAULT nextval('roles_roles_id_seq'::regclass) NOT NULL,
	"name" varchar(255) NOT NULL,
	deleted_at timestamptz NULL,
	created_at timestamptz DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamptz DEFAULT CURRENT_TIMESTAMP NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (role_id)
);


-- public.voucher_types definition

-- Drop table

-- DROP TABLE public.voucher_types;

CREATE TABLE public.voucher_types (
	voucher_type_id serial4 NOT NULL,
	status_name varchar(255) NOT NULL,
	description varchar(255) NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	CONSTRAINT voucher_types_pkey PRIMARY KEY (voucher_type_id)
);


-- public.cities definition

-- Drop table

-- DROP TABLE public.cities;

CREATE TABLE public.cities (
	city_id serial4 NOT NULL,
	"name" varchar(255) NOT NULL,
	province_id int4 NOT NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	CONSTRAINT cities_pkey PRIMARY KEY (city_id),
	CONSTRAINT cities_province_id_fkey FOREIGN KEY (province_id) REFERENCES public.provinces(province_id)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	user_id serial4 NOT NULL,
	full_name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	"password" varchar(255) NOT NULL,
	city_id int4 NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	birthdate timestamp NULL,
	is_organizer bool DEFAULT false NULL,
	referral_code varchar(255) NULL,
	profile_picture varchar(255) NULL,
	referrer_code varchar(255) NULL,
	CONSTRAINT users_email_key UNIQUE (email),
	CONSTRAINT users_pkey PRIMARY KEY (user_id),
	CONSTRAINT users_referral_code_key UNIQUE (referral_code),
	CONSTRAINT users_city_id_fkey FOREIGN KEY (city_id) REFERENCES public.cities(city_id)
);


-- public.event_organizers definition

-- Drop table

-- DROP TABLE public.event_organizers;

CREATE TABLE public.event_organizers (
	event_organizer_id bigserial NOT NULL,
	users_id int8 NOT NULL,
	"name" varchar(255) NOT NULL,
	city_id int8 NULL,
	description text NULL,
	profile_picture_link varchar(255) NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	CONSTRAINT event_organizers_pkey PRIMARY KEY (event_organizer_id),
	CONSTRAINT event_organizers_city_id_fkey FOREIGN KEY (city_id) REFERENCES public.cities(city_id),
	CONSTRAINT event_organizers_users_id_fkey FOREIGN KEY (users_id) REFERENCES public.users(user_id)
);
CREATE INDEX idx_event_organizers_city_id ON public.event_organizers USING btree (city_id);
CREATE INDEX idx_event_organizers_users_id ON public.event_organizers USING btree (users_id);


-- public.events definition

-- Drop table

-- DROP TABLE public.events;

CREATE TABLE public.events (
	event_id serial4 NOT NULL,
	organizer_id int8 NOT NULL,
	"name" varchar(255) NOT NULL,
	description text NOT NULL,
	thumbnail varchar(255) NOT NULL,
	event_category_id int8 NOT NULL,
	city_id int8 NOT NULL,
	location_detail text NOT NULL,
	started_at timestamp NOT NULL,
	ended_at timestamp NOT NULL,
	total_capacity int4 NOT NULL,
	total_available int4 NOT NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	starting_price numeric(10, 2) NULL,
	CONSTRAINT events_pkey PRIMARY KEY (event_id),
	CONSTRAINT events_city_id_fkey FOREIGN KEY (city_id) REFERENCES public.cities(city_id),
	CONSTRAINT events_event_categories_id_fkey FOREIGN KEY (event_category_id) REFERENCES public.event_categories(event_category_id),
	CONSTRAINT events_organizer_id_fkey FOREIGN KEY (organizer_id) REFERENCES public.event_organizers(event_organizer_id)
);


-- public.user_points definition

-- Drop table

-- DROP TABLE public.user_points;

CREATE TABLE public.user_points (
	user_point_id bigserial NOT NULL,
	user_id int8 NOT NULL,
	points numeric NOT NULL,
	used_points numeric NOT NULL,
	expired_at timestamptz NULL,
	created_at timestamptz DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at timestamptz NULL,
	deleted_at timestamptz NULL,
	CONSTRAINT user_points_pkey PRIMARY KEY (user_point_id),
	CONSTRAINT user_points_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id)
);


-- public.user_roles definition

-- Drop table

-- DROP TABLE public.user_roles;

CREATE TABLE public.user_roles (
	user_roles_id serial4 NOT NULL,
	user_id int4 NULL,
	role_id int4 NULL,
	deleted_at timestamptz NULL,
	created_at timestamptz DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamptz DEFAULT CURRENT_TIMESTAMP NULL,
	CONSTRAINT user_roles_pkey PRIMARY KEY (user_roles_id),
	CONSTRAINT user_roles_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.roles(role_id),
	CONSTRAINT user_roles_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id)
);


-- public.vouchers definition

-- Drop table

-- DROP TABLE public.vouchers;

CREATE TABLE public.vouchers (
	voucher_id serial4 NOT NULL,
	code varchar(255) NOT NULL,
	"name" varchar(255) NOT NULL,
	amount numeric NOT NULL,
	description varchar(255) NULL,
	total_capacity int4 NOT NULL,
	total_available int4 NOT NULL,
	voucher_type_id int8 NOT NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	validity_period varchar(255) NULL,
	CONSTRAINT vouchers_amount_check CHECK ((amount >= (0)::numeric)),
	CONSTRAINT vouchers_code_key UNIQUE (code),
	CONSTRAINT vouchers_pkey PRIMARY KEY (voucher_id),
	CONSTRAINT vouchers_total_available_check CHECK ((total_available >= 0)),
	CONSTRAINT vouchers_total_capacity_check CHECK ((total_capacity >= 0)),
	CONSTRAINT vouchers_voucher_type_id_fkey FOREIGN KEY (voucher_type_id) REFERENCES public.voucher_types(voucher_type_id)
);


-- public.event_tickets definition

-- Drop table

-- DROP TABLE public.event_tickets;

CREATE TABLE public.event_tickets (
	event_ticket_id bigserial NOT NULL,
	event_id int8 NOT NULL,
	ticket_name varchar(255) NOT NULL,
	price numeric(10, 2) NOT NULL,
	total_capacity int4 NOT NULL,
	description text NULL,
	started_at timestamptz NOT NULL,
	ended_at timestamptz NOT NULL,
	created_at timestamptz DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamptz NULL,
	deleted_at timestamptz NULL,
	total_available int4 NOT NULL,
	CONSTRAINT tickets_pkey PRIMARY KEY (event_ticket_id),
	CONSTRAINT tickets_price_check CHECK ((price >= 0.0)),
	CONSTRAINT tickets_total_capacity_check CHECK ((total_capacity >= 0)),
	CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES public.events(event_id)
);


-- public.transactions definition

-- Drop table

-- DROP TABLE public.transactions;

CREATE TABLE public.transactions (
	transaction_id bigserial NOT NULL,
	users_id int8 NOT NULL,
	event_ticket_id int8 NOT NULL,
	total_ticket int4 NOT NULL,
	original_amount numeric(10, 2) NOT NULL,
	voucher_deduction numeric(10, 2) NULL,
	points_deduction numeric(10, 2) NULL,
	total_amount numeric(10, 2) NOT NULL,
	created_at timestamptz DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at timestamptz NULL,
	deleted_at timestamptz NULL,
	invoice_number varchar(255) NOT NULL,
	CONSTRAINT transactions_invoice_number_key UNIQUE (invoice_number),
	CONSTRAINT transactions_pkey PRIMARY KEY (transaction_id),
	CONSTRAINT fk_event_ticket FOREIGN KEY (event_ticket_id) REFERENCES public.event_tickets(event_ticket_id),
	CONSTRAINT fk_user FOREIGN KEY (users_id) REFERENCES public.users(user_id)
);


-- public.user_tickets definition

-- Drop table

-- DROP TABLE public.user_tickets;

CREATE TABLE public.user_tickets (
	user_ticket_id bigserial NOT NULL,
	user_id int8 NOT NULL,
	event_ticket_id int8 NOT NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	total_ticket int4 NOT NULL,
	CONSTRAINT user_tickets_pkey PRIMARY KEY (user_ticket_id),
	CONSTRAINT fk_event_ticket FOREIGN KEY (event_ticket_id) REFERENCES public.event_tickets(event_ticket_id),
	CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES public.users(user_id)
);


-- public.user_vouchers definition

-- Drop table

-- DROP TABLE public.user_vouchers;

CREATE TABLE public.user_vouchers (
	user_voucher_id bigserial NOT NULL,
	user_id int8 NOT NULL,
	voucher_id int8 NOT NULL,
	expired_at timestamptz NULL,
	used_at timestamptz NULL,
	created_at timestamptz DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at timestamptz NULL,
	deleted_at timestamptz NULL,
	CONSTRAINT user_vouchers_pkey PRIMARY KEY (user_voucher_id),
	CONSTRAINT user_vouchers_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id),
	CONSTRAINT user_vouchers_voucher_id_fkey FOREIGN KEY (voucher_id) REFERENCES public.vouchers(voucher_id)
);


-- public.event_feedbacks definition

-- Drop table

-- DROP TABLE public.event_feedbacks;

CREATE TABLE public.event_feedbacks (
	event_feedback_id serial4 NOT NULL,
	event_ticket_id int8 NOT NULL,
	user_id int8 NOT NULL,
	feedback varchar(1000) NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	CONSTRAINT event_feedbacks_pkey PRIMARY KEY (event_feedback_id),
	CONSTRAINT event_feedbacks_event_ticket_id_fkey FOREIGN KEY (event_ticket_id) REFERENCES public.event_tickets(event_ticket_id),
	CONSTRAINT event_feedbacks_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id)
);


-- public.event_reviews definitioncity

-- Drop table

-- DROP TABLE public.event_reviews;

CREATE TABLE public.event_reviews (
	event_review_id serial4 NOT NULL,
	event_ticket_id int4 NOT NULL,
	user_id int4 NOT NULL,
	rating int4 NOT NULL,
	description text NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	CONSTRAINT event_reviews_pkey PRIMARY KEY (event_review_id),
	CONSTRAINT event_reviews_rating_check CHECK (((rating >= 1) AND (rating <= 5))),
	CONSTRAINT event_reviews_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id),
	CONSTRAINT fk_event_ticket_id FOREIGN KEY (event_ticket_id) REFERENCES public.event_tickets(event_ticket_id)
);