DELETE FROM user;
INSERT INTO user VALUES (1, unix_timestamp(now()), unix_timestamp(now()), 'jack.chen@example.com', 'Jack', 'Chen', 'jack');
INSERT INTO user VALUES (2, unix_timestamp(now()), unix_timestamp(now()), 'cathy.hu@example.com', 'Cathy', 'Hu', 'cathy');

