package com.addi.syndicat.controllers;

import com.addi.syndicat.entities.Site;
import com.addi.syndicat.services.SiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Site")
public class SiteController {
    @Autowired
    private SiteService siteService;

    @GetMapping("/getSite/{codeSite}")
    public Site getGestionniresite(@PathVariable("codeSite") String codeSite) {
        return siteService.getSite(codeSite);
    }

    @DeleteMapping("/deleteSite/{id}")
    public int deleteSite(@PathVariable("id") long id) {
        return siteService.deleteSite(id);
    }

    @GetMapping("/ListSite")
    public List<Site> listSites() {

        return
                siteService.listSites();
    }

    @PostMapping("/")
    public ResponseEntity<?> saveSite(@RequestBody Site site) {
        return siteService.saveSite(site);
    }

    @PutMapping("/Site/{id}")
    public Site updateSite(@RequestBody Site site, @PathVariable("id") long id) {

        return siteService.updateSite(site,id);
    }
}
