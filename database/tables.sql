/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  amira
 * Created: 18-Feb-2022
 */

/* differents sql commands to create initials tables */


CREATE TABLE hospital(
	id INT NOT NULL,  
  	name VARCHAR(64), 
  	location VARCHAR(128),
  	score INT,
  	PRIMARY KEY(id)
);
ALTER TABLE hospital ADD (phone VARCHAR(64),email VARCHAR(64));

CREATE TABLE pharmacy(
	id INT NOT NULL,  
  	name VARCHAR(64), 
  	location VARCHAR(128),
  	score INT,
        phone VARCHAR(64),
        email VARCHAR(64),
	hourly ENUM('night', 'day ')
  	PRIMARY KEY(id)
);
/* add column type to pharmacy */
ALTER TABLE pharmacy ADD type ENUM('night', 'day ');
ALTER TABLE pharmacy ADD (phone VARCHAR(64),email VARCHAR(64));
ALTER TABLE pharmacy Change type hourly ENUM('night', 'day ');

CREATE TABLE cabinet(
	id INT NOT NULL,  
  	name VARCHAR(64), 
  	location VARCHAR(128),
  	speciality VARCHAR(64),
  	phone VARCHAR(64), 
  	score INT,
  	PRIMARY KEY(id)
);
ALTER TABLE cabinet ADD (email VARCHAR(64));

/* make id autoincrement */

ALTER TABLE pharmacy MODIFY  COLUMN id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE cabinet MODIFY  COLUMN id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE hospital MODIFY  COLUMN id INT NOT NULL AUTO_INCREMENT;

ALTER TABLE pharmacy MODIFY  COLUMN score INT;
ALTER TABLE hospital MODIFY  COLUMN score INT;

alter table cabinet rename to complexeMedicale;

ALTER TABLE complexeMedical
DROP COLUMN speciality;