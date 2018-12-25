package org.springmvcframework.samples.mvc.form;

import com.sun.security.jgss.InquireType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springmvcframework.samples.mvc.convert.MaskFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class FormBean {

    @NotEmpty
    private String name;

    @Min(20)
    private int age;

    @DateTimeFormat(iso = ISO.DATE)
    @Past
    private Date birthDate;

    @MaskFormat("(###) ###-####")
    private String phone;

    @NumberFormat(pattern = "$###,###.00")
    private BigDecimal currency;

    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private BigDecimal precent;

    private InquireType inquireType;

    private String inquiryDetails;

    private boolean subscribeNewsletter;

    private Map<String,String> additionalInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getCurrency() {
        return currency;
    }

    public void setCurrency(BigDecimal currency) {
        this.currency = currency;
    }

    public BigDecimal getPrecent() {
        return precent;
    }

    public void setPrecent(BigDecimal precent) {
        this.precent = precent;
    }

    public InquireType getInquireType() {
        return inquireType;
    }

    public void setInquireType(InquireType inquireType) {
        this.inquireType = inquireType;
    }

    public String getInquiryDetails() {
        return inquiryDetails;
    }

    public void setInquiryDetails(String inquiryDetails) {
        this.inquiryDetails = inquiryDetails;
    }

    public boolean isSubscribeNewsletter() {
        return subscribeNewsletter;
    }

    public void setSubscribeNewsletter(boolean subscribeNewsletter) {
        this.subscribeNewsletter = subscribeNewsletter;
    }

    public Map<String, String> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, String> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "FormBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", currency=" + currency +
                ", precent=" + precent +
                ", inquireType=" + inquireType +
                ", inquiryDetails='" + inquiryDetails + '\'' +
                ", subscribeNewsletter=" + subscribeNewsletter +
                ", additionalInfo=" + additionalInfo +
                '}';
    }
}
