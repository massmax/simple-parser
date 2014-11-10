package ru.example.controller;

import com.mysema.query.types.expr.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.example.model.QResume;
import ru.example.model.Resume;
import ru.example.parser.Parser;
import ru.example.parser.ParserResumeE1;
import ru.example.repository.ResumeRepository;
import ru.example.reqresp.RequestSearchJson;
import ru.example.reqresp.ResponseJson;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private final static String HEADER = "header";
    private final static String ALL = "all";

    @Qualifier("resumeRepository")
    @Autowired
    private ResumeRepository repository;

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public ModelAndView indexGet() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/load", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseJson loadGet() {
        Parser parser = new ParserResumeE1();
        List<Resume> list = parser.parse();
        saveList(list);

        Page<Resume> list1 = repository.findAll(new PageRequest(0, 10, Sort.Direction.ASC,"id"));
        ResponseJson response = new ResponseJson();
        response.setCountPage(repository.findAll().size());
        response.setRespList(list1.getContent());
        return response;
    }

    @RequestMapping(value = "/page/{number}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseJson listResumes(@PathVariable("number") Integer number) {
        Page<Resume> list = repository.findAll(new PageRequest(number, 10, Sort.Direction.ASC, "id"));

        ResponseJson response = new ResponseJson();
        response.setRespList(list.getContent());
        return response;
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseJson searchPost(@RequestBody RequestSearchJson request) {
        String strSearch = request.getRequestStr();
        String[] arrayStr = strSearch.split(" ");
        BooleanExpression predicate = QResume.resume.header.contains(strSearch);
        if (arrayStr.length > 0 ) {
            for(String s : arrayStr) {
                predicate = predicate.and(QResume.resume.header.contains(s));
            }
        }
        List<Resume> list = (List<Resume>) repository.findAll(predicate);

        ResponseJson response = new ResponseJson();
        response.setCountPage(list.size());
        response.setRespList(list);
        return response;
    }

    @Transactional
    private void saveList(List<Resume> list) {
        for (Resume resume : list) {
            repository.saveAndFlush(resume);
        }
    }

}
