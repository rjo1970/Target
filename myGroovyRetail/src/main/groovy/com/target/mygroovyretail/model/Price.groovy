package com.target.mygroovyretail.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

/**
 * Created by jrtitko1 on 8/6/16.
 */
class Price {

    @Id
    Integer id

    Double value

    @JsonProperty("currency_code")
    String currencyCode;

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", value=" + value +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
