/* Create BOOK Table */
create table RAAMATULAENUTUS.BOOK (
   id BIGINT NOT NULL AUTO_INCREMENT,
   title VARCHAR(255) NOT NULL,
   author VARCHAR(255) NOT NULL,
   rentedout BOOLEAN NOT NULL,
   comment VARCHAR(255) NULL,
   rentingdate DATE,
   PRIMARY KEY (id)
);

/* Populate BOOK Table */
INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Kolm musketäri','Alexandre Dumas',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Kakskümmend aastat hiljem','Alexandre Dumas',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('12 tooli','Ilf ja Petrov',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Hukkunud Alpinisti hotell','Arkadi ja Boriss Strugatski',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Linn ja tähed','Arthur C. Clarke',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Kaart ja territoorium','Michel Houellebecq',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Idoru','William Gibson',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Kevad','Oskar Luts',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Suvi','Oskar Luts',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Kuritöö ja karistus','Fjodor Dostojevski',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Lilled Algernonile','Daniel Keyes',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Igaviku lõpp','Isaac Asimov',false,null,null);



commit;