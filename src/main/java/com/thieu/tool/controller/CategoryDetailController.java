package com.thieu.tool.controller;


import com.thieu.tool.models.CategoryDetails;
import com.thieu.tool.services.CategoryDetailService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cate-detail/")
public class CategoryDetailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDetailController.class);

    @Autowired
    private CategoryDetailService service;

    @GetMapping("suggestion/{cateDetailsType}")
    public ResponseObject suggestListItem(@PathVariable("cateDetailsType") String cateDetailsType) {
        ResponseObject responseObject = new ResponseObject();
        try {
            List<CategoryDetails> listItem = service.suggestItem(cateDetailsType);
            if (listItem != null) {
                responseObject.setData(listItem);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call requestProductDetail in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("{cateDetailsType}/list-supplier")
    public ResponseObject suggestSupplier(@PathVariable("cateDetailsType") String cateDetailsType){
        ResponseObject responseObject = new ResponseObject();
        try {
            List<CategoryDetails> listSupplier = service.suggestListSupplier(cateDetailsType);
            if (listSupplier != null) {
                responseObject.setData(listSupplier);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call requestProductDetail in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

}
