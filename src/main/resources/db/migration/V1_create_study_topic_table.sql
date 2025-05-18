CREATE TABLE study_topic (
    id BIGSERIAL PRIMARY KEY,
    study_topic VARCHAR(100) NOT NULL,
    current_knowledge VARCHAR(50) NOT NULL,
    time_available int NOT NULL,
    due_date DATE NOT NULL,
    study_style VARCHAR(50) NOT NULL,
    objective VARCHAR(255) NOT NULL
);