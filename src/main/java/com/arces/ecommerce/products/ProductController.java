package com.arces.ecommerce.products;

// import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
// import java.util.Set;

// import org.springframework.beans.BeanUtils;
// import org.springframework.beans.BeanWrapper;
// import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Product> list() {
        return service.listAll();
    }

    @GetMapping("/products/{product_id}")
    public ResponseEntity<Product> get(@PathVariable Long product_id) {

        try {
            Product product = service.get(product_id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            }

        }
    // .../search/?title=
    // .../search/?category=
    // .../search/?description=
    // .../search/?all= (title or category or description)
    
    // Ricerca per titolo
    @GetMapping("/products/")
    public ResponseEntity<List<Product>> getProductsByTitle(@RequestParam String title) {

        List<Product> response;
        response = service.getProductsByTitle(title);
        if (response.isEmpty()){
            return new ResponseEntity<List<Product>>(response,HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Product>>(response, HttpStatus.OK);
     
    }
    
    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        service.save(product);
    }

    @DeleteMapping("/products/{product_id}")
    public ResponseEntity<?> delete(@PathVariable Long product_id) {
        try {

            service.delete(product_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    // @PostMapping("/products")
    // public void addAll(@RequestBody Product[] Product) {
        
    //     for (Product p : Product){
    //         service.save(p);
    //     }
    

    // }

    // @PutMapping("/products/{product_id}")
    // public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long product_id) {
    //     try {
    //         Product product_old = service.get(product_id);
    //         copyNonNullProperties(product, product_old);
    //         service.save(product_old);
    //         return new ResponseEntity<>(HttpStatus.OK);

    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }


    // public static void copyNonNullProperties(Object src, Object target) {
    //     BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    // }

    // public static String[] getNullPropertyNames(Object source) {
    //     final BeanWrapper src = new BeanWrapperImpl(source);
    //     java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

    //     Set<String> emptyNames = new HashSet<String>();
    //     for (java.beans.PropertyDescriptor pd : pds) {
    //         Object srcValue = src.getPropertyValue(pd.getName());
    //         if (srcValue == null)
    //             emptyNames.add(pd.getName());
    //     }
    //     String[] result = new String[emptyNames.size()];
    //     return emptyNames.toArray(result);
    // }
}
