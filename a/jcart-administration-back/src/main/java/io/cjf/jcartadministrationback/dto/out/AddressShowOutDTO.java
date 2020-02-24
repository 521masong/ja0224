package io.cjf.jcartadministrationback.dto.out;

public class AddressShowOutDTO {
    private Integer addressId;
    private Integer customerid;
    private String receivermobile;
    private String receivernames;
    private String content;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getReceivermobile() {
        return receivermobile;
    }

    public void setReceivermobile(String receivermobile) {
        this.receivermobile = receivermobile;
    }

    public String getReceivernames() {
        return receivernames;
    }

    public void setReceivernames(String receivernames) {
        this.receivernames = receivernames;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
