CREATE DATABASE tasktracker;
USE tasktracker;

CREATE TABLE category (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE task (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      due_date DATE,
                      priority VARCHAR(20),
                      completed BOOLEAN DEFAULT FALSE,
                      category_id BIGINT,
                      CONSTRAINT fk_category
                          FOREIGN KEY (category_id) REFERENCES category(id)
                              ON DELETE SET NULL
);

INSERT INTO category (name) VALUES
                                ('Work'),
                                ('Personal'),
                                ('Fitness'),
                                ('Shopping');

INSERT INTO task (title, description, due_date, priority, completed, category_id)
VALUES
    ('Finish AWS Project', 'Lambda + DynamoDB integration', '2025-11-20', 'HIGH', false, 1),
    ('Go to Gym', 'Leg day workout', '2025-11-15', 'MEDIUM', false, 3),
    ('Buy Groceries', 'Eggs, milk, bread', '2025-11-14', 'LOW', true, 4),
    ('Team Meeting', 'Sprint planning with dev team', '2025-11-13', 'HIGH', false, 1),
    ('Read 20 Pages', 'Read Mistborn or Stormlight', '2025-11-18', 'LOW', false, 2);

