package edu.evt.admin.user;

/**
 * Created by Wheeler on 9/12/2016.
 */
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public User greeting(@RequestParam(value="name", defaultValue="Wheeler Law") String name) {
        String[] names = name.split(" ");
        System.out.println(name);
        return new User(counter.incrementAndGet(), names[0], names[1], "603007588", "wpl3499");
    }
}
