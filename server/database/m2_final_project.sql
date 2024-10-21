-- database m2_final_project
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tournament, weight_class, fighter, fight, registration, gym;


-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

--users (name is pluralized because 'user' is a SQL keyword)
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE tournament(
	tournament_id serial PRIMARY KEY,
	tournament_name VARCHAR(100) NOT NULL,
	location VARCHAR(50) NOT NULL,
	start_date DATE UNIQUE NOT NULL,
	end_date DATE UNIQUE NULL,
	img_url VARCHAR(255)
);

CREATE TABLE weight_class(
	weight_class_id serial PRIMARY KEY,
	weight_class_name VARCHAR (50),
	minimum_weight float ,
	maximum_weight float
);

CREATE TABLE gym (
	gym_id serial PRIMARY KEY,
	gym_name VARCHAR (50) NOT NULL,
	gym_location VARCHAR (50) NOT NULL,
	kru_name VARCHAR (50) NULL,
	overall_gym_record VARCHAR (50) NULL
);

CREATE TABLE fighter (
	fighter_id serial PRIMARY KEY,
	fighter_name VARCHAR (50) NOT NULL,
	current_weight_class_id int REFERENCES weight_class(weight_class_id) NOT NULL,
	fighter_experience_level VARCHAR (20) NOT NULL,
	fighter_age int NOT NULL,
	fighter_height VARCHAR (50) NOT NULL,
	fighter_gender VARCHAR (20) NOT NULL,
	fighter_record VARCHAR (100) NOT NULL,
	current_gym_id int REFERENCES gym(gym_id) NOT NULL,
	fighter_location VARCHAR (50) NOT NULL,
	fighter_email VARCHAR (50) NOT NULL,
	fighter_registration_status VARCHAR (50) NOT NULL,
	img_url VARCHAR(255)
);

CREATE TABLE fight(
	fight_id serial PRIMARY KEY,
	blue_corner_id int REFERENCES fighter(fighter_id)NOT NULL,
	red_corner_id int REFERENCES fighter(fighter_id) NOT NULL,
	winner VARCHAR (50) NOT NULL,
	loser VARCHAR (50) NOT NULL,
	win_type VARCHAR (50) NOT NULL,
	tournament_id int REFERENCES tournament(tournament_id)NOT NULL,
	fight_name VARCHAR (200) NOT NULL
);



CREATE TABLE registration(
	registration_id serial PRIMARY KEY,
	tournament_id int REFERENCES tournament(tournament_id)NOT NULL,
	fighter_id int REFERENCES fighter(fighter_id) NOT NULL,
	weight_class_id int REFERENCES weight_class(weight_class_id)NOT NULL,
	gym_id int REFERENCES gym(gym_id)NOT NULL

);

-- *************************************************************************************************
-- Insert some sample starting data
-- *************************************************************************************************

-- Users
-- Password for all users is password
INSERT INTO
    users (username, password_hash, role)
VALUES
    ('user', '$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_USER'),
    ('admin','$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_ADMIN');

INSERT INTO tournament (tournament_name, location, start_date, end_date, img_url)
VALUES
	('TBA Classic World Championships', 'Des Moines, Iowa', '2024-06-19', '2024-06-23', 'http://www.tbasanctioning.org/2024Expo/TBAGraphics.png'),
	('Tournament of Champions at The Arnold', 'Columbus, Ohio', '2024-02-28', '2024-03-02','https://img1.wsimg.com/isteam/ip/9bd496e6-b17e-45f3-8a19-192da667a12a/WebArnold.png/:/cr=t:0%25,l:0%25,w:100%25,h:100%25');

INSERT INTO weight_class (weight_class_name, minimum_weight, maximum_weight)
VALUES
	    ('Pin Weight', NULL, '102'),
        ('Atom Weight', '102.1', '107'),
        ('Straw Weight', '107.1', '112'),
        ('Fly Weight', '112.1', '117'),
        ('Bantam Weight', '117.1', '122'),
        ('Feather Weight', '122.1', '127'),
        ('Light Weight', '127.1', '132'),
        ('Super Light Weight', '132.1', '137'),
        ('Light Welter Weight', '137.1', '142'),
        ('Welter Weight', '142.1', '147'),
        ('Super Welter Weight', '147.1', '153'),
        ('Light Middle Weight', '153.1', '159'),
        ('Middle Weight', '159.1', '165'),
        ('Super Middle Weight', '165.1', '172'),
        ('Light Heavy Weight', '172.1', '179'),
        ('Light Cruiser Weight', '179.1', '186'),
        ('Cruiser Weight', '186.1', '195'),
        ('Heavy Weight', '195.1', '215'),
        ('Super Heavy Weight', '215.1', '250'),
        ('Colossal Weight', '250.1', NULL);

INSERT INTO gym (gym_name, gym_location, kru_name, overall_gym_record)
VALUES
	('Short North Muay Thai', 'Columbus, Ohio', 'Kru Hope', null),
	('Chicago Muay Thai', 'Chicago, Illinois', null, null),
	('Chonburi Muay Thai', 'Nashville, Tennessee', 'Kru Chonburi', '19-4-3'),
	('The Cellar Gym', 'Roseville, Minnesota', null, null),
	('Boss Thai Boxing', 'Kemptville, Ontario', 'Kru Boss', null);

INSERT INTO fighter (fighter_name, current_weight_class_id, fighter_experience_level, fighter_age, fighter_height,
		fighter_gender, fighter_record, current_gym_id, fighter_location, fighter_email, fighter_registration_status, img_url)
VALUES
	('Chun Li', 1, 'B Class', '43', '4ft 10in', 'Female', 'Muay Thai 3-1', 1,
	 'Columbus, Ohio', 'c.li@gmail.com', 'Confirmed','https://art.pixilart.com/sr2cd05a1da8eac.png' ),
	('Rose', 1, 'B Class', '23', '5ft 2in', 'Female', 'Muay Thai 1-0 Smokers 3-0', 3,
	 'Nashville, Tennessee', 'rboxer@yahoo.com', 'Confirmed','https://preview.redd.it/what-are-the-chances-for-rose-returning-to-street-fighter-6-v0-2w2jp7yip7yc1.jpeg?width=1080&crop=smart&auto=webp&s=4cc6a25b63a8366b549815bbf8bf2aa49f55d681'),
	 ('Kitana', 2, 'C Class/Novice', '43', '5ft 5in', 'Female', 'Muay Thai 0', 1,
	 'Columbus, Ohio', 'KT@gmail.com', 'Confirmed','https://cdn-prod.mortalkombat.com/roster/kitana/body.png'),
	 ('Sheeva', 2, 'C Class/Novice', '38', '5ft 3in', 'Female', 'Muay Thai 0-1 MMA 1-0', 2,
	 'Chicago, Illinois', 'sheeev@hotmail.com', 'Confirmed','https://wiki.supercombo.gg/images/4/47/Umk3_Sheeva_pose.png'),
	 ('Sonya Blade', 3, 'C Class/Novice', '36', '5ft 6in', 'Female', 'Muay Thai 0', 4,
	 'Roseville, Minnesota', 'sonya@gmail.com', 'Confirmed','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgarMRhbuJKvqS2-KY6PO9fET3jf6zOvgAiA&s'),
	 ('Mileena', 3, 'C Class/Novice', '38', '5ft 8in', 'Female', 'Muay Thai 0-1 ', 5,
	 'Kemptville, Ontario', 'mileena@hotmail.com', 'Confirmed','https://upload.wikimedia.org/wikipedia/en/e/ec/Mileena_-_MK1_render.webp'),
	 ('Sub-Zero', 4, 'A Class/Open', '43', '5ft 8in', 'Male', 'Muay Thai 6-1 Smokers 5-1', 1,
	 'Columbus, Ohio', 'sz@gmail.com', 'Confirmed','https://wiki.supercombo.gg/images/5/50/Umk3_Classic_Sub-Zero_pose.png'),
	 ('Johnny Cage', 4, 'A Class/Open', '38', '5ft 7in', 'Male', 'Muay Thai 24-8 8 KO/TKO MMA 1-0', 2,
	 'Chicago, Illinois', 'JohnnyC@hotmail.com', 'Confirmed','https://upload.wikimedia.org/wikipedia/en/7/7b/Johnny_Render_mk_11.png'),
	 ('E. Honda', 5, 'B Class', '31', '5ft 8in', 'Male', 'Muay Thai 6-1', 1,
	 'Columbus, Ohio', 'honda.e@gmail.com', 'Confirmed','https://www.ladose.net/wp-content/uploads/2018/01/SSF2T_E._Honda.png'),
	 ('Ryu', 5, 'B Class', '27', '6ft 7in', 'Male', 'Muay Thai 4-1', 2,
	 'Chicago, Illinois', 'ryu@hotmail.com', 'Confirmed','https://assets.vg247.com/current//2014/07/o7vij6.png');

	 INSERT INTO fight (blue_corner_id, red_corner_id, winner, loser, win_type, tournament_id, fight_name)
     VALUES
     	(1, 2, 'Chun Li', 'Rose', 'TKO', 1, 'Chun Li vs Rose'),
     	(3, 4, 'Sheeva', 'Kitana', 'Split', 2, 'Kitana vs Sheeva'),
     	(3, 4, 'Sheeva', 'Kitana', 'KO', 1, 'Sheeva vs Kitana'),
     	(5, 6, 'Sonya Blade', 'Mileena', 'Unanimous', 1, 'Mileena vs Sonya Blade'),
     	(7, 8, 'Johnny Cage', 'Sub-Zero', 'Split', 1, 'Johnny Cage vs Sub-Zero' ),
     	(8, 7, 'Sub-Zero', 'Johnny Cage', 'Split', 2, 'Sub-Zero vs Johnny Cage'),
     	(9, 10, 'E. Honda', 'Ryu', 'Forfeit', 2, 'Ryu vs E.Honda' );


     INSERT INTO registration (tournament_id, fighter_id, weight_class_id, gym_id)
     VALUES
     	(1,1,1,1),
     	(1,2,1,3),
     	(2,3,2,1),
     	(2,4,2,2),
     	(1,3,2,1),
     	(1,4,2,2),
     	(1,5,3,4),
     	(1,6,3,5),
     	(1,7,4,1),
     	(1,8,4,2),
     	(2,7,4,1),
     	(2,8,4,2),
     	(2,9,5,1),
     	(2,10,5,2);


COMMIT TRANSACTION;
