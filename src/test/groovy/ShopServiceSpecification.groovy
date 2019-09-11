import com.interview.models.Affiliate
import com.interview.models.Cart
import com.interview.models.Customer
import com.interview.models.Employee
import com.interview.models.GroceryItem
import com.interview.models.NonGroceryItem
import com.interview.services.ShopServices
import com.interview.services.ShopServicesImpl
import spock.lang.Specification

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 05:03
 */
class ShopServiceSpecification extends Specification {

    def Cart cart = new Cart();
    def ShopServices shopServices = new ShopServicesImpl();

    def setup(){

        cart.addToCart(new GroceryItem("carrot", new BigDecimal("1.00")))
        cart.addToCart(new GroceryItem("dishwasher", new BigDecimal("2.50")))
        cart.addToCart(new GroceryItem("soap", new BigDecimal("0.70")))
        cart.addToCart(new GroceryItem("onion", new BigDecimal("2.55")))
        cart.addToCart(new GroceryItem("salad", new BigDecimal("3.25")))
        //total price of groceries are 10.00

        cart.addToCart(new NonGroceryItem("shirt", new BigDecimal("19.00")))
        cart.addToCart(new NonGroceryItem("jeans", new BigDecimal("25.00")))
        cart.addToCart(new NonGroceryItem("sport shoes", new BigDecimal("22.00")))
        cart.addToCart(new NonGroceryItem("jacket", new BigDecimal("30.00")))
        //total price of non groceries are 96.00

    }

    def "Customers for 2 years or more will get 5% discount on non groceries" (){

        given:
        Customer customer = new Customer();
        customer.setMemberSince(Date.parse("yyyy-MM-dd","2015-05-22"))

        expect:
        shopServices.calculateNetPayable(cart, customer) == 96.20
    }

    def "Customers for less than 2 years will not get any discount on non groceries" (){

        given:
        Customer customer = new Customer();
        customer.setMemberSince(Date.parse("yyyy-MM-dd","2018-02-10"))

        expect:
        shopServices.calculateNetPayable(cart, customer) == 101.00
    }

    def "Employees will get 30% discount on non groceries" (){

        given:
        Employee employee = new Employee();

        expect:
        shopServices.calculateNetPayable(cart, employee) == 77.20
    }

    def "Affiliates will get 30% discount on non groceries" (){

        given:
        Affiliate affiliate = new Affiliate();

        expect:
        shopServices.calculateNetPayable(cart, affiliate) == 96.40
    }

}
