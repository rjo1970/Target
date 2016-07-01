package com.target.myretail.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {

    @Id
    private Integer id;

    private Double value;
    
    @JsonProperty("currency_code")
    private String currencyCode;

    public Price() {
        super();
    }

    public Price(Integer id, Double value, String currencyCode) {
        this.setId(id);
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "Price [id=" + id + ", value=" + value + ", currencyCode=" + currencyCode + "]";
    }

}
