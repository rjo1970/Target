package com.target.myretail.model.productapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.myretail.exception.InformationUnavailableException;

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

    public String getItemOnlineDescription() throws InformationUnavailableException {
        try {
            return getProductCompositeResponse().getItems().get(0).getOnlineDescription().getValue();
        } catch (Exception e) {
            throw new InformationUnavailableException("Item Online Description is unavailable");
        }
    }
    
    @Override
    public String toString() {
        return "Response [productCompositeResponse=" + productCompositeResponse + "]";
    }
    
    
}
