-- ========================
-- FILE TABLE
-- ========================
INSERT INTO file (id, image) VALUES
                                 (10, '/images/tk.jpg'),
                                 (11, 'images/lik.jpg'),
                                 (12, '/images/batman.jpg');

-- ========================
-- MOVIE TABLE
-- ========================
INSERT INTO movie (movie_id, movie_name, price, description, date, file_id) VALUES
                                                                                (1, 'Doctor', 150, 'The theme highlights prevention over cure', '2024-01-01', 12),
                                                                                (2, 'TK', 250, 'Focuses on women agency and family dynamics', '2022-10-01', 10),
                                                                                (3, 'Batman', 200, 'Superhero movie', '2024-01-01', 11);

-- ========================
-- THEATRE TABLE
-- ========================
INSERT INTO theatre (theatre_id, theatre_name, tickets) VALUES
                                                            (1, 'PVR', 50),
                                                            (2, 'INOX', 20),
                                                            (4, 'Vetri Theatre', 5);

-- ========================
-- USERS TABLE
-- ========================
INSERT INTO users (user_id, email, name, password) VALUES
                                                       (1, 'admin@admin.com', 'admin', 'pass'),
                                                       (2, 'dhanu@xyz.com', 'dhanu', 'pass');

-- ========================
-- ROLE TABLE
-- ========================
INSERT INTO role (id, name) VALUES
                                (1, 'ROLE_ADMIN'),
                                (2, 'ROLE_USER');

-- ========================
-- USERS_ROLES TABLE
-- ========================
INSERT INTO users_roles (user_id, role_id) VALUES
                                               (1, 1),
                                               (2, 2);

-- ========================
-- THEATRE_MOVIE TABLE
-- ========================
INSERT INTO theatre_movie (theatre_id, movie_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (1, 3);