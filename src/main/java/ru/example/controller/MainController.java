package ru.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.example.repository.ResumeRepository;
import ru.example.reqresp.RequestJson;
import ru.example.reqresp.ResponseJson;
import ru.example.services.IResumeService;

import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Qualifier("resumeRepository")
    @Autowired
    private ResumeRepository service;

//    @RequestMapping(value = "/index",  method = RequestMethod.GET)
//    public @ResponseBody List getResumeList() {
//        return service.findAll();
//    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public ModelAndView methodGet() {
        return new ModelAndView("index");
    }

//    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
//    @ResponseBody
//    public ResponseJson methodPost(@RequestBody RequestJson request) {
//        String delims = "[;]";
//
//        String[] arrSgtin = request.getRequestStr().split(delims);
//        Set<String> sgtins = new HashSet<>(Arrays.asList(arrSgtin));
//        List<EmObj> emObjList = new ArrayList<>();
//        List<GoodObj> goodObjList = new ArrayList<>();
//        List<SaleObj> saleObjList = new ArrayList<>();
//        for (String sgtin : sgtins) {
//            if (!sgtin.startsWith("urn:epc:tag:sgtin-96:")) {
//                sgtin = "urn:epc:tag:sgtin-96:" + sgtin;
//            }
//            fillEmission(sgtin, emObjList);
//            fillGoods(sgtin, goodObjList);
//            fillSale(sgtin, saleObjList);
//        }
//        ResponseJson resp = new ResponseJson();
//        resp.setRespEmList(emObjList);
//        resp.setRespGoodList(goodObjList);
//        resp.setRespSaleList(saleObjList);
//        return resp;
//    }

}
