DROP DATABASE IF EXISTS beacon_db;
CREATE DATABASE beacon_db;
USE beacon_db;

CREATE TABLE Users (
    userID int(10) not null primary key AUTO_INCREMENT,
    username varchar(30) not null unique,
    password varchar(90) not null
);

CREATE TABLE Disasters (
    disasterID int(15) not null primary key AUTO_INCREMENT,
    disasterName varchar(30) not null unique,
    disasterType varchar(30) not null
);

CREATE TABLE Posts(
    postID INT(15) NOT NULL AUTO_INCREMENT, 
    disasterID INT(15) NOT NULL,
    userID INT(10) NOT NULL, 
    postScore INT(10), 
    timeStamps DATETIME NOT NULL,
    postTitle VARCHAR(300) NOT NULL unique,
    postContent VARCHAR(1000) NOT NULL,
    PRIMARY KEY(postID), 
    FOREIGN KEY(disasterID) REFERENCES Disasters(disasterID),
    FOREIGN KEY(userID) REFERENCES Users(userID)
);
    
CREATE TABLE Comments(
    commentID INT(15) NOT NULL AUTO_INCREMENT,
    userID INT(10) NOT NULL,
    postID INT(15) NOT NULL, 
    commentContent VARCHAR(1000) NOT NULL, 
    timeStamps DATETIME NOT NULL,
    
    PRIMARY KEY(commentID),
    FOREIGN KEY(userID) REFERENCES Users(UserID),
    FOREIGN KEY(postID) REFERENCES Posts(postID)
);
