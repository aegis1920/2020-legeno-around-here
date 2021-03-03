ALTER TABLE `area` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `area` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `area` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `post_zzang` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `post_zzang` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `post_zzang` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `post` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `post` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `post` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `post_image` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `post_image` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `post_image` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `user` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `user` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `user` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `user_image` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `user_image` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `user_image` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `mail_auth` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `mail_auth` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `mail_auth` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `popular_post_award` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `popular_post_award` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `popular_post_award` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `sector_creator_award` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `sector_creator_award` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `sector_creator_award` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `post_report` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `post_report` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `post_report` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `comment_report` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `comment_report` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `comment_report` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `user_report` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `user_report` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `user_report` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `comment` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `comment` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `comment` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `sector` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `sector` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `sector` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `notification` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `notification` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `notification` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;

ALTER TABLE `comment_zzang` MODIFY COLUMN `deleted_at` BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE `comment_zzang` RENAME COLUMN `deleted_at` TO `deleted`;
UPDATE `comment_zzang` SET `deleted` = CASE WHEN deleted IS NULL THEN 0 ELSE 1 END;
