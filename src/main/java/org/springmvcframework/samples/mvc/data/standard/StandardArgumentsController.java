package org.springmvcframework.samples.mvc.data.standard;

import org.springframework.cglib.core.Local;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.security.Principal;

@RestController
public class StandardArgumentsController {

    @GetMapping("/data/standard/request")
    public String standardRequestArgs(HttpServletRequest request, Principal user, Local local){
        StringBuilder buffer = new StringBuilder();
        buffer.append("request = ").append(request).append(",");
        buffer.append("userPrincipal = ").append(user).append(",");
        buffer.append("requestLocale = ").append(local);
        return buffer.toString();
    }


    @PostMapping("/data/standard/request/reader")
    public String requestReader(Reader requestBodyReader) throws IOException {
        return "Read char request body =" + FileCopyUtils.copyToString(requestBodyReader);
    }

    @PostMapping("/data/standard/request/is")
    public String requestReader(InputStream requestBodyIs) throws IOException {
        return "Read binary request body =" + new String(FileCopyUtils.copyToByteArray(requestBodyIs));
    }

    @GetMapping("/data/standard/response")
    public String response(HttpServletResponse response){
        return "response = "+ response;
    }

    @GetMapping("/data/standard/response/writer")
    public void availableStandardResponseArguments(Writer responseWriter) throws IOException {
        responseWriter.write("wrote char response using Writer");
    }

    @GetMapping("/data/standard/reponse/os")
    public void availableStandardResponseArguments(OutputStream os) throws IOException {
        os.write("wrote binary response using OutputStream".getBytes());
    }

    @GetMapping("/data/standard/session")
    public String session(HttpSession session){
        StringBuilder buffer = new StringBuilder();
        buffer.append("session = ").append(session);
        return buffer.toString();
    }


}
