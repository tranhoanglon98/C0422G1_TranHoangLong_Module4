package com.codegym.phone_web_service.controller;

import com.codegym.phone_web_service.model.Phone;
import com.codegym.phone_web_service.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PhoneController {

    @Autowired
    private IPhoneService phoneService;

    @GetMapping("")
    public ResponseEntity<Page<Phone>> goPhonePage(Pageable pageable){
        Page<Phone> phoneList = this.phoneService.findAll(pageable);
        if (phoneList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phoneList,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewPhone(@RequestBody Phone phoneObj){
        try {
            this.phoneService.save(phoneObj);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("delete")
    public ResponseEntity<Void> delete(@RequestParam Integer id){
        Phone phone = this.phoneService.findById(id);
        if (phone == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.phoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("showUpdate")
    public ResponseEntity<Phone> showUpdate(@RequestParam Integer id){
        Phone phone = this.phoneService.findById(id);
        if (phone == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(phone,HttpStatus.OK);
    }

    @PatchMapping("update")
    public ResponseEntity<Void> update(@RequestBody Phone phone){
        try {
            this.phoneService.save(phone);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
