package mk.finki.ukim.mk.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.model.Balloon;
import mk.finki.ukim.mk.model.Manufacturer;
import mk.finki.ukim.mk.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Balloon>balloonList = new ArrayList<>();
    public static List<Manufacturer> manufacturerList = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
}
