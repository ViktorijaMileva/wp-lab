package mk.finki.ukim.mk.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String balloonColor;

    private String balloonSize;

    @ManyToOne

    private User user;


    public Order(String balloonColor, String balloonSize, User user) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.user = user;
    }
    public Order(){}

    public Long getId() {
        return id;
    }

    public String getBalloonColor() {
        return balloonColor;
    }

    public void setBalloonColor(String balloonColor) {
        this.balloonColor = balloonColor;
    }

    public String getBalloonSize() {
        return balloonSize;
    }

    public void setBalloonSize(String balloonSize) {
        this.balloonSize = balloonSize;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
