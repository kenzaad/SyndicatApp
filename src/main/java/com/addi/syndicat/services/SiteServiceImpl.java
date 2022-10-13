package com.addi.syndicat.services;

import com.addi.syndicat.entities.Site;
import com.addi.syndicat.repository.SiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SiteServiceImpl implements SiteService{
    @Autowired
    private SiteRepository siteRepository;

    @Override
    public Site getSite(String codeSite) {

        return siteRepository.findByCodesite(codeSite) ;
    }

    @Override
    public ResponseEntity<String> saveSite(Site site) {
        if(getSite(site.getCodesite())!=null)
        {
            return  ResponseEntity.badRequest()
                    .body("Code site existe déjà");
        }
        else
            siteRepository.save(site);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Code site enregistré");


    }

    @Override
    public List<Site> listSites() {

        return siteRepository.findAll();
    }

    @Override
    @Transactional
    public int deleteSite(Long id) {
        siteRepository.deleteById(id);

        return 0;
    }


    @Override
    public Site updateSite(Site site, long id)  {
        site.setId(id);
        return siteRepository.save(site);
        }
    }

