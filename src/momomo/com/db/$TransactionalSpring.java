package momomo.com.db;

import momomo.com.annotations.informative.Final;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Joseph S.
 */
public interface $TransactionalSpring extends $Transactional<$TransactionSpring, $TransactionOptionsSpring> {
    public PlatformTransactionManager platformTransactionManager();

    @Final default $TransactionManagerSpring transactionManager() {
        return new $TransactionManagerSpring(platformTransactionManager());
    }

    @Override
    @Final default $TransactionOptionsSpring options() {
        return new $TransactionOptionsSpring(this);
    }

}
