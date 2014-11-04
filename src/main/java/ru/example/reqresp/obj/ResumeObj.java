package ru.example.reqresp.obj;


import java.io.Serializable;
import java.util.Date;

public class ResumeObj implements Serializable {

    private String emitent;
    private Date emissionDate;
    private String emSgtin;

    public String getEmitent() {
        return emitent;
    }

    public void setEmitent(String emitent) {
        this.emitent = emitent;
    }


    public String getEmSgtin() {
        return emSgtin;
    }

    public void setEmSgtin(String emSgtin) {
        this.emSgtin = emSgtin;
    }

    @SuppressWarnings("all")
    public Date getEmissionDate() {
        return emissionDate;
    }

    @SuppressWarnings("all")
    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }
}
