package org.springmvcframework.samples.mvc.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springmvcframework.mvc.extensions.ajax.AjaxUtils;

import javax.validation.Valid;

@Controller
@RequestMapping("/form")
@SessionAttributes("formBean")
public class FormController {

    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model){
        model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }

    @ModelAttribute("formBean")
    public FormBean createFormBean(){
        return new FormBean();
    }

    @GetMapping
    public void form(){

    }

    @PostMapping
    public String processSubmit(@Valid FormBean formBean, BindingResult result,
                                @ModelAttribute("ajaxRequesr") boolean ajaxRequest,
                                Model model, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            return null;
        }

        String message = "Form submitted successfully. Bound" + formBean;

        if (ajaxRequest){
            model.addAttribute("message",message);
            return null;
        }else {
            redirectAttributes.addFlashAttribute("message",message);
            return "redirect:/form";
        }
    }


}
