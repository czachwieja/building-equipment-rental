INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');

INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('Flir E8 to mobilna, prosta w obsludze, wytrzymala i ultra uniwersalna kamera termowizyjna. Przeznaczona jest do zastosowania w budownictwie, energetyce i przemysle', 'Kamera termowizyjna Flir E8 WiFi', 200, '../images/e8-wifi.png');
INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('Urzadzenie do wykonywania pomiarow certyfikacyjnych sieci LAN kat. 6, 6A', 'Miernik certyfikacyjny sieci LAN VIAVI Certifier 40G', 300, '../images/viavi-certifier-40g.png');
INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('Wytrzymała, prosta w obsłudze i posiadająca najszybszy na świecie cykl spawania z wygrzewaniem osłonek spawow.', 'Spawarka światłowodowa Fujikura 70S+', 10000, '../images/70S-case.png');
INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('Kompaktowy reflektometr VIAVI SmartOTDR 1310/1550/1625nm z filtrem do pomiaru aktywnych sieci FTTx,  dynamika 40/40/41dB', 'Kompaktowy reflektometr VIAVI SmartOTDR 1310/1550/1625nm z filtrem do pomiaru aktywnych sieci FTTx', 10000, '../images/viavi_smartotdr.jpg');
INSERT INTO rental.equipment (description, name, price, path_to_image) VALUES ('SONEL MPI-540 to wielokfuncyjny miernik parametrów elektrycznych pozwalający na pomiar wszystkich parametrów ochrony przeciwporażeniowej', 'Miernik parametrów elektrycznych SONEL MPI-540', 10000, '../images/mpi540.jpg');

INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-11', 1);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-13', 2);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-15', 3);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-16', 1);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-17', 2);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-18', 3);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-19', 1);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-20', 2);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-21', 3);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-22', 1);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-23', 2);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-24', 3);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-15', 1);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-26', 2);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-27', 3);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-01-31', 3);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-02-21', 1);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-02-22', 1);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-02-23', 1);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-02-24', 2);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-02-25', 2);
INSERT INTO rental.rentals (rental_date, equipment_id) VALUES ('2020-02-26', 2);