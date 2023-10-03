package edu.icet.services.wallet;

import edu.icet.Repositories.WalletRepository;
import edu.icet.dao.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService{
    @Autowired
    private WalletRepository walletRepository;
    public Wallet createOrUpdate(Wallet wallet){
        if(wallet.getId()==null){
            return  walletRepository.save(wallet);
        }else {
            return walletRepository.save(wallet);
        }
    }
}
