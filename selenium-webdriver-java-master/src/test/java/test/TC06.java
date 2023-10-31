package test;

import driver.driverFactory;
import model.pages.LoginPageSimple;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class TC06 {
    public static void testValidQuantity() {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().window().maximize();

        // Step 1: Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        // Step 2: Click on the "My Account" link
        WebElement myAccountLink = driver.findElement(By.linkText("ACCOUNT"));
        myAccountLink.click();
        WebElement myAccountLink2 = driver.findElement(By.linkText("My Account"));
        myAccountLink2.click();
//        LoginPageSimple login = new LoginPageSimple(driver);
//        login.inputUsername("phannam151@gmail.com");
//        login.inputPassword("phannam112");
//        login.loginBtn().click();
        // Step 3: Login to the application using previously created credentials
        WebElement usernameInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.name("send"));

        // Enter your username and password
        usernameInput.sendKeys("phannam151@gmail.com");
        passwordInput.sendKeys("phannam112");

        loginButton.click();

        // Step 4: Click on MY WISHLIST link
        WebElement myWishlistLink = driver.findElement(By.linkText("MY WISHLIST"));
        myWishlistLink.click();

        // Step 5: Click ADD TO CART link
        WebElement addToCartLink = driver.findElement(By.xpath("//div[@class='cart-cell']//button[@class='button btn-cart']"));
        addToCartLink.click();

        // Step 6: Enter general shipping country, state/province, and zip for the shipping cost estimate
        WebElement shippingCountryInput = driver.findElement(By.id("country"));
        WebElement shippingStateInput = driver.findElement(By.id("region"));
        WebElement shippingZipInput = driver.findElement(By.id("postcode"));

        // Enter the shipping details
        shippingCountryInput.sendKeys("VietNam");
        shippingStateInput.sendKeys("30");
        shippingZipInput.sendKeys("71200");

        // Step 7: Click Estimate
        WebElement estimateButton = driver.findElement(By.xpath("//div[@class='buttons-set']//button[@class='button2']"));
        estimateButton.click();

        // Step 8: Verify Shipping cost generated
        // (Perform the necessary assertions or verifications)

        // Step 9: Select Shipping Cost, Update Total
        WebElement shippingCostRadio = driver.findElement(By.cssSelector("input[name='estimate_method']"));
        shippingCostRadio.click();

        WebElement updateTotalButton = driver.findElement(By.cssSelector("[value='Update Total']"));
        updateTotalButton.click();

        // Step 10: Verify shipping cost is added to total
        // (Perform the necessary assertions or verifications)
        //todo check price
//        boolean validCost = true;
//        String subtotal = By.xpath("//div[@class='cart-totals-wrapper']//div[@class='cart-totals']" +
//                "//table[@id='shopping-cart-totals-table']" +
//                "//tbody" +
//                "//tr" +
//                "//td[@style")



        // Step 11: Click "Proceed to Checkout"
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//ul[@class='checkout-types bottom']" +
                "//li[@class='method-checkout-cart-methods-onepage-bottom']" +
                "//button[@class='button btn-proceed-checkout btn-checkout']"));
        proceedToCheckoutButton.click();

        // Step 12a: Enter Billing Information, and click Continue
        WebElement billingAddressInput = driver.findElement(By.id("billing:street1"));
        billingAddressInput.sendKeys("Vinhome Grand Park");
        WebElement billingCityInput = driver.findElement(By.id("billing:city"));
        billingCityInput.sendKeys("Hồ Chí Minh");

        // Continue with the remaining billing information

        // Step 12b: Enter Shipping Information, and click Continue
        WebElement shippingFirstNameInput = driver.findElement(By.id("shipping_first_name"));
        WebElement shippingLastNameInput = driver.findElement(By.id("shipping_last_name"));
        // Enter the shipping details (if different from billing)
        shippingFirstNameInput.sendKeys("Your_Shipping_FirstName");
        shippingLastNameInput.sendKeys("Your_Shipping_LastName");

        // Continue with the remaining shipping information
        WebElement stateInput = driver.findElement(By.xpath());
        // Step 13: In Shipping Method, Click Continue
        WebElement shippingMethodContinueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        shippingMethodContinueButton.click();

        // Step 14: In Payment Information select 'Check/Money Order' radio button. Click Continue
        WebElement paymentCheckMoneyOrderRadio = driver.findElement(By.cssSelector("input[value='cheque']"));
        paymentCheckMoneyOrderRadio.click();

        WebElement paymentMethodContinueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        paymentMethodContinueButton.click();

        // Step 15: Click 'PLACE ORDER' button
        WebElement placeOrderButton = driver.findElement(By.cssSelector("[value='Place order']"));
        placeOrderButton.click();

        // Step 16: Verify Order is generated. Note the order number
        // (Perform the necessary assertions or verifications)

        // Close the browser
        driver.quit();
    }
}
