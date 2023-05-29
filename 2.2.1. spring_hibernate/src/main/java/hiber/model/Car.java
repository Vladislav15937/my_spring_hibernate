package hiber.model;

import javax.persistence.*;

@Entity
@Table
public class Car {

    public Car(String model, int series){
        this.model = model;
        this.series = series;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User user;

    public User getUser() {
        return user;
    }

    public User setUser(User user) {
       return this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    @Column
    private String model;
    @Column
    private int series;

    public Car() {

    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public Long getId() {
        return id1;
    }

    public void setId(Long id) {
        this.id1 = id;
    }
}
