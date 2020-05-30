package hse.projectx.petdonate_api.controller;

import hse.projectx.petdonate_api.model.Transaction;
import hse.projectx.petdonate_api.model.User;
import hse.projectx.petdonate_api.repository.TransactionRepository;
import hse.projectx.petdonate_api.repository.UserRepository;
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
    private UserRepository userRepository;

    public TransactionController(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("apiv1/transaction/{token}")
    public ResponseEntity postTransaction(@Valid @RequestBody Transaction transaction) {
        transactionRepository.save(transaction); //TODO token check
        if (userRepository.existsById(transaction.getUser_id())) {
            User user = userRepository.getUserById(transaction.getUser_id()).get(0);
            user.setTransactionsCount(user.getTransactionsCount() + 1);
            userRepository.save(user);
        }

        return ResponseEntity.ok(transaction);
    }


}
