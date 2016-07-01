package com.target.myretail.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("online_description")
    private OnlineDescription onlineDescription;

    public OnlineDescription getOnlineDescription() {
        return onlineDescription;
    }

    public void setOnlineDescription(OnlineDescription onlineDescription) {
        this.onlineDescription = onlineDescription;
    }

    @Override
    public String toString() {
        return "Item [onlineDescription=" + onlineDescription + "]";
    }

}
