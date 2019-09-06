//package com.thieu.tool.services;
//
//import com.thieu.tool.mappers.ProductCatalogMapper;
//import com.thieu.tool.models.ProductCatalog;
//import com.thieu.tool.shared.CommonStrings;
//import com.thieu.tool.shared.ResponseObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductCatalogService {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatalogService.class);
//
//    @Autowired
//    private ProductCatalogMapper mapper;
//
//    public ResponseObject createProductCatalog(ProductCatalog productCatalog){
//        ResponseObject responseObject = new ResponseObject();
//        try {
//            int result = mapper.addProductCatalog(productCatalog);
//            if(result > 0){
//                responseObject.setSuccess(true);
//                responseObject.setMessage(CommonStrings.RESP_MSG_SUCCESS);
//            } else {
//                responseObject.setSuccess(false);
//                responseObject.setMessage(CommonStrings.RESP_MSG_SERVER_ERROR);
//            }
//        }catch (Exception e){
//            LOGGER.error("Error when call createProductCatalog in ProductCatalogService class: .", e);
//            return ResponseObject.FAILURE;
//        }
//        return responseObject;
//    }
//}
//package com.thieu.tool.services;
//
//import com.thieu.tool.mappers.ProductCatalogMapper;
//import com.thieu.tool.models.ProductCatalog;
//import com.thieu.tool.shared.CommonStrings;
//import com.thieu.tool.shared.ResponseObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductCatalogService {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatalogService.class);
//
//    @Autowired
//    private ProductCatalogMapper mapper;
//
//    public ResponseObject createProductCatalog(ProductCatalog productCatalog){
//        ResponseObject responseObject = new ResponseObject();
//        try {
//            int result = mapper.addProductCatalog(productCatalog);
//            if(result > 0){
//                responseObject.setSuccess(true);
//                responseObject.setMessage(CommonStrings.RESP_MSG_SUCCESS);
//            } else {
//                responseObject.setSuccess(false);
//                responseObject.setMessage(CommonStrings.RESP_MSG_SERVER_ERROR);
//            }
//        }catch (Exception e){
//            LOGGER.error("Error when call createProductCatalog in ProductCatalogService class: .", e);
//            return ResponseObject.FAILURE;
//        }
//        return responseObject;
//    }
//}
