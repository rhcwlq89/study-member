DROP TABLE IF EXISTS `member`.`member`;
CREATE TABLE `member`.`member`
(
    `member_uid`      bigint PRIMARY KEY,
    `member_name`     varchar(100),
    `email`           varchar(150),
    `phone_number`    varchar(64),
    `birth_date`      varchar(30),
    `deleted_yn`      bool,
    `last_sign_in_at` datetime,
    `created_at`      datetime,
    `updated_at`      datetime
);

DROP TABLE IF EXISTS `member`.`member_role`;
CREATE TABLE `member`.`member_role`
(
    `member_role_uid` bigint PRIMARY KEY,
    `member_uid`      bigint,
    `role_uid`        bigint
);

DROP TABLE IF EXISTS `member`.`role`;
CREATE TABLE `member`.`role`
(
    `role_uid`   bigint PRIMARY KEY,
    `role_name`  varchar(150),
    `created_at` datetime,
    `updated_at` datetime
);

ALTER TABLE `member`.`member_role`
    ADD FOREIGN KEY (`member_uid`) REFERENCES `member`.`member` (`member_uid`);

ALTER TABLE `member`.`member_role`
    ADD FOREIGN KEY (`role_uid`) REFERENCES `member`.`role` (`role_uid`);
