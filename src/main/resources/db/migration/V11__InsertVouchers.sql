INSERT INTO public.voucher_types (status_name,description,created_at,updated_at,deleted_at) VALUES
	 ('Discount','Voucher that provides a discount on the total amount','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Points','Voucher that can be redeemed for loyalty points','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Cashback','Voucher that offers cashback on purchase','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Gift','Gift voucher for special occasions','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Referral','Voucher awarded for referring a new user','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL),
	 ('Holiday','Special holiday voucher with discount','2024-12-08 16:44:08.489671','2024-12-08 16:44:08.489671',NULL);


INSERT INTO public.vouchers (code,"name",amount,description,total_capacity,total_available,voucher_type_id,created_at,updated_at,deleted_at,validity_period) VALUES
	 ('CHRP2FZ','Chrismast Discount',20.00,'50% discount for the Chrismast Holiday',100,89,1,'2024-12-14 06:30:37.931482','2025-01-12 07:49:10.089198',NULL,'P30D'),
	 ('NEWMK31','New Year Discount',20.00,'50% discount for the New Year Holiday',100,99,1,'2024-12-16 01:04:42.831292','2025-01-12 08:16:28.903374',NULL,'P30D');
