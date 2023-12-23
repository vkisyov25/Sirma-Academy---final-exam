package com.sirma.academy.finalProject.Controllers;

import com.sirma.academy.finalProject.Models.OutputTemplate;
import com.sirma.academy.finalProject.Services.OutputTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/view")
public class OutputTemplateController {
    private OutputTemplateService outputTemplateService;

    @Autowired
    public OutputTemplateController(OutputTemplateService outputTemplateService) {
        this.outputTemplateService = outputTemplateService;
    }

    @GetMapping("/allPairs")
    public List<OutputTemplate> allPairs() {
        return outputTemplateService.commonDaysOfEachPairForEachProject();
    }

    @GetMapping("/maxCommonDays")
    public OutputTemplate pairWithTheMostCommonDays() {
        return outputTemplateService.maxCommonDays();
    }
}
