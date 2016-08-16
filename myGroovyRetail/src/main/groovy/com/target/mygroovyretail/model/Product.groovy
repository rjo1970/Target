package com.target.mygroovyretail.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by jrtitko1 on 8/6/16.
 */
@JsonInclude(Include.NON_EMPTY)
class Product {

    Integer id
    String name

    @JsonProperty("current_price")
    Price currentPrice


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
