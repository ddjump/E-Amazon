package javaa.Beans;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class ShoppingCartBean {

    private int ShoppingCartID;
    private int totalprice;
    private int pricePerItem;


    public int getShoppingCartID() {
        return ShoppingCartID;
    }

    public void setShoppingCartID(int shoppingCartID) {
        ShoppingCartID = shoppingCartID;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(int pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    private int numberOfItems;
    private int person_id;



}


