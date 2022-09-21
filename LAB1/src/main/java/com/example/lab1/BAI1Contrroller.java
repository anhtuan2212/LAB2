package com.example.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BAI1Contrroller {
    @GetMapping("bai1")
    public String bai1(@RequestParam(name = "str1", defaultValue = "STR1") String str1,
                       @RequestParam(name = "str2", defaultValue = "STR2") String str2,
                       Model model){
        String info="";
        if (str1.length() > str2.length() ){
            info = str1 ;
        }else{
            info = str2 ;
        }
        System.out.println(info);
        model.addAttribute("info",info);
        return "bai1";
    }
    @GetMapping("bai2")
    public String bai2(@RequestParam(name = "str", defaultValue = "STR") String str,
                       Model model){
        String info = new StringBuffer(str).reverse().toString();
        model.addAttribute("info",info);
        return "bai1";
    }
    @GetMapping("bai3")
    public String bai3(@RequestParam(name = "number") Integer number, Model model) {
        if (number < 2) {
            model.addAttribute("info", 2);
        } else {
            int a = number + 1;
            while (!isPrimeNumber(a)) {
                a++;
            }

            model.addAttribute("info", a);
        }
        return "bai3";
    }

    public static boolean isPrimeNumber(int n) {
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
