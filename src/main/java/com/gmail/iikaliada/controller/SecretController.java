package com.gmail.iikaliada.controller;

import com.gmail.iikaliada.entity.Secret;
import com.gmail.iikaliada.service.SecretService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SecretController {

    private final SecretService secretService;

    @GetMapping("/secret")
    public String secretForm(Model model) {
        model.addAttribute("secret", new Secret());
        return "secret-form";
    }

    @PostMapping("/submit")
    public String submitSecret(@ModelAttribute Secret secret, Model model) {
        Secret savedSecret = secretService.saveSecret(secret);
        model.addAttribute("uniqueLink", savedSecret.getUniqueLink());
        return "secret-link-form";
    }

    @GetMapping("/secret/{uniqueLink}")
    public String showSecret(@PathVariable String uniqueLink, Model model) {
        Secret secret = secretService.findByUniqueLink(uniqueLink);
        if (secret != null) {
            model.addAttribute("secret", secret);
            secretService.deleteSecretById(secret.getId());
            return "secret-view";
        } else {
            return "secret-expired";
        }
    }

}
