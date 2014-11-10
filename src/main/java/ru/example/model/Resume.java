package ru.example.model;

import javax.persistence.*;

@Entity
@Table (name = "resume")
public class Resume {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column
    private String name;

    @Column
    private String institution;

    @Column
    private String header;

    @Column
    private String birthday;

    @Column
    private String city;

    @Column
    private String education;

    @Column
    private String education_speciality;

    @Lob
    @Column(length=100000)
    private String experience;

    @Column
    private String experience_length;

    @Column
    private String salary;

    @Column
    private String urle1;

    @Column
    private String age;

    @Column
    private String info;

    @Lob
    @Column(length=100000)
    private String personal_qualities;

    @Column
    private String ide1;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getInstitution() {
        return institution;
    }
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation_speciality() {
        return education_speciality;
    }
    public void setEducation_speciality(String education_speciality) {
        this.education_speciality = education_speciality;
    }

    public String getExperience() {
        return experience;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperience_length() {
        return experience_length;
    }
    public void setExperience_length(String experience_length) {
        this.experience_length = experience_length;
    }

    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getUrle1() {
        return urle1;
    }
    public void setUrle1(String urle1) {
        this.urle1 = urle1;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public String getPersonal_qualities() {
        return personal_qualities;
    }
    public void setPersonal_qualities(String personal_qualities) {
        this.personal_qualities = personal_qualities;
    }

    public String getIde1() {
        return ide1;
    }
    public void setIde1(String ide1) {
        this.ide1 = ide1;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
