package pageLocators;

import org.openqa.selenium.By;

public class ProductsLocators {
    public static final By productName = By.className("inventory_item_name");
    public static final By productPrice = By.className("inventory_item_price");
    public static final By productImage = By.className("inventory_item_img");


    public static final By burgerMenuButton = By.id("react-burger-menu-btn");
    public static final By menuOption = By.id("inventory_sidebar_link");

    public static final By sortDropdown = By.className("product_sort_container");

    public static final By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    public static final By cartBadge = By.className("shopping_cart_badge");

    public static final By removeButton = By.id("remove-sauce-labs-backpack");
    public static final By cartIcon = By.className("shopping_cart_link");






}
