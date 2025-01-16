INSERT INTO public.event_categories ("name",description,created_at,updated_at,deleted_at) VALUES
	 ('Music','Music event','2024-12-02 17:39:55.128297',NULL,NULL),
	 ('Seminar','Seminar event','2024-12-16 02:01:31.076998',NULL,NULL),
	 ('Sport','Sport Event','2024-12-16 02:01:31.090732',NULL,NULL);

INSERT INTO public.provinces ("name",created_at,updated_at,deleted_at) VALUES
	 ('Jawa Barat','2024-11-29 01:21:15.688019',NULL,NULL),
	 ('Jawa Timur','2024-11-29 20:02:41.994482',NULL,NULL),
	 ('Jawa Tengah','2024-11-29 20:02:41.994482',NULL,NULL),
	 ('Jakarta','2024-12-16 04:02:48.298754',NULL,NULL);

INSERT INTO public.roles ("name",deleted_at,created_at,updated_at) VALUES
	 ('ADMIN',NULL,'2024-12-16 07:37:55.284363+07','2024-12-16 07:37:55.284363+07'),
	 ('USER',NULL,'2024-12-16 07:37:55.301767+07','2024-12-16 07:37:55.301767+07'),
	 ('ORGANIZER',NULL,'2024-12-16 07:37:55.305515+07','2024-12-16 07:37:55.305515+07');

INSERT INTO public.voucher_types (status_name,description,created_at,updated_at,deleted_at) VALUES
	 ('Discount','Voucher that provides a discount on the total amount','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Points','Voucher that can be redeemed for loyalty points','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Cashback','Voucher that offers cashback on purchase','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Gift','Gift voucher for special occasions','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Referral','Voucher awarded for referring a new user','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Holiday','Special holiday voucher with discount','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL);