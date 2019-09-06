package com.thieu.tool.services;

import com.thieu.tool.mappers.*;
import com.thieu.tool.models.*;
import com.thieu.tool.shared.CommonStrings;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsService.class);


    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private ProductImageMapper imageMapper;

    @Autowired
    private ProductCatalogMapper catalogMapper;

    @Autowired
    private SupplierProductMapper supplierProductMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;


    public List<Products> searchProducts(String name) {
        List<Products> service = productsMapper.searchProducts(name);
        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call searchProducts in ProductsService class: .");
            return null;
        }

    }

    public List<Products> requestProductDetail(String cateDetailsType) {
        List<Products> service = productsMapper.requestProduct(cateDetailsType);
        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call searchProducts in ProductsService class: .");
            return null;
        }
    }


    public List<Products> getInfoProduct() {
        List<Products> service = productsMapper.getDataProduct();
        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call getInfoProduct in ProductsService class: .");
            return null;
        }
    }

    public ResponseObject createProduct(Products products, List<ProductImage> item, List<ProductCatalog> catalog, int arg, List<ProductDetail> details) {
        ResponseObject responseObject = new ResponseObject();
        try {
            int result = productsMapper.createProduct(products);
            if (result > 0) {

                /* Product Image */
                for (ProductImage product : item) {
                    product.setProductId(products.getProductId());
                }
                int images = imageMapper.addImageForProduct(item);

                /* Product Catalog */
                for (ProductCatalog pdCatalog : catalog) {
                    pdCatalog.setProductId(products.getProductId());
                }
                int pdCatalog = catalogMapper.addProductCatalog(catalog);

                /* Supplier Product */
                SupplierProduct supplierProduct = new SupplierProduct();
                supplierProduct.setProductId(products.getProductId());
                supplierProduct.setIsActive(products.getIsActiveProduct());
                supplierProduct.setSupplierProfileId(arg);

                int sp = supplierProductMapper.createSupplierProduct(supplierProduct);

                /* Product Detail */
                if (details.size() != 0) {
                    for (ProductDetail productDetail : details) {
                        productDetail.setProductId(products.getProductId());
                        productDetail.setStatus("Còn hàng !");
                    }

                    int pd = productDetailMapper.addProductDistinct(details);
                }
                responseObject.setSuccess(true);
                responseObject.setMessage(CommonStrings.RESP_MSG_SUCCESS);
            } else {
                responseObject.setSuccess(false);
                responseObject.setMessage(CommonStrings.RESP_MSG_SERVER_ERROR);
            }
        } catch (Exception e) {
            LOGGER.error("Error when call createProduct in ProductsService class: .", e);
            return ResponseObject.FAILURE;
        }
        return responseObject;
    }


    public List<Products> getListProductFromCategorySetting(String name) {
        List<Products> service = productsMapper.getListProductFromSetting(name);
        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call getListProductFromCategorySetting in ProductsService class: .");
            return null;
        }
    }

    public List<Products> getListProductFromCategoryDetail(String typeDetail) {
        List<Products> service = productsMapper.getListProductCategoryDetail(typeDetail);
        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call getListProductFromCategoryDetail in ProductsService class: .");
            return null;
        }
    }

    public Products getListProductDetail(String nameProduct) {
        Products service = productsMapper.getListProductDetail(nameProduct);
        if (service != null) {
            return service;
        } else {
//            LOGGER.error("Error when call getListProductDetail in ProductsService class: .");
            return new Products();
        }
    }


    public Products getProductByProductName(String nameProduct) {
        Products service = productsMapper.getInfoProductByProductName(nameProduct);

        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call getListProductDetail in ProductsService class: .");
            return null;
        }
    }


    public int updateProductQuantity(List<Products> products) {
        try {
            for (int i = 0; i < products.size(); i++) {
                int result = productsMapper.updateQuantityProduct(products.get(i).getProductQuantity(), products.get(i).getProductId());
            }
            return 1;
        } catch (Exception e) {
            LOGGER.error("Error when call updateOrderUser in ProductsService class: .", e);
            return 0;
        }
    }

    public int resetProductQuantity(int productId) {
        try {
            int result = productsMapper.resetQuantityProduct(productId);
            return 1;
        } catch (Exception e) {
            LOGGER.error("Error when call resetProductQuantity in ProductsService class: .", e);
            return 0;
        }
    }

    public int updateProduct(int productQuantity, int productId) {
        try {
            int result = productsMapper.updateQuantityProduct(productQuantity, productId);
            return 1;
        } catch (Exception e) {
            LOGGER.error("Error when call updateProduct in ProductsService class: .", e);
            return 0;
        }
    }

    public int updateProductDetailQuantity(List<ProductDetail> details) {
        try {
            for (int i = 0; i < details.size(); i++) {
                int result = productDetailMapper.updateQuantityProductDetail(details.get(i).getQuantity(), details.get(i).getProductDetailId());
            }
            return 1;
        } catch (Exception e) {
            LOGGER.error("Error when call updateProductDetailQuantity in ProductsService class: .", e);
            return 0;
        }
    }

    public int updateProductDetail(int quantity, int productDetailId) {
        try {
            int result = productDetailMapper.updateQuantityProductDetail(quantity, productDetailId);
            return 1;
        } catch (Exception e) {
            LOGGER.error("Error when call updateProductDetail in ProductsService class: .", e);
            return 0;
        }
    }

    public int resetProductDetailQuantity(int productDetailId) {
        try {
            int result = productDetailMapper.resetQuantityProductDetail(productDetailId);
            return 1;
        } catch (Exception e) {
            LOGGER.error("Error when call resetProductDetailQuantity in ProductsService class: .", e);
            return 0;
        }
    }


    public List<Products> searchByNameProducts(String name) {
        List<Products> service = productsMapper.searchProductsByName(name);
        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call searchByNameProducts in ProductsService class: .");
            return null;
        }
    }

    public List<ProductDetail> showProductDetails(int productId) {
        List<ProductDetail> service = productDetailMapper.showProductDetail(productId);
        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call showProductDetails in ProductsService class: .");
            return null;
        }
    }

    public SupplierProduct existSupplier(SupplierProduct supplierProduct) {
        SupplierProduct service = supplierProductMapper.checkExistSupplierBuy(supplierProduct);
        if (service != null) {
            return service;
        } else {
            return null;
        }
    }

    public int addProductDetailForSupplier(SupplierProduct supplierProduct) {
        try {
            SupplierProduct supplier = new SupplierProduct();
            supplier.setSupplierProfileId(supplierProduct.getSupplierProfileId());
            supplier.setProductId(supplierProduct.getProductId());
            supplier.setIsActive(1);
            supplier.setProductDetailId(supplierProduct.getProductDetailId());

            int result = supplierProductMapper.addProductForSupplier(supplier);
            return 1;
        } catch (Exception e) {
            LOGGER.error("Error when call addProductDetailForSupplier in ProductsService class: .", e);
            return 0;
        }
    }

    public int compareProductName(String productNameCompare) {
        int result = productsMapper.checkNameProduct(productNameCompare);
        if (result >0) {
            return result;
        } else {
            return 0;
        }
    }

}
