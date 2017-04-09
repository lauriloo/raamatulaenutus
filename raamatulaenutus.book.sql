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
VALUES ('Title1','Author1',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title2','Author2',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title3','Author3',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title4','Author4',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title5','Author5',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title6','Author6',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title7','Author7',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title8','Author8',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title9','Author9',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title10','Author10',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title11','Author11',false,null,null);

INSERT INTO raamatulaenutus.BOOK(title,author,rentedout,comment,rentingdate)
VALUES ('Title12','Author12',false,null,null);



commit;