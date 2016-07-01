package com.target.myretail.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {

    @JsonProperty("product_composite_response")
    private ProductCompositeResponse productCompositeResponse;

    public ProductCompositeResponse getProductCompositeResponse() {
        return productCompositeResponse;
    }

    public void setProductCompositeResponse(ProductCompositeResponse productCompositeResponse) {
        this.productCompositeResponse = productCompositeResponse;
    }

    @Override
    public String toString() {
        return "Response [productCompositeResponse=" + productCompositeResponse + "]";
    }
    
    
}
