INSERT INTO book
	(id, author, launch_date, price, title)
VALUES
	(public.uuid_generate_v4(), 'Michael C. Feathers', '2017-11-29 13:50:05.878000', 8.57, 'Working effectively with legacy code'),
	(public.uuid_generate_v4(), 'Ralph Johnson, Erich Gamma, John Vlissides e Richard Helm', '2017-11-29 15:15:13.636000', 7.87, 'Design Patterns'),
	(public.uuid_generate_v4(), 'Robert C. Martin', '2009-01-10 00:00:00.000000', 13.46, 'Clean Code'),
	(public.uuid_generate_v4(), 'Crockford', '2017-11-07 15:09:01.674000', 11.71, 'JavaScript'),
	(public.uuid_generate_v4(), 'Steve McConnell', '2017-11-07 15:09:01.674000', 10.14, 'Code complete'),
	(public.uuid_generate_v4(), 'Martin Fowler e Kent Beck', '2017-11-07 15:09:01.674000', 15.38, 'Refactoring'),
	(public.uuid_generate_v4(), 'Eric Freeman, Elisabeth Freeman, Kathy Sierra, Bert Bates', '2017-11-07 15:09:01.674000', 19.23, 'Head First Design Patterns'),
	(public.uuid_generate_v4(), 'Eric Evans', '2017-11-07 15:09:01.674000', 16.09, 'Domain Driven Design'),
	(public.uuid_generate_v4(), 'Brian Goetz e Tim Peierls', '2017-11-07 15:09:01.674000', 13.99, 'Java Concurrency in Practice'),
	(public.uuid_generate_v4(), 'Susan Cain', '2017-11-07 15:09:01.674000', 21.51, 'O poder dos quietos'),
	(public.uuid_generate_v4(), 'Roger S. Pressman', '2017-11-07 15:09:01.674000', 9.79, 'Engenharia de Software: uma abordagem profissional'),
	(public.uuid_generate_v4(), 'Viktor Mayer-Schonberger e Kenneth Kukier', '2017-11-07 15:09:01.674000', 9.44, 'Big Data: como extrair volume, variedade, velocidade e valor da avalanche de informação cotidiana'),
	(public.uuid_generate_v4(), 'Richard Hunter e George Westerman', '2017-11-07 15:09:01.674000', 16.61, 'O verdadeiro valor de TI'),
	(public.uuid_generate_v4(), 'Marc J. Schiller', '2017-11-07 15:09:01.674000', 7.87, 'Os 11 segredos de líderes de TI altamente influentes'),
	(public.uuid_generate_v4(), 'Aguinaldo Aragon Fernandes e Vladimir Ferraz de Abreu', '2017-11-07 15:09:01.674000', 9.44, 'Implantando a governança de TI');
