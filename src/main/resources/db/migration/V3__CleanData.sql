-- Truncate all tables
TRUNCATE TABLE public.cities RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.event_categories RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.event_feedbacks RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.event_organizers RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.event_reviews RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.event_tickets RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.events RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.provinces RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.roles RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.transactions RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.user_points RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.user_roles RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.user_tickets RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.user_vouchers RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.users RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.voucher_types RESTART IDENTITY CASCADE;
TRUNCATE TABLE public.vouchers RESTART IDENTITY CASCADE;

-- Reset sequences
ALTER SEQUENCE public.cities_city_id_seq RESTART WITH 1;
ALTER SEQUENCE public.event_categories_event_category_id_seq RESTART WITH 1;
ALTER SEQUENCE public.event_feedbacks_event_feedback_id_seq RESTART WITH 1;
ALTER SEQUENCE public.event_organizers_event_organizer_id_seq RESTART WITH 1;
ALTER SEQUENCE public.event_reviews_event_review_id_seq RESTART WITH 1;
ALTER SEQUENCE public.event_tickets_event_ticket_id_seq RESTART WITH 1;
ALTER SEQUENCE public.events_event_id_seq RESTART WITH 1;
ALTER SEQUENCE public.provinces_province_id_seq RESTART WITH 1;
ALTER SEQUENCE public.roles_roles_id_seq RESTART WITH 1;
ALTER SEQUENCE public.transactions_transaction_id_seq RESTART WITH 1;
ALTER SEQUENCE public.user_points_user_point_id_seq RESTART WITH 1;
ALTER SEQUENCE public.user_roles_user_roles_id_seq RESTART WITH 1;
ALTER SEQUENCE public.user_tickets_user_ticket_id_seq RESTART WITH 1;
ALTER SEQUENCE public.user_vouchers_user_voucher_id_seq RESTART WITH 1;
ALTER SEQUENCE public.users_user_id_seq RESTART WITH 1;
ALTER SEQUENCE public.voucher_types_voucher_type_id_seq RESTART WITH 1;
ALTER SEQUENCE public.vouchers_voucher_id_seq RESTART WITH 1;
