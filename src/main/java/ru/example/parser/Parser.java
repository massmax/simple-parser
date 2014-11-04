package ru.example.parser;


import ru.example.model.Resume;

import java.util.List;

public interface Parser {
    public List<Resume> parse() throws Exception;
}
