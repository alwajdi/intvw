import com.interview.models.Affiliate
import spock.lang.Specification

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 04:51
 */
class AffiliateSpecification extends Specification {

    def "An affiliate is eligible for 10% discount for non grocery items"(){
        given:
        Affiliate affiliate = new Affiliate();

        expect:
        affiliate.eligibleDiscountOnNonGroceryItems == 0.1d
    }
}
