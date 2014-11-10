package ru.example.reqresp;

import ru.example.model.Resume;

import java.util.List;

public class ResponseJson {

    private List<Resume> respList;
    private Integer countPage;

    public List<Resume> getRespList() {
        return respList;
    }
    public void setRespList(List<Resume> respList) {
        this.respList = respList;
    }

    public Integer getCountPage() {
        return countPage;
    }
    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
    }
}
