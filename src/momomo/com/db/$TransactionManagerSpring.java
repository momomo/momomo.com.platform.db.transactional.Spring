package momomo.com.db;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;

public class $TransactionManagerSpring implements $TransactionManager<$TransactionSpring, $TransactionOptionsSpring> {
    protected final PlatformTransactionManager delegate;

    public $TransactionManagerSpring(PlatformTransactionManager delegate) {
        this.delegate = delegate;
    }

    public TransactionTemplate template() {
        return new TransactionTemplate(delegate);
    }

    @Override
    public void commit($TransactionSpring transaction) {
        delegate.commit(transaction.delegate);
    }

    @Override
    public void rollback($TransactionSpring transaction) {
        delegate.rollback(transaction.delegate);
    }

    public TransactionStatus getTransaction(TransactionTemplate template) {
        return delegate.getTransaction(template);
    }
}
