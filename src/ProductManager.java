import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> arrayList = new ArrayList<>();

    public void inputProduct(){
        Product product1 = new Product("p1","television",50);
        arrayList.add(product1);
        Product product2 = new Product("p2","wasing machine",40);
        arrayList.add(product2);
        Product product3 = new Product("p3","clean machine",70);
        arrayList.add(product3);
        Product product4 = new Product("p4","laptop",30);
        arrayList.add(product4);
        Product product5 = new Product("p5","dryer",15);
        arrayList.add(product5);
    }

    public void displayList (){
        for (Product product: arrayList){
            product.displayProduct();
        }
    }

    public String inputId(){
        System.out.print("Nhap Id : ");
        return scanner.nextLine();
    }

    public String inputName(){
        System.out.print("Nhap Ten : ");
        return scanner.nextLine();
    }

    public int inputPrice(){
        System.out.print("Nhap Gia : ");
        return scanner.nextInt();
    }

    public void inputProductInfo(){
        inputId();
        inputName();
        inputPrice();
    }

    Scanner scanner = new Scanner(System.in);
    public void addMoreProduct(){
        Product newProduct = new Product(inputId(),inputName(),inputPrice());
        arrayList.add(newProduct);
    }

    public Product findProductViaId(String id){
        Product findOutProduct = null;
        for (Product product : arrayList) {
            if (product.getId().equals(id)) {
                findOutProduct = product;
            }
        }
        return findOutProduct;
    }

    public boolean isAProduct(Product product){
        return product !=null;
    }

    public void changeInfoProductViaId(){
        System.out.println("Nhap Id san pham muon sua : ");
        String needToChangeProductId = inputId();
        if (isAProduct(findProductViaId(needToChangeProductId))){
            findProductViaId(needToChangeProductId).setName(inputName());
            findProductViaId(needToChangeProductId).setPrice(inputPrice());
        } else {
            System.out.println("Khong co san pham vua tim");
        }
    }

    public void deleteProduct(String id){
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId().equals(id)){
                arrayList.set(i, arrayList.get(i + 1));
            }
        }
    }

    public void deleteProductViaId(){
        System.out.println("Nhap Id san pham muon xoa : ");
        String needToDeleteProductId = inputId();
        if (isAProduct(findProductViaId(needToDeleteProductId))){
            deleteProduct(needToDeleteProductId);
        }else {
            System.out.println("Khong co san pham can xoa");
        }
    }

    public Product findProductViaName(String name){
        Product findOutProduct = null;
        for (Product product : arrayList) {
            if (product.getName().equals(name)) {
                findOutProduct = product;
            }
        }
        return findOutProduct;
    }

    public void findProduct(){
        System.out.println("Nhap ten san pham can tim kiem");
        String needToFindProductName = inputName();
        if (isAProduct(findProductViaName(needToFindProductName))){
            findProductViaName(needToFindProductName).displayProduct();
        } else {
            System.out.println("Khong co san pham can tim kiem");
        }
    }

    public void increasingSort(){
        arrayList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() > o2.getPrice() ? 1 : -1;
            }
        });
        displayList();
    }

    public void decreasingSort(){
        arrayList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() < o2.getPrice() ? 1 : -1;
            }
        });
        displayList();
    }

}
