DROP TABLE IF EXISTS bill;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS guest;
DROP TABLE IF EXISTS user;

SELECT * FROM user;
SELECT * FROM guest;
SELECT * FROM room;
SELECT * FROM reservation;
SELECT * FROM bill;


CREATE TABLE user (
                      userId VARCHAR(10) NOT NULL,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      role ENUM('ADMIN', 'RECEPTIONIST', 'STAFF') NOT NULL,
                      fullName VARCHAR(100),
                      status VARCHAR(10) DEFAULT 'ACTIVE',
                      CONSTRAINT pk_user PRIMARY KEY (userId),
                      CONSTRAINT uk_username UNIQUE (username)
);
INSERT INTO user (userId, username, password, role, fullName, status) VALUES
                                                                          ('U001', 'admin', 'admin123', 'ADMIN', 'System Administrator', 'ACTIVE'),
                                                                          ('U002', 'mala', 'mala123', 'RECEPTIONIST', 'Mala Silva', 'ACTIVE'),
                                                                          ('U003', 'kamal', 'kamal123', 'RECEPTIONIST', 'Kamal Perera', 'ACTIVE');



CREATE TABLE guest (
                       guestId VARCHAR(10) NOT NULL,
                       name VARCHAR(100) NOT NULL,
                       contact VARCHAR(15),
                       email VARCHAR(100),
                       nic VARCHAR(20),
                       CONSTRAINT pk_guest PRIMARY KEY (guestId),
                       CONSTRAINT uk_nic UNIQUE (nic)
);
INSERT INTO guest (guestId, name, contact, email, nic) VALUES
                                                           ('G001', 'John Doe', '0771234567', 'john@example.com', '199012345678'),
                                                           ('G002', 'Nimmi Fernando', '0719876543', 'nimmi@example.com', '956781234V'),
                                                           ('G003', 'David Smith', '0751112223', 'david@example.com', '198599887766');



CREATE TABLE room (
                      roomId VARCHAR(10) NOT NULL,
                      type VARCHAR(50) NOT NULL,
                      price DOUBLE NOT NULL CHECK (price > 0), -- GFG Standard: Validation constraint
                      status ENUM('AVAILABLE', 'OCCUPIED', 'MAINTENANCE') DEFAULT 'AVAILABLE',
                      CONSTRAINT pk_room PRIMARY KEY (roomId)
);
INSERT INTO room (roomId, type, price, status) VALUES
                                                   ('R001', 'Single Standard', 5000.00, 'AVAILABLE'),
                                                   ('R002', 'Double Deluxe', 12000.00, 'AVAILABLE'),
                                                   ('R003', 'Luxury Suite', 25000.00, 'OCCUPIED'),
                                                   ('R004', 'Family Room', 18000.00, 'MAINTENANCE'),
                                                   ('R005', 'Single Standard', 5500.00, 'AVAILABLE');



CREATE TABLE reservation (
                             resId VARCHAR(10) NOT NULL,
                             guestId VARCHAR(10),
                             roomId VARCHAR(10),
                             checkIn DATE NOT NULL,
                             checkOut DATE NOT NULL,
                             status VARCHAR(20) DEFAULT 'CONFIRMED',
                             CONSTRAINT pk_reservation PRIMARY KEY (resId),
                             CONSTRAINT fk_res_guest FOREIGN KEY (guestId) REFERENCES guest(guestId) ON DELETE CASCADE,
                             CONSTRAINT fk_res_room FOREIGN KEY (roomId) REFERENCES room(roomId) ON DELETE SET NULL
);
INSERT INTO reservation (resId, guestId, roomId, checkIn, checkOut, status) VALUES
                                                                                ('RES001', 'G001', 'R001', '2026-02-16', '2026-02-18', 'CONFIRMED'),
                                                                                ('RES002', 'G002', 'R002', '2026-02-20', '2026-02-25', 'PENDING');



CREATE TABLE bill (
                      billId VARCHAR(10) NOT NULL,
                      resId VARCHAR(10),
                      totalAmount DOUBLE NOT NULL,
                      paymentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      CONSTRAINT pk_bill PRIMARY KEY (billId),
                      CONSTRAINT fk_bill_res FOREIGN KEY (resId) REFERENCES reservation(resId) ON DELETE CASCADE
);
INSERT INTO bill (billId, resId, totalAmount) VALUES
                                                  ('B001', 'RES001', 10000.00),
                                                  ('B002', 'RES002', 60000.00);



