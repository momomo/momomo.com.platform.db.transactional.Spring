package momomo.com.db;

import momomo.com.exceptions.$DatabaseTransactionalTimeoutException;
import org.springframework.transaction.TransactionStatus;

public final class $TransactionSpring extends $Transaction<$TransactionSpring> {
    public final $TransactionManagerSpring manager;
    public final TransactionStatus         delegate;

    protected $TransactionSpring(TransactionStatus transaction, boolean isNew, $TransactionManagerSpring manager) {
        super( isNew ? null : Boolean.FALSE );
        
        this.manager  = manager;
        this.delegate = transaction;
    }

    @Override
    protected void $commit$() {
        manager.commit(this);
    }

    @Override
    protected void $rollback$() {
        manager.rollback(this);
    }

    @Override
    protected void handleExecuteException(Throwable e) {
        String message = e.getMessage();
        if (message != null && message.contains("transaction timeout expired")) {
            throw new $DatabaseTransactionalTimeoutException(e);
        }
    }
}
