package momomo.com.db;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashMap;

public final class $TransactionOptionsSpring extends $TransactionOptions<$TransactionSpring, $TransactionOptionsSpring> {
    final $TransactionalSpring      outer;
    final $TransactionManagerSpring manager;

    public $TransactionOptionsSpring($TransactionalSpring outer) {
        this.outer    = outer;
        this.manager  = outer.transactionManager();
    }

    /////////////////////////////////////////////////////////////////////

    @Override
    public  $TransactionSpring create() {
        TransactionTemplate template = manager.template();
    
        template.setPropagationBehavior( PROPAGATION_TRANSLATION.get(super.propagation).value() );

        if ( super.readOnly != null ) {
            template.setReadOnly(super.readOnly);
        }

        /*
         * Really only supported for $HibernateRepository
         */
        if (super.isolation != null) {
            template.setIsolationLevel(super.isolation.delegate);
        }
        
        if (super.timeout != null) {
            template.setTimeout(super.timeout);
        }

        TransactionStatus  delegate    = manager.getTransaction(template);
        $TransactionSpring transaction = new $TransactionSpring(manager, delegate);

        return transaction;
    }

    /////////////////////////////////////////////////////////////////////

    private static final HashMap<Propagation, org.springframework.transaction.annotation.Propagation> PROPAGATION_TRANSLATION = new HashMap<>();

    static {
        PROPAGATION_TRANSLATION.put(Propagation.NEW    , org.springframework.transaction.annotation.Propagation.REQUIRES_NEW);
        PROPAGATION_TRANSLATION.put(Propagation.REQUIRE, org.springframework.transaction.annotation.Propagation.REQUIRED);
        PROPAGATION_TRANSLATION.put(Propagation.SUPPORT, org.springframework.transaction.annotation.Propagation.SUPPORTS);
    }
    
    /////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////
}
