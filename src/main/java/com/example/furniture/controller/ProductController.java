package com.example.furniture.controller;

import com.example.furniture.model.Product;
import com.example.furniture.model.ProductIdList;
import com.example.furniture.model.User;
import com.example.furniture.service.ProductService;
import com.example.furniture.service.UserService;
import com.example.furniture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//@RestController
//@RequestMapping
//public class UserController {
//    private final UserRepository userRepository;
//    private final PaymentRepository paymentRepository;
//
//    public UserController(UserRepository userRepository, PaymentRepository paymentRepository) {
//        this.userRepository = userRepository;
//        this.paymentRepository = paymentRepository;
//    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        System.out.println(user);
//        return userRepository.save(user);
//    }
//
//    @PostMapping("/payment")
//    public Payment createPayment(@RequestBody Payment payment) {
//        System.out.println(payment);
//        return paymentRepository.save(payment);
//    }
//
//    @GetMapping
//    public String createUser() {
//        return "userRepository.save(user);";
//    }
//}

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{category_id}")
    public List<Product> getProductsByCategory(@PathVariable("category_id") int categoryId){
        return productService.getProductByCategory(categoryId);
    }

    @GetMapping("/findProduct/{query}")
    public List<Product> getProductsByCategory(@PathVariable("query") String query){
        return productService.findProductsByName(query);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("Xoá sản phẩm thành công");
    }

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    private final Path root = Paths.get("uploads");

    @GetMapping("/images/{fileName}")
    public ResponseEntity<byte[]>  load(@PathVariable("fileName") String filename) throws IOException {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_JPEG); // Set the appropriate content type

                return new ResponseEntity<>(resource.getContentAsByteArray(), headers, HttpStatus.OK);
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @PostMapping
    public Product createProductWithFormData(
            @RequestParam("name") String name,
            @RequestParam("price") Double price,
            @RequestParam("description") String description,
            @RequestParam("categoryId") Integer categoryId,
            @RequestParam("colorsList") String colorsList,
            @RequestParam("createAt") String createAt,
            @RequestParam(value = "productId", required = false) Long productId,
            @RequestParam(value = "image", required = false) MultipartFile imageFile) throws IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (imageFile != null && !imageFile.isEmpty()) {
            try {

                StringBuilder fileNames = new StringBuilder();
                Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, imageFile.getOriginalFilename());
                fileNames.append(imageFile.getOriginalFilename());
                Files.write(fileNameAndPath, imageFile.getBytes());


                // Now, you can save the product information, including the image URL (filePath)
                Product product;
                if( productId == null) {
                    product = new Product(
                            name,
                            price,
                            description,
                            categoryId,
                            colorsList,
                            fileNames.toString(),
                            sdf.parse(createAt)
                    );
                }else{
                    product = new Product(
                            productId,
                            name,
                            price,
                            description,
                            categoryId,
                            colorsList,
                            fileNames.toString(),
                            sdf.parse(createAt)
                    );
                }
                System.out.println(product);
                return productService.createProduct(product);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception (e.g., return an error response)
            }
        } else {
            // Handle the case where no image was provided
            // Return an appropriate error response
            Product product;
            if( productId == null) {
                product = new Product(
                        name,
                        price,
                        description,
                        categoryId,
                        colorsList,
                        null,
                        sdf.parse(createAt)
                );
            }else{
                product = new Product(
                        productId,
                        name,
                        price,
                        description,
                        categoryId,
                        colorsList,
                        null,
                        sdf.parse(createAt)
                );
            }
            System.out.println(product);
            return productService.createProduct(product);
        }
        return null;
    }

    @PostMapping("/findByIds")
    public List<Product> getProductsByIds(@RequestBody ProductIdList idList){
        return productService.getProductsByIds(idList.getIds());
    }

    @GetMapping("/find/{id}")
    public Product getProductsByCategory(@PathVariable("id") Long productId){
        return productService.getProductById(productId);
    }

}

