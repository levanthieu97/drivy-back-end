package com.thieu.tool.controller;

import com.thieu.tool.models.*;
import com.thieu.tool.services.ProductsService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/products/")
public class ProductsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    private ProductsService service;

    @GetMapping("all")
    public ResponseObject searchProduct(@RequestParam String name) {
        ResponseObject responseObject = new ResponseObject();
        try {
            List<Products> products = service.searchProducts(name);
            if (products != null) {
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call searchProduct in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("product-detail")
    public ResponseObject requestProductDetails(@RequestParam String cateDetailsType) {
        ResponseObject responseObject = new ResponseObject();
        try {
            List<Products> productsDetails = service.requestProductDetail(cateDetailsType);
            if (productsDetails != null) {
                responseObject.setData(productsDetails);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call searchProduct in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("random-product")
    public ResponseObject requestInfoProduct(){
        ResponseObject responseObject = new ResponseObject();
        try{
            List<Products> products = service.getInfoProduct();
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call requestInfoProduct in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @PostMapping("new-product")
    public ResponseObject createProduct(@Valid @RequestBody ProductConvert products) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Products newProduct = new Products(products.getProductName(), products.getProductDescription()
                    , products.getShortDescription(), products.getProductCode(), products.getProductQuantity()
                    ,products.getCategoryDetailId(), products.getPrice(), products.getAlterPrice(), products.getStoreSupplier(),products.getIsActiveProduct());
            if (newProduct != null) {
                newProduct.setCreateDate(new Date());
                newProduct.setIsActive(products.getIsActiveProduct());
                String st = products.getProductImage();
                String base64Data = st.split(",")[1];
                newProduct.setProductImage(Base64.getDecoder().decode(base64Data));

                List<ProductImage> productImages = new ArrayList<>();
                for (int i = 0; i < products.getPath().size(); i++) {
                    ProductImage newProductImage = new ProductImage();
                    String base64Image = products.getPath().get(i).split(",")[1];
                    newProductImage.setPicture(Base64.getDecoder().decode(base64Image));
                    productImages.add(newProductImage);
                }

                List<ProductCatalog> productCatalogs = new ArrayList<>();
                for (int i = 0; i < products.getPdCatalog().size(); i++) {
                    ProductCatalog pdCatalog = new ProductCatalog();
                    pdCatalog.setCatalogId(products.getPdCatalog().get(i));
                    productCatalogs.add(pdCatalog);
                }

                int supplierProduct = products.getSupplierProduct();

                for(int i =0; i < products.getProductDetail().size(); i++){
                    String base64Image = products.getImageDetail().get(i).split(",")[1];

                    products.getProductDetail().get(i).setPdImage(Base64.getDecoder().decode(base64Image));
                }


                responseObject.setData(service.createProduct(newProduct, productImages, productCatalogs, supplierProduct, products.getProductDetail()));
                responseObject.setSuccess(true);
                responseObject.setMessage("Tạo sản phẩm thành công !!!");
            } else {
                responseObject.setSuccess(false);
                responseObject.setMessage("Create product Failed!!!");
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call createProduct in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @GetMapping("list-setting-product/{settingName}")
    public ResponseObject requestSettingProduct(@PathVariable("settingName") String settingName){
        ResponseObject responseObject = new ResponseObject();
        try{
            List<Products> products = service.getListProductFromCategorySetting(settingName);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call requestSettingProduct in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    };

    @GetMapping("list-detail-product/{typeDetail}")
    public ResponseObject requestProductDetail(@PathVariable("typeDetail") String typeDetail){
        ResponseObject responseObject = new ResponseObject();
        try{
            List<Products> products = service.getListProductFromCategoryDetail(typeDetail);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call requestProductDetail in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("info-detail/{productName}")
    public ResponseObject requestListProductDetail(@PathVariable("productName") String productName){
        ResponseObject responseObject = new ResponseObject();
        try{
            Products products = service.getListProductDetail(productName);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call requestListProductDetail in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }




    @GetMapping("information-product/{productName}")
    public ResponseObject getInfoProductByProductName(@PathVariable("productName") String productName){
        ResponseObject responseObject = new ResponseObject();
        try {
            Products products = service.getProductByProductName(productName);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e){
            LOGGER.error("Error when call getInfoProductByProductName in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @PutMapping("update-quantity")
    public ResponseObject updateProductQuantity(@RequestBody List<Products> products){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.updateProductQuantity(products);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call updateProductQuantity in ProductsController class: .", e);
            return responseObject.FAILURE;
        }
    }


    @PutMapping("update-quantity-detail")
    public ResponseObject updateQuantityProductDetail(@RequestBody List<ProductDetail> productDetails){
        ResponseObject responseObject = new ResponseObject();
        try{

            int result = service.updateProductDetailQuantity(productDetails);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call updateQuantityProductDetail in ProductsController class: .", e);
            return responseObject.FAILURE;
        }
    }


    @PutMapping("update-product-quantity")
    public ResponseObject updateProductQuantity(@RequestParam int productQuantity,@RequestParam int productId){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.updateProduct(productQuantity,productId);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call updateProductQuantity in ProductsController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @PutMapping("update-product-quantity-detail")
    public ResponseObject updateQuantityProductDetail(@RequestParam int quantity, @RequestParam int productDetailId){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.updateProductDetail(quantity,productDetailId);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call updateQuantityProductDetail in ProductsController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @PutMapping("reset-product-quantity")
    public ResponseObject resetQuantity(@RequestParam int productId){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.resetProductQuantity(productId);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call resetQuantity in ProductsController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @PutMapping("reset-product-quantity-detail")
    public ResponseObject resetQuantityDetail(@RequestParam int productDetailId){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.resetProductDetailQuantity(productDetailId);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call resetQuantityDetail in ProductsController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @GetMapping("product-name")
    public ResponseObject searchProductsByName(@RequestParam String productName){
        ResponseObject responseObject = new ResponseObject();
        try{
            List<Products> products = service.searchByNameProducts(productName);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call searchProductsByName in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("show-product-detail")
    public ResponseObject showProductDetail(@RequestParam int productId){
        ResponseObject responseObject = new ResponseObject();
        try{
            List<ProductDetail> products = service.showProductDetails(productId);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call showProductDetail in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @PostMapping("exist-product")
    public ResponseObject checkExistProduct(@RequestBody SupplierProduct supplierProduct){
        ResponseObject responseObject = new ResponseObject();
        try {
            SupplierProduct products = service.existSupplier(supplierProduct);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e){
            LOGGER.error("Error when call checkExistProduct in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @PostMapping("add-product-supplier")
    public ResponseObject addProductForSupplier(@RequestBody SupplierProduct supplierProduct){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.addProductDetailForSupplier(supplierProduct);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call updateQuantityProductDetail in ProductsController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @GetMapping("compare-name-product")
    public ResponseObject checkProductName(@RequestParam String productNameCompare){
        ResponseObject responseObject = new ResponseObject();
        try {
            int result = service.compareProductName(productNameCompare);
            if (result >= 0) {
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call checkProductName in SupplierController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

}
