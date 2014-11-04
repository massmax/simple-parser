package ru.example.services;

import org.springframework.stereotype.Service;
import ru.example.model.Resume;

import java.util.List;

@Service
public interface IResumeService {
    public Resume createResume(Resume resume);
    public List<Resume> getAllResume();
    public Resume updateResume(Integer id) throws Exception;
    public Resume findResume(Resume resume);
}
