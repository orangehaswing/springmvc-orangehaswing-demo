package org.springmvcframework.samples.mvc.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springmvcframework.mvc.extensions.ajax.AjaxUtils;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model){
        model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }

    @GetMapping
    public void fileuploadForm(){

    }

    @PostMapping
    public void processUpload(@RequestParam MultipartFile file,Model model){
        model.addAttribute("message","File'" + file.getOriginalFilename() + "'upload successfully");
    }
}
