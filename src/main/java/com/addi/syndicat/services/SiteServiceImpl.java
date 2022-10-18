package com.addi.syndicat.services;

import com.addi.syndicat.entities.Site;
import com.addi.syndicat.payload.response.MessageResponse;
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

        return siteRepository.findByCodeSite(codeSite) ;
    }

    @Override
    public ResponseEntity<?> saveSite(Site site) {
       site.setCodeSite(alphaNumeric.getAlphaNumericString(6));
       if(site.getAdresseSite().isEmpty() || site.getAdresseSite()==null)
       {
           return ResponseEntity.badRequest().body(new MessageResponse("Adresse du site est requise!"));
       }
       if(site.getNomSite().isEmpty() || site.getNomSite()==null)
       {
           return ResponseEntity.badRequest().body(new MessageResponse("Nom du site est requis!"));

       }
       if(site.getBatimentsSite().name().isEmpty() || site.getBatimentsSite().name()==null)
       {
           return ResponseEntity.badRequest().body(new MessageResponse("Type du batiment du site est requis!"));
       }
       if(site.getTitreFoncier().isEmpty()|| site.getBatimentsSite().name()==null)
       {
           return ResponseEntity.badRequest().body(new MessageResponse("Titre foncier du site est requis!"));
       }

       siteRepository.save(site);
       return ResponseEntity.ok(new MessageResponse("Site est ajouté avec succès"));

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

