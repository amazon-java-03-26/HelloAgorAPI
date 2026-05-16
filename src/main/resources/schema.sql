DROP TABLE IF EXISTS user_followed_philosophers;
DROP TABLE IF EXISTS quote;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_profile;
DROP TABLE IF EXISTS philosopher;

CREATE TABLE philosopher
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(255),
    school     VARCHAR(255),
    birth_year INT,
    biography  TEXT
);

CREATE TABLE quote
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    content        TEXT,
    topic          VARCHAR(255),
    philosopher_id BIGINT,
    CONSTRAINT fk_quote_philosopher
        FOREIGN KEY (philosopher_id)
            REFERENCES philosopher (id)
);

CREATE TABLE user_profile
(
    id                         BIGINT PRIMARY KEY AUTO_INCREMENT,
    country                    VARCHAR(255),
    age                        INT,
    favorite_school_of_thought VARCHAR(255),
    bio                        TEXT
);

CREATE TABLE users
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    username   VARCHAR(255),
    email      VARCHAR(255),
    profile_id BIGINT UNIQUE,
    CONSTRAINT fk_user_profile
        FOREIGN KEY (profile_id)
            REFERENCES user_profile (id)
);

CREATE TABLE user_followed_philosophers
(
    user_id        BIGINT,
    philosopher_id BIGINT,

    PRIMARY KEY (user_id, philosopher_id),

    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES users (id),

    CONSTRAINT fk_philosopher
        FOREIGN KEY (philosopher_id)
            REFERENCES philosopher (id)
);