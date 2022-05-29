-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO cambio
	(id, from_currency, to_currency, conversion_factor)
VALUES
	(public.uuid_generate_v4(), 'USD', 'BRL', 5.73),
	(public.uuid_generate_v4(), 'USD', 'EUR', 0.84),
	(public.uuid_generate_v4(), 'USD', 'GBP', 0.73),
	(public.uuid_generate_v4(), 'USD', 'ARS', 92.56),
	(public.uuid_generate_v4(), 'USD', 'CLP', 713.30),
	(public.uuid_generate_v4(), 'USD', 'COP', 3665.00),
	(public.uuid_generate_v4(), 'USD', 'MXN', 20.15);
