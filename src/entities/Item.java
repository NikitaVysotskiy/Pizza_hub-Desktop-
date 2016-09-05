package entities;


import javax.persistence.*;

@Entity
@Table(name="items")
public class Item {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private Integer weight;

//    @Column(name = "quantity")
//    private Integer quantity;

    @Column(name = "price")
    private Integer price;

    public Item(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.category = item.getCategory();
        this.description = item.getDescription();
        this.weight = item.getWeight();
       // this.quantity=item.getQuantity();
        this.price = item.getPrice();
    }




  /*  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
    private Set<Item> items = new HashSet<Item>(0);*/


    @Override
    public String toString() {
        return name;
   }

    public Item(){

    }

    public Item(Integer id, String name, Category category, String description, Integer weight,
                //Integer quantity,
                Integer price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.weight = weight;
      //  this.quantity= quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }

  /* public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }*/
}
