package code020;

import code020.supermarket.Category;

public class UseEnum {
    public static void main(String[] args) {
        for (Category category:Category.values()){
            System.out.println("-------------"+ category.getId()+ "--------------");
            System.out.println(category.ordinal());
            System.out.println(category.name());
            System.out.println(category.toString());
        }

        System.out.println();
        System.out.println(Category.valueOf("FOOD"));
        System.out.println(Category.valueOf("food"));
    }
}
