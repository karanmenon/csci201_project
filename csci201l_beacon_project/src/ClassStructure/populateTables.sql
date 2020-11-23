USE beacon_db;
INSERT INTO Users (username,password) values
	('kiva','kivaisthecoolest'),
    ('kelly','kellyisanawesomeperson'),
    ('jared','everybodylovesjared!'),
    ('brendan','brendanhasexcellenttasteinsportsteams'),
    ('karan','karaniskaptivating'),
    ('erin','erinisreallyhappythatherfinalsaredone'),
    ('sally769','dogsrcool'),
    ('bob99','butcatsareeasier'),
    ('dijkstra','imadeanalgorithmorsomething'),
    ('jarnik','imadeanalgorithmorsomething'),
    ('Harry','HedwigIsANiceBird'),
    ('Hermione','CrookshanksIsANiceCat'),
    ('Ron','ScabbersIsABadRat'),
    ('Scabbers','ButIMakeABetterRatThanHuman'),
    ('Voldemort','Whatisthatmysterioustickingnoise?');

INSERT INTO Disasters (disasterName,disasterType) values 
	('Grizzly Creek Fire','Fire'),
    ('Pine Gulch Fire','Fire'),
    ('Cameron Peak Fire','Fire'),
    ('Santiam Fire','Fire'),
    ('Glass Fire','Fire'),
    ('Aegean Sea Earthquake','Earthquake'),
    ('Oaxaca Earthquake','Earthquake'),
    ('Creek Fire','Fire'),
    ('Hurricane Sally','Hurricane'),
    ('Hurricane Teddy','Hurricane'),
    ('Hurricane Zeta','Hurricane'),
    ('Hurricane Laura','Hurricane'),
    ('Hurricane Marco','Hurricane'),
    ('Cookeville, Tennessee Tornado - March','Tornado'),
    ('Chatsworth, Georgia Tornado - April','Tornado');

INSERT INTO Posts (disasterID, userID, postScore, timeStamps, postTitle, postContent) values
	(8,11,0,'2020-11-22 00:00:00','Need help evacuating 18 horses','Hi, I live near the Walmart on 5th Street and I need help evacuating my animals. I only have one horse trailer. Please email me at harry@gmail.com if you can help, thanks.'),
	(1,7,0,'2020-11-22 01:00:00','Road blocked at the overpass','Just wanted to let everyone know that the road is currently blocked and it is going to be several hours until this route is available according to emergency services at the scene.'),
	(2,8,0,'2020-11-22 02:00:00','Found dog in my yard','Very scared dog just showed up at my house. Collar does not have tags. He is black and white and about 20 lbs'),
    (3,9,0,'2020-11-22 00:00:00','Shelter for the night?','I have been calling around and all of the places offering temporary shelter are full. My two children and husband need somewhere to stay.'),
    (4,10,0,'2020-11-22 04:44:00','Evacuation for people living near main street?','Hi, I live near main street and the directions have been unclear - are we required to evacuate?'),
    (5,11,0,'2020-11-22 09:00:00','Medical supplies needed','I am at a temporary treatment set up in the high school and we have run out of some supplies, if someone could help that would be great.'),
    (6,12,0,'2020-11-22 10:00:50','Has anyone seen my husband, Jerry Smith?','He was working at the factory today but I have not heard from him since the earthquake. Any help would be appreciated, thank you.'),
    (7,13,0,'2020-11-22 00:00:00','Places to volunteer?','Hi, I live about 50 miles from the earthquake and I was wondering if there are places that need volunteers. I have a large truck that could be useful.'),
    (9,14,0,'2020-11-22 20:00:00','Evacuation policies right now?','When are we supposed to leave the area?'),
    (10,15,0,'2020-11-22 00:00:00','Lost dog','Hi, when my family was leaving the house our dog got frightened and ran away. He is a black terrier mix. Has anyone seen him?'),
    (11,13,0,'2020-11-22 00:00:00','Help needed at high school gym on main','We could use volunteers at this evacuation site to set up beds and equipment. Thanks!'),
    (12,8,0,'2020-11-22 00:00:00','Lost child','Not sure if this is the right forum for this but my 3 year old son, Jeremy Higgins, disappeared at a Walmart and we are distraught. If anyone has seen him, please contact me or the police.'),
    (13,12,0,'2020-11-22 00:00:00','open shelters near me','Are there any shelters with open spaces right now? I cannot find any that have any spots.'),
    (14,7,0,'2020-11-22 00:00:00','temporary housing in cookesville','My house was destroyed last night and I am trying to find housing for the next few months - does anyone know of any places?'),
    (15,7,0,'2020-11-22 00:00:00','volunteers needed in chatsworth','We have a rescue site set up at a high school and need help.'),
    (10,14,0,'2020-11-22 00:00:00','places to sleep?','hi, what temporary living options are there right now?'),
    (6,15,0,'2020-11-22 00:00:00','places to donate','Here are some links to places to donate to help our community right now.') 
;

INSERT INTO Comments (userID, postID, commentContent, timeStamps) values
	(12,1,'I can help! Just sent an email', '2020-11-22 09:00:00'),
	(8,2, 'Thanks for the heads up, was just about to travel that way', '2020-11-22 09:00:00'),
	(10,4, 'I think the high school still has some spots', '2020-11-22 09:00:00'),
	(9,17, 'thanks for this list','2020-11-22 08:00:00'),
	(13,17, 'Sorry about the loss your community is facing right now','2020-11-22 08:55:00')
;