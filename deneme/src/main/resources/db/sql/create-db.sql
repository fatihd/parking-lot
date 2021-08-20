CREATE SEQUENCE SEQ_ZZZ_USERS
    START WITH     1000
    INCREMENT BY   1
    NOCACHE
    NOCYCLE;


  CREATE TABLE "ZZZ_USERS"
   (	"ID" NUMBER(19,0) NOT NULL,
	"AD" VARCHAR2(50) NOT NULL,
	"VERSION" NUMBER(19,0) NOT NULL,
	 PRIMARY KEY ("ID")
   );


   CREATE SEQUENCE SEQ_ZZZ_SPOTS
       START WITH     1000
       INCREMENT BY   1
       NOCACHE
       NOCYCLE;

  CREATE TABLE "ZZZ_SPOTS" (
    "ID" NUMBER(19,0) NOT NULL,
	"VERSION" NUMBER(19,0) NOT NULL,
    "CODE" VARCHAR2(50) NOT NULL,
    PRIMARY KEY ("ID")
    );


   CREATE SEQUENCE SEQ_ZZZ_RESERVATIONS
       START WITH     1000
       INCREMENT BY   1
       NOCACHE
       NOCYCLE;

  CREATE TABLE "ZZZ_RESERVATIONS"
   (	"ID" NUMBER(19,0) NOT NULL,
	"VERSION" NUMBER(19,0) NOT NULL,
	"USER_ID" NUMBER(19,0) NOT NULL,
	"SPOT_ID" NUMBER(19,0) NOT NULL,
	"START_" TIMESTAMP NOT NULL,
	"END_" TIMESTAMP NOT NULL,
	 PRIMARY KEY ("ID")
   );
