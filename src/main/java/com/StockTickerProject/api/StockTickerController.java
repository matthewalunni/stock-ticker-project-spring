package com.StockTickerProject.api;

import com.StockTickerProject.model.StockTickerDataService;
import com.StockTickerProject.model.StockTickerEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
public class StockTickerController {
    @Autowired
    StockTickerDataService stockTickerDataService;

    @GetMapping("show")
    public String show(Model model) {
        List<StockTickerEntry> entries = getAllStockTickerData();
        model.addAttribute("entries", entries);
        return "show";
    }

    @PostMapping("upload")
    public RedirectView uploadSubmit(@ModelAttribute("stocktickerentry") StockTickerEntry stockTickerEntry, Model model) {
        stockTickerDataService.uploadSubmit(stockTickerEntry);
        List<StockTickerEntry> entries = getAllStockTickerData();
        model.addAttribute("entries", entries);
        return new RedirectView("show");
    }

    @GetMapping("upload")
    public String upload(Model model) {
        model.addAttribute("stocktickerentry", new StockTickerEntry());
        return "upload";
    }

    @PostMapping("uploadMany")
    public RedirectView uploadManySubmit(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file.isEmpty()) {
            return new RedirectView("uploadMany");
        }
        stockTickerDataService.uploadManySubmit(file);
        List<StockTickerEntry> entries = getAllStockTickerData();
        model.addAttribute("entries", entries);
        return new RedirectView("show");
    }

    @GetMapping("uploadMany")
    public String uploadMany() {
        return "uploadMany";
    }

    public List<StockTickerEntry> getAllStockTickerData() {
        return stockTickerDataService.getAllStockTickerData();
    }
}
