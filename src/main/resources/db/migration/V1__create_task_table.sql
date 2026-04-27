CREATE SCHEMA IF NOT EXISTS spring;

CREATE SEQUENCE IF NOT EXISTS spring.task_seq
    START WITH 1
    INCREMENT BY 50
    MINVALUE 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS spring.task (
    task_id BIGINT PRIMARY KEY DEFAULT nextval('spring.task_seq'),
    description VARCHAR(300) NOT NULL,
    creation_date TIMESTAMP WITH TIME ZONE NOT NULL,
    due_date DATE
);

ALTER SEQUENCE spring.task_seq OWNED BY spring.task.task_id;
