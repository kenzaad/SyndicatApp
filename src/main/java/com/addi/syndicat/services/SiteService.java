package com.addi.syndicat.services;

import com.addi.syndicat.entities.Site;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SiteService {
    Site getSite(String Codesite);
    ResponseEntity<?> saveSite(Site site);
    List<Site> listSites();
    int deleteSite(Long id);
    Site updateSite(Site site, long id);
}
