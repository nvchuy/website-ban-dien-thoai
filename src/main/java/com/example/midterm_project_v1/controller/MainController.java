package com.example.midterm_project_v1.controller;

import com.example.midterm_project_v1.modals.Brand;
import com.example.midterm_project_v1.modals.Order;
import com.example.midterm_project_v1.modals.OrderDetail;
import com.example.midterm_project_v1.modals.Product;
import com.example.midterm_project_v1.services.BrandServiceImp;
import com.example.midterm_project_v1.services.OrderDetailServiceImp;
import com.example.midterm_project_v1.services.OrderServiceImp;
import com.example.midterm_project_v1.services.ProductServicesImp;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {
    Product p = null;

    final ProductServicesImp productServicesImp;
    final BrandServiceImp brandServiceImp;
    final OrderServiceImp orderServiceImp;
    final OrderDetailServiceImp orderDetailServiceImp;

    public MainController(BrandServiceImp brandServiceImp, ProductServicesImp productServicesImp, OrderServiceImp orderServiceImp, OrderDetailServiceImp orderDetailServiceImp) {
        this.brandServiceImp = brandServiceImp;
        this.productServicesImp = productServicesImp;
        this.orderServiceImp = orderServiceImp;
        this.orderDetailServiceImp = orderDetailServiceImp;
    }

    public void initBrand() {
        brandServiceImp.save(new Brand(1, "Apple"));
        brandServiceImp.save(new Brand(2, "Samsung"));
        brandServiceImp.save(new Brand(3, "Xiaomi"));
        brandServiceImp.save(new Brand(4, "ZTE"));
        brandServiceImp.save(new Brand(5, "Oppo"));
        brandServiceImp.save(new Brand(6, "Sony"));
        brandServiceImp.save(new Brand(7, "Huawei"));
    }

    public void initProduct() {
        productServicesImp.save(new Product(1, "iPhone 13 Pro Max", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/3/_/3_51_1_2_2_1_1_2.jpg",
                25290000.0, "xanh dương", 1, 128, 1, "Apple", 1, "Điện thoại/Phone", 1));
        productServicesImp.save(new Product(2, "iPhone 13 Pro Max", "https://cdn2.cellphones.com.vn/358x/media/catalog/product/6/0/600_iphone-13-pro-256gb-xanh-la_5.jpg",
                27790000.0, "xanh lá", 1, 256, 1, "Apple", 1, "Điện thoại/Phone", 1));
        productServicesImp.save(new Product(3, "iPhone 13 Pro Max", "https://cdn2.cellphones.com.vn/358x/media/catalog/product/v/a/vanggg_3.jpg",
                29990000.0, "vàng", 1, 512, 1, "Apple", 1, "Điện thoại/Phone", 1));
        productServicesImp.save(new Product(4, "Samsung Galaxy S23 Ultra", "https://cdn2.cellphones.com.vn/358x/media/catalog/product/s/2/s23-ultra-tim_1.png",
                23890000.0, "tím", 1, 256, 2, "Samsung", 1, "Điện thoại/Phone", 1));
        productServicesImp.save(new Product(5, "Laptop Xiaomi RedmiBook 15 JYU4506AP", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/t/e/text_ng_n_8__14.png",
                13290000.0, "đen", 1, 512, 3, "Xiaomi", 2, "Laptop", 1));
        productServicesImp.save(new Product(6, "Apple Watch SE 2022 40mm", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/2/_/2_248.jpg",
                13290000.0, "trắng", 1, 32, 1, "Apple", 3, "Đồng hồ/Watch", 1));
        productServicesImp.save(new Product(7, "Tai nghe Bluetooth Apple AirPods 2", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/g/r/group_169_2.png",
                2750000.0, "trắng", 1, 0, 1, "Apple", 4, "Tai nghe/Ear/Head", 1));
        productServicesImp.save(new Product(8, "iPad Air 5 (2022) 64GB", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/_/1_253_3.jpg",
                14190000.0, "xám", 1, 64, 1, "Apple", 5, "Máy tính bảng/Tablet/ipad", 1));
        productServicesImp.save(new Product(9, "Xiaomi Pad 5", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/o/1/o1cn01laervj1slqjxkeekw_-2201438992231_1628773507_1628827052_1.jpg",
                7990000.0, "xám", 1, 128, 3, "Xiaomi", 5, "Máy tính bảng/Tablet", 1));
        productServicesImp.save(new Product(10, "Apple MacBook Air M1 256GB 2020", "https://cdn2.cellphones.com.vn/358x/media/catalog/product/m/a/macbook-air-space-gray-select-201810_1.jpg",
                18590000.0, "xám", 1, 256, 1, "Apple", 2, "Laptop", 1));
        productServicesImp.save(new Product(11, "Smart Tivi Sony 4K 55 inch KD-55X75K VN3", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/s/m/smart-tivi-sony-4k-50-inch-kd-50x75k-1_1.jpg",
                11990000.0, "đen", 1, 0, 6, "Sony", 6, "Tivi/TV", 1));
        productServicesImp.save(new Product(12, "OPPO Find N2 Flip\n", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/n/2/n2_flip_-_combo_product_-_black.png",
                19990000.0, "đen", 1, 128, 5, "Oppo", 1, "Điện thoại/Phone", 1));
    }

    public static String stripAccents(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("\\p{InCombiningDiacriticalMarks}", "");

        return s;
    }

    @RequestMapping("/")
    public String move2dp() {
        return "redirect:/store";
    }

    @RequestMapping({"/store",
            "/store/detail/{id}",
            "/store/{name}"
    })
    public String defaultPage(Model model,
                              @PathVariable(required = false) String id,
                              @PathVariable(required = false) String name) {
        initBrand();
        initProduct();

        String nameFormatted;

        if (id != null) {
            p = productServicesImp.get(Integer.valueOf(id));
            nameFormatted = stripAccents(p.getName()).toLowerCase().replaceAll(" ", "-");

            return "redirect:/store/" + nameFormatted;
        }

        if (name != null) {
            model.addAttribute("product", p);

            return "product-detail";
        }

        if (!brandServiceImp.findAll().isEmpty()) {
            model.addAttribute("brands", brandServiceImp.findAll());
        }

        if (!productServicesImp.findAll().isEmpty()) {
            model.addAttribute("products", productServicesImp.findAll());
        }

        return "index";
    }

    List<Product> products = new ArrayList<>();

    @RequestMapping("/add2cart/{id}")
    public String add2cart(@PathVariable("id") String id) {
        for (Product product : products) {
            if (product.getId().equals(Integer.parseInt(id))) {
                return "redirect:/store/cart/{id}/add";
            }
        }

        products.add(productServicesImp.get(Integer.parseInt(id)));

        return "redirect:/store";
    }

    @RequestMapping({"/store/cart",
            "/store/cart/{id}/sub",
            "/store/cart/{id}/add",
            "/store/cart/{id}/change"})
    public String move2cart(@PathVariable(value = "id", required = false) Integer id,
                            Model model, HttpServletRequest request) {
        int len = request.getRequestURI().split("/").length;

        for (Product product : products) {
            if (product.getId().equals(id)) {
                if (Objects.equals(request.getRequestURI().split("/")[len - 1], "sub")) {
                    if (product.getQuantity() - 1 < 1) {
                        product.setQuantity(1);
                    } else {
                        product.setQuantity(product.getQuantity() - 1);
                    }
                    return "redirect:/store/cart";
                } else if (Objects.equals(request.getRequestURI().split("/")[len - 1], "add")) {
                    product.setQuantity(product.getQuantity() + 1);
                    return "redirect:/store/cart";
                } else if (Objects.equals(request.getRequestURI().split("/")[len - 1], "change")) {
                    product.setQuantity(Integer.valueOf(request.getParameter("quantity")));
                    return "redirect:/store/cart";
                }
            }
        }

        model.addAttribute("cart_items", products);
        return "cart";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            if (product.getId().equals(id)) {
                products.remove(product);
            }
        }

        return "redirect:/store/cart";
    }

    @RequestMapping("/store/cart/checkout")
    public String checkoutCart(Model model) {
        if (products.size() > 0) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String create_at = formatter.format(date);

            Order newOrder = orderServiceImp.save(new Order("HÓA ĐƠN MUA HÀNG", create_at));

            for (Product p : products) {
                orderDetailServiceImp.save(new OrderDetail(newOrder.getOrder_id(), p.getId(), p.getName(),
                        p.getPrice(), p.getQuantity()));
            }
        }

        products.clear();

        return "redirect:/store";
    }

    List<Order> orders = new ArrayList<>();

    @RequestMapping("/store/order")
    public String move2order(Model model) {
        orders.clear();
        orders.addAll(orderServiceImp.findAll());
        model.addAttribute("orders", orders);
        return "orders";
    }

    List<OrderDetail> orderDetails = new ArrayList<>();

    @RequestMapping("/store/order/{id}")
    public String move2orderDetail(Model model, @PathVariable Integer id) {
        orderDetails.clear();
        int order_id_clicked = 0;
        double total_price = 0;

        for (Order order : orders) {
            if (order.getOrder_id().equals(id)) {
                orderDetails.addAll(orderDetailServiceImp.findAllByOrderID(id));
                order_id_clicked = id;
            }
        }

        for (OrderDetail orderDetail : orderDetails) {
            total_price += orderDetail.getProduct_price() * orderDetail.getProduct_quantity();
        }

        model.addAttribute("order_details", orderDetails);
        model.addAttribute("order_id", order_id_clicked);
        model.addAttribute("total_price", total_price);

        return "detail-order";
    }

    @RequestMapping("/store/filter/{brand_name}")
    public String sortByBrandName(@PathVariable String brand_name, Model model) {
        initBrand();

        List<Product> tmp = new ArrayList<>(productServicesImp.findAllProdByBrandName(brand_name));

        if (!brandServiceImp.findAll().isEmpty()) {
            model.addAttribute("brands", brandServiceImp.findAll());
        }

        model.addAttribute("products", tmp);

        return "index";
    }

    @RequestMapping({"/store/sort/desc",
            "/store/sort/asc",
    })
    public String sortByPrice(Model model, HttpServletRequest request) {
        initBrand();

        List<Product> tmp = new ArrayList<>();

        int len = request.getRequestURI().split("/").length;

        if (request.getRequestURI().split("/")[len - 1].equals("desc")) {
            tmp.addAll(productServicesImp.sortDescPrice());
        }
        if (request.getRequestURI().split("/")[len - 1].equals("asc")) {
            tmp.addAll(productServicesImp.sortAscPrice());
        }

        if (!brandServiceImp.findAll().isEmpty()) {
            model.addAttribute("brands", brandServiceImp.findAll());
        }

        model.addAttribute("products", tmp);

        return "index";
    }

    @RequestMapping({"/search"})
    public String searchBySpecific(Model model, HttpServletRequest request) {
        initBrand();

        List<Product> tmp = new ArrayList<>();

        if (request.getParameter("search-value") != null) {
            tmp.addAll(productServicesImp.searchProductSpecific(request.getParameter("search-value").trim()));
        }

        if (!brandServiceImp.findAll().isEmpty()) {
            model.addAttribute("brands", brandServiceImp.findAll());
        }

        model.addAttribute("products", tmp);

        return "index";
    }

    @RequestMapping({"/api/products",
            "/api/orders",
            "/api/order_details"
    })
    public void APIs(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int len = request.getRequestURI().split("/").length;
        String stringResult = "";

        if (request.getRequestURI().split("/")[len - 1].equals("products")) {
            stringResult = new Gson().toJson(productServicesImp.findAll());
        }
        if (request.getRequestURI().split("/")[len - 1].equals("orders")) {
            stringResult = new Gson().toJson(orderServiceImp.findAll());
        }
        if (request.getRequestURI().split("/")[len - 1].equals("order_details")) {
            stringResult = new Gson().toJson(orderDetailServiceImp.findAll());
        }

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(stringResult);
        out.flush();
    }

    @RequestMapping("error/{errorCode}")
    public String move2error(@PathVariable String errorCode) {
        if (errorCode.equals("404")) {
            return "error/404";
        }

        return "error/404";
    }
}
