package ru.example.services.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.example.model.Resume;
import ru.example.services.IResumeService;

import java.util.List;

public class ResumeServiceImpl implements IResumeService {
    @Override
    @Transactional
    public Resume createResume(Resume resume) {
        return null;
    }

    @Override
    @Transactional
    public List<Resume> getAllResume() {
        return null;
    }

    @Override
    @Transactional
    public Resume updateResume(Integer id) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public Resume findResume(Resume resume) {
        return null;
    }
}
