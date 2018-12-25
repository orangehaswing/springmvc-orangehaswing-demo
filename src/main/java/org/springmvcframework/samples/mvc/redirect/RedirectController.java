package org.springmvcframework.samples.mvc.redirect;

import org.joda.time.LocalDate;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;

@Controller
@RequestMapping("/redirect")
public class RedirectController {
    private final ConversionService conversionService;

    @Inject
    public RedirectController(ConversionService conversionService){
        this.conversionService = conversionService;
    }

    @GetMapping("/uriTemplate")
    public String uriTemplate(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("account","a123");
        redirectAttributes.addAttribute("date",new LocalDate(2018,12,18));
        return "redirect:/redirect/{account}";
    }

    @GetMapping("/uriComponentsBuilder")
    public String uriComponetsBuilder(){
        String date = this.conversionService.convert(new LocalDate(2018,12,20),String.class);
        UriComponents redirectUri = UriComponentsBuilder.fromPath("/redirect/{account}")
                .queryParam("date",date).build().expand("a123").encode();
        return "redirect:"+redirectUri.toUriString();
    }


    @GetMapping("/{account}")
    public String show(@PathVariable String account, @RequestParam(required = false) LocalDate date)
    {
        return "redirect/redirectResults";
    }

}
