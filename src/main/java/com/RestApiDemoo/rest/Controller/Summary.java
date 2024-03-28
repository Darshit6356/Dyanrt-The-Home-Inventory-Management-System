package com.RestApiDemoo.rest.Controller;

import com.RestApiDemoo.rest.Model.ItemBuy;
import com.RestApiDemoo.rest.Model.ItemUsed;
import com.RestApiDemoo.rest.repository.ItemBuyRepository;
import com.RestApiDemoo.rest.repository.ItemUsedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class sendOutput{
    float totalAmount;
    List<ItemBuy> buyedList;
    List<ItemUsed> usedList;

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ItemBuy> getBuyedList() {
        return buyedList;
    }

    public void setBuyedList(List<ItemBuy> buyedList) {
        this.buyedList = buyedList;
    }

    public List<ItemUsed> getUsedList() {
        return usedList;
    }

    public void setUsedList(List<ItemUsed> usedList) {
        this.usedList = usedList;
    }

    public sendOutput(float totalAmount, List<ItemBuy> buyedList, List<ItemUsed> usedList) {
        this.totalAmount = totalAmount;
        this.buyedList = buyedList;
        this.usedList = usedList;
    }

    public sendOutput() {
    }
}

@RestController
@RequestMapping("/summary")
public class Summary{

    @Autowired
    ItemBuyRepository itbrepo;
    @Autowired
    ItemUsedRepository iturepo;
    // some function
    @GetMapping
    public sendOutput GenertingOutput(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                    @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)
    {
//        System.out.println("Summary data for startDate: " + startDate + " and endDate: " + endDate);
        Predicate<ItemBuy> itemBuyDatePredicate = itemBuy -> {
            LocalDate itemBuyDate = itemBuy.getItemBuyDate();
            return itemBuyDate != null && (itemBuyDate.isEqual(startDate) || itemBuyDate.isAfter(startDate)) &&
                    (itemBuyDate.isEqual(endDate) || itemBuyDate.isBefore(endDate));
        };

        Predicate<ItemUsed> itemUsedDatePredicate = itemUsed -> {
            LocalDate itemUsedDate = itemUsed.getItemUsedDate();
            return itemUsedDate != null && (itemUsedDate.isEqual(startDate) || itemUsedDate.isAfter(startDate)) &&
                    (itemUsedDate.isEqual(endDate) || itemUsedDate.isBefore(endDate));
        };
        List<ItemBuy> itb = itbrepo.findAll();
        List<ItemUsed> itu = iturepo.findAll();
// Filter the ItemBuy list based on the date range
        List<ItemBuy> filteredItemBuys = itb.stream()
                .filter(itemBuyDatePredicate)
                .collect(Collectors.toList());

// Filter the ItemUsed list based on the date range
        List<ItemUsed> filteredItemUseds = itu.stream()
                .filter(itemUsedDatePredicate)
                .collect(Collectors.toList());
        float totalamount=0;
        for(ItemBuy i : filteredItemBuys){
            long qty = i.getItemBuyQty();
            float prc = i.getItemBuyPrice();
            totalamount+=(qty*prc);
        }
        return new sendOutput(totalamount,filteredItemBuys,filteredItemUseds);
    }

}
