package com.example.case_study_module_4.controller;

import com.example.case_study_module_4.dto.ContractDto;
import com.example.case_study_module_4.dto.IContractDetailDto;
import com.example.case_study_module_4.model.contract.AttachFacility;
import com.example.case_study_module_4.model.contract.Contract;
import com.example.case_study_module_4.model.contract.ContractDetail;
import com.example.case_study_module_4.model.contract.NewContractInfo;
import com.example.case_study_module_4.model.customer.Customer;
import com.example.case_study_module_4.model.employee.Employee;
import com.example.case_study_module_4.model.facility.Facility;
import com.example.case_study_module_4.service.Employee.IEmployeeService;
import com.example.case_study_module_4.service.contract.IAttachFacilityService;
import com.example.case_study_module_4.service.contract.IContractDetailService;
import com.example.case_study_module_4.service.contract.IContractService;
import com.example.case_study_module_4.service.customer.ICustomerService;
import com.example.case_study_module_4.service.facility.IFacilityService;
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

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<Page<ContractDto>> goContractPage(@PageableDefault(size = 5) Pageable pageable) {

        Page<ContractDto> contractPage = this.contractService.findAll(pageable);
        if (contractPage.hasContent()) {
            return new ResponseEntity<>(contractPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/contractDetail")
    public ResponseEntity<List<ContractDetail>> getAttachFacilityList(@RequestParam Integer id) {
        List<ContractDetail> contractDetailList = this.contractDetailService.findByContractId(id);
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }

    @PostMapping("/addContractDetail")
    public ResponseEntity<Void> addContractDetail(@RequestBody List<ContractDetail> contractDetailList) {

        this.contractDetailService.saveAll(contractDetailList);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/attachFacility")
    public ResponseEntity<List<IContractDetailDto>> getAttachFacilityListToAddAttachFacility(Integer id) {
        List<IContractDetailDto> contractDetailDtoList = this.contractDetailService.findAllContractDetailByContractId(id);

        if (contractDetailDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contractDetailDtoList, HttpStatus.OK);
        }
    }

    @GetMapping("/showAddNewContractModal")
    public ResponseEntity<NewContractInfo> showAddNewContractModal() {
        List<Facility> facilities = this.facilityService.getListAllFacility();

        List<Customer> customers = this.customerService.getListAllCustomer();

        List<Employee> employees = this.employeeService.getListAllEmployee();

        List<AttachFacility> attachFacilities = this.attachFacilityService.findAll();

        NewContractInfo newContractInfo = new NewContractInfo(facilities, customers, employees, attachFacilities);

        return new ResponseEntity<>(newContractInfo, HttpStatus.OK);
    }

    @GetMapping("/getCost")
    public ResponseEntity<Double> getFacilityCost(@RequestParam Integer id){
        Double cost = 0.0;
        if (id != 0){
            cost = Double.parseDouble(this.facilityService.findById(id).getCost());
        }
        return new ResponseEntity<>(cost,HttpStatus.OK);
    }

    @PostMapping("createContract")
    public ResponseEntity<Void> createContract(@RequestBody Contract contract){
        try {
            this.contractService.save(contract);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
