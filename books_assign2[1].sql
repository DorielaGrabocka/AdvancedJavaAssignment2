-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 02, 2021 at 08:16 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `books_assign2`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `ID` int(11) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Author` varchar(255) NOT NULL,
  `PublishingHouse` varchar(255) NOT NULL,
  `Publication_Year` varchar(4) NOT NULL,
  `Genre` varchar(255) NOT NULL,
  `Date_Added` date NOT NULL,
  `Synopsis` varchar(255) DEFAULT NULL,
  `Status` varchar(8) NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`ID`, `Title`, `Author`, `PublishingHouse`, `Publication_Year`, `Genre`, `Date_Added`, `Synopsis`, `Status`) VALUES
(1, 'Java How To Program', 'Paul Deitel', 'Deitel', '2017', 'Academic', '2021-02-11', 'This is a book that contains the A-Z of Java programming, suitable for beginners and advanced programmers.', 'N'),
(2, 'Arc of Triumph', 'Erich Maria Remarque', 'Express Publishing', '1945', 'Novel', '2021-02-13', NULL, 'N'),
(3, 'Three Comrades', 'Erich Maria Remarque', 'Express Publishing', '1936', 'Novel', '2021-02-14', NULL, 'N'),
(4, 'Great Expectations', 'Charles Dickens', 'Express Publishing', '1861', 'Novel', '2021-02-04', NULL, 'N'),
(5, 'Don Quixote', 'Miguel De Cervantes', 'Express Publishing', '1605', 'Satire', '2021-02-18', NULL, 'N'),
(6, 'Robinson Crusoe', 'Daniel Defoe', 'Old England', '1719', 'Adventure Fiction', '2021-02-24', 'This book tells about the adventures of Robinson Crusoe, who got lost in an abandoned island for 27 years.', 'N'),
(7, 'C++ How to Program', 'Harvey Deitel', 'Deitel', '2018', 'Academic', '2021-02-14', 'A-Z of C++ programing. A hands-on guide', 'N'),
(9, 'The Fallen Angel', 'Daniel Silva', 'Living', '2012', 'Mystery', '2021-02-17', '', 'N'),
(13, 'Poliana', 'Eleanor H. Porter', 'Toena', '1913', 'Fiction', '2021-02-17', 'This book tells the story of a young girl that despite all the difficulties that life showed her, she never stopped showing her virtues.', 'N'),
(14, 'Caravaggio Case', 'Daniel Silva', 'Living ', '2018', 'Action', '2021-02-27', '', 'N'),
(15, 'The Order', 'Daniel Silva', 'Living', '2020', 'Thriller', '2021-03-01', '', 'N'),
(16, 'The Kill Artist', 'Daniel Silva', 'Living', '2000', 'Thriller', '2021-03-01', '', 'N'),
(17, 'House of Spies', 'Daniel Silva', 'Harpin Collins', '2017', 'Novel', '2021-03-01', '', 'N'),
(18, 'The Other Women', 'Daniel Silva', 'Harper', '2018', 'Novel', '2021-03-01', '', 'N'),
(19, 'Royal', 'Daniel Steel', 'Living', '2020', 'Historical Fiction', '2021-03-01', '', 'N'),
(20, 'Daddy\'s Girl', 'Daniel Steel', 'Living', '2020', 'Contemporary Romance', '2021-03-01', '', 'N'),
(21, 'The Royal Game', 'Stephan Cweig', 'Toena', '1943', 'Novel', '2021-03-01', '', 'N'),
(22, 'The World of Yesterday', 'Stephan Cweig', 'Toena', '1941', 'Biography', '2021-03-01', '', 'N'),
(23, 'Letter From an Unknown Woman', 'Stephan Cweig', 'Toena ', '1922', 'Fiction', '2021-03-01', '', 'N'),
(24, 'Marie Antoinette', 'Stephan Cweig', 'Toena', '1932', 'Biography', '2021-03-01', '', 'N'),
(25, 'Fantastic Night', 'Stefan Cweig', 'Toena', '1922', 'Fiction', '2021-03-01', '', 'N'),
(26, 'Montaigne', 'Stefan Cweig', 'Toena', '1942', 'Biography', '2021-03-01', '', 'N'),
(27, 'Clarisssa', 'Stefan Cweig', 'Toena', '1981', 'Biography', '2021-03-01', '', 'N'),
(28, 'Twenty Thousand Leagues Under the SeaSea', 'Jul Verne', 'Toena', '1870', 'Novel', '2021-03-01', '', 'N'),
(29, 'Five Weeks In a Ballon', 'Jul Verne', 'Pierre - Heltz', '1863', 'Novel', '2021-03-01', '', 'N'),
(30, 'The Mysterious Island', 'Jul Verne', 'Piere Ferrat', '1873', 'Novel', '2021-03-01', '', 'N'),
(31, 'Two Years Vacation', 'Jules Verne', 'Piere Heltz', '1888', 'Adventure Fiction', '2021-03-01', '', 'N'),
(32, 'Master of the World', 'Jules Verne', 'Toena', '1904', 'Novel', '2021-03-01', '', 'N'),
(33, 'Steam House', 'Jules Verne', 'Piere- Hetzel', '1880', 'Novel', '2021-03-01', '', 'N'),
(34, 'The Floating City', 'Jules Verne', 'Piere - Hetzel', '1904', 'Adenture Fiction', '2021-03-01', '', 'N'),
(35, 'Mistress Branican', 'Jules Verne', 'Toena', '1891', 'Adventure Fiction', '2021-03-01', '', 'N'),
(36, 'Family Without a Name', 'Jules Verne', 'Piere - Hetzel', '1891', 'Novel', '2021-03-01', '', 'N'),
(37, 'The Green Ray', 'Jules Verne', 'Toena', '1893', 'Novel', '2021-03-01', '', 'N'),
(38, 'War and Peace ', 'Leo Tolstoi', 'Toena', '1863', 'Novel', '2021-03-01', '', 'N'),
(39, 'Anna Karenina', 'Leo Tolstoi', 'Toena', '1877', 'Novel', '2021-03-01', '', 'N'),
(40, 'Resurection', 'Leo Tolstoi', 'Toena', '1899', 'Novel', '2021-03-01', '', 'N'),
(41, 'Childhood', 'Leo Tolstoi', 'Toena', '1923', 'Autobiography', '2021-03-01', '', 'N'),
(42, 'Youth', 'Leo Tolstoi', 'Toena', '1857', 'Fiction', '2021-03-01', '', 'N'),
(43, 'Family Happiness', 'Leo Tolstoi', 'Toena', '1857', 'Fiction', '2021-03-01', '', 'N'),
(44, 'The General of Dead Army', 'Ismail Kadare', 'Toena ', '1963', 'Novel', '2021-03-01', '', 'N'),
(45, 'Chronicle in Stone', 'Ismail Kadare', 'Toena', '1971', 'Novel', '2021-03-01', '', 'N'),
(46, 'Doruntine', 'Ismail Kadare', 'Toena', '1980', 'Drama Fiction', '2021-03-01', '', 'N'),
(47, 'The Fall of  the Stone City', 'Ismail Kadare', 'Onufri', '2008', 'Historical Fiction', '2021-03-01', '', 'N'),
(48, 'The Doll: A Portrait of My Mother', 'Ismail Kadare', 'Onufri', '2020', 'Autobiogrphy', '2021-03-01', '', 'N'),
(49, 'The Accident', 'Ismail Kadare', 'Onufri', '2010', 'Novel', '2021-03-01', '', 'N'),
(50, 'Broken April', 'Ismail Kadare', 'Onufri', '1978', 'Novel', '2021-03-01', '', 'N'),
(51, 'The File on H', 'Ismail Kadare', 'Onufri', '1981', 'Novel', '2021-03-01', '', 'N'),
(52, 'Dummy', 'dummy', 'Dummy', '1000', 'Dmmy', '2021-03-02', 'no', 'D');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `UserID` int(11) NOT NULL,
  `BookID` int(11) NOT NULL,
  `Rating` int(11) NOT NULL,
  `Text` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`UserID`, `BookID`, `Rating`, `Text`) VALUES
(1, 1, 5, 'Very good book! Highly recommended!'),
(4, 2, 1, 'I do not recommend this book to romance fans!'),
(4, 4, 5, 'Love it'),
(4, 5, 4, 'Good book!'),
(4, 6, 3, 'Not sure, if you have time give it a try!'),
(4, 9, 5, 'Very Good Book!'),
(4, 13, 5, 'Exellent book!'),
(4, 17, 5, 'Good Book!'),
(4, 33, 5, 'Love it!'),
(4, 34, 5, 'Amazing!'),
(4, 50, 5, 'Loved it!'),
(4, 51, 4, 'Good!'),
(5, 3, 4, 'Quite Good!'),
(5, 4, 5, 'Excellent book!'),
(5, 5, 2, 'Not good for me!'),
(5, 6, 2, 'Not good for me!'),
(5, 9, 5, 'Fantastic book! Action Paced!\n'),
(5, 13, 3, 'Very good for young ladies!'),
(5, 20, 5, 'Love it!'),
(5, 21, 2, 'Not good!'),
(5, 23, 5, 'Love it!'),
(5, 25, 3, 'Liked it but not a lot!'),
(6, 13, 5, 'Loved it!'),
(6, 14, 4, 'Good!'),
(6, 18, 5, 'Love it!'),
(6, 19, 5, 'Love it!'),
(6, 20, 2, 'Not good!'),
(6, 21, 5, 'Love it!'),
(6, 22, 3, 'Liked it but not a lot!'),
(6, 23, 5, 'Love it!'),
(6, 24, 5, 'Very good!'),
(6, 26, 5, 'Love it!'),
(6, 27, 5, 'Love it!'),
(6, 28, 1, 'Didn\'t like it.'),
(6, 51, 5, 'Amazing!'),
(8, 14, 4, 'Good!'),
(8, 18, 5, 'Love it!'),
(8, 19, 5, 'Love it!'),
(8, 20, 2, 'Not good!'),
(8, 21, 5, 'Love it!'),
(8, 22, 3, 'Liked it but not a lot!'),
(8, 23, 5, 'Love it!'),
(8, 24, 5, 'Very good!'),
(8, 26, 5, 'Love it!'),
(8, 27, 5, 'Love it!'),
(8, 28, 1, 'Didn\'t like it.'),
(8, 43, 5, 'Amazing!'),
(8, 51, 5, 'Loved it!'),
(15, 15, 5, 'Love it!'),
(15, 16, 5, 'Very good!'),
(15, 17, 5, 'Love it!'),
(15, 20, 5, 'Love it!'),
(15, 21, 1, 'Didn\'t like it.'),
(15, 29, 5, 'Love it!'),
(15, 30, 5, 'Loved it!'),
(15, 31, 4, 'Good!'),
(15, 32, 5, 'Love it!'),
(15, 36, 5, 'Amazing!'),
(15, 38, 2, 'Not good!'),
(15, 40, 3, 'Liked it but not a lot!'),
(15, 41, 5, 'Love it!'),
(15, 42, 5, 'Very good!'),
(15, 43, 5, 'Love it!'),
(15, 44, 5, 'Love it!'),
(15, 50, 5, 'Love it!'),
(17, 14, 4, 'Good!'),
(17, 18, 5, 'Love it!'),
(17, 19, 5, 'Love it!'),
(17, 20, 2, 'Not good!'),
(17, 21, 5, 'Love it!'),
(17, 22, 3, 'Liked it but not a lot!'),
(17, 23, 5, 'Love it!'),
(17, 24, 5, 'Very good!'),
(17, 26, 5, 'Love it!'),
(17, 27, 5, 'Love it!'),
(17, 28, 1, 'Didn\'t like it.'),
(17, 43, 5, 'Amazing!'),
(17, 51, 5, 'Loved it!'),
(19, 14, 4, 'Good!'),
(19, 18, 5, 'Love it!'),
(19, 19, 5, 'Love it!'),
(19, 20, 2, 'Not good!'),
(19, 21, 5, 'Love it!'),
(19, 22, 3, 'Liked it but not a lot!'),
(19, 23, 5, 'Love it!'),
(19, 24, 5, 'Very good!'),
(19, 26, 5, 'Love it!'),
(19, 27, 5, 'Love it!'),
(19, 28, 1, 'Didn\'t like it.'),
(19, 43, 5, 'Amazing!'),
(19, 51, 5, 'Loved it!'),
(21, 1, 1, 'Didn\'t like it.'),
(21, 2, 5, 'Loved it!'),
(21, 3, 4, 'Good!'),
(21, 20, 5, 'Love it!'),
(21, 21, 5, 'Amazing!'),
(21, 22, 5, 'Love it!'),
(21, 23, 2, 'Not good!'),
(21, 24, 5, 'Love it!'),
(21, 25, 3, 'Liked it but not a lot!'),
(21, 26, 5, 'Love it!'),
(21, 27, 5, 'Very good!'),
(21, 28, 5, 'Love it!'),
(21, 29, 5, 'Love it!'),
(21, 30, 1, 'Didn\'t like it.'),
(21, 31, 5, 'Loved it!'),
(21, 32, 4, 'Good!'),
(21, 33, 5, 'Love it!'),
(21, 35, 5, 'Love it!'),
(21, 36, 2, 'Not good!'),
(21, 37, 5, 'Love it!'),
(21, 38, 3, 'Liked it but not a lot!'),
(21, 39, 5, 'Love it!'),
(21, 40, 5, 'Very good!'),
(21, 41, 5, 'Love it!'),
(21, 42, 5, 'Love it!');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Surname` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `UserType` varchar(8) NOT NULL,
  `Status` char(1) NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `Name`, `Surname`, `Email`, `Password`, `UserType`, `Status`) VALUES
(1, 'Doriela', 'Grabocka', 'dorielag18@gmail.com', 'YWRtaW4=', 'admin', 'N'),
(2, 'Oli', 'Dedo', 'oli.dedo@yahoo.com', 'YWRtaW4=', 'admin', 'N'),
(4, 'John', 'Smith', 'johnsmith@gmail.com', 'anM=', 'standard', 'N'),
(5, 'John', 'Doe', 'jdoe@gmail.com', 'amQ=', 'standard', 'N'),
(6, 'Mark', 'Doe', 'markdoe@gmail.com', 'dXNlcg==', 'standard', 'N'),
(8, 'Ann', 'Smith', 'ann@yahoo.com', 'dXNlcg==', 'standard', 'N'),
(15, 'ABC', 'ABC', 'abc@gmail.com', 'dXNlcg==', 'standard', 'N'),
(17, 'Ann', 'Jonathan', 'ann1@yahoo.com', 'dXNlcg==', 'standard', 'N'),
(19, 'John', 'Doe', 'jdoe1@gmail.com', 'dXNlcg==', 'standard', 'N'),
(21, 'AA', 'BB', 'aa@gmail.com', 'dXNlcg==', 'standard', 'N'),
(22, 'Mary', 'Lodge', 'mlodge@yahoo.com', 'dXNlcg==', 'admin', 'D'),
(23, 'Test', 'Test', 'test@test.com', 'dXNlcg==', 'admin', 'N');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`UserID`,`BookID`),
  ADD KEY `fk_book_id` (`BookID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `unique-email` (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `fk_book_id` FOREIGN KEY (`BookID`) REFERENCES `books` (`ID`),
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`UserID`) REFERENCES `users` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
