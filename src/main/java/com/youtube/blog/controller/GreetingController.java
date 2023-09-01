package com.youtube.blog.controller;


import com.youtube.blog.beans.FirstBean;
import com.youtube.blog.beans.TestBean;
import com.youtube.blog.beans.ThirdBean;
import com.youtube.blog.db.Cars;
import com.youtube.blog.db.DBManager;
import com.youtube.blog.db.Items;
import com.youtube.blog.entities.Countries;
import com.youtube.blog.entities.ShopItems;
import com.youtube.blog.services.ItemService;
import com.youtube.blog.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GreetingController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String home(Model model) {

        List<ShopItems> items = itemService.getAllItems();
        model.addAttribute("tovary", items);

        List<Countries> countries = itemService.getAllCountries();
        model.addAttribute("countries",countries);

        return "home";
    }
    @GetMapping("/about")
    public String about(Model model){
        ArrayList<Cars> allCars = DBManager.getAllCars();
        model.addAttribute("MyText","Page");
        model.addAttribute("Cars",allCars);
        return "about";
    }


    @PostMapping(value = "/addItem")
    public String addItem(@RequestParam(name = "country_id", defaultValue = "0") Long id,
                          @RequestParam(name = "item_name", defaultValue = "No Item") String name,
                          @RequestParam(name = "item_price", defaultValue = "0") int price,
                          @RequestParam(name = "item_amount", defaultValue = "0") int amount){
        Countries cnt = itemService.getCountry(id);
        if(cnt!=null) {
            ShopItems item = new ShopItems();
            item.setName(name);
            item.setPrice(price);
            item.setAmount(amount);
            item.setCountry(cnt);
            itemService.addItem(item);
        }



        return "redirect:/";
    }



    @GetMapping(value = "/detailes/{idshka}")
    public String detailes(Model model, @PathVariable(name = "idshka") Long id){
        List<Countries> countries = itemService.getAllCountries();
        model.addAttribute("countries",countries);

        ShopItems item = itemService.getItem(id);
        model.addAttribute("item", item);
        return "detailes";
    }

    @PostMapping(value = "/saveItem")
    public String saveItem(@RequestParam(name = "id", defaultValue = "0") Long id,
                           @RequestParam(name = "country_id", defaultValue = "0") Long countryId,
                           @RequestParam(name = "item_name", defaultValue = "No Item") String name,
                           @RequestParam(name = "item_price", defaultValue = "0") int price,
                           @RequestParam(name = "item_amount", defaultValue = "0") int amount){
        ShopItems item = itemService.getItem(id);
        if(item!=null){
            Countries cnt = itemService.getCountry(countryId);
            if(cnt!=null) {
                item.setName(name);
                item.setPrice(price);
                item.setAmount(amount);
                item.setCountry(cnt);
                itemService.saveItem(item);
            }

        }

        return "redirect:/";
    }
    @PostMapping(value = "/deleteItem")
    public String deleteItem(@RequestParam(name = "id", defaultValue = "0") Long id){
        ShopItems item = itemService.getItem(id);
        if(item!=null){
            itemService.deleteItem(item);
        }

        return "redirect:/";
    }

}