package com.urbanladder.Objectrepo;

import org.openqa.selenium.By;

public class Locators {
	// Locators for User Registration and Login
    public static By SignUp_Link = By.id("header-icon-signup");
    public static By Login_Link = By.id("header-icon-login");
    public static By Email_Field = By.id("spree_user_email");
//    public static By Password_Field = By.id("spree_user_password");
    public static By Password_Field = By.xpath("//input[@id='spree_user_password'][2]");
    public static By Login_Email_Field = By.xpath("//input[@class='email required input_authentication']");
    public static By login_Password_Field = By.xpath("//input[@class='required input_authentication']");
    
//    public static By SignUp_Button = By.name("commit");
    public static By SignUp_Button = By.xpath("//input[contains(@class, 'signup')]");
    public static By Login_Button = By.xpath("//input[@id='ul_site_login']");
//    public static By Error_Message = By.xpath("//div[contains(@class, 'flash ulmessage error')]");
    public static By Login_Failure_Message = By.xpath("//div[text()='The email or password you entered is incorrect. Please try again.']");

    
 // Locators for Edit Account Settings - Change Password
    public static By Profile = By.id("header-icon-profile");
    public static By Edit = By.id("edit");
    public static By Name_Field = By.id("user_name");
    public static By Mobile_Field = By.id("user_mobile");
    public static By Change_Password = By.id("change_password");
    public static By New_Password_Field = By.id("user_password");
    public static By Confirm_Password_Field = By.id("user_password_confirmation");
    public static By Save_Changes_Button = By.name("commit");
    public static By Success_Message = By.xpath("//div[contains(text(),'Account updated')]");
    public static By Profile_icon = By.xpath("//span[contains(@class, 'user-profile-icon')]");
			
	//Locators for Homepage
	
    public static By Top_Offers = By.xpath("//div[contains(text(), 'Enjoy up to 70% off')]");    
    public static By BestSeller = By.xpath("//h2[contains(text(),'Our Bestsellers, Handpicked Just for You')]");
    public static By Search_Bar = By.id("search");
    
    //Locators for search
    
    public static By Search_Button = By.xpath("//button[@id='search_button']"); 
    public static By Search_Result_Header = By.xpath("//h2[contains(text(), 'Search results for')]");
    public static By Product_Count = By.xpath("//span[@class='count']");
    public static By Recommended_Dropdown = By.xpath("//span[text()='Recommended']"); 
    public static By New_Arrivals_Option = By.xpath("//li[contains(text(),'New Arrivals')]");
    public static By Price_Filter = By.xpath("//div[@class='gname' and contains(text(), 'Price')]"); 
    public static By Price_Range = By.xpath("//input[@id='price_limit_53081-104560']");
    public static By Pop_Up=By.xpath("//div[@id=\"authentication_popup\"]");
    
    
    //Locators for product details
    
    public static final By SEARCH_RESULTS = By.xpath("//li[contains(@class, 'product')]");
    public static final By OUT_OF_STOCK_LABEL = By.xpath("//div[text()='Sold Out']");
    public static final By LET_ME_KNOW_LABEL = By.xpath("//div[text()='Let Me Know']");
    public static final By SELECT_PRODUCT = By.xpath("//span[text()='(Sunset Ikat Stripes)']");
    // Product Details Page
    public static final By PRODUCT_TITLE = By.xpath("//h1[@class='page-heading product-title no-margin']");
    public static final By PRODUCT_DESCRIPTION = By.xpath("//span[@class='product-property-title with-stroke']");
    public static final By PRODUCT_PRICE = By.xpath("//div[@class='price final']");


    // Wishlist
    public static final By WISHLIST_ICON = By.xpath("//span[@class='icofont icofont-heart_outline_thick wishicon']"); //adding to wishlist icon
//    public static final By WISHLIST_PAGE = By.xpath("//a[@id='header-icon-wishlist']");//for checking
    public static final By WISHLIST_PAGE = By.xpath("//div[@id='shortlist-badge']");
    
    public static final By WISHLIST_PRODUCT = By.xpath("//span[contains(text(),'Taran Teak Wood Sofa ')]");
    
    // Cart
    public static final By ADD_TO_CART_BUTTON = By.xpath("//button[@id='add-to-cart-button']");
    public static final By CART_PAGE_PRODUCT_TITLE = By.xpath("//a[text()='Taran Teak Wood Sofa']");
    
    //cart page
    public static final By CART_QUANTITY_INPUT = By.xpath("//select[@id='select_0_quantity']");
    
    public static final By Quantity_Dropdown = By.id("select_0_quantity");
    public static final By deleteButton = By.xpath("//div[@class='cart-item-delete']");
    public static final By emptyCartMessage = By.xpath("//p[text()='Your cart is empty']");
    public static final By wishlistLink = By.xpath("//a[text()='Wishlist']");
    public static final By checkoutButton = By.id("checkout-link");


    
    
   
    

}
