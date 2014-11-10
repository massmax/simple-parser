package ru.example.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ru.example.model.Resume;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ParserResumeE1 implements Parser {

    private static final String URL1 = "http://rabota.e1.ru/api/v1/resumes/?limit=100&offset=";
    private static final String URL2 = "&search_key=1z7sn9e&auth_token=&q=&average_salary=true";

    @Override
    public List<Resume> parse() {
        String urlString;
        List<Resume> listResume = new ArrayList<Resume>();
        BufferedReader reader = null;
        String resultJson = "";
        HttpURLConnection urlConnection = null;
        int offset = 0;
        while (offset < 1000) {
            try {
                urlString = URL1 + String.valueOf(offset) + URL2;
                URL url = new URL(urlString);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder buffer = new StringBuilder();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                resultJson = buffer.toString();
                List<Resume> temp = parseJson(resultJson);
                listResume.addAll(temp);
                offset = offset + 100;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listResume;
    }


    private List<Resume> parseJson(String json) {
        JSONObject dataJsonObj = null;
        Resume resumeObj = null;
        List<Resume> tempList = new ArrayList<Resume>();
        try {
            dataJsonObj = new JSONObject(json);
            JSONArray resumes = dataJsonObj.getJSONArray("resumes");

            for (int i = 0; i < resumes.length(); i++) {
                resumeObj = new Resume();
                JSONObject resume = resumes.getJSONObject(i);
                resumeObj.setBirthday(resume.getString("birthday")==null?"":resume.getString("birthday"));
                JSONObject contactResume = resume.getJSONObject("contact");
                resumeObj.setName(contactResume.getString("name"));
                JSONObject titleCity = contactResume.getJSONObject("city");
                resumeObj.setCity(titleCity.getString("title"));
                resumeObj.setInstitution(resume.getString("institution"));
                resumeObj.setHeader(resume.getString("header"));
                resumeObj.setEducation(resume.getString("education"));
                resumeObj.setEducation_speciality(resume.getString("education_specialty"));
                resumeObj.setExperience(resume.getString("experience"));

                if ( !resume.isNull("experience_length") ) {
                    JSONObject experience_length = resume.getJSONObject("experience_length");
                    resumeObj.setExperience_length(experience_length.getString("title"));
                } else {resumeObj.setExperience_length("неизвестно");}

                resumeObj.setSalary(resume.getString("salary"));
                resumeObj.setUrle1(resume.getString("url"));
                resumeObj.setAge(resume.getString("age")==null?"":resume.getString("age"));
                resumeObj.setInfo(resume.getString("info_short"));
                resumeObj.setPersonal_qualities(resume.getString("personal_qualities"));
                resumeObj.setIde1(resume.getString("id"));

                tempList.add(resumeObj);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return tempList;
    }
}