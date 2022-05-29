CREATE TABLE book (
	id uuid NOT NULL,
	author VARCHAR(180) NOT NULL,
	launch_date DATE NOT NULL,
	price DECIMAL(35, 2) NOT NULL,
	title VARCHAR(250) NOT NULL,
	CONSTRAINT pk_cambio PRIMARY KEY (id)
);

