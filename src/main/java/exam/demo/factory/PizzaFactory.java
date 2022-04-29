package exam.demo.factory;

import exam.demo.model.Pizza;
import exam.demo.model.pizzas.Diavola;
import exam.demo.model.pizzas.Margueritta;
import exam.demo.model.pizzas.Pepperoni;

public class PizzaFactory {
       public static Pizza getPizza(String pizza){
           switch(pizza){
               case "Diavola":
                   return new Diavola();
               case "Margueritta":
                   return new Margueritta();
               case "Pepperoni":
                   return new Pepperoni();
               default: return null;
           }
       }
}
