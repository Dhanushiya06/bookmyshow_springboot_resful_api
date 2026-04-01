-- ========================
-- FILE TABLE (Images)
-- ========================
INSERT INTO file (id, image) VALUES
                                 (10, '/images/tk.jpg'),
                                 (11, '/images/batman.jpg'),
                                 (12, '/images/et.jpg');

-- ========================
-- MOVIE TABLE
-- ========================
INSERT INTO movie (id, name, price, description, release_date, file_id) VALUES
                                                                            (1, 'Doctor', 150, 'The theme highlights prevention over cure', '2024-01-01', 12),
                                                                            (2, 'TK', 250, 'Focuses on women agency and family dynamics', '2022-10-01', 10),
                                                                            (3, 'Batman', 200, 'Superhero movie', '2024-01-01', 11);

-- ========================
-- THEATRE TABLE
-- ========================
INSERT INTO theatre (id, name, capacity) VALUES
                                             (1, 'PVR', 50),
                                             (2, 'INOX', 20),
                                             (4, 'Vetri Theatre', 5);

-- ========================
-- USERS TABLE
-- ========================
INSERT INTO users (id, email, username, password) VALUES
                                                      (1, 'admin@admin.com', NULL, '$2a$10$EzkrO3j4GqCj53MlwS2.oexxzwwUjqn1lhxCDs6VuDXnXBeCdnmiS'),
                                                      (2, 'dhanu@xyz.com', 'dhanu', '$2a$10$rntzya2Mp7QPmwcHDYiaKeI3o3iBHZpWYg5W5hQNrN8vd1ABodBAW'),
                                                      (7, NULL, NULL, '$2a$10$00CofIRD2Yili.zZk/ddyefHLKyr0Ac3n/9K.zpcuFf4OQKsu0yNe'),
                                                      (14, 'mani@xyz.com', 'mani', '$2a$10$nCuXwsbvdPW0zo8ha879gegS2sKY6nTMAfE.1wvtx/cFChBFV2Tn');

-- ========================
-- THEATRE_MOVIE MAPPING
-- ========================
INSERT INTO theatre_movie (theatre_id, movie_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (1, 3);