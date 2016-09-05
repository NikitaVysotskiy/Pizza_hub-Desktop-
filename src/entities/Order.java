package entities;


import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "adress")
    private String adress;

   /* @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ordersitems", joinColumns = {
            @JoinColumn(name = "id_order", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id_item",
                    nullable = false, updatable = false) })
    private Set<Item> items = new HashSet<Item>(0);*/


    public Order() {
    }

    public Order(Integer id, Client client, Integer totalPrice, String adress) {
        this.id = id;
        this.client = client;
        this.totalPrice = totalPrice;
        this.adress = adress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    /*public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }*/

    @Override
    public String toString() {

        /*Calendar c= Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        String curTime=hour+":"+minute+":"+second;*/

        return "Заказ: " + totalPrice + " грн.";
    }
}
