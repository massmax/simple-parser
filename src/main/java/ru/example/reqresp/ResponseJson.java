package ru.example.reqresp;

import ru.example.reqresp.obj.ResumeObj;

import java.util.List;

public class ResponseJson {

    private List<ResumeObj> respList;

    public List<ResumeObj> getRespList() {
        return respList;
    }
    public void setRespList(List<ResumeObj> respList) {
        this.respList = respList;
    }
}
