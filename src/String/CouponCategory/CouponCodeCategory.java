/*
package String.CouponCategory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;



public class CouponCodeCategory {

    private static Map<String, TreeMap<Long, List<Coupon>>> categoryToCoupons;
    private static Map<String, String> categoryToParent;
    private static Map<String, Product> productNameToProductObjectMap;
    private static final String datePattern = "yyyy-MM-dd";

    static SimpleDateFormat format = new SimpleDateFormat(datePattern);

    static List<String[]> coupons = List.of(
            new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01","Discount:10%"},
            new String[]{"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2020-01-01","Discount:$15"},
            new String[]{"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01","Discount:35%"},
            new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01","Discount:25%"},
            new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01","Discount:50%"},
            new String[]{"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01","Discount:75%"}
    );

    static List<String[]> couponsV1 = List.of(
            new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01","Discount:10%"},
            new String[]{"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2020-01-01","Discount:$15"},
            new String[]{"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01","Discount:35%"},
            new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01","Discount:25%"},
            new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01","Discount:50%"},
            new String[]{"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01","Discount:75%"}
    );



    static List<String[]> categories = List.of(
            new String[]{"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
            new String[]{"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
            new String[]{"CategoryName:Bed & Bath", "CategoryParentName:None"},
            new String[]{"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
            new String[]{"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
            new String[]{"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
            new String[]{"CategoryName:Baby And Kids", "CategoryParentName:None"}
    );

    static List<String[]> products = List.of(
            new String[]{"ProductName:Cozy Comforter Sets","Price:100.00", "CategoryName:Comforter Sets"},
            new String[]{"ProductName:All-in-one Bedding Set", "Price:50.00", "CategoryName:Bedding"},
            new String[]{"ProductName:Infinite Soap Dispenser", "Price:500.00" ,"CategoryName:Bathroom Accessories"},
            new String[]{"ProductName:Rainbow Toy Box","Price:257.00", "CategoryName:Baby And Kids"}
    );

    private static String findParent(String category) {
        String parentCategory = categoryToParent.get(category);
        if(parentCategory.equals("None")) {
            return "None";
        }
        if(categoryToCoupons.containsKey(parentCategory)) {
            return parentCategory;
        }
        categoryToParent.put(category, findParent(parentCategory));
        return categoryToParent.get(category);
    }

    private static TreeMap<Long, List<Coupon>> getCouponDetailsByCategoryOrParentCategory(String category) {

        return categoryToCoupons.getOrDefault( category,
                categoryToCoupons.getOrDefault(findParent(category), new TreeMap<>()));
    }

    private static List<Coupon> getLatestCouponByLinearSearch(TreeMap<Long, List<Coupon>> coupons) {

        Date currentDate = new Date();
        List<Coupon> result = new ArrayList<>();
        int i=coupons.size()-1;
        for(Map.Entry<Long, List<Coupon>> entry: coupons.entrySet()) {
            if(entry.getKey().compareTo(currentDate.getTime())>0){
            }
             else {
                return entry.getValue();
            }
        }
        return new ArrayList<>();
    }

    private static List<Coupon> getAllCoupons(String category, String v1) {

        TreeMap<Long, List<Coupon>> coupons = getCouponDetailsByCategoryOrParentCategory(category);
        if(coupons == null || coupons.size() == 0) return new ArrayList<>();

        if(v1.equals("v1")) return coupons.getOrDefault();


        return getLatestCouponByLinearSearch(coupons);
    }

    private static String parse(String str) {
        return str.split(":")[1];
    }

    private static List<Double> getDiscountedPrice(String productName) {

        if(!productNameToProductObjectMap.containsKey(productName)) {
            return List.of();
        }

        Product product = productNameToProductObjectMap.get(productName);
        List<Coupon> coupons = getAllCoupons(productNameToProductObjectMap.get(productName).categoryName, "v3");

        return getAllPossibleDiscountedPrices(coupons, product);
    }


    private static List<Double> getAllPossibleDiscountedPrices(List<Coupon> coupons, Product product) {
        if(coupons == null || coupons.size() == 0) {
            return List.of(product.price);
        }
        return coupons.stream().map(coupon -> coupon.discountType == DiscountType.ABSOLUTE
                ? product.price - coupon.discount
                : product.price - (product.price * coupon.discount)/100.00
        ).collect(Collectors.toList());
    }


    public static void main(String[] args) throws ParseException {

        prepareCategoryToCouponMap();

        prepareCategoryToParentMap();

        prepareProductToProductObjectMap();

        System.out.print("Cozy Comforter Sets => ");

        //v1 printing only coupon information, getting coupon name using productname
        getAllCoupons("Cozy Comforter Sets", "v1").forEach(item -> System.out.print(item.toString() +" , "));

        //dateModified is added. getting latest coupons (not future coupon)
        getAllCoupons("Cozy Comforter Sets", "v2").forEach(item -> System.out.print(item.toString() +" , "));



        getDiscountedPrice("Cozy Comforter Sets").forEach(item -> System.out.print(item.toString() +" , "));
        System.out.println();
        System.out.print("All-in-one Bedding Set => ");
        getDiscountedPrice("All-in-one Bedding Set").forEach(item -> System.out.print(item.toString() +" , "));
        System.out.println();
        System.out.print("Infinite Soap Dispenser => ");
        getDiscountedPrice("Infinite Soap Dispenser").forEach(item -> System.out.print(item.toString() +" , "));
        System.out.println();
        System.out.print("Rainbow Toy Box => ");
        getDiscountedPrice("Rainbow Toy Box").forEach(item -> System.out.print(item.toString() +" , "));
    }

    private static void prepareCategoryToCouponV1Map() {
        for(var str: coupons) {
            String category = parse(str[0]);
            String couponName = parse(str[1]);
            String dateModified = parse(str[2]);
            String discount = parse(str[3]);

            DiscountType discountType = discount.startsWith("$") ? DiscountType.ABSOLUTE : DiscountType.PERCENT;
            double totalDiscount = Double.parseDouble(discount.replace("%", "").replace("$", ""));

            categoryToCoupons.getOrDefault(category, new TreeMap<Long, List<Coupon>>()).
                    getOrDefault(format.parse(dateModified).getTime(), new ArrayList<Coupon>()).
                    add(new Coupon(couponName, format.parse(dateModified).getTime(), totalDiscount, discountType));

        }
    }

    private static void prepareCategoryToCouponMap() throws ParseException {
        for(var str: coupons) {
            String category = parse(str[0]);
            String couponName = parse(str[1]);
            String dateModified = parse(str[2]);
            String discount = parse(str[3]);

            DiscountType discountType = discount.startsWith("$") ? DiscountType.ABSOLUTE : DiscountType.PERCENT;
            double totalDiscount = Double.parseDouble(discount.replace("%", "").replace("$", ""));

            categoryToCoupons.getOrDefault(category, new TreeMap<Long, List<Coupon>>()).
                    getOrDefault(format.parse(dateModified).getTime(), new ArrayList<Coupon>()).
                    add(new Coupon(couponName, format.parse(dateModified).getTime(), totalDiscount, discountType));

        }
    }

    private static void prepareCategoryToParentMap() {
        for(var str: categories) {
            categoryToParent.put(parse(str[0]), parse(str[1]));
        }
    }

    private static void prepareProductToProductObjectMap() {
        for(var product: products) {
            String productName = parse(product[0]);
            double price = Double.parseDouble(parse(product[1]));
            String category = parse(product[2]);

            productNameToProductObjectMap.put(productName, new Product(productName, category, price));
        }
    }
}
*/
