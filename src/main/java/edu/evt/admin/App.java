package edu.evt.admin;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import edu.evt.admin.resource.Calculator;

/**
 * Created by Wheeler on 10/6/2016.
 */
public class App extends Application {
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<>();
        classes.add(Calculator.class);
        return Collections.unmodifiableSet(classes);
    }
}
