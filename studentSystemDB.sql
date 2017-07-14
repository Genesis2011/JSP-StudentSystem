-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2017-07-13 15:06:49
-- 服务器版本： 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `studentSystemDB`
--

-- --------------------------------------------------------

--
-- 表的结构 `Grade`
--

CREATE TABLE IF NOT EXISTS `Grade` (
  `id` int(11) NOT NULL COMMENT '年级编号',
  `name` varchar(255) NOT NULL COMMENT '年级名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='年级信息表';

--
-- 转存表中的数据 `Grade`
--

INSERT INTO `Grade` (`id`, `name`) VALUES
(1, '一年级'),
(2, '二年级'),
(3, '三年级'),
(4, '四年级'),
(5, '五年级'),
(6, '六年级');

-- --------------------------------------------------------

--
-- 表的结构 `Score`
--

CREATE TABLE IF NOT EXISTS `Score` (
`id` int(11) NOT NULL COMMENT '编号',
  `score` double NOT NULL COMMENT '成绩',
  `course` varchar(255) NOT NULL COMMENT '科目',
  `time` varchar(255) NOT NULL COMMENT '考试时间',
  `studentid` int(11) NOT NULL COMMENT '学号'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='学生成绩信息表' AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `Score`
--

INSERT INTO `Score` (`id`, `score`, `course`, `time`, `studentid`) VALUES
(1, 94, '数学', '2017-07-04', 1),
(2, 96, '英语', '2017-07-03', 2),
(3, 100, '数学', '2017-07-04', 3),
(4, 99, '历史', '2017-07-05', 4),
(5, 94, '英语', '2017-07-03', 5);

-- --------------------------------------------------------

--
-- 表的结构 `Student`
--

CREATE TABLE IF NOT EXISTS `Student` (
  `id` int(11) NOT NULL COMMENT '学号',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `password` varchar(255) NOT NULL COMMENT '学生用户密码',
  `age` int(11) NOT NULL COMMENT '年龄',
  `place` varchar(255) NOT NULL COMMENT '籍贯',
  `phone` varchar(11) NOT NULL COMMENT '电话',
  `qq` varchar(11) NOT NULL COMMENT 'QQ',
  `grade` int(11) NOT NULL COMMENT '年级编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生信息表';

--
-- 转存表中的数据 `Student`
--

INSERT INTO `Student` (`id`, `name`, `password`, `age`, `place`, `phone`, `qq`, `grade`) VALUES
(1, '杜时', '123', 22, '山东', '17865981279', '513757184', 2),
(2, '李军', '123', 23, '上海', '17865981563', '516475924', 3),
(3, '王广', '123', 21, '北京', '17865984562', '513714964', 2),
(4, '张可', '123', 20, '河北', '17865986954', '513694851', 4),
(5, '韩峰', '123', 21, '山西', '17865987651', '579163482', 1);

-- --------------------------------------------------------

--
-- 表的结构 `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `id` int(11) NOT NULL COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `age` int(11) NOT NULL COMMENT '年龄',
  `phone` varchar(11) NOT NULL COMMENT '电话'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

--
-- 转存表中的数据 `User`
--

INSERT INTO `User` (`id`, `name`, `password`, `age`, `phone`) VALUES
(1, '赵一', '14111201', 18, '17865931234'),
(2, '钱二', '14111202', 21, '17865931235'),
(3, '孙三', '14111203', 25, '17865931236'),
(4, '李四', '14111204', 19, '17865931237'),
(5, '赵刚', '14111205', 18, '17865931238');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Grade`
--
ALTER TABLE `Grade`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Score`
--
ALTER TABLE `Score`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Student`
--
ALTER TABLE `Student`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Score`
--
ALTER TABLE `Score`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
