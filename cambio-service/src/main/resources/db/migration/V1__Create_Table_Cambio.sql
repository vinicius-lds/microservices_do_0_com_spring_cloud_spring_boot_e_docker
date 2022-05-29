CREATE TABLE cambio (
	id uuid NOT NULL,
	from_currency char(3) NOT NULL,
	to_currency char(3) NOT NULL,
	conversion_factor decimal(35, 2) NOT NULL,
	CONSTRAINT pk_cambio PRIMARY KEY (id)
);
