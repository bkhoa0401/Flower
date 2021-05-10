package com.ecommerce.wProductService.controller;

import com.ecommerce.wProductService.entity.Branch;
import com.ecommerce.wProductService.entity.response.BaseResponse;
import com.ecommerce.wProductService.service.IBranchService;
import com.ecommerce.wProductService.utils.ERRORCODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BranchController {

    @Autowired
    IBranchService iBranchService;

    @GetMapping("/branches")
    private ResponseEntity<BaseResponse<List<Branch>>>  getBranches() {
        return new ResponseEntity<>(new BaseResponse<>(iBranchService.getBranches()),HttpStatus.OK);
    }

    @PostMapping("/branch")
    private ResponseEntity<BaseResponse> addNewBranch(@RequestBody Branch branch) {

        if (branch.getName() != null && !"".equals(branch.getName())) {
            iBranchService.addNewBranch(branch);
            return new ResponseEntity<>(new BaseResponse(ERRORCODE.SUCCESS), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.BADREQUEST), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/branch")
    private ResponseEntity<BaseResponse> updateBranch(@RequestBody Branch branch) {
        if (branch.getName() != null && !"".equals(branch.getName())) {
            iBranchService.updateBranch(branch);
            return new ResponseEntity<>(new BaseResponse(ERRORCODE.SUCCESS), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.BADREQUEST), HttpStatus.BAD_REQUEST);
    }

}