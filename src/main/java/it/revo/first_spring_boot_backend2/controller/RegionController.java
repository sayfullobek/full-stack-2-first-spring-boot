package it.revo.first_spring_boot_backend2.controller;

import it.revo.first_spring_boot_backend2.pyload.ReqRegion;
import it.revo.first_spring_boot_backend2.pyload.ResRegion;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/region")
@Controller
public class RegionController {
    @Autowired
    RegionService regionService;

    @GetMapping
    public String getRegion() {
        return "region";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<ResRegion> getRegionList() {
        return regionService.getRegion();
    }

    @PostMapping("/add")
    @ResponseBody
    public Result addRegion(@RequestBody ReqRegion reqRegion) {
        return regionService.addRegion(reqRegion);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Result editRegion(@PathVariable Integer id, @RequestBody ReqRegion reqRegion) {
        return regionService.editRegion(id, reqRegion);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteRegion(@PathVariable Integer id) {
        return regionService.deleteRegion(id);
    }
}
