# --------------------------------------------------------
# Host:                         snapviod.us-west-2.rds.amazonaws.com
# Server version:               5.7.17-log
# Server OS:                    Linux
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2017-10-19 11:05:27
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for video_manager
DROP DATABASE IF EXISTS `video_manager`;
CREATE DATABASE IF NOT EXISTS `video_manager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `video_manager`;


# Dumping structure for table video_manager.profile
DROP TABLE IF EXISTS `profile`;
CREATE TABLE IF NOT EXISTS `profile` (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `p_type` varchar(30) NOT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `type` (`p_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

# Dumping data for table video_manager.profile: ~1 rows (approximately)
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` (`p_id`, `p_type`) VALUES
	(1, 'ADMIN');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;


# Dumping structure for table video_manager.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(50) NOT NULL,
  `u_password` varchar(100) NOT NULL,
  `u_join_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`u_id`),
  KEY `u_id` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table video_manager.users: ~0 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`u_id`, `u_name`, `u_password`, `u_join_date`) VALUES
	(1, 'admin', '$2a$10$AQg7SARAZ5fkY65wvI3ileqkEPj9mXCuDUBRY/o8iPIA.j0MR5u22', '2017-10-19 16:00:51');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


# Dumping structure for table video_manager.user_profile_map
DROP TABLE IF EXISTS `user_profile_map`;
CREATE TABLE IF NOT EXISTS `user_profile_map` (
  `u_id` bigint(20) NOT NULL,
  `p_id` bigint(20) NOT NULL,
  PRIMARY KEY (`u_id`,`p_id`),
  KEY `FK_user_profile_map_profile` (`p_id`),
  CONSTRAINT `FK_user_profile_map_profile` FOREIGN KEY (`p_id`) REFERENCES `profile` (`p_id`),
  CONSTRAINT `FK_user_profile_map_users` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table video_manager.user_profile_map: ~1 rows (approximately)
/*!40000 ALTER TABLE `user_profile_map` DISABLE KEYS */;
INSERT INTO `user_profile_map` (`u_id`, `p_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `user_profile_map` ENABLE KEYS */;


# Dumping structure for table video_manager.videos
DROP TABLE IF EXISTS `videos`;
CREATE TABLE IF NOT EXISTS `videos` (
  `v_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) NOT NULL,
  `v_name` varchar(64) NOT NULL,
  `v_length` int(10) NOT NULL,
  `v_bitrate` int(10) NOT NULL,
  `v_res` varchar(20) NOT NULL,
  `v_add_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`v_id`),
  KEY `v_id` (`v_id`),
  KEY `uid` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table video_manager.videos: ~0 rows (approximately)
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
