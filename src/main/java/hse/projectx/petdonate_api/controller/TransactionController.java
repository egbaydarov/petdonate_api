package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.model.Transaction;
import hse.projectx.petdonate_api.repository.TransactionRepository;
import hse.projectx.petdonate_api.transfer.UserDataRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class TransactionController {
    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("apiv1/transaction/{token}")
    public ResponseEntity postTransaction(@Valid @RequestBody Transaction transaction)
    {
        transactionRepository.save(transaction); //TODO token check
        return ResponseEntity.ok(transaction);
    }
}
