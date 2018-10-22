DELETE FROM customer;
DELETE FROM account_addresses;
DELETE FROM account_credit_cards;
DELETE FROM credit_card;
DELETE FROM account;
DELETE FROM address;
INSERT INTO account VALUES (1, unix_timestamp(now()), unix_timestamp(now()), 12345, 1, 'jack');
SET @account_id = 1;
INSERT INTO address VALUES (1, unix_timestamp(now()), unix_timestamp(now()), 0, 'Palo Alto', 'United States', 'CA', '3495 Deer Creek Road', '', '94304');
SET @address_id = 1;
INSERT INTO account_addresses VALUES (@account_id, @address_id);
INSERT INTO credit_card VALUES (1, unix_timestamp(now()), unix_timestamp(now()), '1234567801234567', 0);
SET @cc_id = 1;
INSERT INTO account_credit_cards VALUES (@account_id, @cc_id);
INSERT INTO customer VALUES (1, unix_timestamp(now()), unix_timestamp(now()), 'jack.chen@example.com', 'Jack', 'Chen', @account_id);

