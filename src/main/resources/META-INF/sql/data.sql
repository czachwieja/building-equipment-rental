INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_USER');

INSERT INTO rental.users (enabled, password, username) VALUES (1, '$2a$10$xSN6PmHRoQtpW3CgsAP5u.oVAao.pTS3Wta/e1epUJO8o6H/g1noi', 'admin');
INSERT INTO rental.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO rental.users (enabled, password, username) VALUES (1, '$2a$10$nJY6BTFM.RJ2YCQI.c3c6.PVeuCJ71qQrPmCDEB5zWPEcgBAPnM/y', 'user');
INSERT INTO rental.user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('Flir E8 to mobilna, prosta w obsłudze, wytrzymała i ultra uniwersalna kamera termowizyjna. Przeznaczona jest do zastosowania w budownictwie, energetyce i przemyśle', 'Kamera termowizyjna Flir E8 WiFi', 200, '../images/e8-wifi.png');
INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('Urządzenie do wykonywania pomiarów certyfikacyjnych sieci LAN kat. 6, 6A', 'Miernik certyfikacyjny sieci LAN VIAVI Certifier 40G', 300, '../images/viavi-certifier-40g.png');
INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('Wytrzymała, prosta w obsłudze i posiadająca najszybszy na świecie cykl spawania z wygrzewaniem osłonek spawów.', 'Spawarka światłowodowa Fujikura 70S+', 10000, '../images/70S-case.png');
INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('Kompaktowy reflektometr VIAVI SmartOTDR 1310/1550/1625nm z filtrem do pomiaru aktywnych sieci FTTx,  dynamika 40/40/41dB', 'Kompaktowy reflektometr VIAVI SmartOTDR 1310/1550/1625nm z filtrem do pomiaru aktywnych sieci FTTx', 10000, '../images/viavi_smartotdr.jpg');
INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('SONEL MPI-540 to wielofunkcyjny miernik parametrów elektrycznych pozwalający na pomiar wszystkich parametrów ochrony przeciwporażeniowej', 'Miernik parametrów elektrycznych SONEL MPI-540', 10000, '../images/mpi540.jpg');

INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-11', 1, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-11', 1, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-13', 2, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-15', 3, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-16', 1, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-17', 2, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-18', 3, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-19', 1, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-20', 2, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-21', 3, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-22', 1, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-23', 2, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-24', 3, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-15', 1, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-26', 2, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-27', 3, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-01-31', 3, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-02-21', 1, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-02-22', 1, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-02-23', 1, 2);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-02-24', 2, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-02-25', 2, 1);
INSERT INTO rental.rentals (rental_date, equipment_id, user_id) VALUES ('2020-02-26', 2, 1);