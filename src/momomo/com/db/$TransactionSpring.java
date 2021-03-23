package momomo.com.db;

import org.springframework.transaction.TransactionStatus;

public final class $TransactionSpring extends $Transaction<$TransactionSpring> {
    public final $TransactionManagerSpring manager;
    public final TransactionStatus         delegate;

    protected $TransactionSpring($TransactionManagerSpring outer, TransactionStatus delegate, boolean isNew) {
        super(outer, isNew ? null : Boolean.FALSE );
    
        this.manager  = outer;
        this.delegate = delegate;
    }
    
    /**
     * To grant access to the underlying transaction should there be a need
     */
    public TransactionStatus delegate() {
        return delegate; 
    }
    
    /**
     * To grant access to our 'transaction manager' from a transaction if there is ever a need
     */
    public $TransactionManagerSpring manager() {
        return manager; 
    }
}
