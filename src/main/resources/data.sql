INSERT INTO philosopher(name, school, birth_year, biography)
VALUES
    ('Socrates', 'Classical Greek', -470, 'Known for the Socratic method'),
    ('Nietzsche', 'Existentialism', 1844, 'God is dead philosopher'),
    ('Marcus Aurelius', 'Stoicism', 121, 'Roman emperor and stoic');

INSERT INTO quote(content, topic, philosopher_id)
VALUES
    ('The unexamined life is not worth living.', 'Life', 1),
    ('He who has a why can bear almost any how.', 'Meaning', 2),
    ('You have power over your mind, not outside events.', 'Stoicism', 3);

INSERT INTO user_profile(country, age, favorite_school_of_thought, bio)
VALUES
    ('Spain', 28, 'Stoicism', 'Loves philosophy and coffee'),
    ('Italy', 31, 'Existentialism', 'Reads Nietzsche at midnight');

INSERT INTO users(username, email, profile_id)
VALUES
    ('salvatore', 'salvatore@example.com', 1),
    ('lisa', 'lisa@example.com', 2);

INSERT INTO user_followed_philosophers(user_id, philosopher_id)
VALUES
    (1, 1),
    (1, 3),
    (2, 2);