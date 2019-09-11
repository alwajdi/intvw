import com.interview.models.Employee
import spock.lang.Specification

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 04:51
 */
class EmployeeSpecification  extends Specification{

    def "An employee is eligible for 30% discount for non grocery items"(){
        given:
        Employee employee = new Employee();

        expect:
        employee.eligibleDiscountOnNonGroceryItems == 0.3d
    }

}
