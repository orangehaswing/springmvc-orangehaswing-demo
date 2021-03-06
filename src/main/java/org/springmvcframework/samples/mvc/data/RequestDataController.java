package org.springmvcframework.samples.mvc.data;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class RequestDataController {

    @GetMapping("param")
    public String withParam(@RequestParam String foo){
        return "Obtained 'foo' qurey parameter value '" + foo + "'";
    }

    @GetMapping("group")
    public String withParamGroup(JavaBean bean){
        return "Obtained parameter group" + bean;
    }

    @GetMapping("path/{var}")
    public String withPathVariable(@PathVariable String var){
        return "Obtained 'var' path variable value '" + var + "'";
    }

    @GetMapping("{path}/simple")
    public String withMatrixVariable(@PathVariable String path, @MatrixVariable String foo){
        return  "Obtained matrix variable 'foo=" + foo+ "' from path segmet '" + path + "'";
    }

    @GetMapping("{path1}/{path2}")
    public String withMatrixVariablesMultiple(
            @PathVariable String path1, @MatrixVariable(name="foo",pathVar = "path1") String foo1,
            @PathVariable String path2, @MatrixVariable(name="foo",pathVar = "path2") String foo2){
        return "Obtain matrix variable foo=" + foo1 + "from path segmet'" + path1 +
                "'and variable 'foo=" + foo2 + "from path segmet'" + path2 + "'";
    }

    @GetMapping("header")
    public String withHeader(@RequestHeader String Accept){
                return "Obtained 'Accept' header '"+ Accept + "'";
    }

    @GetMapping("cookie")
    public String withCookie(@CookieValue String openid_provider){
        return "Obtained 'openid_provider' cookie '" + openid_provider + "'";
    }

    @PostMapping("body")
    public String withBody(@RequestBody String body){
        return "Posted request body '" + body + "'";
    }

    @PostMapping("entity")
    public String withEntity(HttpEntity<String> entity){
        return "Posted request body '" + entity.getBody() + "'; headers = " + entity.getHeaders();
    }

}
