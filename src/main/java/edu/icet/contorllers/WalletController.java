package edu.icet.contorllers;

import edu.icet.dao.Wallet;
import edu.icet.services.validation.ValidationService;
import edu.icet.services.wallet.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @Autowired
    private ValidationService validationService;
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Wallet wallet, BindingResult result ){
        System.out.println(result.getFieldErrors());

        ResponseEntity<?> errors=validationService.validate(result);
        if(errors!=null){
            return errors;
        }
        Wallet saveWallet=walletService.createOrUpdate(wallet);

        return new ResponseEntity<Wallet>(saveWallet, HttpStatus.CREATED);
    }
}
