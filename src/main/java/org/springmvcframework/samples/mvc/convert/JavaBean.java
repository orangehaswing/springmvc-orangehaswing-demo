package org.springmvcframework.samples.mvc.convert;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class JavaBean {

    private Integer primitive;

    @DateTimeFormat(iso = ISO.DATE)
    private Date date;

    @MaskFormat("(###) ###-####")
    private String masked;

    private List<Integer> list;

    @DateTimeFormat(iso = ISO.DATE)
    private List<Date> formattedList;

    private Map<Integer,String> map;

    private NestedBean nested;

    public Integer getPrimitive() {
        return primitive;
    }

    public void setPrimitive(Integer primitive) {
        this.primitive = primitive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMasked() {
        return masked;
    }

    public void setMasked(String masked) {
        this.masked = masked;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public List<Date> getFormattedList() {
        return formattedList;
    }

    public void setFormattedList(List<Date> formattedList) {
        this.formattedList = formattedList;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public NestedBean getNested() {
        return nested;
    }

    public void setNested(NestedBean nested) {
        this.nested = nested;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "primitive=" + primitive +
                ", date=" + date +
                ", masked='" + masked + '\'' +
                ", list=" + list +
                ", formattedList=" + formattedList +
                ", map=" + map +
                ", nested=" + nested +
                '}';
    }
}
