package momomo.com.db;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author Joseph S.
 */
public class $TransactionManagerSpring implements $TransactionManager<$TransactionSpring, $TransactionOptionsSpring> {
    public final PlatformTransactionManager delegate;

    public $TransactionManagerSpring(PlatformTransactionManager delegate) {
        this.delegate = delegate;
    }
    
    public PlatformTransactionManager delegate() {
        return delegate; 
    }

    public TransactionTemplate template() {
        return new TransactionTemplate(delegate);
    }
    
    protected TransactionStatus transaction(TransactionTemplate template) {
        return delegate.getTransaction(template);
    }

    @Override
    public void commit($TransactionSpring transaction) {
        delegate.commit(transaction.delegate);
    }

    @Override
    public void rollback($TransactionSpring transaction) {
        delegate.rollback(transaction.delegate);
    }
}
