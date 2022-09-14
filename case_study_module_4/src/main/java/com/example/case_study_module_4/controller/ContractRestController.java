package com.example.case_study_module_4.controller;

import com.example.case_study_module_4.dto.ContractDto;
import com.example.case_study_module_4.dto.IContractDetailDto;
import com.example.case_study_module_4.model.contract.ContractDetail;
import com.example.case_study_module_4.service.contract.IAttachFacilityService;
import com.example.case_study_module_4.service.contract.IContractDetailService;
import com.example.case_study_module_4.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractRestController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;


    @PostMapping("/addContractDetail")
    public ResponseEntity<Page<ContractDto>> goContractPage(@PageableDefault(size = 5) Pageable pageable) {

        Page<ContractDto> contractPage = this.contractService.findAll(pageable);
        if(contractPage.hasContent()){
            return new ResponseEntity<>(contractPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/contractDetail")
    public ResponseEntity<List<ContractDetail>> getAttachFacilityList(@RequestParam Integer id){
        List<ContractDetail> contractDetailList = this.contractDetailService.findByContractId(id);
        if (contractDetailList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> addContractDetail(@RequestBody List<ContractDetail> contractDetailList){

        this.contractDetailService.saveAll(contractDetailList);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/attachFacility")
    public ResponseEntity<List<IContractDetailDto>> getAttachFacilityListToAdd(@RequestParam Integer id){
        List<IContractDetailDto> contractDetailDtoList = this.contractDetailService.findAllContractDetailByContractId(id);

        if (contractDetailDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(contractDetailDtoList,HttpStatus.OK);
        }
    }
}
