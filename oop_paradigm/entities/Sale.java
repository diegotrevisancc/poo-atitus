package oop_paradigm.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Sale {
    private int id;
    private String clientName;
    private List<ItemSale> itens;
    private LocalDateTime time;

    public Sale(String clientName) {
        this.itens = new ArrayList<>();
        this.id = 99;
        this.clientName = clientName;
        this.time = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public List<ItemSale> getItens() {
        return itens;
    }
    public void setItens(List<ItemSale> itens) {
        this.itens = itens;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
