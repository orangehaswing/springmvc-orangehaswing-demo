package org.springmvcframework.samples.mvc.convert;

public class SocialSecurityNumber {

    private final String value;

    public SocialSecurityNumber(String value){
        this.value = value;
    }

    @MaskFormat("###-##-####")
    public String getValue(){
        return value;
    }

    public static SocialSecurityNumber valueOf(@MaskFormat("###-##-####") String value){
        return new SocialSecurityNumber(value);
    }

    @Override
    public String toString() {
        return "SocialSecurityNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
