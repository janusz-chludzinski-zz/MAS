INSERT INTO users (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PHONE_NUMBER, AUTHORITY, ENABLED)
VALUES ('Janusz', 'Chludzinski', 'chludzinski.janusz@gmail.com', 'db45f572a2601e0706f9dd4a333f5926', '515229090', 'ROLE_ADMIN', 1);

INSERT INTO authorities (AUTHORITY)
VALUES ('ROLE_ADMIN');

INSERT INTO mechanics (ID, EMAIL, FIRST_NAME, LAST_NAME, PHONE, SALARY)
VALUES (1, 'adam@abacki.pl', 'Adam', 'Abacki',  '11223344', '5000');

INSERT INTO mechanics (ID, EMAIL, FIRST_NAME, LAST_NAME, PHONE, SALARY)
VALUES (2, 'bartosz@bartacki.pl', 'Bartosz', 'Bartacki', '22334455', '1000');

INSERT INTO mechanics (ID, EMAIL, FIRST_NAME, LAST_NAME, PHONE, SALARY)
VALUES (3, 'cezary@nowacki.pl','Cezary', 'Nowacki',  '33445566', '8000');

INSERT INTO services (NAME, COST)
VALUES ('Hamulce', 100);

INSERT INTO services (NAME, COST)
VALUES ('Elektryka', 200);

INSERT INTO services (NAME, COST)
VALUES ('Blacharka', 300);

INSERT INTO services (NAME, COST)
VALUES ('Silnik', 400);

INSERT INTO services (NAME, COST)
VALUES ('Płyny', 500);