package com.addi.syndicat.controllers;

import com.addi.syndicat.entities.Depenses;
import com.addi.syndicat.services.DepensesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Depenses")
public class DepensesController {
    @Autowired
    private DepensesService depensesService;

    @GetMapping("/getDepenses/{codedep}")
    public Depenses getDepenses(@PathVariable("codedep") String codedep) {
        return depensesService.getDepenses(codedep);
    }

    @DeleteMapping("/deleteDepenses/{id}")
    public ResponseEntity<?> deleteDepense(@PathVariable("id") long id) {
        return depensesService.deleteDepense(id);
    }
    @GetMapping("/ListDepenses")
    public List<Depenses> listDepenses() {

        return
                depensesService.listDepenses();
    }
    @PostMapping("/")
    public ResponseEntity<?> saveDepenses(@RequestBody Depenses depenses) {
        return depensesService.saveDepenses(depenses);
    }
    @PutMapping("/{codedep}")
    public ResponseEntity<?> updateDepense(@RequestBody Depenses depenses,@PathVariable("codedep") String code)  {

        return depensesService.updateDepenses(depenses,code);
    }
}
