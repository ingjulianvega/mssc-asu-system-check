DROP DATABASE IF EXISTS systemcheckservice;
DROP USER IF EXISTS `system_check_service`@`%`;
CREATE DATABASE IF NOT EXISTS systemcheckservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `system_check_service`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `systemcheckservice`.* TO `system_check_service`@`%`;
FLUSH PRIVILEGES;

