DROP TABLE IF EXISTS student;
CREATE TABLE IF NOT EXISTS student (id INT NOT NULL AUTO_INCREMENT, code INT NOT NULL, name VARCHAR(50), lastname VARCHAR(100), age INT, state INT, PRIMARY KEY (id));
INSERT INTO student(code,name,lastname,age,state) VALUES(1,'Luis','Benvenuto',37,1);