import com.interview.models.Customer
import spock.lang.Specification

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 04:51
 */
class CustomerSpecification extends Specification{

    def "Customer more than 2 years is eligible for 5% discount for non grocery items"(){

        given:
        Customer customerForTwoYears  = new Customer();
        customerForTwoYears.setMemberSince(Date.parse("yyyy-MM-dd", "2016-11-18"))

        expect:
        customerForTwoYears.eligibleDiscountOnNonGroceryItems == 0.05d

    }

    def "Customer less than 2 years should not get any discount on non grocery items" (){
        given:
        Customer newCustomer = new Customer();
        newCustomer.setMemberSince(Date.parse("yyyy-MM-dd", "2019-01-20"))

        expect:
        newCustomer.eligibleDiscountOnNonGroceryItems == 0.00d
    }

}
