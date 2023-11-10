INSERT INTO USERS (id, password, username, enabled) SELECT 1,
"$2a$10$loHBsPwCw7wi1qbgjaUyB.MuUCLmgqdcLH97bsdnrISB8TY1bLM42", "admin@admin.com",
true FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM USERS WHERE username = "admin@admin.com");

INSERT INTO USERS (id, password, username, enabled) SELECT 2,
"$2a$10$loHBsPwCw7wi1qbgjaUyB.MuUCLmgqdcLH97bsdnrISB8TY1bLM42", "user@user.com",
true FROM DUAL WHERE NOT EXISTS (SELECT 2 FROM USERS WHERE username = "user@user.com");

INSERT INTO USERS (id, password, username, enabled) SELECT 3,
"$2a$10$loHBsPwCw7wi1qbgjaUyB.MuUCLmgqdcLH97bsdnrISB8TY1bLM42", "customer@customer.com",
true FROM DUAL WHERE NOT EXISTS (SELECT 3 FROM USERS WHERE username = "customer@customer.com");

INSERT INTO authorities (id, authority) SELECT 1, "VIEW_ADMIN" FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM authorities WHERE id = 1);
INSERT INTO authorities (id, authority) SELECT 2, "VIEW_INFO" FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM authorities WHERE id = 2);
INSERT INTO authorities (id, authority) SELECT 3, "STANDARD" FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM authorities WHERE id = 3);

INSERT INTO user_authority (user_id, authority_id) SELECT 1, 1 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM user_authority WHERE user_id = 1 AND authority_id = 1);
INSERT INTO user_authority (user_id, authority_id) SELECT 1, 2 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM user_authority WHERE user_id = 1 AND authority_id = 2);
INSERT INTO user_authority (user_id, authority_id) SELECT 1, 3 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM user_authority WHERE user_id = 1 AND authority_id = 3);

INSERT INTO user_authority (user_id, authority_id) SELECT 2, 2 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM user_authority WHERE user_id = 2 AND authority_id = 2);
INSERT INTO user_authority (user_id, authority_id) SELECT 2, 3 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM user_authority WHERE user_id = 2 AND authority_id = 3);

INSERT INTO user_authority (user_id, authority_id) SELECT 3, 3 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM user_authority WHERE user_id = 3 AND authority_id = 3);