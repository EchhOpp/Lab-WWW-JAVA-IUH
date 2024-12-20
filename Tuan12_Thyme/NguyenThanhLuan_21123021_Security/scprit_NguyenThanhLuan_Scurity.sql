create database SpringSecurity
go
use SpringSecurity
go
SET IDENTITY_INSERT app_user ON;
INSERT INTO app_user (user_id, user_name, encrypted_password, enabled) VALUES
(1, 'user1', '1234567', 1),
(2, 'user2', '1234567', 0);
SET IDENTITY_INSERT app_user OFF;

SET IDENTITY_INSERT app_role ON
INSERT INTO app_role (role_id, role_name) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');
SET IDENTITY_INSERT app_role off

SET IDENTITY_INSERT user_role on
INSERT INTO user_role (id, user_id, role_id) VALUES
(1, 1, 1),  -- John Doe as ROLE_USER
(2, 2, 2);  -- Jane Smith as ROLE_ADMIN

SET IDENTITY_INSERT user_role off