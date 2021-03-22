package com.example.demo;

import RequestClass.*;
import ResponseClass.CommitTrxnResponse;
import ResponseClass.QueryTrxnResponse;
import fabricjavaclient.BillPayment;
import fabricjavaclient.WalletCredit;
import fabricjavaclient.WalletTransfer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class DemoController {

//    @GetMapping(path = "/enrollAdmin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity login(EnrollAdminRequest enrollAdminRequest) throws Exception {
//        String username = enrollAdminRequest.getUsername();
//        String password = enrollAdminRequest.getPassword();
//
//        EnrollAdmin adminCreds = new EnrollAdmin();
//
//        String result = adminCreds.enroll(username,password);
//
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
//
//    }

    @PostMapping(path = "/walletCredit", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CommitTrxnResponse> walletCreditTrxn(@RequestBody final WalletCreditRequest walletCreditRequest ) throws Exception {
        String agentId = walletCreditRequest.getAgentId();
        String amount = walletCreditRequest.getAmount();
        String sourceType = walletCreditRequest.getSourceType();
        String transactionId = walletCreditRequest.getTransactionId();
        String walletId = walletCreditRequest.getWalletId();

        String UID = "walletCredit-"+ UUID.randomUUID() +"-"+transactionId;

        WalletCredit walletCredit  = new WalletCredit();

        String result = walletCredit.walletCreditSubmit(UID,agentId,amount,sourceType,transactionId,walletId);
        System.out.println(result);

        if (!result.isEmpty()){
            CommitTrxnResponse commitTrxnResponse = new CommitTrxnResponse();
            commitTrxnResponse.setRetry("60");
            commitTrxnResponse.setLocation(UID);

            return new ResponseEntity<>(commitTrxnResponse,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }


    }

    @GetMapping(path = "/queryWalletCreditByTrxnId", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity queryWalletCreditByTrxnId(@RequestBody final QueryTrxnRequest queryWalletCreditByTrxnIdRequest) throws Exception {
        String UID = queryWalletCreditByTrxnIdRequest.getUID();

        WalletCredit walletCredit  = new WalletCredit();

        String result = walletCredit.queryTrxnByTrxnId(UID);
        System.out.println(result);

        QueryTrxnResponse queryTrxnResponse  = new QueryTrxnResponse();
        queryTrxnResponse.setResponse(result);

        return new ResponseEntity<>(queryTrxnResponse,HttpStatus.OK);

    }

    @PostMapping(path = "/walletTransfer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity walletTransferTrxn(@RequestBody final WalletTransferRequest walletTransferRequest  ) throws Exception {

        String amount = walletTransferRequest.getAmount();
        String destinationAgentId = walletTransferRequest.getDestinationAgentId();
        String sourceAgentId = walletTransferRequest.getSourceAgentId();
        String sourceType = walletTransferRequest.getSourceType();

        String UID = "walletTransfer-"+ UUID.randomUUID();

        WalletTransfer walletTransfer   = new WalletTransfer();

        String result = walletTransfer.walletTransferSubmit(UID,amount,destinationAgentId,sourceAgentId,sourceType);
        System.out.println(result);

        if (!result.isEmpty()){
            CommitTrxnResponse commitTrxnResponse = new CommitTrxnResponse();
            commitTrxnResponse.setRetry("60");
            commitTrxnResponse.setLocation(UID);

            return new ResponseEntity<>(commitTrxnResponse,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @GetMapping(path = "/queryWalletTransferBySourceAgentId", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity queryWalletTransferBySourceAgentId(@RequestBody final QueryTrxnRequest queryTrxnRequest  ) throws Exception {
        String UID = queryTrxnRequest.getUID();

        WalletTransfer walletTransfer   = new WalletTransfer();

        String result = walletTransfer.queryTrxnBySourceAgentId(UID);
        System.out.println(result);

        QueryTrxnResponse queryTrxnResponse  = new QueryTrxnResponse();
        queryTrxnResponse.setResponse(result);

        return new ResponseEntity<>(queryTrxnResponse,HttpStatus.OK);

    }


    @PostMapping(path = "/billPayment", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity billPayment(@RequestBody final BillPaymentRequest billPaymentRequest   ) throws Exception {

        String agentId = billPaymentRequest.getAgentId();
        String  amount = billPaymentRequest.getAmount();
        String billId = billPaymentRequest.getBillId();
        String consumerAccountId = billPaymentRequest.getConsumerAccountId();
        String consumerName = billPaymentRequest.getConsumerName();
        String discom = billPaymentRequest.getDiscom();
        String division  = billPaymentRequest.getDivision();
        String divisionCode  = billPaymentRequest.getDivisionCode();
        String mobile  = billPaymentRequest.getMobile();
        String referenceTransactionId  = billPaymentRequest.getReferenceTransactionId();
        String sourceType = billPaymentRequest.getSourceType();
        String type  = billPaymentRequest.getType();
        String vanNo = billPaymentRequest.getVanNo();
        String walletId = billPaymentRequest.getWalletId();

        String UID = "billPayment-"+ UUID.randomUUID()+"-"+consumerAccountId;

        BillPayment billPayment  = new BillPayment();

        String result = billPayment.billPaymentSubmit(UID,agentId,  amount, billId, consumerAccountId, consumerName, discom,division,
                divisionCode,mobile,referenceTransactionId,sourceType,type,vanNo,walletId);
        System.out.println(result);

        if (!result.isEmpty()){
            CommitTrxnResponse commitTrxnResponse = new CommitTrxnResponse();
            commitTrxnResponse.setRetry("60");
            commitTrxnResponse.setLocation(UID);

            return new ResponseEntity<>(commitTrxnResponse,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @GetMapping(path = "/queryBillPaymentTrxnByBillId", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity queryBillPaymentTrxnByBillId(@RequestBody final QueryTrxnRequest queryTrxnRequest   ) throws Exception {
        String UID = queryTrxnRequest.getUID();

        BillPayment billPayment    = new BillPayment();

        String result = billPayment.queryTrxnByBillId(UID);
        System.out.println(result);

        QueryTrxnResponse queryTrxnResponse  = new QueryTrxnResponse();
        queryTrxnResponse.setResponse(result);

        return new ResponseEntity<>(queryTrxnResponse,HttpStatus.OK);

    }

}
