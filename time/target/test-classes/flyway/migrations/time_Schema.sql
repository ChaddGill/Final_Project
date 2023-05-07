DROP TABLE IF EXISTS punchSchedule;
DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS punch;
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  employeeID int unsigned NOT NULL AUTO_INCREMENT,
  name varchar (60) NOT NULL,
  minHours decimal (2,0),
  vacationHours decimal (5, 2),
  otEligible boolean,
  constraint employee_employeeID_pk primary key (employeeID)
  );

CREATE TABLE punch (
  punchID int unsigned NOT NULL AUTO_INCREMENT,
  punchChoice enum ('IN', 'OUT') NOT NULL,
  constraint punch_punchID_pk primary key (punchID)
  );

CREATE TABLE schedule (
  scheduleID int unsigned NOT NULL AUTO_INCREMENT,
  employeeID int unsigned NOT NULL,
  clockDateTime DATETIME NOT NULL ON UPDATE CURRENT_TIMESTAMP default CURRENT_TIMESTAMP,
  constraint schedule_scheduleID_pk primary key (scheduleID),
  constraint schedule_scheduleID_fk FOREIGN KEY (employeeID) REFERENCES employee (employeeID) ON DELETE CASCADE
  );

CREATE TABLE punchSchedule (
  scheduleID int unsigned NOT NULL,
  punchID int unsigned NOT NULL,
  constraint punchSchedule_scheduleID_fk FOREIGN KEY (scheduleID) REFERENCES schedule (scheduleID) ON DELETE CASCADE,
  constraint punchSchedule_punchID_fk foreign key (punchID) REFERENCES punch (punchID) ON DELETE CASCADE
  );
