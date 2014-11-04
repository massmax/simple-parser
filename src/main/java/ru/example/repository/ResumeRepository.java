package ru.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.example.model.Resume;

@Repository
//public interface ResumeRepository extends JpaRepository<Resume, Integer>, QueryDslPredicateExecutor<Resume> {
public interface ResumeRepository extends JpaRepository<Resume, Integer> {
}
