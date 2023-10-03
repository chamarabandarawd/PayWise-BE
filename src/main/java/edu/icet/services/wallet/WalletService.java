package edu.icet.services.wallet;

import edu.icet.dao.Wallet;

public interface WalletService {
    public Wallet createOrUpdate(Wallet wallet);
}
